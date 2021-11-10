package com.example.musicfriend.entity

import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
class Music(
    @Id
    val id: Long,

    val name: String,
    val youtube: String
) {
    @ManyToOne(cascade = [CascadeType.ALL])
    lateinit var interest: Interest
}