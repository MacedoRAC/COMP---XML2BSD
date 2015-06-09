package Nodes;

import java.util.Vector;

/**
 * Created by André on 13/05/2015.
 */
public class Services {
    private Vector<Fuel> fuels;

    public Services(){
        fuels = new Vector<Fuel>();
    }

    public void output(){
        System.out.println("===================================");
        System.out.println("=======SERVICES -> attributes======");
        System.out.println("===================================");

        for(int i = 0; i < fuels.size(); i++){
            fuels.elementAt(i).output();
        }
    }

    public void addFuel(Fuel fuel){
        fuels.add(fuel);
    }
}
