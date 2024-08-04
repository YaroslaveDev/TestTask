package com.pfv.abzagencytesttask.data.dvo

import com.pfv.abzagencytesttask.domain.NetworkEntity

data class AvailablePositionsDvo(
    val positions: List<PositionDvo>
) : NetworkEntity
