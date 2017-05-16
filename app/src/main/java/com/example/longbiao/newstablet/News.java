package com.example.longbiao.newstablet;

/**
 * Created by longbiao on 17-5-15.
 */

public class News {
    private String title;
    private String content;
    public News(String title,String content){
        this.content=content;
        this.title=title;
    }
    public void setTitle(String title){
        this.title=title;
    }
    public void setContent(String content){
        this.content=content;
    }
    public String getTitle(){
        return title;
    }
    public String getContent(){
        return content;
    }
}
