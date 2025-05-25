package com.example.app.dto.response;

import lombok.Data;

@Data
public class MessageResponse {
    private final String text;

    public MessageResponse(String text) {
        this.text = text;
    }

}
