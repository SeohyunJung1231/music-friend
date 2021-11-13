package com.example.musicfriend.repository

import com.example.musicfriend.entity.Interest
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface InterestRepository : JpaRepository<Interest, Long> {
}