package com.example.user.adahealty;

/**
 * Created by User on 11/28/2017.
 */

public class AdaObject {
    int ID;
    String question;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public AdaObject(int ID, String question) {
        this.ID = ID;
        this.question = question;
    }
}
