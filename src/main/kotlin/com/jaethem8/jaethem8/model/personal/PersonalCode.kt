package com.jaethem8.jaethem8.model.personal

import com.fasterxml.jackson.annotation.JsonBackReference
import javax.persistence.*

@Entity
@Table(name="personal_code")
data class PersonalCode (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    val id:Long=0,
    @Column(name="location")
    val location:Int=0,
    @Column(name = "content", length = 16777215, columnDefinition = "mediumtext")
    val code:String="",
    @ManyToOne(cascade = [CascadeType.ALL])
    @JsonBackReference
    @JoinColumn(name="personal_post_id")
    var personalPost: PersonalPost?,
)