package nichetech.com.employeefullcrudwithlogin;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import java.util.List;

public class ViewActivity extends AppCompatActivity {

    List<Employee> empList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
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


        ListView listView=(ListView)findViewById(R.id.listView1);

        Employee_db employee_db=new Employee_db(this);
        empList=employee_db.displayAll();

        EmployeeAdepter adepter=new EmployeeAdepter(getApplicationContext(),empList);
        listView.setAdapter(adepter);


    }

}
