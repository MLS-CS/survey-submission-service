package com.marketlogicsoftware.cs.surveysubmissionservice.submission;

import com.marketlogicsoftware.cs.surveysubmissionservice.submission.models.SurveySubmission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubmissionService {
    @Autowired
    private SubmissionRepository submissionRepository;

    public String submitSurvey(SurveySubmission surveySubmission) {
        return submissionRepository.create(surveySubmission);
    }

    public SurveySubmission retrieveSubmittedSurvey(String id) {
        return submissionRepository.retrieve(id);
    }

}
