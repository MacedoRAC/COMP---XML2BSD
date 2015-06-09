package Nodes;

/**
 * Created by André on 13/05/2015.
 */
public class VisualModel {

    private float heading;
    private String imageComplexity;
    private String name;
    private String instanceID;

    public VisualModel(){
        this.heading = Float.NaN;
        this.imageComplexity = null;
        this.name = null;
        this.instanceID = null;
    }

    public void output(){
        System.out.println("===================================");
        System.out.println("=====VISUAL MODEL -> attributes====");
        System.out.println("===================================");


        if(this.heading != Float.NaN){
            System.out.println("Heading : " + this.heading);
        }

        if(this.imageComplexity != null){
            System.out.println("ImageComplexity : " + this.imageComplexity);
        }

        if(this.name != null){
            System.out.println("Name : " + this.name);
        }

        if(this.heading != Float.NaN){
            System.out.println("Heading : " + this.heading);
        }

        if(this.instanceID != null){
            System.out.println("InstanceID : " + this.instanceID);
        }


        System.lineSeparator();
        System.lineSeparator();

    }

    public void setHeading(float heading) {
        this.heading = heading;
    }

    public void setImageComplexity(String imageComplexity) {
        this.imageComplexity = imageComplexity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInstanceID(String instanceID) {
        this.instanceID = instanceID;
    }
}
