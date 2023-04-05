package com.coronavirustracker.coronavirustracker.util;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Constants {

    public static String VIRUS_DATA_URL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";
    public static String CORONA_VIRUS_QA = "[{\"id\":\"UNI_1\",\"question\":\"Are you having these symptoms?\",\"responses\":[{\"id\":\"00001\",\"response\":\"fever\"},{\"id\":\"00002\",\"response\":\"symptoms of a cold such as a sore throat, congestion, or a runny nose\"},{\"id\":\"00003\",\"response\":\"loss of taste or smell\"},{\"id\":\"00004\",\"response\":\"nausea or vomiting\"},{\"id\":\"00005\",\"response\":\"diarrhea\"}]},{\"id\":\"UNI_2\",\"question\":\"Have you come into close contact (within 6 feet) with someone who has a laboratory confirmed COVID – 19 diagnosis in the past 14 days?\",\"responses\":[{\"id\":\"00001\",\"response\":\"yes\"},{\"id\":\"00002\",\"response\":\"no\"}]}]";

    public static final Map<String, String> RISK_PROFILE_CATEGORY_ID_MAP = initRiskMap();

    private static Map<String, String> initRiskMap() {
        Map<String, String> riskCategoryId = new HashMap<>();
        riskCategoryId.put("RISK AVERSE","00001");
        riskCategoryId.put("CONSERVATIVE","00002");
        riskCategoryId.put("BALANCED","00003");
        riskCategoryId.put("GROWTH","00004");
        riskCategoryId.put("AGGRESSIVE","00005");
        return Collections.unmodifiableMap(riskCategoryId);
    }





}
