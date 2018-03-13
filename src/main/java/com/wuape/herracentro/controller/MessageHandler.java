package com.wuape.herracentro.controller;

/**
 * Bowpi GT
 * Created by Jose on 3/01/2018.
 */
public class MessageHandler {

    private String requestUri;
    private String message;

    public MessageHandler(String requestUri, String message) {
        this.requestUri = requestUri;
        this.message = message;
    }

    public MessageHandler(String message) {
        this.message = message;
    }

    public String getRequestUri() {
        return requestUri;
    }

    public void setRequestUri(String requestUri) {
        this.requestUri = requestUri;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "MessageHandler{" +
                "requestUri='" + requestUri + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
