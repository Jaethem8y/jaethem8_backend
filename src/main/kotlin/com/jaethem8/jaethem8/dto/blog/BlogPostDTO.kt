package com.jaethem8.jaethem8.dto.blog

import java.sql.Date

data class BlogPostDTO(
    var title:String?=null,
    var role:String?=null,
    var frontend:String?=null,
    var backend:String?=null,
    var general:String?=null
)