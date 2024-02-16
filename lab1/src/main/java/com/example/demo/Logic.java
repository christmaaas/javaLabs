package com.example.demo;

import org.springframework.web.client.RestTemplate;

public class Logic
{
    private String searchResultFormat;
    private String searchRequest;
    private String pageTitle;
    private int pageId;
    private String searchResult;

    private String searchPage(String query)
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
    public void searchInfoByQuery(String query)
    {
        String searchPageResult = searchPage(query);

        if(!searchPageResult.contains("\"title\":\""))
        {
            this.searchResultFormat = "None";
            this.searchRequest = query;
            this.pageTitle = "No title";
            this.searchResult = "No result";
            this.pageId = -1;
        }
        else
        {
            this.searchResultFormat = "Page";
            this.searchRequest = query;
            this.pageId = parsePageId(searchPageResult);
            this.pageTitle = parsePageTitle(searchPageResult);
            this.searchResult = parseMainInfo(searchPageResult);
        }
    }
    private int parsePageId(String searchResult)
    {
        String target = "\"pageid\":";

        int startIndex = searchResult.indexOf(target);

        String pageIdString = searchResult.substring(startIndex + target.length(),
                searchResult.indexOf(',', startIndex + target.length()));

        return Integer.parseInt(pageIdString.trim());
    }

    private String parsePageTitle(String searchResult)
    {
        String target = "\"title\":\"";

        int startIndex = searchResult.indexOf(target);

        return searchResult.substring(startIndex + target.length(),
                searchResult.indexOf('"', startIndex + target.length()));
    }

    private String parseMainInfo(String searchResult)
    {
        String textWithoutMetaData = searchResult.substring(searchResult.indexOf(pageTitle) + pageTitle.length());

        return textWithoutMetaData.replaceAll("<[^>]*>", "");
    }

    public String getSearchResultFormat()
    {
        return this.searchResultFormat;
    }
    public String getSearchResult()
    {
        return this.searchResult;
    }
    public String getSearchRequest()
    {
        return this.searchRequest;
    }
    public String getPageTitle()
    {
        return this.pageTitle;
    }
    public int getPageId()
    {
        return this.pageId;
    }

}
