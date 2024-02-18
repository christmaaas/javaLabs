package com.example.demo.data;

public class RequestData
{
    private String searchResultFormat;
    private String searchRequest;
    private String pageTitle;
    private int pageId;
    private String searchResult;

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

    public void setSearchResultFormat(String searchResultFormat) { this.searchResultFormat = searchResultFormat; }
    public void setSearchResult(String searchResult)
    {
        this.searchResult = searchResult;
    }
    public void setSearchRequest(String searchRequest) { this.searchRequest = searchRequest; }
    public void setPageTitle(String pageTitle) { this.pageTitle = pageTitle; }
    public void setPageId(int pageId)
    {
        this.pageId = pageId;
    }
}
