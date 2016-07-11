package nichetech.com.employeefullcrudwithlogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterationActivity extends AppCompatActivity {

    Db_manager db_manager;
    UserRollPojo pojo;
    EditText name, sir_name, address, mobile, email, password, conform_password;
    Button submit, back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeration);


        db_manager = new Db_manager(this);
        pojo = new UserRollPojo();

        submit = (Button) findViewById(R.id.bt_submit_R);
        back = (Button) findViewById(R.id.bt_back_R);

        name = (EditText) findViewById(R.id.et_fname);
        sir_name = (EditText) findViewById(R.id.et_lname);
        address = (EditText) findViewById(R.id.et_address);
        mobile = (EditText) findViewById(R.id.et_mo);
        email = (EditText) findViewById(R.id.et_email);
        password = (EditText) findViewById(R.id.et_password);
        conform_password = (EditText) findViewById(R.id.et_con_password);




        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String s1=name.getText().toString();
                String s2=sir_name.getText().toString();
                String s3=address.getText().toString();
                String s4=mobile.getText().toString();
                String s5=email.getText().toString();
                String s6=password.getText().toString();

                pojo.setName(s1);
                pojo.setSir_name(s2);
                pojo.setAddress(s3);
                pojo.setMobile(s4);
                pojo.setEmail(s5);
                pojo.setPassword(s6);


                Boolean passAns = checkPassword();
                Boolean emailAns = chackEmail(email.getText().toString().trim());

                if (emailAns) {
                    if (passAns) {

                        Log.e("controller", "i giving data to database");
                        db_manager.addUser(pojo);
                        name.setText("");
                        sir_name.setText("");
                        address.setText("");
                        mobile.setText("");
                        email.setText("");
                        password.setText("");
                        conform_password.setText("");
                        Toast.makeText(getApplicationContext(), "sucessfully Registered", Toast.LENGTH_SHORT).show();

                    } else {


                        Toast.makeText(getApplicationContext(), "password does not match", Toast.LENGTH_SHORT).show();
                    }

                } else {


                    Toast.makeText(getApplicationContext(), "Email does not Proper", Toast.LENGTH_SHORT).show();
                }

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent();
                finish();
            }
        });


    }

    public Boolean checkPassword() {
        if (password.getText().toString().equalsIgnoreCase(conform_password.getText().toString())) {
            return true;
        } else

            return false;
    }

    public Boolean chackEmail(String email) {

        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Boolean b = email.matches(EMAIL_PATTERN);

        if (b)
            return true;
        else
            return false;

    }
}
