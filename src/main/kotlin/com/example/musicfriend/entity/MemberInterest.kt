package com.example.musicfriend.entity

import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
class MemberInterest(
    @Id
    val id: Long,
) {
    @ManyToOne(cascade = [CascadeType.ALL])
    lateinit var member: Member

    @ManyToOne(cascade = [CascadeType.ALL])
    lateinit var interest: Interest
}