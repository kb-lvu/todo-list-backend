package com.lvu.todo.controller

import com.lvu.todo.domain.Todo
import com.lvu.todo.service.TodoService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/todos")
class TodoController(private val todoService: TodoService) {

    /** 📌 할 일 생성 */
    @PostMapping
    fun createTodo(@RequestBody todo: Todo): ResponseEntity<Todo> {
        val createdTodo = todoService.createTodo(todo)
        return ResponseEntity.ok(createdTodo)
    }

    /** 📌 모든 할 일 조회 */
    @GetMapping
    fun getAllTodos(): ResponseEntity<List<Todo>> {
        val todos = todoService.getAllTodos()
        return ResponseEntity.ok(todos)
    }

    /** 📌 특정 할 일 조회 */
    @GetMapping("/{id}")
    fun getTodoById(@PathVariable id: Long): ResponseEntity<Todo> {
        val todo = todoService.getTodoById(id)
        return ResponseEntity.ok(todo)
    }

    /** 📌 할 일 수정 */
    @PutMapping("/{id}")
    fun updateTodo(@PathVariable id: Long, @RequestBody updatedTodo: Todo): ResponseEntity<Todo> {
        val todo = todoService.updateTodo(id, updatedTodo)
        return ResponseEntity.ok(todo)
    }

    /** 📌 할 일 삭제 */
    @DeleteMapping("/{id}")
    fun deleteTodo(@PathVariable id: Long): ResponseEntity<Void> {
        todoService.deleteTodo(id)
        return ResponseEntity.noContent().build()
    }
}
