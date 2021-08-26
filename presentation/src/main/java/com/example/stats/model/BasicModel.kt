package com.example.stats.model

import com.example.domain.entity.Basic
import com.example.stats.base.teamImage
import java.io.Serializable
import kotlin.math.roundToInt

data class BasicModel(

    val personId : Int,
    val name : String,
    val position : String,
    val height : String,
    val pounds : String,
    val teamId : Int,
    val teamName : String
):Serializable

fun Basic.toBasicModel() : BasicModel =
    BasicModel(
        personId= personId,
        name= "$firstName $lastName",
        position= position,
        height = "${changeHeight(height_feet,height_inches)}cm",
        pounds = "${changePounds(weight_pounds)}kg",
        teamId = teamImage(teamId),
        teamName = teamName
    )

fun changeHeight(feet: Int, inches: Int): Int {
    val cm = (inches * 2.54) + (feet * 30.48)
    return cm.roundToInt()
}

fun changePounds(pounds : Int) : Int{
    val kg = pounds * 0.45
    return kg.roundToInt()
}