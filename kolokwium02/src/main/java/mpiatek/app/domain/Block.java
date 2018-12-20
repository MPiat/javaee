package mpiatek.app.domain;

import java.util.Date;

public class Block {
    private int id;
    private String name;
    private Date dateOfProd;
    private double weight;
    private boolean isRed;
    private boolean isBlack;
    private boolean isYellow;


    public Block(String name, Date dateOfProd, double weight) {
        this.name = name;
        this.dateOfProd = dateOfProd;
        this.weight = weight;
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

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public boolean isRed() {
        return isRed;
    }

    public void setRed(boolean Red) {
        isRed = Red;
    }

    public boolean isBlack() {
        return isBlack;
    }

    public void setBlack(boolean Black) {
        isBlack = Black;
    }
    public boolean isYellow() {
        return isYellow;
    }

    public void setYellow(boolean Yellow) {
        isYellow = Yellow;
    }

    @Override
    public String toString() {
        return "Cinder Block{" +
                "name='" + name + '\'' +
                ", dateOfProd=" + dateOfProd +
                ", weight(kg)=" + weight +
                ", isRed=" + isRed +
                ", isYellow=" + isYellow +
                ", isBlack=" + isBlack +
                '}';
    }
}
