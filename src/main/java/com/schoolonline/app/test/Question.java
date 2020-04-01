package com.schoolonline.app.test;

import com.schoolonline.app.common.entity.BaseEntity;
import com.schoolonline.app.test.dto.NewQuestionDTO;
import com.schoolonline.app.test.dto.QuestionAnswer;
import com.schoolonline.app.test.dto.QuestionDTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "QUESTIONS")
class Question extends BaseEntity {

    @Column(nullable = false, length = 1000)
    private String description;

    @Column(nullable = false)
    private String answerA;

    @Column(nullable = false)
    private String answerB;

    @Column(nullable = false)
    private String answerC;

    @Column(nullable = false)
    private String answerD;

    @Column(nullable = false)
    private QuestionAnswer correctAnswer;

    @ManyToOne
    @JoinColumn(name = "TEST_ID", nullable = false)
    private Test test;

    Question() {
    }

    private Question(String description, String answerA, String answerB, String answerC, String answerD, QuestionAnswer correctAnswer, Test test) {
        this.description = description;
        this.answerA = answerA;
        this.answerB = answerB;
        this.answerC = answerC;
        this.answerD = answerD;
        this.correctAnswer = correctAnswer;
        this.test = test;
    }

    String getDescription() {
        return description;
    }

    String getAnswerA() {
        return answerA;
    }

    String getAnswerB() {
        return answerB;
    }

    String getAnswerC() {
        return answerC;
    }

    String getAnswerD() {
        return answerD;
    }

    QuestionAnswer getCorrectAnswer() {
        return correctAnswer;
    }

    Test getTest() {
        return test;
    }

    static Question of(NewQuestionDTO newQuestionDTO, Test test) {
        return new Question(
                newQuestionDTO.getDescription(),
                newQuestionDTO.getAnswerA(),
                newQuestionDTO.getAnswerB(),
                newQuestionDTO.getAnswerC(),
                newQuestionDTO.getAnswerD(),
                newQuestionDTO.getCorrectAnswer(),
                test
        );
    }

    QuestionDTO toDTO() {
        return new QuestionDTO(getId() ,description, answerA, answerB, answerC, answerD, correctAnswer, test.getId());
    }
}
