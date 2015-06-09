package Nodes;

/**
 * Created by André on 13/05/2015.
 */
public class TaxiwayPath {

    private String type;
    private Integer start;
    private Integer end;
    private float width;
    private float weightLimit;
    private String surface;
    private Boolean drawSurface;
    private Boolean drawDetail;
    private Boolean centerLine;
    private Boolean centerLineLighted;
    private String leftEdge;
    private Boolean leftEdgeLighted;
    private String rightEdge;
    private Boolean rightEdgeLighted;
    private String number;
    private String designator;
    private Integer name;


    public TaxiwayPath(){
        this.type = null;
        this.start = null;
        this.end = null;
        this.width = Float.NaN;
        this.weightLimit = Float.NaN;
        this.surface = null;
        this.drawSurface = null;
        this.drawDetail = null;
        this.centerLine = false;
        this.centerLineLighted = false;
        this.leftEdge = null;
        this.leftEdgeLighted = false;
        this.rightEdge = null;
        this.rightEdgeLighted = false;
        this.number = null;
        this.designator = null;
        this.name = null;
    }

    public void output(){
        System.out.println("===================================");
        System.out.println("=====TAXIWAYPATH -> attributes=====");
        System.out.println("===================================");


        if(this.type != null){
            System.out.println("Type : " + this.type);
        }

        if(this.start != Float.NaN){
            System.out.println("Start : " + this.start);
        }

        if(this.end != null){
            System.out.println("End : " + this.end);
        }

        if(this.width != Float.NaN){
            System.out.println("Width : " + this.width);
        }

        if(this.weightLimit != Float.NaN){
            System.out.println("WeightLimit : " + this.weightLimit);
        }

        if(this.centerLine != null){
            System.out.println("CenterLine : " + this.centerLine);
        }

        if(this.drawSurface != null){
            System.out.println("DrawSurface : " + this.drawSurface);
        }

        if(this.drawDetail != null){
            System.out.println("DrawDetail : " + this.drawDetail);
        }

        if(this.centerLineLighted != null){
            System.out.println("CenterLineLighted : " + this.centerLineLighted);
        }

        if(this.leftEdge != null){
            System.out.println("LeftEdge : " + this.leftEdge);
        }

        if(this.leftEdgeLighted != null){
            System.out.println("LeftEdgeLighted : " + this.leftEdgeLighted);
        }

        if(this.rightEdge != null){
            System.out.println("RightEdge : " + this.rightEdge);
        }

        if(this.rightEdgeLighted != null){
            System.out.println("RightEdgeLighted : " + this.rightEdgeLighted);
        }

        if(this.number != null){
            System.out.println("Number : " + this.number);
        }

        if(this.designator != null){
            System.out.println("Designator : " + this.designator);
        }

        if(this.name != null){
            System.out.println("Name : " + this.name);
        }

        System.lineSeparator();
        System.lineSeparator();
    }

    public void setType(String type) {
        this.type = type.replaceAll("^\"|\"$", "");
    }

    public void setStart(String start) {
        start = start.replaceAll("^\"|\"$", "");
        this.start = Integer.parseInt(start);

        if(this.start < 0 || this.start > 3999){
            this.start = null;
            throw new IllegalArgumentException("Start is out of bounds (values between 0 and 3999 are allowed)");
        }
    }

    public void setEnd(String end) {
        end = end.replaceAll("^\"|\"$", "");
        this.end = Integer.parseInt(end);

        if(this.end < 0 || this.end > 3999){
            this.end = null;
            throw new IllegalArgumentException("End is out of bounds (values between 0 and 3999 are allowed)");
        }
    }

    public void setWidth(String width) {
       width = width.replaceAll("^\"|\"$", "");
       this.width = Float.parseFloat(width);
    }

    public void setWeightLimit(String weightLimit) {
        weightLimit = weightLimit.replaceAll("^\"|\"$", "");
        this.weightLimit = Float.parseFloat(weightLimit);
    }

    public void setSurface(String surface) {
        this.surface = surface.replaceAll("^\"|\"$", "");
    }

    public void setDrawSurface(String drawSurface) {
        drawSurface = drawSurface.replaceAll("^\"|\"$", "");

        if(drawSurface == "TRUE" || drawSurface == "YES")
            this.drawSurface = true;
        else
            this.drawSurface = false;
    }

    public void setDrawDetail(String drawDetail) {
        drawDetail = drawDetail.replaceAll("^\"|\"$", "");

        if(drawDetail == "TRUE" || drawDetail == "YES")
            this.drawDetail = true;
        else
            this.drawDetail = false;
    }

    public void setCenterLine(String centerLine) {
        centerLine = centerLine.replaceAll("^\"|\"$", "");

        if(centerLine == "TRUE" || centerLine == "YES")
            this.centerLine = true;
        else
            this.centerLine = false;
    }

    public void setCenterLineLighted(String centerLineLighted) {
        centerLineLighted = centerLineLighted.replaceAll("^\"|\"$", "");

        if(centerLineLighted == "TRUE" || centerLineLighted == "YES")
            this.centerLineLighted = true;
        else
            this.centerLineLighted = false;
    }

    public void setLeftEdge(String leftEdge) {
        this.leftEdge = leftEdge.replaceAll("^\"|\"$", "");
    }

    public void setLeftEdgeLighted(String leftEdgeLighted) {
        leftEdgeLighted = leftEdgeLighted.replaceAll("^\"|\"$", "");

        if(leftEdgeLighted == "TRUE" || leftEdgeLighted == "YES")
            this.leftEdgeLighted = true;
        else
            this.leftEdgeLighted = false;
    }

    public void setRightEdge(String rightEdge) {
        this.rightEdge = rightEdge.replaceAll("^\"|\"$", "");
    }

    public void setRightEdgeLighted(String rightEdgeLighted) {
        rightEdgeLighted = rightEdgeLighted.replaceAll("^\"|\"$", "");

        if(rightEdgeLighted == "TRUE" || rightEdgeLighted == "YES")
            this.rightEdgeLighted = true;
        else
            this.rightEdgeLighted = false;
    }

    public void setNumber(String number) {
        this.number = number.replaceAll("^\"|\"$", "");
    }

    public void setDesignator(String designator) {
        this.designator = designator.replaceAll("^\"|\"$", "");
    }

    public void setName(String name) {
        name = name.replaceAll("^\"|\"$", "");
        this.name = Integer.parseInt(name);

        if(this.name < 0 || this.name > 255){
            this.name = null;
            throw new IllegalArgumentException("Name is out of bounds (values between 0 and 255 are allowed)");
        }
    }
}
