package com.lvu.todo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication

@SpringBootApplication
@EntityScan(basePackages = ["com.lvu.todo.domain"])  // 엔티티 패키지 경로 설정
class TodoListBackendApplication

fun main(args: Array<String>) {
    runApplication<TodoListBackendApplication>(*args)
}
