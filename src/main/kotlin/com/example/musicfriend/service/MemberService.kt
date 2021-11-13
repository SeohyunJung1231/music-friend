package com.example.musicfriend.service

import com.example.musicfriend.entity.Composer
import com.example.musicfriend.entity.Interest
import com.example.musicfriend.repository.InterestRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.annotation.PostConstruct

@Service
class MemberService {
    @Autowired
    private lateinit var interestRepository: InterestRepository

    @PostConstruct
    fun save() {
        val originalData = listOf(
            Interest(
                id = 1L,
                title = "romantic",
                composers = listOf(
                    Composer(
                        id = 1L,
                        name = "Shumann",
                        youtube = "https://www.youtube.com/watch?v=UXYIpI1tck8"
                    ),
                    Composer(
                        id = 2L,
                        name = "Liszt",
                        youtube = "https://www.youtube.com/watch?v=H6UZhMl35lE&t=2179s"
                    )
                )
            ),
            Interest(
                id = 2L,
                title = "classic",
                composers = listOf(
                    Composer(
                        id = 3L,
                        name = "Beethoven",
                        youtube = "https://www.youtube.com/watch?v=cOj0qIRpA-E"
                    ),
                    Composer(
                        id = 4L,
                        name = "Mozart",
                        youtube = "https://www.youtube.com/watch?v=qX7J1HejyHU"
                    )
                )
            )
        )
        originalData.forEach { interest ->
            interest.composers.forEach { music ->
                music.interest = interest
            }
            interestRepository.save(interest)
        }
    }
}