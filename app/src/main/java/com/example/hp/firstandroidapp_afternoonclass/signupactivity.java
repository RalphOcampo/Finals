package com.example.hp.firstandroidapp_afternoonclass;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by RalphPogi on 17/09/16.
 */
public class signupactivity extends AppCompatActivity implements View.OnClickListener{
    TextView firstname;
    TextView lastname;
    TextView username;
    TextView email;
    TextView password;
    TextView confirmPassword;
    Button create;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        //  final databaseAdapter sqlite = new databaseAdapter(getApplicationContext());
        final SimpleDateFormat currentDate = new SimpleDateFormat("dd/MM/yyyy");
        final Date todayDate = new Date();
        final String thisDate = currentDate.format(todayDate);
        final EditText email = (EditText) findViewById(R.id.email);
        final EditText password = (EditText) findViewById(R.id.pass);
        final EditText confirmPassword = (EditText) findViewById(R.id.cpass);
        final EditText username = (EditText) findViewById(R.id.username);
        final EditText firstname = (EditText) findViewById(R.id.Firstname);
        final EditText lastname = (EditText) findViewById(R.id.Lastname);
        create = (Button) findViewById(R.id.btnregister);

create.setOnClickListener(this);
    }

        public void onClick (View view){
        if (view == findViewById(R.id.btnregister)) {
            final EditText email = (EditText) findViewById(R.id.email);
            final EditText password = (EditText) findViewById(R.id.pass);
            final EditText confirmPassword = (EditText) findViewById(R.id.cpass);
            final EditText username = (EditText) findViewById(R.id.username);
            final EditText firstname = (EditText) findViewById(R.id.Firstname);
            final EditText lastname = (EditText) findViewById(R.id.Lastname);
            Button btnRegister = (Button) findViewById(R.id.btnregister);
            int ab=0;
            SimpleDateFormat currentDate = new SimpleDateFormat("dd/MM/yyyy");
            Date todayDate = new Date();
            String thisDate = currentDate.format(todayDate);

            if (isValidEmail(email.getText().toString())) {
                if (((lastname != null)
                        && (firstname != null)
                        && (username != null)
                        && (password != null
                        && password.length() >= 8)
                        && password.getText().toString().equals(confirmPassword.getText().toString()))) {

                    dbopen open = new dbopen();
                    adaptdb adap = new adaptdb(this);
                    open.getfirstname = firstname.getText().toString();
                    open.getlastname = lastname.getText().toString();
                    open.getusername = username.getText().toString();
                    open.getemail = email.getText().toString();
                    open.getpassword = password.getText().toString();
                    open.getdatecreated = thisDate;

                    ab = adap.createAccount(open);
                    Toast.makeText(this, "SUCCESSFULLY CREATED!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(signupactivity.this,Login.class);
                    startActivity(intent);
                } else {
                    password.setError("Password mismatched or insufficient password length: it should be atleast 8 characters");
                    //password.setText("");
                    //confirmPassword.setText("");
                    password.requestFocus();
                }
            } else {
                email.setError("Invalid Email Validation");
                email.setText("");
                password.setText("");
                confirmPassword.setText("");
                email.requestFocus();
            }
        }
    }


    /**findViewById(R.id.btnregister).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                if (isValidEmail(email.getText().toString()))
               {
                    if (((lastname!=null)
                       &&(firstname!=null)
                       &&(username!=null)
                       &&(password != null
                       && password.length() >= 8)
                       && password.getText().toString().equals(confirmPassword.getText().toString())))
                    {
                        sqlite.registerUser(email.getText().toString(),
                                password.getText().toString(),
                                thisDate,
                                username.getText().toString(),
                                firstname.getText().toString(),
                                lastname.getText().toString());
                        Toast.makeText(getApplication(),"Registered Successful",Toast.LENGTH_SHORT).show();
                        Toast.makeText(getApplication(),email.getText().toString(),Toast.LENGTH_SHORT).show();
                        Toast.makeText(getApplication(),password.getText().toString(),Toast.LENGTH_SHORT).show();
                        Toast.makeText(getApplication(),thisDate,Toast.LENGTH_SHORT).show();
                        Toast.makeText(getApplication(),username.getText().toString(),Toast.LENGTH_SHORT).show();
                        Toast.makeText(getApplication(),firstname.getText().toString(),Toast.LENGTH_SHORT).show();
                        Toast.makeText(getApplication(),lastname.getText().toString(),Toast.LENGTH_SHORT).show();
                        email.setText("");
                        password.setText("");
                        confirmPassword.setText("");
                        firstname.setText("");
                        username.setText("");
                        lastname.setText("");

                        Intent intent = new Intent(signupactivity.this,Login.class );
                        startActivity(intent);
                    }
                    else
                    {
                       password.setError("Password mismatched or insufficient password length: it should be atleast 8 characters");
                       //password.setText("");
                       //confirmPassword.setText("");
                       password.requestFocus();
                    }
                }
                else
                {
                    email.setError("Invalid Email Validation");
                    email.setText("");
                    password.setText("");
                    confirmPassword.setText("");
                    email.requestFocus();
                }
           }
        });
    }
*/
    private boolean isValidEmail(String email) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    @Override
    protected  void onPause(){
        super.onPause();
     //   finish();
    }
}
