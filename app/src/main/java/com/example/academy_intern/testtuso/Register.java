package com.example.academy_intern.testtuso;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

import java.text.ParseException;

public class Register extends AppCompatActivity {
    EditText srname, namey, passwordy, cellno, id, username;
    Button reg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Parse.initialize(this, "pr1GkN2ZjWJy5PxsnMJkgR3uX5BDK2cV7lnydoen", "3sZ0V5OAIAASkgFuM0n6qr9ega1ZvGg3Umnv9Cca");

        ParseUser.enableAutomaticUser();

       // ParseUser.getCurrentUser.saveInBackground();

        setContentView(R.layout.activity_register);
        srname = (EditText) findViewById(R.id.txts);
        namey = (EditText) findViewById(R.id.txtn);
        passwordy = (EditText) findViewById(R.id.txtp);
        cellno = (EditText) findViewById(R.id.txtc);
        id = (EditText) findViewById(R.id.txid);
        username = (EditText) findViewById(R.id.txtus);
        reg = (Button) findViewById(R.id.btnreg);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
           Register();

            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);


    }

    public void Register() {
        try {
       //srname.getText().toString();
            ParseObject gameScore = new ParseObject("User");
            gameScore.put("Surname",srname.getText().toString());
            gameScore.put("name",namey.getText().toString());
            gameScore.put("password", passwordy.getText().toString());
            gameScore.put("number", cellno.getText().toString());
            gameScore.put(" Username", username.getText().toString());
            gameScore.saveInBackground();
        }
         catch (Exception e) {
          e.getStackTrace();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

