package com.example.domain.entity

data class Date(
    val date : String?,
    val season : Int?,
    val teamId : Int?,
    val postseason : Boolean?,
    val page : Int,
    val perPage : Int
)