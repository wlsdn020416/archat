package com.example.archat.service;

import com.example.archat.model.Chat;
import com.example.archat.model.repository.ChatRepository;
import com.example.archat.model.repository.InMemoryChatRepository;

import java.time.ZonedDateTime;

public class ChatService {
    private final ChatRepository chatRepository;
    public ChatService() {
        //ChatService - InMemoryChatService
        this.chatRepository = InMemoryChatRepository.getInstance();
    }
    public void sendMessage(Chat chat){
        chatRepository.save(chat);

        String aiResponse = useAi(chat);

        Chat aiChat = new Chat(
                chat.message(),
                "AI",
                chat.sessionId(),
                chat.model(),
                ZonedDateTime.now().toString()
        );
        chatRepository.save(aiChat);
    }
    public String useAi(Chat chat){
        return "%s 라고 하셨네요".formatted(chat.message());
    }
}
