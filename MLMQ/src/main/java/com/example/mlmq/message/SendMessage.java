package com.example.mlmq.message;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SendMessage implements Serializable {

    private String id;
    private String text;
    private String result;

    @Override
    public String toString() {
        return "SendMessage{" +
                "id='" + id + '\'' +
                ", text='" + text + '\'' +
                ", result='" + result + '\'' +
                '}';
    }
}
