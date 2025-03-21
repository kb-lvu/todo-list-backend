package com.lvu.todo.domain

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "todos")
data class Todo(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false)
    var title: String,

    var description: String? = null,

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    var status: TodoStatus = TodoStatus.PENDING, // 기본값을 명확히 설정

    @Column(nullable = false, updatable = false)
    var createdAt: LocalDateTime? = null, // null 가능하도록 변경

    @Column(nullable = false)
    var updatedAt: LocalDateTime? = null // null 가능하도록 변경
) {
    // 엔티티가 저장되기 전에 호출되는 메서드
    @PrePersist
    fun prePersist() {
        createdAt = LocalDateTime.now() // 엔티티가 저장되기 전에 createdAt에 현재 시간 설정
        updatedAt = createdAt // createdAt과 updatedAt을 동일한 값으로 초기화
        if (status == null) { // 만약 status가 null이라면 기본값으로 설정
            status = TodoStatus.PENDING
        }
    }

    // 엔티티가 수정될 때마다 호출되는 메서드
    @PreUpdate
    fun preUpdate() {
        updatedAt = LocalDateTime.now() // 엔티티가 수정될 때마다 updatedAt 갱신
    }
}

enum class TodoStatus {
    PENDING, IN_PROGRESS, COMPLETED
}
