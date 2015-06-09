package Nodes;

/**
 * Created by André on 13/05/2015.
 */
public class Markings {

    private Boolean alternateThreshold;
    private Boolean alternateTouchdown;
    private Boolean alternateFixedDistance;
    private Boolean alternatePrecision;
    private Boolean leadingZeroIdent;
    private Boolean noThresholdEndArrwos;
    private Boolean edges;
    private Boolean threshold;
    private Boolean fixed;
    private Boolean touchdown;
    private Boolean dashes;
    private Boolean ident;
    private Boolean precision;
    private Boolean edgePavement;
    private Boolean singleEnd;
    private Boolean primaryClosed;
    private Boolean secondaryClosed;
    private Boolean primaryStol;
    private Boolean secondaryStol;

    public Markings(){
        this.alternateThreshold = null;
        this.alternateTouchdown = null;
        this.alternateFixedDistance = null;
        this.alternatePrecision = null;
        this.leadingZeroIdent = null;
        this.noThresholdEndArrwos = null;
        this.edges = null;
        this.threshold = null;
        this.fixed = null;
        this.touchdown = null;
        this.dashes = null;
        this.ident = null;
        this.precision = null;
        this.edgePavement = null;
        this.singleEnd = null;
        this.primaryClosed = null;
        this.secondaryClosed = null;
        this.primaryStol = null;
        this.secondaryStol = null;
    }

    public void output(){

        System.out.println("===================================");
        System.out.println("=======AIRPORT -> attributes=======");
        System.out.println("===================================");

        if(this.alternateThreshold != null){
            System.out.println("AlternateThreshold : " + this.alternateThreshold);
        }

        if(this.alternateTouchdown != null){
            System.out.println("AlternateTouchdown : " + this.alternateTouchdown);
        }

        if(this.alternateFixedDistance != null){
            System.out.println("AlternateFixedDistance : " + this.alternateFixedDistance);
        }

        if(this.alternatePrecision != null){
            System.out.println("AlternatePrecision : " + this.alternatePrecision);
        }

        if(this.leadingZeroIdent != null){
            System.out.println("LeadingZeroIdent : " + this.leadingZeroIdent);
        }

        if(this.noThresholdEndArrwos != null){
            System.out.println("NoThresholdEndArrwos : " + this.noThresholdEndArrwos);
        }

        if(this.edges != null){
            System.out.println("Edges : " + this.edges);
        }

        if(this.threshold != null){
            System.out.println("Threshold : " + this.threshold);
        }

        if(this.fixed != null){
            System.out.println("Fixed : " + this.fixed);
        }

        if(this.touchdown != null){
            System.out.println("Touchdown : " + this.touchdown);
        }

        if(this.dashes != null){
            System.out.println("Dashes : " + this.dashes);
        }

        if(this.ident != null){
            System.out.println("Ident : " + this.ident);
        }

        if(this.precision != null){
            System.out.println("Precision : " + this.precision);
        }

        if(this.edgePavement != null){
            System.out.println("EdgePavement : " + this.edgePavement);
        }

        if(this.singleEnd != null){
            System.out.println("SingleEnd : " + this.singleEnd);
        }

        if(this.primaryClosed != null){
            System.out.println("PrimaryClosed : " + this.primaryClosed);
        }

        if(this.secondaryClosed != null){
            System.out.println("SecondaryClosed : " + this.secondaryClosed);
        }

        if(this.primaryStol != null){
            System.out.println("PrimaryStol : " + this.primaryStol);
        }

        if(this.secondaryStol != null){
            System.out.println("SecondaryStol : " + this.secondaryStol);
        }

        System.lineSeparator();
        System.lineSeparator();
    }

    public void setAlternateThreshold(Boolean alternateThreshold) {
        this.alternateThreshold = alternateThreshold;
    }

    public void setAlternateTouchdown(Boolean alternateTouchdown) {
        this.alternateTouchdown = alternateTouchdown;
    }

    public void setAlternateFixedDistance(Boolean alternateFixedDistance) {
        this.alternateFixedDistance = alternateFixedDistance;
    }

    public void setAlternatePrecision(Boolean alternatePrecision) {
        this.alternatePrecision = alternatePrecision;
    }

    public void setLeadingZeroIdent(Boolean leadingZeroIdent) {
        this.leadingZeroIdent = leadingZeroIdent;
    }

    public void setNoThresholdEndArrwos(Boolean noThresholdEndArrwos) {
        this.noThresholdEndArrwos = noThresholdEndArrwos;
    }

    public void setEdges(Boolean edges) {
        this.edges = edges;
    }

    public void setThreshold(Boolean threshold) {
        this.threshold = threshold;
    }

    public void setFixed(Boolean fixed) {
        this.fixed = fixed;
    }

    public void setTouchdown(Boolean touchdown) {
        this.touchdown = touchdown;
    }

    public void setDashes(Boolean dashes) {
        this.dashes = dashes;
    }

    public void setIdent(Boolean ident) {
        this.ident = ident;
    }

    public void setPrecision(Boolean precision) {
        this.precision = precision;
    }

    public void setEdgePavement(Boolean edgePavement) {
        this.edgePavement = edgePavement;
    }

    public void setSingleEnd(Boolean singleEnd) {
        this.singleEnd = singleEnd;
    }

    public void setPrimaryClosed(Boolean primaryClosed) {
        this.primaryClosed = primaryClosed;
    }

    public void setSecondaryClosed(Boolean secondaryClosed) {
        this.secondaryClosed = secondaryClosed;
    }

    public void setPrimaryStol(Boolean primaryStol) {
        this.primaryStol = primaryStol;
    }

    public void setSecondaryStol(Boolean secondaryStol) {
        this.secondaryStol = secondaryStol;
    }
}
