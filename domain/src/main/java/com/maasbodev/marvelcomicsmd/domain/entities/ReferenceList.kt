package com.maasbodev.marvelcomicsmd.domain.entities

data class ReferenceList(
    val type: Type,
    val references: List<Reference>
) {
    enum class Type {
        CHARACTER,
        COMIC,
        STORY,
        EVENT,
        SERIES
    }
}
