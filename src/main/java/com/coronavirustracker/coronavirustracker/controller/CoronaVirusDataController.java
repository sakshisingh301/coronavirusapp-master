package com.coronavirustracker.coronavirustracker.controller;
import com.coronavirustracker.coronavirustracker.Request.QuestionairreRequest;
import com.coronavirustracker.coronavirustracker.Response.*;
import com.coronavirustracker.coronavirustracker.dto.RegisterUserRequestDto;
import com.coronavirustracker.coronavirustracker.service.CoronaVirusDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

@RestController
public class CoronaVirusDataController {

    @Autowired
    CoronaVirusDataService coronaVirusDataService;

    @Autowired
    RestTemplate restTemplate;


    /**
     * @return list of state, country and their total cases,increase in case from previous day
     * @throws IOException
     * @throws InterruptedException
     */
    @GetMapping("/data")
    public List<TotalCaseWithStateAndCountryResponse> getData() throws IOException, InterruptedException {
        return coronaVirusDataService.fetchVirusData();

    }

    /**
     * list of state and total case country wise
     *
     * @param country
     * @return
     * @throws IOException
     * @throws InterruptedException
     */
    @GetMapping("/data/{country}")
    public List<CountryWiseCoronaVirusCaseResponse> getCoronaVirusDataByCountry(@PathVariable String country) throws IOException, InterruptedException {
        return coronaVirusDataService.fetchDataByCountry(country);
    }


   @GetMapping("/data/symptoms")
    public List<CoronaQuestionairre> coronaQuestionairre()
    {
        return coronaVirusDataService.getCoronaQuestionairre();
    }

   @PostMapping("/data/submit-answers")
    public SubmitAnswerResponse getSubmitAnswer(@RequestBody QuestionairreRequest questionairreRequest)
   {
       return coronaVirusDataService.submitQuestionairre(questionairreRequest);
   }

   @GetMapping("/data/report")
    public ReportResponse getReport(SubmitAnswerResponse submitAnswerResponse)
   {
       return coronaVirusDataService.fetchReport(submitAnswerResponse);
   }


}
