package com.example.cpu10225.daggermvp.data.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.cpu10225.daggermvp.data.db.model.DaoMaster;
import com.example.cpu10225.daggermvp.util.anotation.ApplicationContext;
import com.example.cpu10225.daggermvp.util.anotation.DatabaseInfo;

import org.greenrobot.greendao.database.Database;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by cpu10225 on 20/11/2017.
 */

@Singleton
public class DbOpenHelper extends DaoMaster.OpenHelper {
    @Inject
    public DbOpenHelper(@ApplicationContext Context context, @DatabaseInfo String name) {
        super(context, name);
    }

    @Override
    public void onCreate(Database db) {
        super.onCreate(db);
    }

    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        super.onUpgrade(db, oldVersion, newVersion);
        DaoMaster.createAllTables(db, true);
    }
}
