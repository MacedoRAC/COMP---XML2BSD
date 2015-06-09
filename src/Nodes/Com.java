package Nodes;

/**
 * Created by André on 13/05/2015.
 */
public class Com {

    private float freq;
    private String type;
    private String name;

    public Com(){
        this.freq = Float.NaN;
        this.type = null;
        this.name = null;
    }

    public void output(){
        System.out.println("===================================");
        System.out.println("=========COM -> attributes=========");
        System.out.println("===================================");

        if(this.freq != Float.NaN){
            System.out.println("Frequency : " + this.freq);
        }

        if(this.type != null){
            System.out.println("Type : " + this.type);
        }

        if(this.name != null){
            System.out.println("Name : " + this.name);
        }

    }

    public void setFreq(float freq) {
        this.freq = freq;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }
}
