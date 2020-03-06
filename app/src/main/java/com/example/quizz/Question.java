package com.example.quizz;

public class Question {
    private int answerID;
    private boolean isCorrect;

    public Question(int answerID, boolean isCorrect) {
        this.answerID = answerID;
        this.isCorrect = isCorrect;
    }

    public int getAnswerID() {
        return answerID;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setAnswerID(int answerID) {
        this.answerID = answerID;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }
}
