package com.maasbodev.marvelcomicsmd

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
	/*private val moshi = Moshi.Builder()
		.addLast(KotlinJsonAdapterFactory())
		.build()
	private val retrofit = Retrofit.Builder()
		.baseUrl("https://gateway.marvel.com/v1/public/")
		.addConverterFactory(MoshiConverterFactory.create(moshi))
		.build()
	private val marvelService = retrofit.create(MarvelService::class.java)
	private var offset = 0
	private val limit = 100

	suspend fun getCharacters(offset: Int, limit: Int): List<ApiCharacter> {
		return withContext(Dispatchers.IO) {
			try {
				val ts = Date().time
				val response = marvelService.getCharacters(
					"dee033d28552710396e7d9b1d3b44efb", ts.toString(),
					generateHash(
						ts,
						"ffaf89575ae603b38ad1dc78d20194fb40cc1500",
						"dee033d28552710396e7d9b1d3b44efb"
					),
					offset, limit
				)
				response.data.results
			} catch (e: Exception) {
				e.printStackTrace()
				emptyList()
			}
		}
	}*/
}