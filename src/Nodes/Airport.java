package Nodes;

/**
 * Created by André on 13/05/2015.
 */
public class Airport {
    private String region;
    private String country;
    private String state;
    private String city;
    private String name;
    private String ident;
    private String alt;
    private String testRadius;


    private float lat;
    private float lon;
    private float magvar;
    private float trafficScalar;

    public Airport() {
        this.lat = Float.NaN;
        this.lon = Float.NaN;
        this.magvar = Float.NaN;
        this.trafficScalar = Float.NaN;
    }

    public void output() {

        System.out.println("===================================");
        System.out.println("=======AIRPORT -> attributes=======");
        System.out.println("===================================");

        if (this.region != null) {
            System.out.println("Region : " + this.region);
        }

        if (this.country != null) {
            System.out.println("Country : " + this.country);
        }

        if (this.state != null) {
            System.out.println("State : " + this.state);
        }

        if (this.city != null) {
            System.out.println("City : " + this.city);
        }

        if (this.ident != null) {
            System.out.println("Ident : " + this.ident);
        }

        if (this.alt != null) {
            System.out.println("Alt : " + this.alt);
        }

        if (this.testRadius != null) {
            System.out.println("AirportTestRadius : " + this.testRadius);
        }

        if (this.lat != Float.NaN) {
            System.out.println("Lat : " + this.lat);
        }

        if (this.lon != Float.NaN) {
            System.out.println("Lon : " + this.lon);
        }


        if (this.magvar != Float.NaN) {
            System.out.println("Magvar : " + this.magvar);
        }


        if (this.trafficScalar != Float.NaN) {
            System.out.println("TrafficScalar : " + this.trafficScalar);
        }

        System.lineSeparator();
        System.lineSeparator();
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIdent(String ident) {
        this.ident = ident;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public void setTestRadius(String testRadius) {
        this.testRadius = testRadius;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }

    public void setMagvar(float magvar) {
        this.magvar = magvar;
    }

    public void setTrafficScalar(float trafficScalar) {
        this.trafficScalar = trafficScalar;
    }

    public String getRegion() {
        return region;
    }

    public String getCountry() {
        return country;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public String getName() {
        return name;
    }

    public String getIdent() {
        return ident;
    }

    public String getAlt() {
        return alt;
    }

    public String getTestRadius() {
        return testRadius;
    }

    public float getLat() {
        return lat;
    }

    public float getLon() {
        return lon;
    }

    public float getMagvar() {
        return magvar;
    }

    public float getTrafficScalar() {
        return trafficScalar;
    }
}