package com.example.data.entity

import com.google.gson.annotations.SerializedName

data class BasicPlayerData(

    @SerializedName("id")
    val personId : Int,

    @SerializedName("first_name")
    val firstName : String,

    @SerializedName("last_name")
    val lastName : String
)