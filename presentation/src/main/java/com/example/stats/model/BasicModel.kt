package com.example.stats.model

import com.example.domain.entity.Basic

data class BasicModel(

    val personId : String,
    val name : String,
    val position : String,
    val height : String,
    val pounds : String,
    val teamId : String,
    val teamName : String
)

fun Basic.toBasicModel() : BasicModel =
    BasicModel(
        personId= "$personId",
        name= "$firstName $lastName",
        position= position,
        height = "${changeHeight(height_feet,height_inches)}",
        pounds = "${changePounds(weight_pounds)}",
        teamId = "$teamId",
        teamName = teamName
    )

fun changeHeight(feet: Int, inches: Int): Double {
    return (inches * 2.54) + (feet * 30.48)
}

fun changePounds(pounds : Int) : Double{
    return pounds * 0.45
}

