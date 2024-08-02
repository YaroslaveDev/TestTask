package com.pfv.abzagencytesttask.data.mapper

import com.pfv.abzagencytesttask.data.dto.UsersDto
import com.pfv.abzagencytesttask.data.dvo.UserDvo
import com.pfv.abzagencytesttask.data.dvo.UsersDvo


class UsersDataDtoToDvoMapper(
    data: UsersDto?,
) : Mapper<UsersDto?, UsersDvo?>(data) {

    override fun transform(): UsersDvo {

        return UsersDvo(
            users = data?.users?.map { userDto ->
                UserDvo(
                    id = userDto.id ?: -1,
                    name = userDto.name.orEmpty(),
                    email = userDto.email.orEmpty(),
                    phone = userDto.phone.orEmpty(),
                    photo = userDto.photo.orEmpty()
                )
            }.orEmpty()
        )
    }
}