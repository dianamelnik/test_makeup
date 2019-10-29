package model;

public class MakeUpCredentials {
    private String login;
    private String password;
    private String phoneNumber;

    public MakeUpCredentials(String login, String password, String phoneNumber) {
        this.login = login;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
       // System.out.println("Phone number got out");
        return phoneNumber;
    }

    @Override
    public String toString() {
        return   login +" "+ password +" "+ phoneNumber ;
    }
}
