package it.unitn.hci.support;

/**
 * Created by Franco on 16/12/13.
 */
public class Message {

    private String text;
    private String time;
    private int id_image;

    public Message(int id_image, String text, String time) {
        this.id_image = id_image;
        this.text = text;
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getId_image() {
        return id_image;
    }

    public void setId_image(int id_image) {
        this.id_image = id_image;
    }

}
