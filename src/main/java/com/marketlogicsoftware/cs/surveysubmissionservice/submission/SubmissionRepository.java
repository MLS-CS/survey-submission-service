package com.marketlogicsoftware.cs.surveysubmissionservice.submission;

import com.marketlogicsoftware.cs.surveysubmissionservice.submission.models.SurveySubmission;
import com.marketlogicsoftware.cs.surveysubmissionservice.submission.models.SurveySubmissionDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SubmissionRepository {
    @Autowired
    private MongoTemplate mongoTemplate;

    public String create(SurveySubmission surveySubmission) {
        return this.mongoTemplate
                .insert(new SurveySubmissionDocument(surveySubmission))
                .getId();
    }

    public SurveySubmission retrieve(String id) {
        return this.mongoTemplate.findById(id, SurveySubmissionDocument.class).getSurveySubmission();
    }

}
