package com.ayman.banzena.model.local.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.ayman.banzena.model.local.dao.AddressDao;
import com.ayman.banzena.model.pojo.BanzenaPojo;


/**
 * Created by ayman on 2019-02-18.
 */

@Database(entities = {BanzenaPojo.class}, version = 1, exportSchema = false)
public abstract class MyAppDB extends RoomDatabase {

    private static MyAppDB INSTANCE;

    public abstract AddressDao addressDao();

    public static MyAppDB getAppDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), MyAppDB.class, "ic_user-database")
                            // allow queries on the main thread.
                            // Don't do this on a real app! See PersistenceBasicSample for an example.
                            .allowMainThreadQueries()
                            .build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }
}
