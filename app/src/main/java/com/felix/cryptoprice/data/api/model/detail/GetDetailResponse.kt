package com.felix.cryptoprice.data.api.model.detail


import com.google.gson.annotations.SerializedName

data class GetDetailResponse(
    @SerializedName("status")
    val status: Status,
    @SerializedName("data")
    val `data`: Data
) {
    data class Status(
        @SerializedName("timestamp")
        val timestamp: String,
        @SerializedName("error_code")
        val errorCode: Int,
        @SerializedName("error_message")
        val errorMessage: Any?,
        @SerializedName("elapsed")
        val elapsed: Int,
        @SerializedName("credit_count")
        val creditCount: Int,
        @SerializedName("notice")
        val notice: Any?
    )

    data class Data(
        @SerializedName("BTC")
        val bTC: BTC
    ) {
        data class BTC(
            @SerializedName("id")
            val id: Int,
            @SerializedName("name")
            val name: String,
            @SerializedName("symbol")
            val symbol: String,
            @SerializedName("category")
            val category: String,
            @SerializedName("description")
            val description: String,
            @SerializedName("slug")
            val slug: String,
            @SerializedName("logo")
            val logo: String,
            @SerializedName("subreddit")
            val subreddit: String,
            @SerializedName("notice")
            val notice: String,
            @SerializedName("tags")
            val tags: List<String>,
            @SerializedName("tag-names")
            val tagNames: List<String>,
            @SerializedName("tag-groups")
            val tagGroups: List<String>,
            @SerializedName("urls")
            val urls: Urls,
            @SerializedName("platform")
            val platform: Any?,
            @SerializedName("date_added")
            val dateAdded: String,
            @SerializedName("twitter_username")
            val twitterUsername: String,
            @SerializedName("is_hidden")
            val isHidden: Int,
            @SerializedName("date_launched")
            val dateLaunched: Any?,
            @SerializedName("contract_address")
            val contractAddress: List<Any>,
            @SerializedName("self_reported_circulating_supply")
            val selfReportedCirculatingSupply: Any?,
            @SerializedName("self_reported_tags")
            val selfReportedTags: Any?,
            @SerializedName("self_reported_market_cap")
            val selfReportedMarketCap: Any?
        ) {
            data class Urls(
                @SerializedName("website")
                val website: List<String>,
                @SerializedName("twitter")
                val twitter: List<Any>,
                @SerializedName("message_board")
                val messageBoard: List<String>,
                @SerializedName("chat")
                val chat: List<Any>,
                @SerializedName("facebook")
                val facebook: List<Any>,
                @SerializedName("explorer")
                val explorer: List<String>,
                @SerializedName("reddit")
                val reddit: List<String>,
                @SerializedName("technical_doc")
                val technicalDoc: List<String>,
                @SerializedName("source_code")
                val sourceCode: List<String>,
                @SerializedName("announcement")
                val announcement: List<Any>
            )
        }
    }
}