package com.coronavirustracker.coronavirustracker.Response;

import java.util.List;

public class CoronaQuestionairre {

    private String id;
    private String question;
    private List<CoronaQuestionairreResponse> responses;

    public CoronaQuestionairre(String id, String question, List<CoronaQuestionairreResponse> responses) {
        this.id = id;
        this.question = question;
        this.responses = responses;
    }

    public CoronaQuestionairre() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<CoronaQuestionairreResponse> getResponses() {
        return responses;
    }

    public void setResponses(List<CoronaQuestionairreResponse> responses) {
        this.responses = responses;
    }
}
