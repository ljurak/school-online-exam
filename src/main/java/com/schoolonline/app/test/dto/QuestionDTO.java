package com.schoolonline.app.test.dto;

public class QuestionDTO {

    private Long id;
    private String description;
    private String answerA;
    private String answerB;
    private String answerC;
    private String answerD;
    private QuestionAnswer answer;
    private Long testId;

    public QuestionDTO(
            Long id,
            String description,
            String answerA,
            String answerB,
            String answerC,
            String answerD,
            QuestionAnswer answer,
            Long testId
    ) {
        this.id = id;
        this.description = description;
        this.answerA = answerA;
        this.answerB = answerB;
        this.answerC = answerC;
        this.answerD = answerD;
        this.answer = answer;
        this.testId = testId;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getAnswerA() {
        return answerA;
    }

    public String getAnswerB() {
        return answerB;
    }

    public String getAnswerC() {
        return answerC;
    }

    public String getAnswerD() {
        return answerD;
    }

    public QuestionAnswer getAnswer() {
        return answer;
    }

    public Long getTestId() {
        return testId;
    }
}
