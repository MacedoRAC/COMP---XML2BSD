package Nodes;

/**
 * Created by André on 13/05/2015.
 */
public class ApproachLights {

    private String end;
    private String system;
    private Integer strobes;
    private Boolean reil;
    private Boolean touchdown;
    private Boolean endLights;

    public ApproachLights(){
        this.end = null;
        this.system = null;
        this.strobes = 0;
        this.reil = null;
        this.touchdown = null;
        this.endLights = null;
    }

    public void output(){
        System.out.println("===================================");
        System.out.println("===APPROACH LIGHTS -> attributes===");
        System.out.println("===================================");


        if(this.end != null){
            System.out.println("End : " + this.end);
        }

        if(this.system != null){
            System.out.println("System : " + this.system);
        }

        if(this.strobes != null){
            System.out.println("Strobes : " + this.strobes);
        }

        if(this.reil != null){
            System.out.println("Reil : " + this.reil);
        }

        if(this.touchdown != null){
            System.out.println("Touchdown : " + this.touchdown);
        }

        if(this.endLights != null){
            System.out.println("EndLights : " + this.endLights);
        }

        System.lineSeparator();
        System.lineSeparator();
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public void setStrobes(Integer strobes) {
        this.strobes = strobes;
    }

    public void setReil(Boolean reil) {
        this.reil = reil;
    }

    public void setTouchdown(Boolean touchdown) {
        this.touchdown = touchdown;
    }

    public void setEndLights(Boolean endLights) {
        this.endLights = endLights;
    }
}
