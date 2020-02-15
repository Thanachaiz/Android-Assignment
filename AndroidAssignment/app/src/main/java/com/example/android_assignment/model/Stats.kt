package com.example.android_assignment.model

data class Stats(
    var base: String,
    var limit: Int,
    var offset: Int,
    var order: String,
    var total: Int,
    var total24hVolume: Double,
    var totalExchanges: Int,
    var totalMarketCap: Double,
    var totalMarkets: Int
)