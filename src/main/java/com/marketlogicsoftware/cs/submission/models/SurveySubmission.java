package com.marketlogicsoftware.cs.submission.models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public class SurveySubmission {
    @NotNull
    private String surveyId;
    @NotNull
    @NotEmpty
    private List<QuestionSubmission> questionSubmissions;

    public SurveySubmission(){}
    public SurveySubmission(@NotNull String surveyId, @NotNull @NotEmpty List<QuestionSubmission> questionSubmissions) {
        this.surveyId = surveyId;
        this.questionSubmissions = questionSubmissions;
    }

    public String getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(String surveyId) {
        this.surveyId = surveyId;
    }

    public List<QuestionSubmission> getQuestionSubmissions() {
        return questionSubmissions;
    }

    public void setQuestionSubmissions(List<QuestionSubmission> questionSubmissions) {
        this.questionSubmissions = questionSubmissions;
    }
}
