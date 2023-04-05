package com.coronavirustracker.coronavirustracker.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "LOCATIONSTATS")
public class LocationStats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String state;
    private String country;
    private int latestTotalCases;
    private String latitude;
    private String longitudes;

    public LocationStats() {
    }

    public LocationStats(String state, String country, int latestTotalCases, String latitude, String longitudes) {
        this.state = state;
        this.country = country;
        this.latestTotalCases = latestTotalCases;
        this.latitude = latitude;
        this.longitudes = longitudes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitudes() {
        return longitudes;
    }

    public void setLongitudes(String longitudes) {
        this.longitudes = longitudes;
    }

    @Override
    public String toString() {
        return "LocationStats{" +
                "id=" + id +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", latestTotalCases=" + latestTotalCases +
                ", latitude='" + latitude + '\'' +
                ", longitudes='" + longitudes + '\'' +
                '}';
    }
}
