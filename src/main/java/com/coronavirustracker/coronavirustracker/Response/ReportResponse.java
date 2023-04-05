package com.coronavirustracker.coronavirustracker.Response;

public class ReportResponse {

    private String report;
    private String name;

    public ReportResponse() {
    }

    public ReportResponse(String report,String name) {
        this.report = report;
        this.name=name;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
