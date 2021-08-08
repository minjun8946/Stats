package com.example.data.entity

import com.example.domain.entity.Meta
import com.google.gson.annotations.SerializedName

data class MetaData(
    @SerializedName("total_pages")
    val totalPage : Int,
    @SerializedName("next_page")
    val page : Int?
)

fun MetaData.toEntity() =
    Meta(
        totalPage = totalPage,
        page= page
    )