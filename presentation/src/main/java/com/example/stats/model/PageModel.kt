package com.example.stats.model

import com.example.domain.entity.Page

data class PageModel(
    var page : Int?,
    val perPage : Int?,
    val search : String?
)

fun PageModel.toEntity() =
    Page(
        page =page,
        perPage = perPage,
        search = search
    )