package com.example.demo.model;

import java.io.Serializable;

public class FileDetails implements Serializable{
	
	private String text;
    private int priority;
    private boolean secret;

    // Default constructor is needed to deserialize JSON
    public FileDetails() {
    }

    public FileDetails(String text, int priority, boolean secret) {
        this.text = text;
        this.priority = priority;
        this.secret = secret;
    }

    public String getText() {
        return text;
    }

    public int getPriority() {
        return priority;
    }

    public boolean isSecret() {
        return secret;
    }

    @Override
    public String toString() {
        return "CustomMessage{" +
                "text='" + text + '\'' +
                ", priority=" + priority +
                ", secret=" + secret +
                '}';
    }
	

}
