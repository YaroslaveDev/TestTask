package com.pfv.abzagencytesttask.data.mapper

import com.pfv.abzagencytesttask.data.dto.AvailablePositionsResponseDto
import com.pfv.abzagencytesttask.data.dto.UsersDto
import com.pfv.abzagencytesttask.data.dvo.AvailablePositionsDvo
import com.pfv.abzagencytesttask.data.dvo.PositionDvo
import com.pfv.abzagencytesttask.data.dvo.UsersDvo

class AvailablePositionsDtoToDvoMapper(
    data: AvailablePositionsResponseDto?,
) : Mapper<AvailablePositionsResponseDto?, AvailablePositionsDvo?>(data) {

    override fun transform(): AvailablePositionsDvo {

        return AvailablePositionsDvo(
            data?.positions?.map {
                PositionDvo(
                    id = it.id.orEmpty(),
                    name = it.name.orEmpty()
                )
            }.orEmpty()
        )
    }
}