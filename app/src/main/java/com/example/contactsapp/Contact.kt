package com.example.contactsapp

import androidx.annotation.DrawableRes

data class Contact(
    val name : String,
    val phoneNumber : String,
    @DrawableRes val image : Int,
)
