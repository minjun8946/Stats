package com.example.data.reomte.response

import com.example.data.entity.BasicData
import com.example.data.entity.MetaData

data class GetAllPlayerResponse(
    val data : ArrayList<BasicData>,

    val meta : MetaData
)

