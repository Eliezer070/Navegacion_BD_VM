package com.eas.dbroom.model

import android.media.RouteListingPreference.Item
import com.eas.dbroom.data.User

data class UserData (
    val name: String,
    val email: String,
    val phone: String
)

fun UserData.toItem()= User(
    id = 0,
    name = name,
    email = email,
    phone = phone
)