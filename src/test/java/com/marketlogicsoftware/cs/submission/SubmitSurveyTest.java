package com.marketlogicsoftware.cs.submission;

import com.marketlogicsoftware.cs.submission.models.QuestionSubmission;
import com.marketlogicsoftware.cs.submission.models.SurveySubmission;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.util.Arrays;
import java.util.Collection;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SubmitSurveyTest {
    @Autowired
    private WebTestClient webTestClient;

    private Collection<SurveySubmission> surveySubmissions() {
        return Arrays.asList(
                new SurveySubmission(
                        "72554b63-38c6-464f-b247-52ef36b1d155"
                        , Arrays.asList(
                                new QuestionSubmission("9b95e32e-726e-4092-9821-70072adf0264", "90a564be-847d-4ecc-9f0c-8655f27b16f9")
                ))
        );
    }

    private void testCreateSurvey(SurveySubmission surveySubmission) {
        webTestClient.post()
                     .uri("api/survey/submission")
                     .body(BodyInserters.fromObject(surveySubmission))
                     .exchange()
                     .expectStatus()
                     .isCreated();
    }

    @Test
    public void testCreateSurvey() {
        for (SurveySubmission surveySubmission : surveySubmissions()) {
            testCreateSurvey(surveySubmission);
        }
    }
}
