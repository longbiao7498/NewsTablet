package com.example.longbiao.newstablet;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by longbiao on 17-5-15.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    private List<News> newsList;
    private boolean isTwoPane;
    private Context context;
    private NewsTitleFragment newsTitleFragment;
    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView newsTileText;
        public ViewHolder(View view){
            super(view);
            newsTileText=(TextView)view.findViewById(R.id.news_title_item);
        }
    }
    public NewsAdapter(List<News> newsList,NewsTitleFragment newsTitleFragment){
        this.newsList=newsList;
        this.newsTitleFragment=newsTitleFragment;

    }


    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        context=parent.getContext();
        View view= LayoutInflater.from(context).inflate(R.layout.news_title_list_item,parent,false);
        final ViewHolder viewHolder=new ViewHolder(view);
        if(newsTitleFragment.getActivity().findViewById(R.id.news_content_layout)!=null){
            isTwoPane=true;
        } else {
            isTwoPane=false;
        }
        if(isTwoPane){
            News news=newsList.get(0);
            NewsContentFragment newsContentFragment=(NewsContentFragment)newsTitleFragment.
                    getFragmentManager().findFragmentById(R.id.news_content_frament);
            newsContentFragment.onRefresh(news.getTitle(),news.getContent());
        }
        return viewHolder;

    }
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        News news=newsList.get(position);
        holder.newsTileText.setText(news.getTitle());
        holder.newsTileText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                News news=newsList.get(position);
                if(isTwoPane){
                    NewsContentFragment newsContentFragment=(NewsContentFragment)newsTitleFragment.
                            getFragmentManager().findFragmentById(R.id.news_content_frament);
                    newsContentFragment.onRefresh(news.getTitle(),news.getContent());
                }else{
                    NewsContentActivity.actionStart(context,news.getTitle(),news.getContent());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }
}
