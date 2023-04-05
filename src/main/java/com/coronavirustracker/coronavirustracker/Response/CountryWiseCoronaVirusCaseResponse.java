package com.coronavirustracker.coronavirustracker.Response;

public class CountryWiseCoronaVirusCaseResponse {

    private String state;
    private int totalCase;

    public CountryWiseCoronaVirusCaseResponse() {
    }

    public CountryWiseCoronaVirusCaseResponse(String state, int totalCase) {
        this.state = state;
        this.totalCase = totalCase;
    }


    public int getTotalCase() {
        return totalCase;
    }

    public void setTotalCase(int totalCase) {
        this.totalCase = totalCase;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }


}
