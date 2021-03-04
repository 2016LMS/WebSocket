package com.winwain.webSocket.controller;

import com.winwain.webSocket.pojo.Message;
import com.winwain.webSocket.pojo.OutputMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;
@Controller
public class MessageController {
    @MessageMapping("/chatting")
    @SendTo("/topic/messages") //@SendTo()广播消息到前端监听/topic/message的地方
    public OutputMessage send(Message message) throws Exception {
        String time = new SimpleDateFormat("HH:mm").format(new Date());
        return new OutputMessage(message.getFrom(), message.getText(), time);
    }
}
