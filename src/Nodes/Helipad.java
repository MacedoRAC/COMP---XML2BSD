package Nodes;

/**
 * Created by André on 13/05/2015.
 */
public class Helipad {

    private float lat;
    private float lon;
    private String alt;
    private String surface;
    private float heading;
    private String length;
    private String width;
    private String type;
    private Boolean closed;
    private Boolean transparent;
    private Integer red;
    private Integer green;
    private Integer blue;

    public Helipad(){
        this.lat = Float.NaN;
        this.lon = Float.NaN;
        this.alt = null;
        this.surface = null;
        this.heading = Float.NaN;
        this.length = null;
        this.width = null;
        this.type = null;
        this.closed = null;
        this.transparent = null;
        this.red = null;
        this.green = null;
        this.blue = null;
    }

    public void output(){
        System.out.println("===================================");
        System.out.println("========HELIPAD -> attributes======");
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

        if(this.surface != null){
            System.out.println("Surface : " + this.surface);
        }

        if(this.length != null){
            System.out.println("Length : " + this.length);
        }

        if(this.width != null){
            System.out.println("Width : " + this.width);
        }

        if(this.type != null){
            System.out.println("Type : " + this.type);
        }

        if(this.closed != null){
            System.out.println("Closed : " + this.closed);
        }

        if(this.width != null){
            System.out.println("Width : " + this.width);
        }

        if(this.transparent != null){
            System.out.println("Transparent : " + this.transparent);
        }

        if(this.red != null){
            System.out.println("Red : " + this.red);
        }

        if(this.green != null){
            System.out.println("Green : " + this.green);
        }

        if(this.blue != null){
            System.out.println("Blue : " + this.blue);
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

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public void setSurface(String surface) {
        this.surface = surface;
    }

    public void setHeading(float heading) {
        this.heading = heading;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setClosed(Boolean closed) {
        this.closed = closed;
    }

    public void setTransparent(Boolean transparent) {
        this.transparent = transparent;
    }

    public void setRed(Integer red) {
        this.red = red;
    }

    public void setGreen(Integer green) {
        this.green = green;
    }

    public void setBlue(Integer blue) {
        this.blue = blue;
    }
}
