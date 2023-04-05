package com.coronavirustracker.coronavirustracker.Response;

public class JwtTokenResponse {

    private String jwtToken;

    public JwtTokenResponse() {
    }

    public JwtTokenResponse(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }
}
