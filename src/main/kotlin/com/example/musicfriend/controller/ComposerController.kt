package com.example.musicfriend.controller

import com.example.musicfriend.entity.Composer
import com.example.musicfriend.repository.ComposerRepository
import io.swagger.annotations.ApiOperation
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/composer")
class ComposerController(
    private val composerRepository: ComposerRepository
) {
    @ApiOperation(value = "모든 곡 조회")
    @GetMapping("/all")
    fun getAllComposers(): List<Composer> {
        return composerRepository.findAll()
    }
}