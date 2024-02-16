package com.plcoding.cryptocurrencyappyt.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.plcoding.cryptocurrencyappyt.domain.model.Coin

data class CoinDto(

    @field:SerializedName("symbol")
    val symbol: String,

    @field:SerializedName("is_active")
    val isActive: Boolean,

    @field:SerializedName("is_new")
    val isNew: Boolean,

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("rank")
    val rank: Int,

    @field:SerializedName("id")
    val id: String,

    @field:SerializedName("type")
    val type: String
)

fun CoinDto.toCoin(): Coin {
    return Coin(
        id = this.id,
        isActive = this.isActive,
        name = this.name,
        rank = this.rank,
        symbol = this.symbol

    )
}
