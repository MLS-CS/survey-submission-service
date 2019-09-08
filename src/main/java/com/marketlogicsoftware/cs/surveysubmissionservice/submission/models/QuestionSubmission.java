package com.marketlogicsoftware.cs.surveysubmissionservice.submission.models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public class QuestionSubmission {
    @NotNull
    private String questionId;
    @NotNull
    @NotEmpty
    private List<String> answerIds;

    public QuestionSubmission(){}

    public QuestionSubmission(@NotNull String questionId, List<String> answerIds) {
        this.questionId = questionId;
        this.answerIds = answerIds;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public List<String> getAnswerIds() {
        return answerIds;
    }

    public void setAnswerIds(List<String> answerIds) {
        this.answerIds = answerIds;
    }
}
