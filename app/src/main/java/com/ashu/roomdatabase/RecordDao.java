package com.ashu.roomdatabase;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.ashu.roomdatabase.Model.Record;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface RecordDao
{
    @Insert
    public void adduser(Record record);

    @Query("select * from users")
    public List<Record> getAllRecord();

    @Delete
    public void deleteuser(Record record);

    @Update
    public void updateuser(Record record);


}
