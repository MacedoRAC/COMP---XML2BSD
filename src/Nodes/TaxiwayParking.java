package Nodes;

/**
 * Created by André on 13/05/2015.
 */
public class TaxiwayParking {

    private Integer index;
    private String type;
    private String orientation;
    private float lat;
    private float lon;
    private float biasX;
    private float biasZ;
    private float heading;
    private Integer number;
    private String airlineCodes;
    private Integer pushBack;
    private float teeOffset1;
    private float teeOffset2;
    private float teeOffset3;
    private float teeOffset4;

    public TaxiwayParking(){
        this.index = null;
        this.type = null;
        this.orientation = null;
        this.lat = Float.NaN;
        this.lon = Float.NaN;
        this.biasX = Float.NaN;
        this.biasZ = Float.NaN;
    }

    public void output(){
        System.out.println("===================================");
        System.out.println("====TAXIWAYARKING -> attributes====");
        System.out.println("===================================");


        if(this.lat != Float.NaN){
            System.out.println("Lat : " + this.lat);
        }

        if(this.lon != Float.NaN){
            System.out.println("Lon : " + this.lon);
        }

        if(this.type != null){
            System.out.println("Type : " + this.type);
        }

        if(this.orientation != null){
            System.out.println("Orientation : " + this.orientation);
        }

        if(this.biasX != Float.NaN){
            System.out.println("BiasX : " + this.biasX);
        }

        if(this.biasZ != Float.NaN){
            System.out.println("BiasZ : " + this.biasZ);
        }

        if(this.index != null){
            System.out.println("Index : " + this.index);
        }

        if(this.heading != Float.NaN){
            System.out.println("Heading : " + this.heading);
        }

        if(this.number != Float.NaN){
            System.out.println("Number : " + this.number);
        }

        if(this.airlineCodes != null){
            System.out.println("AirlineCodes : " + this.airlineCodes);
        }

        if(this.pushBack != null){
            System.out.println("PushBack : " + this.pushBack);
        }

        if(this.teeOffset1 != Float.NaN){
            System.out.println("TeeOffset1 : " + this.teeOffset1);
        }

        if(this.teeOffset2 != Float.NaN){
            System.out.println("TeeOffset2 : " + this.teeOffset2);
        }

        if(this.teeOffset3 != Float.NaN){
            System.out.println("TeeOffset3 : " + this.teeOffset3);
        }

        if(this.teeOffset4 != Float.NaN){
            System.out.println("TeeOffset4 : " + this.teeOffset4);
        }

        System.lineSeparator();
        System.lineSeparator();
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }

    public void setBiasX(float biasX) {
        this.biasX = biasX;
    }

    public void setBiasZ(float biasZ) {
        this.biasZ = biasZ;
    }

    public void setHeading(float heading) {
        this.heading = heading;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setAirlineCodes(String airlineCodes) {
        this.airlineCodes = airlineCodes;
    }

    public void setPushBack(Integer pushBack) {
        this.pushBack = pushBack;
    }

    public void setTeeOffset1(float teeOffset1) {
        this.teeOffset1 = teeOffset1;
    }

    public void setTeeOffset2(float teeOffset2) {
        this.teeOffset2 = teeOffset2;
    }

    public void setTeeOffset3(float teeOffset3) {
        this.teeOffset3 = teeOffset3;
    }

    public void setTeeOffset4(float teeOffset4) {
        this.teeOffset4 = teeOffset4;
    }
}
