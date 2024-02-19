package com.example.demo.service;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.web.client.RestTemplate;
import com.example.demo.data.RequestData;

public class Logic
{
    private static RequestData searchPage(String query)
    {
        String apiUrl = "https://en.wikipedia.org/w/api.php" +
                "?action=query" +
                "&format=xml" +
                "&prop=extracts" +
                "&generator=search" +
                "&gsrsearch=" + query +
                "&gsrlimit=1";

        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForObject(apiUrl, RequestData.class);
    }
    public static RequestData searchInfoByQuery(String query)
    {
        RequestData searchPageResult = searchPage(query);

        return searchPageResult;
    }

    private static String parseMainInfo(String searchResult)
    {
        return searchResult.replaceAll("\\\\u[a-fA-F0-9]{4,}", "")
                .replaceAll("\\\\n", " ")
                .replaceAll("\\\\", "")
                .replaceAll("<[^>]*>", "")
                .replaceAll("[^\\p{L}\\p{N}\\s\\p{Punct}]", "")
                .replaceAll("\\s{2,}", " ")
                .trim();
    }
}

