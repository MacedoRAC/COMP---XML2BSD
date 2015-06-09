package Nodes;

/**
 * Created by André on 13/05/2015.
 */
public class DME {

    private float lat;
    private float lon;
    private String alt;
    private String range;

    public DME(){
        this.lat = Float.NaN;
        this.lon = Float.NaN;
        this.alt = null;
        this.range = null;
    }

    public void output(){
        System.out.println("===================================");
        System.out.println("=========DME -> attributes=========");
        System.out.println("===================================");


        if(this.lat != Float.NaN){
            System.out.println("Lat : " + this.lat);
        }

        if(this.lon != Float.NaN){
            System.out.println("Lon : " + this.lon);
        }

        if(this.alt != null){
            System.out.println("Alt : " + this.alt);
        }

        if(this.range != null){
            System.out.println("Range : " + this.range);
        }
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public void setRange(String range) {
        this.range = range;
    }
}
