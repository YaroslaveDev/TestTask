package com.pfv.abzagencytesttask.data.mapper

abstract class Mapper<SRC, DST>(val data: SRC?) : IMapper<DST>