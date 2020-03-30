package com.schoolonline.app.test.dto;

public class NewQuestionDTO {

    private String description;
    private String answerA;
    private String answerB;
    private String answerC;
    private String answerD;
    private QuestionAnswer answer;
    private Long testId;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAnswerA() {
        return answerA;
    }

    public void setAnswerA(String answerA) {
        this.answerA = answerA;
    }

    public String getAnswerB() {
        return answerB;
    }

    public void setAnswerB(String answerB) {
        this.answerB = answerB;
    }

    public String getAnswerC() {
        return answerC;
    }

    public void setAnswerC(String answerC) {
        this.answerC = answerC;
    }

    public String getAnswerD() {
        return answerD;
    }

    public void setAnswerD(String answerD) {
        this.answerD = answerD;
    }

    public QuestionAnswer getAnswer() {
        return answer;
    }

    public void setAnswer(QuestionAnswer answer) {
        this.answer = answer;
    }

    public Long getTestId() {
        return testId;
    }

    public void setTestId(Long testId) {
        this.testId = testId;
    }
}
