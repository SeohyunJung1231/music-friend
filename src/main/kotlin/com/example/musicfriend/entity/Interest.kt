package com.example.musicfriend.entity

import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity
class Interest(
    @Id
    val id: Long,

    val title: String,

    @OneToMany(mappedBy = "interest", cascade = [CascadeType.ALL])
    val music: List<Music> = listOf()
)