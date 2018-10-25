package mpiatek.ug.servletdemo.model;

import java.util.Date;

public class Router {

    public String name;
    public Date prodDate;
    public Boolean isWireless;
    public Double frequency;

    public Router(String name, Date prodDate, Boolean isWireless, Double frequency) {
        this.name = name;
        this.prodDate = prodDate;
        this.isWireless = isWireless;
        this.frequency = frequency;
    }
//
//    public static String getName() {
//        return name;
//    }
//
//    public static String getEmail() {
//        return email;
//    }
//
//    public static String getPassword() {
//        return password;
//    }
//
//    public static String getReference() {
//        return reference;
//    }
//
//    public String getGender(){
//        return gender;
//    }
//
//    public String[] getInterests() {
//        return interests;
//    }


}
