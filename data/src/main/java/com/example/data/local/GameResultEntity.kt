package com.example.data.local

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.data.entity.HomeTeamData
import com.example.data.entity.VisitorTeamData
import com.example.data.entity.toEntity
import com.example.domain.entity.GameResult

@Entity
data class GameResultEntity(

    @PrimaryKey(autoGenerate = true)
    val gameId : Int,

    val gameDate : String,

    val homeTeamScore : String,

    val visitorTeamScore : String,

    val season : String,

    val period : Int,

    val status : String,

    val postSeason : Boolean,

    @Embedded
    val visitorTeam: ResultVisitorTeamData,
    @Embedded
    val homeTeam: ResultHomeTeamData
)

fun GameResult.toEntity() =
    GameResultEntity(
        gameId = gameId,

        gameDate = gameDate,

        homeTeamScore = homeTeamScore,

        visitorTeamScore = visitorTeamScore,

        season = season,

        period = period,

        status = status,

        postSeason = postSeason,

        visitorTeam = visitorTeam.toResultVisitorTeamData(),

        homeTeam = homeTeam.toResultHomeTeamData()
    )

fun GameResultEntity.toEntity() =
    GameResult(
        gameId = gameId,

        gameDate = gameDate,

        homeTeamScore = homeTeamScore,

        visitorTeamScore = visitorTeamScore,

        season = season,

        period = period,

        status = status,

        postSeason = postSeason,

        visitorTeam = visitorTeam.toVisitorTeam(),

        homeTeam = homeTeam.toHomeTeam()
    )

