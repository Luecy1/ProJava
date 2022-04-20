package com.example.demo

import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class HomeRestController {

    private val taskItems = mutableListOf<TaskItem>()

    @RequestMapping("/resthello")
    fun hello(model: Model): String {
//        model.addAttribute("time", LocalDateTime.now())
        return "hello"
    }

    @GetMapping("/restadd")
    fun addItem(@RequestParam("task") task: String, @RequestParam("deadline") deadline: String): String {

        val id = UUID.randomUUID().toString().substring(0, 8)
        val item = TaskItem(id, task, deadline, false)
        taskItems.add(item)

        return "タスクを追加しました"
    }

    @GetMapping("restlist")
    fun listItems(): String {
        return taskItems.joinToString(", ") { it.toString() }
    }
}