package com.example.stats.model

import com.example.domain.entity.Basic
import com.example.domain.entity.Meta
import com.example.domain.entity.StatsBasicInfo

data class StatsBasicInfoModel(
    val data : List<BasicModel>,
    val meta : MetaModel
)

