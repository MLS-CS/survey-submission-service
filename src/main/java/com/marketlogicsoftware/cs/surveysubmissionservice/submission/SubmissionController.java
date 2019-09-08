package com.marketlogicsoftware.cs.surveysubmissionservice.submission;

import com.marketlogicsoftware.cs.surveysubmissionservice.submission.models.SurveySubmission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("survey/submission")
public class SubmissionController {
    @Autowired
    private SubmissionService submissionService;

    @PostMapping()
    public ResponseEntity<?> submitSurvey(@Valid @RequestBody SurveySubmission surveySubmission) {
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(submissionService.submitSurvey(surveySubmission))
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> retriveSubmittedSurvey(@PathVariable("id") String id) {
        return ResponseEntity.ok(submissionService.retrieveSubmittedSurvey(id));
    }

}
