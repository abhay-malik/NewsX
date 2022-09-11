package com.example.newsx;

import java.util.ArrayList;

public class mainNews {
    private String status;
    private String totResults;

    private ArrayList<modelClass> articles;

    public mainNews(String status, String totResults, ArrayList<modelClass> articles) {
        this.status = status;
        this.totResults = totResults;
        this.articles = articles;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotResults() {
        return totResults;
    }

    public void setTotResults(String totResults) {
        this.totResults = totResults;
    }

    public ArrayList<modelClass> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<modelClass> articles) {
        this.articles = articles;
    }
}
