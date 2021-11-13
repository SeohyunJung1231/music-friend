package com.example.musicfriend.service

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.Rollback
import org.springframework.transaction.annotation.Transactional

@SpringBootTest
internal class MusicMatchingServiceTest {
    @Autowired
    private lateinit var musicMatchingService: MusicMatchingService

    @Autowired
    private lateinit var registerService: RegisterService

    @Transactional
    @Rollback(false)
    @Test
    fun findMusicTest() {
        registerService.register("shu", "romantic")
        println("결과 : ${musicMatchingService.findMusic("shu")}")
    }
}