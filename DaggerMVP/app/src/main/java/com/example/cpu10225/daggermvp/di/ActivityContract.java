package com.example.cpu10225.daggermvp.di;

import com.example.cpu10225.daggermvp.data.db.BaseGetData;

import java.util.List;

/**
 * Created by cpu10225 on 14/11/2017.
 */

public interface ActivityContract {
    interface View {
        void showData(List<BaseGetData> listData);
        void showError(String message);
        void showComplete();
    }

    interface Presenter {
        void loadData();
    }
}
