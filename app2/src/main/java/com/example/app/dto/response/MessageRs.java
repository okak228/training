package com.example.app.dto.response;

import lombok.Data;

@Data
public class MessageRs {
    private final String text;

    public MessageRs(String text) {
        this.text = text;
    }

}
