package com.coronavirustracker.coronavirustracker.dto;

public class LocationDTO {

    private String state;
    private String country;
    private int latestTotalCases;
    private int increasedCaseFromYesterday;

    public LocationDTO() {
    }

    public LocationDTO(String state, String country, int latestTotalCases,int increasedCaseFromYesterday) {
        this.state = state;
        this.country = country;
        this.latestTotalCases = latestTotalCases;
        this.increasedCaseFromYesterday=increasedCaseFromYesterday;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getLatestTotalCases() {
        return latestTotalCases;
    }

    public void setLatestTotalCases(int latestTotalCases) {
        this.latestTotalCases = latestTotalCases;
    }

    public int getIncreasedCaseFromYesterday() {
        return increasedCaseFromYesterday;
    }

    public void setIncreasedCaseFromYesterday(int increasedCaseFromYesterday) {
        this.increasedCaseFromYesterday = increasedCaseFromYesterday;
    }

    @Override
    public String toString() {
        return "LocationDTO{" +
                "state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", latestTotalCases=" + latestTotalCases +
                ", increasedCaseFromYesterday=" + increasedCaseFromYesterday +
                '}';
    }
}
