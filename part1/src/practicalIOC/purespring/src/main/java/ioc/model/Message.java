package part1.src.practicalIOC.purespring.src.main.java.ioc.model;

public class Message {
    private String text = "Spring is Fun";

    public String getText() {
        return this.text;
    }

    public void setText(String paramToSet) {
        this.text = paramToSet;
    }

    public Message(String text) {
        this.text = text;
    }
}