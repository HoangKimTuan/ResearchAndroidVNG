package com.example.cpu10225.daggermvp.data.network;

import com.example.cpu10225.daggermvp.data.network.model.Comment;
import com.example.cpu10225.daggermvp.data.network.model.Post;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by cpu10225 on 20/11/2017.
 */

public interface ApiHelper {
    @GET(ApiEndPoint.ENDPOINT_GET_POSTS)
    Observable<List<Post>> getPostList();

    @GET(ApiEndPoint.ENDPOINT_GET_COMMENTS)
    Observable<List<Comment>> getCommentList(@Path("id") Integer postId);
}
