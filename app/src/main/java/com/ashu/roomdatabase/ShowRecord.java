package com.ashu.roomdatabase;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ashu.roomdatabase.Adapter.RecordAdapter;
import com.ashu.roomdatabase.Model.Record;

import java.util.ArrayList;
import java.util.List;

public class ShowRecord extends AppCompatActivity {

    RecyclerView recyclerView;

    List<Record> arrayList;

    private MyDatabase myDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_record);

        recyclerView=findViewById(R.id.recycleitem);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        myDatabase = Room.databaseBuilder(getApplicationContext(),MyDatabase.class,"UserEntry").allowMainThreadQueries().build();
        arrayList = myDatabase.recordDao().getAllRecord();
        RecordAdapter adapter = new RecordAdapter(this,(ArrayList) arrayList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();



    }
}
