package com.example.hp.firstandroidapp_afternoonclass;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by RalphPogi on 7/20/2016.
 */
public class Login extends AppCompatActivity {

    TextView show;

    EditText Username;
    EditText Password;
    Button Loginbtn,signup1;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.logn);

        Username = (EditText) findViewById(R.id.email);
        Password = (EditText) findViewById(R.id.password);
        Loginbtn = (Button) findViewById(R.id.button);
        show = (TextView) findViewById(R.id.szhow);
        signup1 = (Button) findViewById(R.id.signup);
        // loginbtn = (Button) findViewById(R.id.button);




        Loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                adaptdb repo = new adaptdb(getApplicationContext());
                boolean res = false;
                res = repo.validateLogin(Username.getText().toString(), Password.getText().toString());
                if (res == true) {
                    Intent intent = new Intent(Login.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getBaseContext(), "Username/Email or password is incorrect.", Toast.LENGTH_SHORT).show();
                }
            }
        });


        signup1.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {

                                           Intent intent = new Intent(Login.this, signupactivity.class);
                                           startActivity(intent);
                                       }


                                   }
        );


        show.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        Password.setInputType(InputType.TYPE_CLASS_TEXT);
                        break;
                    case MotionEvent.ACTION_UP:
                        Password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                        break;
                }
                return true;
            }

        });




    }





            /**      databaseAdapter sqlite = new databaseAdapter(getApplicationContext());

             if (sqlite.validateUser(Username.getText().toString(),Password.getText().toString())==true)
             {
             Intent intent = new Intent(Login.this, MainActivity.class);
             startActivity(intent);
             }
             else
             {
             Toast.makeText(getBaseContext(), "Invalid Email/Username or Password", Toast.LENGTH_SHORT).show();
             }


             }
             }); **/




    private boolean isValidEmail(String email) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private boolean isValidPassword(String pass) {
        if (pass != null && pass.length() > 7) {
            return true;
        }
        return false;

    }

    @Override
    protected  void onPause(){
        super.onPause();
    //    finish();
    }
}