package com.jaethem8.jaethem8.dto.personal

data class PersonalContentDTO(
    var title:String="",
    var location:Int=0,
    var content:String="",
    var image:ByteArray?=null,
    var code:String="",
)