package com.example.filmushits.Etities.Models

data class MoviesPagedListModel (
    val movies: List<MovieElementModel>,
    val pageInfo: PageInfoModel
)