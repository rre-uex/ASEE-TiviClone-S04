package es.unex.giiis.asee.tiviclone.model

import java.io.Serializable

data class Show(
    val title: String,
    val description: String,
    val year: String,
    val seasons: String,
    val image: Int,
    val coverImage: Int,
    val genres: List<String> = emptyList()
) : Serializable
