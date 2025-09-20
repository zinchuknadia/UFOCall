package org.example.ufocall;

public class Answer {
    private String id;
    private String text;
    private String next;

    public Answer(String id, String text, String next) {
        this.id = id;
        this.text = text;
        this.next = next;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }
}
