package Nodes;

/**
 * Created by André on 13/05/2015.
 */
public class RunwayAlias {

    private String number;
    private String designator;

    public RunwayAlias(){
        this.number = null;
        this.designator = null;
    }

    public void output(){

        System.out.println("===================================");
        System.out.println("=====RUNWAYALIAS -> attributes=====");
        System.out.println("===================================");


        if(this.number != null){
            System.out.println("Number : " + this.number);
        }

        if(this.designator != null){
            System.out.println("Designator : " + this.designator);
        }


        System.lineSeparator();
        System.lineSeparator();
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setDesignator(String designator) {
        this.designator = designator;
    }
}
