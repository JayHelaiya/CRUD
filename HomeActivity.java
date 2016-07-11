package nichetech.com.employeefullcrudwithlogin;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    Button addButton,viewButton,updateButton,deleteButton;
    final Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        addButton=(Button)findViewById(R.id.bt_add);
        viewButton=(Button)findViewById(R.id.bt_view);
        updateButton=(Button)findViewById(R.id.bt_update);
        deleteButton=(Button)findViewById(R.id.main_bt_delete);


        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String button_name=deleteButton.getText().toString();
                Log.e("Button name", button_name);
                // get prompts.xml view
                LayoutInflater li = LayoutInflater.from(context);
                View promptsView = li.inflate(R.layout.inputdialogbox, null);

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        context);

                // set prompts.xml to alertdialog builder
                alertDialogBuilder.setView(promptsView);

                final EditText userInput = (EditText) promptsView
                        .findViewById(R.id.editTextDialogUserInput);

                // set dialog message
                alertDialogBuilder
                        .setCancelable(false)
                        .setPositiveButton("OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,int id) {
                                        // get user input and set it to result
                                        // edit text
                                        Integer ui= new Integer(userInput.getText().toString());

                                        Intent updateByid=new Intent(getApplicationContext(),MainScreenForCrud.class);
                                        updateByid.putExtra("buttonName", button_name);
                                        updateByid.putExtra("idNo",103);
                                        updateByid.putExtra("poupId",ui);
                                        startActivity(updateByid);
                                        Toast.makeText(getApplicationContext(), "U Clicked YES", Toast.LENGTH_SHORT).show();
                                    }
                                })
                        .setNegativeButton("Cancel",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,int id) {
                                        dialog.cancel();
                                    }
                                });

                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();


            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String button_name=addButton.getText().toString();
                Log.e("Button name", button_name);
                Intent addEmp=new Intent(getApplicationContext(),MainScreenForCrud.class);
                addEmp.putExtra("buttonName", button_name);
                addEmp.putExtra("idNo",101);
                addEmp.putExtra("popupId",0);
                startActivity(addEmp);

            }
        });

        viewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent viewData=new Intent(getApplicationContext(),ViewActivity.class);
                startActivity(viewData);

            }
        });


        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String button_name=updateButton.getText().toString();
                Log.e("Button name", button_name);

                final String btId=new Integer(R.id.bt_update).toString();
                // get prompts.xml view
                LayoutInflater li = LayoutInflater.from(context);
                View promptsView = li.inflate(R.layout.inputdialogbox, null);

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        context);

                // set prompts.xml to alertdialog builder
                alertDialogBuilder.setView(promptsView);

                final EditText userInput = (EditText) promptsView
                        .findViewById(R.id.editTextDialogUserInput);

                // set dialog message
                alertDialogBuilder
                        .setCancelable(false)
                        .setPositiveButton("OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,int id) {
                                        // get user input and set it to result
                                        // edit text
                                        Integer ui= new Integer(userInput.getText().toString());

                                        Intent updateByid=new Intent(getApplicationContext(),MainScreenForCrud.class);
                                        updateByid.putExtra("buttonName", button_name);
                                        updateByid.putExtra("idNo",102);
                                        updateByid.putExtra("poupId",ui);
                                        startActivity(updateByid);
                                        Toast.makeText(getApplicationContext(), "U Clicked YES", Toast.LENGTH_SHORT).show();
                                    }
                                })
                        .setNegativeButton("Cancel",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,int id) {
                                        dialog.cancel();
                                    }
                                });

                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();

            }
        });

    }

}
