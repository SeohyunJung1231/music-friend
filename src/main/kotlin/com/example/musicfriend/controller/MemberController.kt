package com.example.musicfriend.controller

import com.example.musicfriend.entity.Member
import com.example.musicfriend.repository.MemberRepository
import com.example.musicfriend.service.MusicMatchingService
import com.example.musicfriend.service.RegisterService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/member")
class MemberController(
    private val memberRepository: MemberRepository,
    private val registerService: RegisterService,
    private val musicMatchingService: MusicMatchingService
) {
    @GetMapping("/all")
    fun getAllMembers(): List<Member> {
        return memberRepository.findAll()
    }

    @GetMapping
    fun register(
        @RequestParam(required = true) name: String,
        @RequestParam(required = true) interest: String
    ) {
        registerService.register(name, interest)
    }

    @GetMapping("/{name}")
    fun findMusicForMember(
        @PathVariable name: String
    ): List<String> {
        return musicMatchingService.findMusic(name)
    }
}