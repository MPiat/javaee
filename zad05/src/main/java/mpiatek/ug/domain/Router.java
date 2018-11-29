package mpiatek.ug.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Router {

    private String name;
    private int modelNum;

    public Router() {
    }

    public Router(String name, int modelNum) {
        this.name = name;
        this.modelNum = modelNum;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getModelNum() {
        return modelNum;
    }
    public void setModelNum(int modelNum) {
        this.modelNum = modelNum;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + modelNum;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Router other = (Router) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (modelNum != other.modelNum)
            return false;
        return true;
    }

}
