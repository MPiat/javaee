package mpiatek.ug.domain;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Router {

    private String name = "unknown";
    private Date prodDate;// = new java.util.Date();
    private boolean wireless = false;
    private Double frequency = 2.4;

    public Router() {
        super();
    }

    public Router(String name, Date prodDate, Boolean wireless, Double frequency) {
        super();
        this.name = name;
        this.prodDate = prodDate;
        this.wireless = wireless;
        this.frequency = frequency;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getProdDate() {
        return prodDate;
    }

    public void setProdDate(String prodDate) {
        try {
            //Error Here
            System.out.println(prodDate);
            SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy");
            Date formattedDate = format.parse(prodDate);
            this.prodDate = formattedDate;
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public Boolean getWireless() {
        return wireless;
    }

    public void setWireless(boolean wireless) {
        this.wireless = wireless;
    }

    public Double getFrequency() {
        return frequency;
    }

    public void setFrequency(Double frequency) {
        this.frequency = frequency;
    }
}
