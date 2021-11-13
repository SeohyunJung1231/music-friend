package com.example.musicfriend.controller

import com.example.musicfriend.entity.Member
import com.example.musicfriend.repository.MemberRepository
import com.example.musicfriend.service.MusicMatchingService
import com.example.musicfriend.service.RegisterService
import io.swagger.annotations.ApiOperation
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/member")
class MemberController(
    private val memberRepository: MemberRepository,
    private val registerService: RegisterService,
    private val musicMatchingService: MusicMatchingService
) {
    @ApiOperation(value = "모든 맴버 조회")
    @GetMapping("/all")
    fun getAllMembers(): List<Member> {
        return memberRepository.findAll()
    }

    @ApiOperation(value = "맴버 등록")
    @GetMapping
    fun register(
        @RequestParam(required = true) name: String,
        @RequestParam(required = true) interest: String
    ) {
        registerService.register(name, interest)
    }

    @ApiOperation(value = "맴버의 곡 추천 링크 조회")
    @GetMapping("/{name}")
    fun findMusicForMember(
        @PathVariable name: String
    ): List<String> {
        return musicMatchingService.findMusic(name)
    }
}