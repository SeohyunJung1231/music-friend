package com.example.musicfriend.repository

import com.example.musicfriend.entity.Member
import org.springframework.data.jpa.repository.JpaRepository

interface MemberRepository: JpaRepository<Member, Long> {
}