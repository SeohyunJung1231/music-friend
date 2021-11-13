package com.example.musicfriend.repository

import com.example.musicfriend.entity.Composer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ComposerRepository : JpaRepository<Composer, Long> {
}