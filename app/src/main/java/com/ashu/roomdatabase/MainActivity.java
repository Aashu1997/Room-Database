package com.ashu.roomdatabase;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ashu.roomdatabase.Model.Record;

public class MainActivity extends AppCompatActivity {
    EditText userid,username,useremail;
    Button insert,read,update,delete;

    private MyDatabase myDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDatabase = Room.databaseBuilder(getApplicationContext(),MyDatabase.class,"UserEntry").allowMainThreadQueries().build();

        userid=findViewById(R.id.editText);
        username=findViewById(R.id.editText2);
        useremail=findViewById(R.id.editText4);
        insert=findViewById(R.id.button);
        read=findViewById(R.id.button2);
        update=findViewById(R.id.button3);
        delete=findViewById(R.id.button4);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               // int id = Integer.parseInt(userid.getText().toString());
                String name = username.getText().toString();
                String email = useremail.getText().toString();

                Record record = new Record();
            //    record.setId(id);
                record.setUser_name(name);
                record.setUser_email(email);

                myDatabase.recordDao().adduser(record);
                Toast.makeText(MainActivity.this, "data saved!!!", Toast.LENGTH_SHORT).show();

              //  userid.setText("");
                username.setText("");
                useremail.setText("");

            }
        });


        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,ShowRecord.class);
                startActivity(intent);
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,UpdateRecord.class);
                startActivity(intent);


            }
        });


        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,DeleteRecord.class);
                startActivity(intent);


            }
        });
    }


}
