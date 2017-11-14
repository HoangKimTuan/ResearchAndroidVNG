package com.example.cpu10225.daggermvp.service;

import com.example.cpu10225.daggermvp.data.db.BaseGetData;
import com.example.cpu10225.daggermvp.data.db.Post;
import com.example.cpu10225.daggermvp.util.AppConstants;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by cpu10225 on 14/11/2017.
 */

public interface DataService {
    interface PostService {
        @GET(AppConstants.GET_POSTS)
        Observable<List<Post>> getPostlist();
    }
}
