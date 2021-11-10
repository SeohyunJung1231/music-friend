//package com.example.musicfriend.service
//
//import com.example.musicfriend.entity.Interest
//import com.example.musicfriend.entity.Member
//import com.example.musicfriend.entity.MemberInterest
//import com.example.musicfriend.repository.MemberRepository
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.stereotype.Service
//import javax.annotation.PostConstruct
//
//@Service
//class MemberService(
//) {
//    @Autowired
//    private lateinit var memberRepository: MemberRepository
//
//    @PostConstruct
//    fun save() {
//
//        val memberInterest = MemberInterest(
//            id = 1L
//        )
//
//        val interest = Interest(
//            id = 1L,
//            title = "me"
//        )
//        val member = Member(
//            id = 1L,
//            nickname = "shu",
//            memberInterest = listOf(
//                memberInterest
//            )
//        )
//        member.memberInterest.forEach {
//            it.member = member
//            it.interest = interest
//        }
//
////        member.memberInterest.forEach {
////            it.member = member
////            it.interest = Interest(id = 1L, title = "me")
////        }
//        memberRepository.save(
//            member
//        )
//    }
//}