package com.example.musicfriend.service

import com.example.musicfriend.repository.MemberRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class MusicMatchingService(
    private val memberRepository: MemberRepository
) {

    @Transactional
    fun findMusic(name: String): List<String> {
        val member = memberRepository.findMemberByNickname(name)
        return member.memberInterest.first().interest.composers.map {
            it.youtube
        }
    }

}