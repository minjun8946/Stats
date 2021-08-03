package com.example.data.entity

import com.example.domain.entity.Page

data class PageData(
    val page : Int?,
    val perPage : Int?,
    val search : String?
)

fun Page.toEntity() : PageData =
    PageData(
        page = page,
        perPage = perPage,
        search = search
    )
