package com.freshly_built.ravi.feedpost.Java;

import com.freshly_built.ravi.feedpost.Java.Modals.Blog_Posts;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface BlogRetrofitApi
{
    @GET("/wp-json/wp/v2/posts")
    Call<List<Blog_Posts>> getpostinfo();


}
