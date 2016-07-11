package nichetech.com.employeefullcrudwithlogin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainScreenForCrud extends AppCompatActivity {

    EditText name,designation,department,email;
    Button button,back;
    Employee_db employee_db;
    Employee employee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen_for_crud);

        employee=new Employee();
        employee_db=new Employee_db(this);
        Bundle extras=getIntent().getExtras();
        String btName=extras.getString("buttonName");
        Integer idNo=new Integer(extras.getInt("idNo"));
        final Integer poupId=new Integer(extras.getInt("poupId"));

        Log.e("Bt","in side crud"+btName);
        Log.e("ddd",idNo.toString());
        Log.e("ddd",poupId.toString());




        if (btName.equalsIgnoreCase("add") && idNo==101)
        {
            name=(EditText)findViewById(R.id.et_emp_name);
            designation=(EditText)findViewById(R.id.et_Emp_designation);
            department=(EditText)findViewById(R.id.et_emp_department);
            email=(EditText)findViewById(R.id.et_emp_email);

            button=(Button)findViewById(R.id.bt_update_Raf);
            button.setText("add");


             button.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {

                     employee.setName(name.getText().toString());
                     employee.setDesignation(designation.getText().toString());
                     employee.setDepartment(department.getText().toString());
                     employee.setEmail(email.getText().toString());

                     Boolean emailAns = chackEmail(email.getText().toString().trim());

                     if (emailAns) {


                             employee_db.addEmployee(employee);
                             Log.e("controller", "i giving data to database");
                             name.setText("");
                             designation.setText("");
                             department.setText("");
                             email.setText("");

                             Toast.makeText(getApplicationContext(), "sucessfully Registered", Toast.LENGTH_SHORT).show();


                     } else {

                         Toast.makeText(getApplicationContext(), "Email does not Proper", Toast.LENGTH_SHORT).show();
                     }


                 }
             });



        }
        else if (btName.equalsIgnoreCase("update") && idNo==102)
        {
            employee=employee_db.displayById(poupId);
            button=(Button)findViewById(R.id.bt_update_Raf);
            button.setText("update");
            back=(Button)findViewById(R.id.bt_back_Raf);

            name=(EditText)findViewById(R.id.et_emp_name);
            designation=(EditText)findViewById(R.id.et_Emp_designation);
            department=(EditText)findViewById(R.id.et_emp_department);
            email=(EditText)findViewById(R.id.et_emp_email);


            name.setText(employee.getName());
            designation.setText(employee.getDesignation());
            department.setText(employee.getDepartment());
            email.setText(employee.getEmail());



            back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent();
                    finish();
                }
            });


            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String s1 = name.getText().toString();
                    String s2 = designation.getText().toString();
                    String s3 = department.getText().toString();
                    String s5 = email.getText().toString();

                    Log.e("TEG", s1);
                    Log.e("TEG", s2);
                    Log.e("TEG", s3);
                    Log.e("TEG", s5);


                    employee.setName(s1);
                    employee.setDesignation(s2);
                    employee.setDepartment(s3);
                    employee.setEmail(s5);


                    boolean status = employee_db.updateAll(employee, poupId);

                    if (status) {
                        name.setText("");
                        designation.setText("");
                        department.setText("");
                        email.setText("");

                        Toast.makeText(getApplicationContext(), "Updated Successfully", Toast.LENGTH_SHORT).show();

                    }

                }
            });

        }else if(btName.equalsIgnoreCase("delete") && idNo==103)
        {
            employee=employee_db.displayById(poupId);
            button=(Button)findViewById(R.id.bt_update_Raf);
            button.setText("delete");
            back=(Button)findViewById(R.id.bt_back_Raf);

            name=(EditText)findViewById(R.id.et_emp_name);
            designation=(EditText)findViewById(R.id.et_Emp_designation);
            department=(EditText)findViewById(R.id.et_emp_department);
            email=(EditText)findViewById(R.id.et_emp_email);


            name.setText(employee.getName());
            designation.setText(employee.getDesignation());
            department.setText(employee.getDepartment());
            email.setText(employee.getEmail());



            back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent();
                    finish();
                }
            });

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    employee_db.deleteById(poupId);

                    Toast.makeText(getApplicationContext(),"sucessfully Deleted",Toast.LENGTH_LONG).show();
                    employee_db.displayAll();


                }
            });



        }
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
