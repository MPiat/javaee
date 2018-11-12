package mpiatek.app.domain;

import java.util.Date;

public class Router {
    private int id;
    private String name;
    private Date dateOfProduction;
    private double frequency;
    private boolean isWireless;

    public Router(String name, Date dateOfProduction, double frequency, boolean isWireless) {
        this.name = name;
        this.dateOfProduction = dateOfProduction;
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

    public Date getDateOfProduction() {
        return dateOfProduction;
    }

    public void setDateOfProduction(Date dateOfProduction) {
        this.dateOfProduction = dateOfProduction;
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
                ", dateOfProduction=" + dateOfProduction +
                ", frequency=" + frequency +
                ", isWireless=" + isWireless +
                '}';
    }
}
