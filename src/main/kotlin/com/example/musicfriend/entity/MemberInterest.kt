package com.example.musicfriend.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
data class MemberInterest(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L
) {
    @JsonIgnore
    @ManyToOne(cascade = [CascadeType.ALL])
    lateinit var member: Member

    @JsonIgnore
    @ManyToOne(cascade = [CascadeType.ALL])
    lateinit var interest: Interest
}