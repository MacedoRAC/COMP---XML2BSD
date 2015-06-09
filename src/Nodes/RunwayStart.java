package Nodes;

/**
 * Created by André on 13/05/2015.
 */
public class RunwayStart {

    private String type;
    private float lat;
    private float lon;
    private String alt;
    private float heading;
    private String end;

    public RunwayStart(){
        this.lat = Float.NaN;
        this.lon = Float.NaN;
        this.alt = null;
        this.heading = Float.NaN;
        this.type = null;
        this.end = null;
    }

    public void output(){
        System.out.println("===================================");
        System.out.println("====RUNWAY START -> attributes=====");
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

        if(this.heading != Float.NaN){
            System.out.println("Heading : " + this.heading);
        }

        if(this.type != null){
            System.out.println("Type : " + this.type);
        }

        if(this.end != null){
            System.out.println("End : " + this.end);
        }
    }

    public void setLat(String lat) {
        lat = lat.replaceAll("^\"|\"$", "");
        this.lat = Float.parseFloat(lat);

        if(this.lat < -90 || this.lat > 90){
            this.lat = Float.NaN;
            throw new IllegalArgumentException("Lat is out of bounds (values between -90 and 90 are allowed)");
        }
    }

    public void setLon(String lon) {
        lon = lon.replaceAll("^\"|\"$", "");
        this.lon = Float.parseFloat(lon);

        if(this.lon < -180 || this.lon > 180){
            this.lon = Float.NaN;
            throw new IllegalArgumentException("Lon is out of bounds (values between -180 and 180 are allowed)");
        }
    }

    public void setAlt(String alt) {
        this.alt = alt.replaceAll("^\"|\"$", "");
    }

    public void setHeading(String heading) {
        heading = heading.replaceAll("^\"|\"$", "");
        this.heading = Float.parseFloat(heading);

        if(this.heading < 0 || this.heading > 360){
            this.heading = Float.NaN;
            throw new IllegalArgumentException("Heading is out of bounds (values between 0.0 and 360 are allowed)");
        }
    }

    public void setEnd(String end) {
        this.end = end.replaceAll("^\"|\"$", "");
    }

    public void setType(String type) {
        this.type = type.replaceAll("^\"|\"$", "");
    }
}
