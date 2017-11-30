package com.example.user.adahealty;

/**
 * Created by User on 11/28/2017.
 */

public class AdaObject {
    int ID;
    String answer;

    @Override
    public String toString() {
        return "AdaObject{" +
                ", answer='" + answer + '\'' +
                '}';
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }


    public AdaObject(int ID,  String answer) {
        this.ID = ID;

        this.answer = answer;
    }
}
