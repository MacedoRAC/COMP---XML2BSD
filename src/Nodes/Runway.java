package Nodes;

/**
 * Created by André on 13/05/2015.
 */
public class Runway {
    private String alt;
    private String surface;
    private String length;
    private String width;
    private String number;
    private String designator;
    private String primaryDesignator;
    private String secondaryDesignator;
    private String patternAltitude;
    private String secondaryPattern;
    private String primMarkingBias;
    private String secMarkBias;

    private Boolean primaryTakeoff;
    private Boolean primarylanding;
    private Boolean secondaryTakeoff;
    private Boolean secondarylanding;

    private float lat;
    private float lon;
    private float heading;


    public Runway(){
        this.alt = null;
        this.surface = null;
        this.length = null;
        this.width = null;
        this.number = null;
        this.designator = null;
        this.primaryDesignator = null;
        this.secondaryDesignator = null;
        this.patternAltitude = null;
        this.secondaryPattern = "LEFT";
        this.primMarkingBias = null;
        this.secMarkBias = null;

        this.primaryTakeoff = null;
        this.primarylanding = true;
        this.secondaryTakeoff = true;
        this.secondarylanding = true;

        this.lat = Float.NaN;
        this.lon = Float.NaN;
        this.heading = Float.NaN;
    }

    public void output(){
        System.out.println("===================================");
        System.out.println("=======RUNWAY -> attributes========");
        System.out.println("===================================");

        if(this.alt != null){
            System.out.println("Alt : " + this.alt);
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

        if(this.number != null){
            System.out.println("Number : " + this.number);
        }

        if(this.designator != null){
            System.out.println("Designator : " + this.designator);
        }

        if(this.primaryDesignator != null){
            System.out.println("PrimaryDesignator : " + this.primaryDesignator);
        }

        if(this.secondaryDesignator != null){
            System.out.println("SecondaryDesignator : " + this.secondaryDesignator);
        }

        if(this.patternAltitude != null){
            System.out.println("PatternAltitude : " + this.patternAltitude);
        }


        if(this.secondaryPattern != null){
            System.out.println("SecondaryPattern : " + this.secondaryPattern);
        }

        if(this.primMarkingBias != null){
            System.out.println("PrimaryMarkingBias : " + this.primMarkingBias);
        }

        if(this.secMarkBias != null){
            System.out.println("SecondaryMarkingBias : " + this.secMarkBias);
        }

        if(this.primaryTakeoff != null){
            System.out.println("PrimaryTakeOff : " + this.primaryTakeoff);
        }

        if(this.primarylanding != null){
            System.out.println("Primarylanding : " + this.primarylanding);
        }

        if(this.secondaryTakeoff != null){
            System.out.println("SecondaryTakeOff : " + this.secondaryTakeoff);
        }

        if(this.secondarylanding != null){
            System.out.println("SecondaryLanding : " + this.secondarylanding);
        }

        if(this.lat != Float.NaN){
            System.out.println("Lat : " + this.lat);
        }

        if(this.lon != Float.NaN){
            System.out.println("Lon : " + this.lon);
        }

        if(this.heading != Float.NaN){
            System.out.println("Heading : " + this.heading);
        }

        System.lineSeparator();
        System.lineSeparator();
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public void setSurface(String surface) {
        this.surface = surface;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setDesignator(String designator) {
        this.designator = designator;
    }

    public void setPrimaryDesignator(String primaryDesignator) {
        this.primaryDesignator = primaryDesignator;
    }

    public void setSecondaryDesignator(String secondaryDesignator) {
        this.secondaryDesignator = secondaryDesignator;
    }

    public void setPatternAltitude(String patternAltitude) {
        this.patternAltitude = patternAltitude;
    }

    public void setSecondaryPattern(String secondaryPattern) {
        this.secondaryPattern = secondaryPattern;
    }

    public void setPrimMarkingBias(String primMarkingBias) {
        this.primMarkingBias = primMarkingBias;
    }

    public void setSecMarkBias(String secMarkBias) {
        this.secMarkBias = secMarkBias;
    }

    public void setPrimaryTakeoff(Boolean primaryTakeoff) {
        this.primaryTakeoff = primaryTakeoff;
    }

    public void setPrimarylanding(Boolean primarylanding) {
        this.primarylanding = primarylanding;
    }

    public void setSecondaryTakeoff(Boolean secondaryTakeoff) {
        this.secondaryTakeoff = secondaryTakeoff;
    }

    public void setSecondarylanding(Boolean secondarylanding) {
        this.secondarylanding = secondarylanding;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }

    public void setHeading(float heading) {
        this.heading = heading;
    }
}
