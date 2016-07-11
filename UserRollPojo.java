package nichetech.com.employeefullcrudwithlogin;

/**
 * Created by krunal on 6/4/16.
 */
public class UserRollPojo {

    private int id;
    private String name;
    private String sir_name;
    private String address;
    private String mobile;
    private String email;
    private String password;
    private String conform_password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSir_name() {
        return sir_name;
    }

    public void setSir_name(String sir_name) {
        this.sir_name = sir_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConform_password() {
        return conform_password;
    }

    public void setConform_password(String conform_password) {
        this.conform_password = conform_password;
    }
}
