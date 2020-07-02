package com.ashu.roomdatabase;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.ashu.roomdatabase.Model.Record;

@Database(entities = {Record.class},version = 1)
public abstract class MyDatabase extends RoomDatabase
{
    public abstract RecordDao recordDao();
}
