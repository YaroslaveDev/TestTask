package com.pfv.abzagencytesttask.data.dto

import com.google.gson.annotations.SerializedName
import com.pfv.abzagencytesttask.data.remote.network.NetworkResult
import com.pfv.abzagencytesttask.domain.NetworkEntity

data class AvailablePositionsResponseDto(
    @SerializedName("positions")
    val positions: List<PositionDto>?
) : NetworkEntity
