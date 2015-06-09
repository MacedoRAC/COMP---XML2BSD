package Nodes;

/**
 * Created by André on 13/05/2015.
 */
public class Tower {
    private String alt;
    private float lat;
    private float lon;

    public Tower(){
        this.lat = Float.NaN;
        this.lon = Float.NaN;
    }

    public void output(){

        System.out.println("===================================");
        System.out.println("========TOWER -> attributes========");
        System.out.println("===================================");


        if(this.alt != null){
            System.out.println("Alt : " + this.alt);
        }

        if(this.lat != Float.NaN){
            System.out.println("Lat : " + this.lat);
        }

        if(this.lon != Float.NaN){
            System.out.println("Lon : " + this.lon);
        }

        System.lineSeparator();
        System.lineSeparator();
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }
}
