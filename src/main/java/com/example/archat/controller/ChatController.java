package com.example.archat.controller;

import com.example.archat.service.ChatService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


@WebServlet("/chat")
public class ChatController extends BaseController {
    private ChatService chatService;

    @Override
    public void init() throws ServletException {
        chatService = ChatService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        req.setAttribute("chats",chatService.readHistory(session.getId()));
        req.getRequestDispatcher(VIEW_PREFIX + "chat.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
