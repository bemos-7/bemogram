package com.bemos.data.mappers

import com.bemos.data.models.Message
import com.bemos.domain.model.MessageDomain

object MessageMapper {

    fun toDomain(message: Message) : MessageDomain {
        return MessageDomain(
            chatId = message.chatId,
            text = message.text,
            senderId = message.senderId
        )
    }

    fun toMessage(messageDomain: MessageDomain) : Message {
        return Message(
            chatId = messageDomain.chatId,
            text = messageDomain.text,
            senderId = messageDomain.senderId
        )
    }

}