package com.example.stats.model

import com.example.domain.entity.Basic
import com.example.domain.entity.Meta

data class StatsBasicInfoModel(
    val data : List<Basic>,

    val meta : Meta
)