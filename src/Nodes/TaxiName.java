package Nodes;

/**
 * Created by André on 13/05/2015.
 */
public class TaxiName {

    private Integer index;
    private String name;

    public TaxiName(){
        this.index = null;
        this.name = null;
    }

    public void output(){
        System.out.println("===================================");
        System.out.println("======TAXINAME -> attributes=======");
        System.out.println("===================================");


        if(this.index != Float.NaN){
            System.out.println("Index : " + this.index);
        }

        System.out.println("Name : " + this.name);


        System.lineSeparator();
        System.lineSeparator();
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public void setName(String name) {
        this.name = name;
    }
}
