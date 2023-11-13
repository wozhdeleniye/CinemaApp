package com.example.filmushits.Etities.Models

data class MovieElementModel (
    val id: String,
    val name: String,
    var poster: String,
    val year: Int,
    val country: String,
    val genres: List<GenreModel>,
    val reviews: List<ReviewShortModel>
)