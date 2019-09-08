package com.marketlogicsoftware.cs.submission.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Submission")
public class SurveySubmissionDocument {
    @Id
    private String id;
    private SurveySubmission surveySubmission;

    public SurveySubmissionDocument(SurveySubmission surveySubmission) {
        this.surveySubmission = surveySubmission;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SurveySubmission getSurveySubmission() {
        return surveySubmission;
    }

    public void setSurveySubmission(SurveySubmission surveySubmission) {
        this.surveySubmission = surveySubmission;
    }
}
