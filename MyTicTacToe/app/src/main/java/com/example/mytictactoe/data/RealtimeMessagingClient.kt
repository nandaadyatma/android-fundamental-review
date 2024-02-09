package com.example.mytictactoe.data

import com.nandaadyatma.models.GameState
import com.nandaadyatma.models.MakeTurn
import kotlinx.coroutines.flow.Flow

interface RealtimeMessagingClient {
    fun getGameStateStream(): Flow<GameState>
    suspend fun sendAction(action: MakeTurn)
    suspend fun close()
}