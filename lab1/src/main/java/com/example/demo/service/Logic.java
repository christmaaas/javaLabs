package com.example.demo.service;

import org.springframework.web.client.RestTemplate;
import com.example.demo.data.RequestData;

public class Logic
{
    private static String searchPage(String query)
    {
        String apiUrl = "https://en.wikipedia.org/w/api.php" +
                "?action=query" +
                "&format=json" +
                "&prop=extracts" +
                "&generator=search" +
                "&gsrsearch=" + query +
                "&gsrlimit=1";

        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForObject(apiUrl, String.class);
    }
    public static RequestData searchInfoByQuery(String query)
    {
        String searchPageResult = searchPage(query);

        RequestData data = new RequestData();

        if(searchPageResult != null)
        {
            if(!searchPageResult.contains("\"title\":\""))
            {
                data.setSearchResultFormat("None");
                data.setSearchRequest(query);
                data.setPageTitle("No title");
                data.setSearchResult("No result");
                data.setPageId(-1);
            }
            else
            {
                data.setSearchResultFormat("Page");
                data.setSearchRequest(query);
                data.setPageId(parsePageId(searchPageResult));
                data.setPageTitle(parsePageTitle(searchPageResult));
                data.setSearchResult(parseMainInfo(searchPageResult));
            }
        }

        return data;
    }
    private static int parsePageId(String searchResult)
    {
        String target = "\"pageid\":";

        int startIndex = searchResult.indexOf(target);

        String pageIdString = searchResult.substring(startIndex + target.length(),
                searchResult.indexOf(',', startIndex + target.length()));

        return Integer.parseInt(pageIdString.trim());
    }

    private static String parsePageTitle(String searchResult)
    {
        String target = "\"title\":\"";

        int startIndex = searchResult.indexOf(target);

        return searchResult.substring(startIndex + target.length(),
                searchResult.indexOf('"', startIndex + target.length()));
    }

    private static String parseMainInfo(String searchResult)
    {
        String textWithoutMetaData = searchResult.substring(searchResult.indexOf("\\n") + 2);

        return textWithoutMetaData.replaceAll("\\\\u[a-fA-F0-9]{4,}", "")
                .replaceAll("\\\\n", " ")
                .replaceAll("\\\\", "")
                .replaceAll("<[^>]*>", "")
                .replaceAll("[^\\p{L}\\p{N}\\s\\p{Punct}]", "")
                .replaceAll("\\s{2,}", " ")
                .trim();
    }
}

