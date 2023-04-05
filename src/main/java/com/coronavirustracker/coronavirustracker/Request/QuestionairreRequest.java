package com.coronavirustracker.coronavirustracker.Request;

public class QuestionairreRequest {

    private String name;
    private String email;
    private String ans1;
    private String ans2;


    public QuestionairreRequest() {
    }

    public QuestionairreRequest(String name, String email, String ans1, String ans2) {
        this.name = name;
        this.email = email;
        this.ans1 = ans1;
        this.ans2 = ans2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAns1() {
        return ans1;
    }

    public void setAns1(String ans1) {
        this.ans1 = ans1;
    }

    public String getAns2() {
        return ans2;
    }

    public void setAns2(String ans2) {
        this.ans2 = ans2;
    }
}
