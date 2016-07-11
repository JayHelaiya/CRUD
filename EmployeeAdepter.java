package nichetech.com.employeefullcrudwithlogin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by krunal on 7/4/16.
 */
public class EmployeeAdepter extends BaseAdapter {


    Context context;
    List<Employee> employeeslist;
    LayoutInflater inflter;

    public EmployeeAdepter(Context context, List<Employee> employeesL) {
        this.context = context;
        this.employeeslist = employeesL;

    }


    @Override
    public int getCount() {
        return employeeslist.size();
    }

    @Override
    public Object getItem(int position) {
        return employeeslist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        inflter = (LayoutInflater.from(context));
        view = inflter.inflate(R.layout.employee_adepter, null);

        TextView name = (TextView) view.findViewById(R.id.tv_add_name);
        TextView department = (TextView) view.findViewById(R.id.tv_add_department);


        Employee employee1=employeeslist.get(position);
        name.setText(employee1.getName());
        department.setText(employee1.getDepartment());


        return view;
    }
}
