package Nodes;

/**
 * Created by André on 13/05/2015.
 */
public class GlideSlope {

    private float lat;
    private float lon;
    private String alt;
    private float pitch;
    private String range;

    public GlideSlope(){
        this.lat = Float.NaN;
        this.lon = Float.NaN;
        this.alt = null;
        this.pitch = Float.NaN;
        this.range = "27N";
    }

    public void output(){
        System.out.println("===================================");
        System.out.println("======GLIDESLOPE -> attributes=====");
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

        if(this.pitch != Float.NaN){
            System.out.println("Pitch : " + this.pitch);
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

    public void setPitch(float pitch) {
        this.pitch = pitch;
    }

    public void setRange(String range) {
        this.range = range;
    }
}
