package com.example.cpu10225.unittestapirequest;

/**
 * Created by cpu10225 on 22/12/2017.
 */

public interface MainContract {

    interface View {

        void onFetchDataStarted();

        void onFetchDataCompleted();

        void onFetchDataSuccess(CharactersResponseModel charactersResponseModel);

        void onFetchDataError(Throwable e);
    }

    interface Presenter {

        void loadData();

        void subscribe();

        void unsubscribe();

        void onDestroy();

    }
}