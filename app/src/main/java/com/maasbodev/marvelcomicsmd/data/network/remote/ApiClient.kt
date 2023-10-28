package com.maasbodev.marvelcomicsmd.data.network

import com.maasbodev.marvelcomicsmd.data.network.remote.CharacterService
import java.util.Date
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val API_ENDPOINT = "https://gateway.marvel.com/v1/public/"

object ApiClient {

	private val loggingInterceptor = HttpLoggingInterceptor().apply {
		level = HttpLoggingInterceptor.Level.BODY
	}

	private val okHttpClient = OkHttpClient.Builder()
		.addInterceptor(loggingInterceptor)
		.addInterceptor(QueryInterceptor())
		.build()

	private val restAdapter = Retrofit.Builder()
		.baseUrl(API_ENDPOINT)
		.addConverterFactory(GsonConverterFactory.create())
		.client(okHttpClient)
		.build()

	val characterService: CharacterService = restAdapter.create(CharacterService::class.java)
}

private class QueryInterceptor : Interceptor {
	override fun intercept(chain: Interceptor.Chain): Response {
		val original = chain.request()
		val originalUrl = original.url
		val ts = Date().time

		val hash = generateHash(
			ts, "ffaf89575ae603b38ad1dc78d20194fb40cc1500",
			"dee033d28552710396e7d9b1d3b44efb"
		)

		val url = originalUrl.newBuilder()
			.addQueryParameter("apikey", "dee033d28552710396e7d9b1d3b44efb")
			.addQueryParameter("ts", ts.toString())
			.addQueryParameter("hash", hash)
			.build()

		val request = original.newBuilder()
			.url(url)
			.build()

		return chain.proceed(request)
	}
}
