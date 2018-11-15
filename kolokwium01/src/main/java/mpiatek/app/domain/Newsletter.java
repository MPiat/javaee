package mpiatek.app.domain;

import java.util.Date;

public class Newsletter {
    private int id;
    private Date dateBeg;
    private Date dateEnd;
    private String frequency;
    private String subject;

    public Newsletter( Date dateBeg, Date dateEnd, String frequency, String subject) {
        this.dateBeg = dateBeg;
        this.dateEnd = dateEnd;
        this.frequency = frequency;
        this.subject = subject;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateBeg() {
        return dateBeg;
    }

    public void setDateBeg(Date dateBeg) {
        this.dateBeg = dateBeg;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Newsletter{" +
                ", dateBeg=" + dateBeg +
                ", dateEnd=" + dateEnd +
                ", frequency=" + frequency +
                ", Subject=" + subject +
                '}';
    }
}
