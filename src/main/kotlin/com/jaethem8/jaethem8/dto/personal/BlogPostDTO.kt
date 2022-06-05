package com.jaethem8.jaethem8.dto.personal

import java.sql.Date

data class BlogPostDTO(
    var title:String="",
    var location:Int=0,
    var content:String="",
    var image:ByteArray?=null,
    var code:String="",
)