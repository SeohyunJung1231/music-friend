package com.example.musicfriend.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import springfox.documentation.annotations.ApiIgnore

@ApiIgnore
@Controller
class HomeController {
    @RequestMapping("/")
    fun home(): String {
        return "redirect:swagger-ui.html"
    }
}