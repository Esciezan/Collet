package fxapplication;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class TableData {
    private SimpleStringProperty Itemname, Property1, Property2;

    private SimpleIntegerProperty NumProperty1, NumProperty2;

    public TableData(String Itemname, String Property1, String Property2, Integer NumProperty1, Integer NumProperty2) {
        this.Itemname = new SimpleStringProperty(Itemname);
        this.Property1 = new SimpleStringProperty(Property1);
        this.Property2 = new SimpleStringProperty(Property2);
        this.NumProperty1 = new SimpleIntegerProperty(NumProperty1);
        this.NumProperty2 = new SimpleIntegerProperty(NumProperty2);
    }

    public TableData() {}
    //Acessor Methods
    public String getItemname() {
        return Itemname.get();
    }

    public String getProperty1() {
        return Property1.get();
    }

    public String getProperty2() {
        return Property2.get();
    }

    public Integer getNumproperty1() {
        return NumProperty1.get();
    }

    public Integer getNumproperty2() {
        return NumProperty2.get();
    }

    public void setItemname(String newitem) {
        Itemname = new SimpleStringProperty(newitem);
    }

    public void setProperty1(String property1) {
        Property1 = new SimpleStringProperty(property1);
    }

    public void setProperty2(String newproperty2) {
        Property2 = new SimpleStringProperty(newproperty2);
    }

    public void setNumproperty1(int newnum1) {
        NumProperty1 = new SimpleIntegerProperty(newnum1);
    }

    public void setNumproperty2(int newnum2) {
        NumProperty2 = new SimpleIntegerProperty(newnum2);
    }

}
