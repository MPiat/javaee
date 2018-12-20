package mpiatek.app.domain;

import java.util.Date;

public class Router {
    private int id;
    private String name;
    private Date dateOfProd;
    private double frequency;
    private boolean isWireless;

    public Router(String name, Date dateOfProd, double frequency, boolean isWireless) {
        this.name = name;
        this.dateOfProd = dateOfProd;
        this.frequency = frequency;
        this.isWireless = isWireless;
    }

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

    public Date getDateOfProd() {
        return dateOfProd;
    }

    public void setDateOfProd(Date dateOfProd) {
        this.dateOfProd = dateOfProd;
    }

    public double getFrequency() {
        return frequency;
    }

    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }

    public boolean isWireless() {
        return isWireless;
    }

    public void setWireless(boolean wireless) {
        isWireless = wireless;
    }

    @Override
    public String toString() {
        return "Router{" +
                "name='" + name + '\'' +
                ", dateOfProd=" + dateOfProd +
                ", Frequency=" + frequency +
                ", isWireless=" + isWireless +
                '}';
    }
}
