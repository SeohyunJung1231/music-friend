package com.example.musicfriend.service

import com.example.musicfriend.entity.Interest
import com.example.musicfriend.entity.Music
import com.example.musicfriend.repository.InterestRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.annotation.PostConstruct

@Service
class MemberService(
) {
    @Autowired
    private lateinit var interestRepository: InterestRepository

    @PostConstruct
    fun save() {
        val originalData = listOf(
            Interest(
                id = 1L,
                title = "romantic",
                music = listOf(
                    Music(
                        id = 1L,
                        name = "Shumann",
                        youtube = "https://www.youtube.com/watch?v=UXYIpI1tck8"
                    ),
                    Music(
                        id = 2L,
                        name = "Liszt",
                        youtube = "https://www.youtube.com/watch?v=H6UZhMl35lE&t=2179s"
                    )
                )
            ),
            Interest(
                id = 2L,
                title = "classic",
                music = listOf(
                    Music(
                        id = 3L,
                        name = "Beethoven",
                        youtube = "https://www.youtube.com/watch?v=cOj0qIRpA-E"
                    ),
                    Music(
                        id = 4L,
                        name = "Mozart",
                        youtube = "https://www.youtube.com/watch?v=qX7J1HejyHU"
                    )
                )
            )
        )
        originalData.forEach { interest ->
            interest.music.forEach { music ->
                music.interest = interest
            }
            interestRepository.save(interest)
        }
    }
}