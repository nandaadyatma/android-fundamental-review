package com.example.mymemo.feature_note.presentation.util

sealed class OrderType {
    object Ascending: OrderType()
    object Descending: OrderType()
}