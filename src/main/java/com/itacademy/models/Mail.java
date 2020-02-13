package com.itacademy.models;

public class Mail {

    private String address;
    private String subject;
    private String text;

    {
        address = "mailtestframework@yandex.by";
        subject = "Framework Mail Test";
        text = "Framework Mail Test";
    }

    public String getAddress() {
        return address;
    }

    public String getSubject() {
        return subject;
    }

    public String getText() {
        return text;
    }
}
