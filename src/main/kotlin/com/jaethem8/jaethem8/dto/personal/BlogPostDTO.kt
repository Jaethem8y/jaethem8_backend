package com.jaethem8.jaethem8.dto.personal

import java.sql.Date

data class BlogPostDTO(
    var pubDate: Date?=null,
    var title:String?=null,
)