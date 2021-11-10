package com.example.musicfriend.entity

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
class MemberInterest(
    @Id
    val id: Long,

    @ManyToOne
    val member: Member, // 최소 한개 선택하도록 해야겠네

    @ManyToOne
    val interest: Interest
)