package com.example.musicfriend.service

import com.example.musicfriend.repository.MemberRepository
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.Rollback
import javax.transaction.Transactional

@SpringBootTest
internal class RegisterServiceTest {
    @Autowired
    private lateinit var registerService: RegisterService

    @Autowired
    private lateinit var memberRepository: MemberRepository

    @Rollback(true)
    @Transactional
    @Test
    fun registerTest() {
        registerService.register("shu", "romantic")
        println("결과 : ${memberRepository.findById(1L).get()}")
    }
}