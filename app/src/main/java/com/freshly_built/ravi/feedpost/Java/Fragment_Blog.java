package com.freshly_built.ravi.feedpost.Java;


import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.freshly_built.ravi.feedpost.R;
import com.google.gson.Gson;
//import com.google.gson.internal.GsonBuildConfig;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Fragment_Blog extends Fragment
{
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private LinearLayoutManager mLayoutManager;
    private ArrayList<blogViewModel> list;
    private BlogAdapter adapter;
    private String baseUrl = "https://freshlybuilt.com";
    protected View mView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.fragment_blog, container, false);
        this.mView = view;
        recyclerView = mView.findViewById(R.id.BlogRecycler);
        LinearLayoutManager llm= new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(llm);
        list = new ArrayList<blogViewModel>();
        getRetrofit();
        adapter= new BlogAdapter(list,getContext());
        recyclerView.setAdapter(adapter);

        return inflater.inflate(R.layout.fragment_blog,null);

    }

    private void getRetrofit()
    {
        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        BlogRetrofitApi service = retrofit.create(BlogRetrofitApi.class);
        Call<List<Blog_Posts>> call= service.getpostinfo();

        call.enqueue(new Callback<List<Blog_Posts>>() {
            @Override
            public void onResponse(Call<List<Blog_Posts>> call, Response<List<Blog_Posts>> response) {

                Log.e("Fragment_Blog","response" + response.body());
                progressBar.setVisibility(View.GONE);

                for (int i=0; i<response.body().size();i++)
                {
                    Log.e("main","title" + response.body().get(i).getTitle().getRendered()+" "+response.body().get(i).getId());
                   String tempdetails = response.body().get(i).getExcerpt().getRendered().toString();
                   tempdetails=tempdetails.replace("<p>","");
                    tempdetails=tempdetails.replace("</p>","");


                    list.add(new blogViewModel(blogViewModel.IMAGE_TYPE,response.body().get(i).getTitle().getRendered(),tempdetails,response.body().get(i).getLinks().getWpFeaturedmedia().get(0).getHref()));
                }

                adapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<List<Blog_Posts>> call, Throwable t) {

            }
        });
    }

}
