package com.coronavirustracker.coronavirustracker.Response;

public class CoronaQuestionairreResponse {

    private String id;
    private String response;

    public CoronaQuestionairreResponse() {
    }

    public CoronaQuestionairreResponse(String id, String response) {
        this.id = id;
        this.response = response;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "CoronaQuestionairreResponse{" +
                "id='" + id + '\'' +
                ", response='" + response + '\'' +
                '}';
    }
}
