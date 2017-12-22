package com.example.cpu10225.unittestapirequest;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by cpu10225 on 22/12/2017.
 */

public interface CharactersDataSource {

    @GET("people/")
    Observable<CharactersResponseModel> getCharacters();

}