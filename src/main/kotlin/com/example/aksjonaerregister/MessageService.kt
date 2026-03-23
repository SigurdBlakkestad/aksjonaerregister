//MessageService.kt
package com.example.aksjonaerregister

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.jdbc.core.query
import java.util.UUID

@Service
class MessageService(private val db: MessageRepository) {
    fun findMessages(): List<Message> = db.findAll().toList()

    fun findMessageById(id: String): Message? = db.findByIdOrNull(id)

    fun save(message: Message): Message = db.save(message)
}