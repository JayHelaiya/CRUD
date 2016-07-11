package nichetech.com.employeefullcrudwithlogin;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    Db_manager dbManager;
    EditText emailAdd,password;
    TextView forgotPass;
    Button registeration,loginButton;
    boolean status=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        forgotPass=(TextView)findViewById(R.id.tv_forgot_pass);
        emailAdd=(EditText)findViewById(R.id.et_emailAdress);
        password= (EditText) findViewById(R.id.et_password);
        registeration=(Button)findViewById(R.id.bt_Registeration);
        loginButton=(Button)findViewById(R.id.bt_login);
        dbManager=new Db_manager(this);

        forgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent forgotPass=new Intent(getApplicationContext(),ForgotPasswordActivity.class);
                startActivity(forgotPass);
            }
        });

        registeration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent register=new Intent(getApplicationContext(),RegisterationActivity.class);
                startActivity(register);
            }
        });






        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email=emailAdd.getText().toString().trim();
                String pass=password.getText().toString();

                Boolean emailResult=isEmailValid(email);
                if (emailResult)
                {
                    Log.e("TAG", "Email is valid");
                    Log.e("TAG", email);
                    Log.e("TAG", pass);
                    status=dbManager.chackUsernameOrPasswordValidOrNot(email,pass);

                    if (status)
                    {
                        Toast.makeText(getApplicationContext(),"login is valid ",Toast.LENGTH_SHORT).show();

                        Intent home=new Intent(getApplicationContext(),HomeActivity.class);
                        startActivity(home);

                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Email or May Password Wrong..",Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Email Not Valid ",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    public boolean isEmailValid(String email)
    {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Boolean b = email.matches(EMAIL_PATTERN);

        if (b)
            return true;
        else
            return false;
    }

}
