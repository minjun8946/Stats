package com.example.data.entity

import com.google.gson.annotations.SerializedName

data class BasicTeamData(

    @SerializedName("id")
    val teamId : Int,

    @SerializedName("full_name")
    val teamName : String
)