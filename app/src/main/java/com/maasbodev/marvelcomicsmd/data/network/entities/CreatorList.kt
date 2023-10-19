package com.maasbodev.marvelcomicsmd.data.network.entities

data class CreatorList(
	val available: Int,
	val returned: Int,
	val collectionURI: String,
	val items: List<ApiVariantPlus>,
)
