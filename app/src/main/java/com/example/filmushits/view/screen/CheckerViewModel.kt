package com.example.filmushits.view.screen

import androidx.lifecycle.ViewModel
import com.example.filmushits.Etities.Models.ProfileModel

class CheckerViewModel: ViewModel() {
    fun checkIfLoginValid(text: String): Boolean {
        return text.isNotEmpty()
    }

    fun checkIfNameValid(text: String): Boolean {
        return text.isNotEmpty()
    }

    fun checkIfPasswordValid(text: String): Boolean {
        return text.isNotEmpty()
    }

    fun checkIfBirthDateValid(text: String): Boolean {
        return Regex("""((([1-2][0-9]|3[0-1]|0[1-9]).(0[13-9]|1[0-2])|(0[13-9]|1[0-2]).([1-2][0-9]|3[0-1]|0[1-9])).\d{4})""").matches(text)
    }

    fun checkIfEmailValid(text: String): Boolean {
        return Regex("""^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+.[a-zA-Z0-9-.]+${'$'}""").matches(text)
    }

    fun checkIfPasswordEqualsRepeatedPassword(password: String, repeatedPassword: String): Boolean {
        return password == repeatedPassword
    }

    fun checkIfProfileModelMatches(newProfileModel: ProfileModel, profileModel: ProfileModel): Boolean {
        return newProfileModel.id == profileModel.id &&
                newProfileModel.birthDate == profileModel.birthDate &&
                newProfileModel.name == profileModel.name &&
                newProfileModel.gender == profileModel.gender &&
                newProfileModel.avatarLink == profileModel.avatarLink &&
                newProfileModel.email == profileModel.email &&
                newProfileModel.nickName == profileModel.nickName
    }

    fun revertFormatDate(date: String): String {
        val (day, month, year) = date.split('.')
        return "${year}-${month}-${day}T00:00:00"
    }


    fun formatDate(date: String): String {
        val (year, month, day) = date.split('-')
        return "$day.$month.$year"
    }
}