package com.example.musicfriend.entity

import javax.persistence.*

@Entity
data class Member(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L,

    val nickname: String,

    @OneToMany(mappedBy = "member", cascade = [CascadeType.ALL])
    var memberInterest: List<MemberInterest> = listOf()
)