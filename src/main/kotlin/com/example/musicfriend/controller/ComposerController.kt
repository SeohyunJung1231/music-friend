package com.example.musicfriend.controller

import com.example.musicfriend.entity.Composer
import com.example.musicfriend.repository.ComposerRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/composer")
class ComposerController(
    private val composerRepository: ComposerRepository
) {
    @GetMapping("/all")
    fun getAllComposers(): List<Composer> {
        return composerRepository.findAll()
    }
}