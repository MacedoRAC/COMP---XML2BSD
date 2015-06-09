package Nodes;

/**
 * Created by André on 13/05/2015.
 */
public class Overrun {

    private String end;
    private String lenght;
    private String width;
    private String surface;

    public Overrun(){
        this.end = null;
        this.lenght = null;
        this.width = null;
        this.surface = null;
    }

    public void output(){
        System.out.println("===================================");
        System.out.println("========OVERRUN -> attributes======");
        System.out.println("===================================");


        if(this.end != null){
            System.out.println("End : " + this.end);
        }

        if(this.lenght != null){
            System.out.println("Lenght : " + this.lenght);
        }

        if(this.width != null){
            System.out.println("Width : " + this.width);
        }

        if(this.surface != null){
            System.out.println("Surface : " + this.surface);
        }

        System.lineSeparator();
        System.lineSeparator();
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public void setLenght(String lenght) {
        this.lenght = lenght;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public void setSurface(String surface) {
        this.surface = surface;
    }
}
