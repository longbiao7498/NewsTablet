package com.example.longbiao.newstablet;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by longbiao on 17-5-15.
 */

public class NewsTitleFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.news_title_list,container,false);
        RecyclerView newsTileRecyclerView=(RecyclerView)view.findViewById(R.id.news_title_recycler_view);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity());
        NewsAdapter newsAdapter=new NewsAdapter(getNews(),this);
        newsTileRecyclerView.setLayoutManager(layoutManager);
        newsTileRecyclerView.setAdapter(newsAdapter);
        return view;
    }

    private List<News> getNews(){
        List<News> newsList=new ArrayList<>();
        for(int i=1;i<=50;i++){
            String newsTile="This is news title"+i;
            String newsContent=getRandomLengthContent(newsTile);
            News news=new News(newsTile,newsContent);
            newsList.add(news);
        }
        return newsList;
    }
    private String getRandomLengthContent(String tilte){
        Random random=new Random();
        int length=random.nextInt(20)+1;
        StringBuilder builder=new StringBuilder();
        for(int i=0;i<length;i++){
            builder.append(tilte);
        }
        return builder.toString();
    }
}

