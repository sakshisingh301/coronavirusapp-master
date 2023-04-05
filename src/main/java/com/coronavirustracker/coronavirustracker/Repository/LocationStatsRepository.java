package com.coronavirustracker.coronavirustracker.Repository;

import com.coronavirustracker.coronavirustracker.Entity.LocationStats;
import com.coronavirustracker.coronavirustracker.Response.CountryWiseCoronaVirusCaseResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocationStatsRepository extends JpaRepository<LocationStats, Integer> {

    List<CountryWiseCoronaVirusCaseResponse> findByCountry(String country);



}
