package Nodes;

/**
 * Created by André on 13/05/2015.
 */
public class Next {

    private String waypointType;
    private String waypointRegion;
    private String waypointIdent;
    private float altitudeMinimum;

    public Next(){
        this.waypointType = null;
        this.waypointRegion = null;
        this.waypointIdent = null;
        this.altitudeMinimum = Float.NaN;
    }

    public void output(){
        System.out.println("===================================");
        System.out.println("=========NEXT -> attributes========");
        System.out.println("===================================");

        if(this.waypointType != null){
            System.out.println("WaypointType : " + this.waypointType);
        }

        if(this.altitudeMinimum != Float.NaN){
            System.out.println("AltitudeMinimum : " + this.altitudeMinimum);
        }

        if(this.waypointRegion != null){
            System.out.println("WaypointRegion : " + this.waypointRegion);
        }

        if(this.waypointIdent != null){
            System.out.println("WaypointIdent : " + this.waypointIdent);
        }


        System.lineSeparator();
        System.lineSeparator();
    }

    public void setWaypointType(String waypointType) {
        this.waypointType = waypointType;
    }

    public void setWaypointRegion(String waypointRegion) {
        this.waypointRegion = waypointRegion;
    }

    public void setWaypointIdent(String waypointIdent) {
        this.waypointIdent = waypointIdent;
    }

    public void setAltitudeMinimum(float altitudeMinimum) {
        this.altitudeMinimum = altitudeMinimum;
    }
}
