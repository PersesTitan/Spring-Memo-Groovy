package com.spring.MemoGroovy.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class MainController {

    @RequestMapping("/")
    String mainPage() {
        return "redirect:/memos"
    }
}
