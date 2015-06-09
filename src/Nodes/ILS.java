package Nodes;

/**
 * Created by André on 13/05/2015.
 */
public class ILS {

    private float lat;
    private float lon;
    private String alt;
    private float heading;
    private float frequency;
    private String end;
    private String range;
    private float magvar;
    private String ident;
    private float width;
    private String name;
    private Boolean backCourse;

    public ILS(){
        this.lat = Float.NaN;
        this.lon = Float.NaN;
        this.alt = null;
        this.heading = Float.NaN;
        this.frequency = Float.NaN;
        this.end = null;
        this.range = "27N";
        this.magvar = 0;
        this.ident = null;
        this.width = Float.NaN;
        this.name = null;
        this.backCourse = null;
    }

    public void output(){
        System.out.println("===================================");
        System.out.println("==========ILS -> attributes========");
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

        if(this.frequency != Float.NaN){
            System.out.println("Frequency : " + this.frequency);
        }

        if(this.end != null){
            System.out.println("End : " + this.end);
        }

        if(this.range != null){
            System.out.println("Range : " + this.range);
        }

        if(this.magvar != Float.NaN){
            System.out.println("Magvar : " + this.magvar);
        }

        if(this.ident != null){
            System.out.println("Ident : " + this.ident);
        }

        if(this.width != Float.NaN){
            System.out.println("Width : " + this.width);
        }

        if(this.name != null){
            System.out.println("Name : " + this.name);
        }

        if(this.backCourse != null){
            System.out.println("BackCourse : " + this.backCourse);
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

    public void setHeading(float heading) {
        this.heading = heading;
    }

    public void setFrequency(float frequency) {
        this.frequency = frequency;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public void setMagvar(float magvar) {
        this.magvar = magvar;
    }

    public void setIdent(String ident) {
        this.ident = ident;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBackCourse(Boolean backCourse) {
        this.backCourse = backCourse;
    }
}
