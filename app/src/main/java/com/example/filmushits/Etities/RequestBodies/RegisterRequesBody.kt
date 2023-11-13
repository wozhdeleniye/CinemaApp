package com.example.filmushits.Etities.RequestBodies


data class RegisterRequestBody(
    var userName: String,
    var name: String,
    var password: String,
    var email: String,
    var birthDate: String,
    var gender: Int
)