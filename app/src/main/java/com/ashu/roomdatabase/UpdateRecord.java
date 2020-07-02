package com.ashu.roomdatabase;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ashu.roomdatabase.Model.Record;

public class UpdateRecord extends AppCompatActivity {

    EditText userid,username,useremail;
    Button udbtn;

    private MyDatabase myDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_record);

        userid=findViewById(R.id.editText5);
        username=findViewById(R.id.editText6);
        useremail=findViewById(R.id.editText7);
        udbtn=findViewById(R.id.button6);

        myDatabase = Room.databaseBuilder(getApplicationContext(),MyDatabase.class,"UserEntry").allowMainThreadQueries().build();

        udbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int id = Integer.parseInt(userid.getText().toString());
                String name = username.getText().toString();
                String email = useremail.getText().toString();

                Record record = new Record();
                record.setId(id);
                record.setUser_name(name);
                record.setUser_email(email);

                myDatabase.recordDao().updateuser(record);
                Toast.makeText(UpdateRecord.this, "data saved!!!", Toast.LENGTH_SHORT).show();

                userid.setText("");
                username.setText("");
                useremail.setText("");

            }
        });

    }
}
