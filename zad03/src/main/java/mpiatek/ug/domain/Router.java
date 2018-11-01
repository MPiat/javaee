package mpiatek.ug.domain;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Router {

    private String name = "unknown";
    private Date prod;// = new java.util.Date();
    private Boolean wireless = false;
    private Double frequency = 2.4;

    public Router() {
        super();
    }

    public Router(String name, Date prod, Boolean wireless, Double frequency) {
        super();
        this.name = name;
        this.prod = prod;
        this.wireless = wireless;
        this.frequency = frequency;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getProd() {
        return prod;
    }

    public void setProd(String prod) {
        // 2018-11-06  - this is bwing passed in the request
//        this.prodDate = new java.util.Date();
//        try {
//            //Error Here
//            System.out.println(prodDate);
//            SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD");
//            Date formattedDate = format.parse(prodDate);
//            this.prodDate = formattedDate;
//        }catch (Exception e){
//            System.out.println(e);
//            this.prodDate = new java.util.Date();
//        }
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd ");

            this.prod = format.parse(prod);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public Boolean getWireless() {
        return wireless;
    }

    public void setWireless(Boolean wireless) {
        this.wireless = wireless;
    }

    public Double getFrequency() {
        return frequency;
    }

    public void setFrequency(Double frequency) {
        this.frequency = frequency;
    }
}
