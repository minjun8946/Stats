package com.example.stats.base

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.stats.R
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
fun koreanDay(dateString : String) : String{
    val date = LocalDate.parse(dateString, DateTimeFormatter.ISO_DATE)
    return "${date.plusDays(1)}"
}

fun teamImage(teamId : Int) : Int{
    return when(teamId){
        1 -> R.drawable.atlanta_hawks
        2 -> R.drawable.boston_celtics
        3 -> R.drawable.brooklyn_nets
        4 -> R.drawable.charlotte_hornets
        5 -> R.drawable.chicago_bulls
        6 -> R.drawable.cleveland_cavaliers
        7 -> R.drawable.dallas_mavericks
        8 -> R.drawable.denver_nuggets
        9 -> R.drawable.detroit_pistons
        10 -> R.drawable.golden_state_warriors
        11 -> R.drawable.houston_rockets
        12 -> R.drawable.indiana_pacers
        13 -> R.drawable.los_angeles_clippers
        14 -> R.drawable.los_angeles_lakers
        15 -> R.drawable.memphis_grizzlies
        16 -> R.drawable.miami_heat
        17 -> R.drawable.milwaukee_bucks
        18 -> R.drawable.minnesota_timberwolves
        19 -> R.drawable.new_orleans_pelicans
        20 -> R.drawable.new_york_knicks
        21 -> R.drawable.oklahoma_city_thunder
        22 -> R.drawable.orlando_magic
        23 -> R.drawable.philadelphia_76ers
        24 -> R.drawable.phoenix_suns
        25 -> R.drawable.portland_trail_blazers
        26 -> R.drawable.sacramento_kings
        27 -> R.drawable.san_antonio_spurs
        28 -> R.drawable.toronto_raptors
        29 -> R.drawable.utah_jazz
        30 -> R.drawable.washington_wizards
        else -> R.drawable.washington_wizards
    }
}