package it.unitn.hci.support;

import android.text.Spanned;

/**
 * Created by Franco on 17/12/13.
 */
public class Payment {

    public static final int PLUS = 0;
    public static final int MINUS = 1;

    private Spanned text;
    private String inserted;
    private int type;

    public Payment(Spanned text, String inserted, int type) {
        this.text = text;
        this.type = type;
        this.inserted = inserted;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Spanned getText() {
        return text;
    }

    public void setText(Spanned text) {
        this.text = text;
    }

    public String getInserted() {
        return inserted;
    }

    public void setInserted(String inserted) {
        this.inserted = inserted;
    }

}
