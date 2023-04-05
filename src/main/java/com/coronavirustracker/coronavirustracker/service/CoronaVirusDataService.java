package com.coronavirustracker.coronavirustracker.service;

import com.coronavirustracker.coronavirustracker.Exception.JsonException;
import com.coronavirustracker.coronavirustracker.Exception.RecordNotFoundException;
import com.coronavirustracker.coronavirustracker.Repository.LocationStatsRepository;
import com.coronavirustracker.coronavirustracker.Request.QuestionairreRequest;
import com.coronavirustracker.coronavirustracker.Response.*;
import com.coronavirustracker.coronavirustracker.dto.AuthenticationResponse;
import com.coronavirustracker.coronavirustracker.dto.LocationDTO;
import com.coronavirustracker.coronavirustracker.dto.LoginRequestDto;
import com.coronavirustracker.coronavirustracker.dto.RegisterUserRequestDto;
import com.coronavirustracker.coronavirustracker.util.Constants;
import com.coronavirustracker.coronavirustracker.util.readDataCSV;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.csv.CSVRecord;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CoronaVirusDataService {

    @Autowired
    LocationStatsRepository locationStatsRepository;

    @Autowired
    readDataCSV readDataCSV;

    private List<LocationDTO> allStats = new ArrayList<>();

    @PostConstruct
    @Scheduled(cron = "* * 1 * * *")
    public List<TotalCaseWithStateAndCountryResponse> fetchVirusData() throws IOException, InterruptedException {
        List<TotalCaseWithStateAndCountryResponse> responses = new ArrayList<>();
        Iterable<CSVRecord> records = readDataCSV.fetchDataCSV();
        if(records==null)
            throw  new RecordNotFoundException("there is a problem in fetching data from excel");
        for (CSVRecord record : records) {
            TotalCaseWithStateAndCountryResponse totalCaseWithStateAndCountryResponse = new TotalCaseWithStateAndCountryResponse();
            String state = record.get("Province/State");
            if (!state.isEmpty() || !state.isBlank()) {
                totalCaseWithStateAndCountryResponse.setState(state);
                totalCaseWithStateAndCountryResponse.setCountry(record.get("Country/Region"));
                totalCaseWithStateAndCountryResponse.setLatestTotalCases(Integer.parseInt(record.get(record.size() - 1)));
                int previousDayIncrement = Integer.parseInt(record.get(record.size() - 1)) - Integer.parseInt(record.get(record.size() - 2));
                totalCaseWithStateAndCountryResponse.setIncreasedCaseFromYesterday(previousDayIncrement);
                responses.add(totalCaseWithStateAndCountryResponse);
            }
        }

        return responses;
    }


    public List<CountryWiseCoronaVirusCaseResponse> fetchDataByCountry(String country) throws IOException, InterruptedException {
        List<CountryWiseCoronaVirusCaseResponse> countryWiseCoronaVirusCaseRespons = locationStatsRepository.findByCountry(country);
        ModelMapper modelMapper = new ModelMapper();
        readDataCSV readDataCSV = new readDataCSV();
        List<CountryWiseCoronaVirusCaseResponse> responses = new ArrayList<>();
        Iterable<CSVRecord> records = readDataCSV.fetchDataCSV();
        for (CSVRecord record : records) {
            CountryWiseCoronaVirusCaseResponse countryWiseCoronaVirusCaseResponse = new CountryWiseCoronaVirusCaseResponse();
            String state = record.get("Province/State");
            String getCountry = record.get("Country/Region");
            if ((!state.isEmpty() || !state.isBlank()) && getCountry.equals(country)) {
                countryWiseCoronaVirusCaseResponse.setState(state);
                countryWiseCoronaVirusCaseResponse.setTotalCase(Integer.parseInt(record.get(record.size() - 1)));
                responses.add(countryWiseCoronaVirusCaseResponse);
            }
        }
        return responses;

    }


    public List<CoronaQuestionairre> getCoronaQuestionairre() {
        List<CoronaQuestionairre> coronaQuestionairreList;
        try {
            ObjectMapper mapper = new ObjectMapper();
            coronaQuestionairreList = mapper.readValue(Constants.CORONA_VIRUS_QA, new TypeReference<List<CoronaQuestionairre>>() {});
        } catch (JsonProcessingException e) {
            throw new JsonException("Error in Json processing . Please try after sometime");
        }
        return coronaQuestionairreList;
    }

    public SubmitAnswerResponse submitQuestionairre(QuestionairreRequest questionairreRequest) {
        SubmitAnswerResponse submitAnswerResponse=new SubmitAnswerResponse();
        submitAnswerResponse.setAns1(questionairreRequest.getAns1());
        submitAnswerResponse.setAns2(questionairreRequest.getAns2());
       submitAnswerResponse.setEmail(questionairreRequest.getEmail());
       submitAnswerResponse.setName(questionairreRequest.getName());
       return submitAnswerResponse;
    }


    public ReportResponse fetchReport(SubmitAnswerResponse submitAnswerResponse) {

       ReportResponse reportResponse=new ReportResponse();
       if(submitAnswerResponse.getAns1().equals("fever")&& submitAnswerResponse.getAns2().equals("yes"))
       {
           reportResponse.setReport("positive");
       }
       else
       {
           reportResponse.setReport("negative");
       }
       reportResponse.setName(submitAnswerResponse.getName());
       return reportResponse;

    }






}
