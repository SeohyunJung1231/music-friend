package com.example.musicfriend.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
data class Composer(
    @Id
    val id: Long,

    val name: String,
    val youtube: String
) {
    @JsonIgnore
    @ManyToOne(cascade = [CascadeType.ALL])
    lateinit var interest: Interest
}