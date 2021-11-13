package com.example.musicfriend.service

import com.example.musicfriend.entity.Member
import com.example.musicfriend.entity.MemberInterest
import com.example.musicfriend.repository.InterestRepository
import com.example.musicfriend.repository.MemberRepository
import org.springframework.stereotype.Service

@Service
class RegisterService(
    private val memberRepository: MemberRepository,
    private val interestRepository: InterestRepository
) {

    fun register(name: String, interest: String) {
        val newMember = Member(
            nickname = name
        )
        newMember.memberInterest = listOf(MemberInterest())
        newMember.memberInterest.forEach {
            it.interest = interestRepository.findInterestByTitle(interest)
            it.member = newMember
        }
        memberRepository.save(newMember)
    }
}