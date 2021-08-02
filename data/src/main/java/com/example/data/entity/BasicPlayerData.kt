package com.example.data.entity

import com.example.domain.entity.BasicPlayer
import com.google.gson.annotations.SerializedName

data class BasicPlayerData(
    @SerializedName("id")
    val personId : Int,
    @SerializedName("first_name")
    val firstName : String,
    @SerializedName("last_name")
    val lastName : String
)

fun BasicPlayerData.toEntity() =
    BasicPlayer(
        personId = personId,
        firstName = firstName,
        lastName = lastName
    )