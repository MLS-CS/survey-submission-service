package com.marketlogicsoftware.cs.submission;

import com.marketlogicsoftware.cs.submission.models.QuestionSubmission;
import com.marketlogicsoftware.cs.submission.models.SurveySubmission;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RetrieveSubmittedSurveyTest {

    @Autowired
    private WebTestClient webTestClient;

    @LocalServerPort
    private int randomPort;

    private List<URI> surveySubmissionURIs;
    private RestTemplate restTemplate = new RestTemplate();

    private Collection<SurveySubmission> surveySubmissions() {
        return Arrays.asList(
                new SurveySubmission(
                        "72554b63-38c6-464f-b247-52ef36b1d155"
                        , Arrays.asList(
                        new QuestionSubmission("9b95e32e-726e-4092-9821-70072adf0264", "90a564be-847d-4ecc-9f0c-8655f27b16f9")
                ))
        );
    }

    private void testRetrieveSurvey(URI surveySubmissionURI) {
        webTestClient.get()
                     .uri(surveySubmissionURI)
                     .exchange()
                     .expectStatus()
                     .isOk();
    }

    @Before
    public void setup() throws URISyntaxException {
        URI createSurveyURI = new URI("http://localhost:" + randomPort + "/api/survey/submission");
        surveySubmissionURIs = new ArrayList<>();

        for (SurveySubmission surveySubmission : surveySubmissions()) {
            surveySubmissionURIs.add(restTemplate.postForLocation(createSurveyURI, surveySubmission));
        }
    }

    @Test
    public void testRetrieveSurvey() {
        for (URI surveySubmissionURI : surveySubmissionURIs) {
            testRetrieveSurvey(surveySubmissionURI);
        }
    }

}
