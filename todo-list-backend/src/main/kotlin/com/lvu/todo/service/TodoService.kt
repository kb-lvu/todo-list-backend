package com.lvu.todo.service

import com.lvu.todo.domain.Todo
import com.lvu.todo.repository.TodoRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class TodoService(private val todoRepository: TodoRepository) {

    /** 📌 할 일 생성 */
    fun createTodo(todo: Todo): Todo {
        return todoRepository.save(todo)
    }

    /** 📌 모든 할 일 조회 */
    fun getAllTodos(): List<Todo> {
        return todoRepository.findAll()
    }

    /** 📌 특정 할 일 조회 */
    fun getTodoById(id: Long): Todo {
        return todoRepository.findById(id).orElseThrow { IllegalArgumentException("Todo not found") }
    }

    /** 📌 할 일 수정 */
    @Transactional
    fun updateTodo(id: Long, updatedTodo: Todo): Todo {
        val todo = getTodoById(id)
        todo.apply {
            title = updatedTodo.title
            description = updatedTodo.description
            status = updatedTodo.status
        }
        return todo
    }

    /** 📌 할 일 삭제 */
    fun deleteTodo(id: Long) {
        todoRepository.deleteById(id)
    }
}
