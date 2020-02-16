package com.example.android_assignment.model

data class CoinsModel(
    val `data`: Data,
    val status: String
)

data class Data(
    val base: Base,
    val coins: List<Coin>,
    val stats: Stats
)

data class Base(
    val sign: String,
    val symbol: String
)

data class Coin(
    val allTimeHigh: AllTimeHigh,
    val approvedSupply: Boolean,
    val change: Double,
    val circulatingSupply: Double,
    val color: String,
    val confirmedSupply: Boolean,
    val description: String,
    val firstSeen: Long,
    val history: List<Double>,
    val iconType: String,
    val iconUrl: String,
    val id: Int,
    val links: List<Link>,
    val marketCap: Long,
    val name: String,
    val numberOfExchanges: Int,
    val numberOfMarkets: Int,
    val penalty: Boolean,
    val price: String,
    val rank: Int,
    val slug: String,
    val socials: List<Social>,
    val symbol: String,
    val totalSupply: Double,
    val type: String,
    val uuid: String,
    val volume: Double,
    val websiteUrl: String
)

data class AllTimeHigh(
    val price: String,
    val timestamp: Long
)

data class Link(
    val name: String,
    val type: String,
    val url: String
)

data class Social(
    val name: String,
    val type: String,
    val url: String
)

data class Stats(
    val base: String,
    val limit: Int,
    val offset: Int,
    val order: String,
    val total: Int,
    val total24hVolume: Double,
    val totalExchanges: Int,
    val totalMarketCap: Double,
    val totalMarkets: Int
)