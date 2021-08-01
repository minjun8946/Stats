package com.example.data.dto.request

data class AllPlayerPageRequest(

    val page : Int,

    val per_page : Int,

    val search : String

)