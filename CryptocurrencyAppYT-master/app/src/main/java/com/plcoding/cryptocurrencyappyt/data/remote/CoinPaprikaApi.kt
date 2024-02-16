package com.plcoding.cryptocurrencyappyt.data.remote

import com.plcoding.cryptocurrencyappyt.data.remote.dto.CoinDetailDto
import com.plcoding.cryptocurrencyappyt.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi {
    @GET("/vi/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("/vi/coins/{coindId}")
    suspend fun getCoinById(@Path("coinId") coinId: String): CoinDetailDto

}