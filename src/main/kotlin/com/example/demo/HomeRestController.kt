package com.example.demo

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate

@RestController
class HomeRestController {

    @RequestMapping("/resthello")
    fun hello(): String {
        return """
            Hello.
            It works!
            現在時刻は${LocalDate.now()}
        """.trimIndent()
    }
}