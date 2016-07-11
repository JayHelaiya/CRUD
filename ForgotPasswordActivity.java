package nichetech.com.employeefullcrudwithlogin;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ForgotPasswordActivity extends AppCompatActivity {

  Db_manager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
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

        dbManager=new Db_manager(this);

        final EditText email=(EditText)findViewById(R.id.et_forgot_email11);
        final EditText pass=(EditText)findViewById(R.id.et_forgot_pass11);
        Button ok=(Button)findViewById(R.id.bt_submit_forgot);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email1=email.getText().toString().trim();
                String pass1=pass.getText().toString();
                boolean status1=chackEmail(email1);
                if (status1)
                {
                    boolean stutus= dbManager.chackImailAvailable(email1);

                    if (stutus)
                    {
                        dbManager.updatePassword(email1,pass1);
                        Toast.makeText(getApplicationContext(),"updated successfully",Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext()," this is not Registered email",Toast.LENGTH_SHORT).show();
                    }

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"email not valid.",Toast.LENGTH_SHORT).show();
                }


            }
        });

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
