package com.jaethem8.jaethem8.dto.blog

import java.sql.Date
import java.sql.Time

data class BlogPostDTO(
    var pubDate: Date?=null,
    var pubTime: Time?=null,
    var title:String?=null,
)