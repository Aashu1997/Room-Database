package com.ashu.roomdatabase;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ashu.roomdatabase.Model.Record;

public class DeleteRecord extends AppCompatActivity {

    EditText userid;
    Button delbtn;

    private MyDatabase myDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_record);

        userid=findViewById(R.id.editText3);
        delbtn=findViewById(R.id.button5);

        myDatabase = Room.databaseBuilder(getApplicationContext(),MyDatabase.class,"UserEntry").allowMainThreadQueries().build();

        delbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int id = Integer.parseInt(userid.getText().toString());

                Record record = new Record();
                record.setId(id);

                myDatabase.recordDao().deleteuser(record);
                Toast.makeText(DeleteRecord.this, "data deleted!!!", Toast.LENGTH_SHORT).show();

                userid.setText("");

            }
        });
    }
}
