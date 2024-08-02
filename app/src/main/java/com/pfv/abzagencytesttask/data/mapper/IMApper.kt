package com.pfv.abzagencytesttask.data.mapper

interface IMapper<DST> {
    fun transform(): DST
}