package Nodes;

/**
 * Created by André on 13/05/2015.
 */
public class Fuel {

    private String fuelType;
    private String fuelAvail;

    public Fuel(){
        this.fuelType = null;
        this.fuelAvail = null;
    }

    public void output(){
        System.out.println("===================================");
        System.out.println("=========Fuel -> attributes========");
        System.out.println("===================================");

        if(this.fuelType != null){
            System.out.println("FuelType : " + this.fuelType);
        }

        if(this.fuelAvail != null){
            System.out.println("FuelAvailability : " + this.fuelAvail);
        }

    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public void setFuelAvail(String fuelAvail) {
        this.fuelAvail = fuelAvail;
    }
}
