package mpiatek.app.domain;

import java.util.Date;

public class Settings {
    private int id;
    private String frequency;
    private Date dateFrom;
    private Date dateTo;
    private boolean wireless;
    private boolean wired;
    private boolean isps;

    public Settings(int id,String frequency, Date dateFrom, Date dateTo) {
        this.id = id;
        this.frequency = frequency;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public boolean isWireless() {
        return wireless;
    }

    public void setWireless(boolean wireless) {
        this.wireless = wireless;
    }

    public boolean isWired() {
        return wired;
    }

    public void setWired(boolean wired) {
        this.wired = wired;
    }

    public boolean isIsps() {
        return isps;
    }

    public void setIsps(boolean isps) {
        this.isps = isps;
    }

    @Override
    public String toString() {
        return "Settings{" +
                "frequency='" + frequency + '\'' +
                ", dateFrom=" + dateFrom +
                ", dateTo=" + dateTo +
                ", wireless=" + wireless +
                ", wired=" + wired +
                ", isps=" + isps +
                '}';
    }
}
