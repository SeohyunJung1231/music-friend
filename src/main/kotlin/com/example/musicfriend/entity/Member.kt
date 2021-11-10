package com.example.musicfriend.entity

import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity
class Member(
    @Id
    val id: Long,

    val nickname: String,

    @OneToMany(mappedBy = "member", cascade = [CascadeType.ALL])
    val memberInterest: List<MemberInterest> = listOf()
)