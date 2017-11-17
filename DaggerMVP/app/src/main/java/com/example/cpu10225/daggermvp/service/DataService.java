package com.example.cpu10225.daggermvp.service;

import com.example.cpu10225.daggermvp.data.db.Comment;
import com.example.cpu10225.daggermvp.data.db.Post;
import com.example.cpu10225.daggermvp.util.AppConstants;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by cpu10225 on 14/11/2017.
 */

public interface DataService {
    interface PostService {
        @GET(AppConstants.GET_POSTS)
        Observable<List<Post>> getPostList();
    }

    interface CommentService {
        @GET(AppConstants.GET_POSTS  + "/{id}/comments")
        Observable<List<Comment>> getCommentList(@Path("id") Integer postId);
    }
}
