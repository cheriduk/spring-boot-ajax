package com.dk.ajax.demo.model;

/**
 * @author Cheri
 * @title: Message
 * @projectName spring-boot-ajax
 * @description: TODO
 * @date 2019/4/220:29
 */
import java.io.Serializable;
import java.util.Date;

public class Message implements Serializable {

    private int id;
    private String from;
    private String to;
    private String text;
    private Date time;

    public Message(int id, String from, String to, String text, Date time) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.text = text;
        this.time = time;
    }

    public Message() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", text='" + text + '\'' +
                ", time=" + time +
                '}';
    }
}