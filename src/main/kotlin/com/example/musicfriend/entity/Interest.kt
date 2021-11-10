package com.example.musicfriend.entity

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity
class Interest(
    @Id
    val id: Long,

    val title: String,

    @OneToMany
    val music: List<Music> = listOf()
)