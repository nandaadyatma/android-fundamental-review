package com.example.rabbitapp.data.remote.response

import com.google.gson.annotations.SerializedName

data class RabbitResponse(

	@field:SerializedName("imageUrl")
	val imageUrl: String,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("description")
	val description: String
)
