package com.marketlogicsoftware.cs.submission.models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class QuestionSubmission {
    @NotNull
    private String questionId;
    @NotNull
    @NotEmpty
    private String answerId;

    public QuestionSubmission(){}

    public QuestionSubmission(@NotNull String questionId, String answerId) {
        this.questionId = questionId;
        this.answerId = answerId;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getAnswerId() {
        return answerId;
    }

    public void setAnswerId(String answerIds) {
        this.answerId = answerIds;
    }
}
