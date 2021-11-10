package com.example.musicfriend.entity

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
class MemberInterest(
    @Id
    val id: Long,
) {
    @ManyToOne
    lateinit var member: Member

    @ManyToOne
    lateinit var interest: Interest
}