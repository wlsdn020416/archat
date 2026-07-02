package com.example.archat.service;

import com.example.archat.model.Chat;
import com.example.archat.model.repository.ChatRepository;
import com.example.archat.model.repository.InMemoryChatRepository;

import java.time.ZonedDateTime;
import java.util.List;

public class ChatService {
    private final ChatRepository chatRepository;
    private ChatService() {
        //ChatService - InMemoryChatService
        this.chatRepository = InMemoryChatRepository.getInstance();
    }
    private static ChatService instance = new ChatService();
    public static ChatService getInstance() {
        return instance;
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
    public List<Chat> readHistory(String userId){
        return chatRepository.findAllByUserId(userId);
    }
}
