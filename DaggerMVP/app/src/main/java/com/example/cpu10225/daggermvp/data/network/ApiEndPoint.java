package com.example.cpu10225.daggermvp.data.network;

import com.example.cpu10225.daggermvp.BuildConfig;

/**
 * Created by cpu10225 on 20/11/2017.
 */

public final class ApiEndPoint {
    public static final String ENDPOINT_GET_POSTS = "/posts";
    public static final String ENDPOINT_GET_COMMENTS = ENDPOINT_GET_POSTS + "/{id}/comments";

    private ApiEndPoint() {}
}
