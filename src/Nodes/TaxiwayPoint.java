package Nodes;

/**
 * Created by André on 13/05/2015.
 */
public class TaxiwayPoint {

    private Integer index;
    private String type;
    private String orientation;
    private float lat;
    private float lon;
    private float biasX;
    private float biasZ;

    public TaxiwayPoint(){
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
        System.out.println("====TAXIWAYPOINT -> attributes=====");
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
}
