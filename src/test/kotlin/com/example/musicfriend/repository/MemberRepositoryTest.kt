package com.example.musicfriend.repository

import com.example.musicfriend.entity.Composer
import com.example.musicfriend.entity.Interest
import com.example.musicfriend.entity.Member
import com.example.musicfriend.entity.MemberInterest
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class MemberRepositoryTest {
    @Autowired
    private lateinit var memberRepository: MemberRepository

    @Test
//    @Rollback(false)
    fun `db 에 잘 저장되는지 확인`() {

        val memberInterest = MemberInterest(
            id = 1L
        )

        val interest = Interest(
            id = 1L,
            title = "me",
            composers = listOf(
                Composer(
                    id = 1L,
                    name = "sh",
                    youtube = "https://"
                )
            )
        )
        interest.composers.forEach {
            it.interest = interest
        }
        val member = Member(
            id = 1L,
            nickname = "shu",
            memberInterest = listOf(
                memberInterest
            )
        )
        member.memberInterest.forEach {
            it.member = member
            it.interest = interest
        }

        memberRepository.save(
            member
        )
    }
}