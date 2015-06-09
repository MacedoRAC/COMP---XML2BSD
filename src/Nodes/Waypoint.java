package Nodes;

/**
 * Created by André on 13/05/2015.
 */
public class Waypoint {

    private float lat;
    private float lon;
    private String waypointType;
    private float magvar;
    private String waypointRegion;
    private String waypointIdent;

    public Waypoint(){
        this.lat = Float.NaN;
        this.lon = Float.NaN;
        this.waypointType = null;
        this.magvar = Float.NaN;
        this.waypointRegion = null;
        this.waypointIdent = null;
    }

    public void output(){
        System.out.println("===================================");
        System.out.println("=======WAYPOINT -> attributes======");
        System.out.println("===================================");


        if(this.lat != Float.NaN){
            System.out.println("Lat : " + this.lat);
        }

        if(this.lon != Float.NaN){
            System.out.println("Lon : " + this.lon);
        }

        if(this.waypointType != null){
            System.out.println("WaypointType : " + this.waypointType);
        }

        if(this.magvar != Float.NaN){
            System.out.println("Magvar : " + this.magvar);
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

    public void setLat(float lat) {
        this.lat = lat;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }

    public void setWaypointType(String waypointType) {
        this.waypointType = waypointType;
    }

    public void setMagvar(float magvar) {
        this.magvar = magvar;
    }

    public void setWaypointRegion(String waypointRegion) {
        this.waypointRegion = waypointRegion;
    }

    public void setWaypointIdent(String waypointIdent) {
        this.waypointIdent = waypointIdent;
    }
}
