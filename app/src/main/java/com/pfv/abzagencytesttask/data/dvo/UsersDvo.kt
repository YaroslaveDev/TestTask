package com.pfv.abzagencytesttask.data.dvo

import com.pfv.abzagencytesttask.domain.NetworkEntity

data class UsersDvo(
    val users: List<UserDvo>
) : NetworkEntity