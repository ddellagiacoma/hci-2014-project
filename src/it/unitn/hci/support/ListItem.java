package it.unitn.hci.support;

/**
 * Created by Franco on 16/12/13.
 */
public class ListItem {

    private String text;
    private String inserted;

    public ListItem(String text, String inserted) {
        this.text = text;
        this.inserted = inserted;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getInserted() {
        return inserted;
    }

    public void setInserted(String inserted) {
        this.inserted = inserted;
    }

}
