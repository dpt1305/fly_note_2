package aden.dev.site.fly_note.controller;

import aden.dev.site.fly_note.dto.NoteMessage;
import org.apache.tomcat.util.json.JSONFilter;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class NoteWebSocketController {

    @MessageMapping("/notes/{nodeId}")  // Client sends to /app/notes
    @SendTo("/topic/notes/{nodeId}")         // Server broadcasts to /topic/notes
    public NoteMessage handleNoteUpdate(@DestinationVariable String nodeId , @Payload NoteMessage message) {
        System.out.println("Message received: " + message.toString() + nodeId);
        System.out.println(message.toString());
        message.setTimestamp(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        return message;
    }
}