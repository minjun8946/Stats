package com.example.stats.model

import java.io.Serializable

data class GameResultModel(

    val rank : String,

    val win : String,

    val lose : String,

    val teamId : Int,

    val teamName : String,

    val teamRate : String

) : Serializable