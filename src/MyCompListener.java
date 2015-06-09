import java.lang.Float;
import java.lang.Integer;
import java.lang.String;
import java.lang.System;
import Nodes.*;
import org.antlr.v4.runtime.misc.NotNull;

public class MyCompListener extends compBaseListener {

    Node currentNode;
    String current_node_string;
    Airport airport = new Airport();



    @Override
    public void enterIdent_airport_attr(@NotNull comp.Ident_airport_attrContext ctx) {
        String str = ctx.getText();
        str = str.replace("\"", "");
        str = str.split("=")[1];
        if(str.length() > 4)
            System.out.println("You can not have more than 48 characters");
        else
            airport.setIdent(str);
    }

    @Override
    public void enterLat_airport_attr(@NotNull comp.Lat_airport_attrContext ctx) {
        String str = ctx.getText();
        str = str.replace("\"", "");
        float val = Float.parseFloat(str.split("=")[1]);
        if (val > 90 || val< -90)
            System.out.println("lattitude value is out of range");
        else{
            airport.setLat(val);
        }
    }

    @Override
    public void enterLon_airport_attr(@NotNull comp.Lon_airport_attrContext ctx){
        String str = ctx.getText();
        str = str.replace("\"", "");
        float val = Float.parseFloat(str.split("=")[1]);
        if(val > 90 || val < -90)
            System.out.println("Longitude value out of range");
        else{
            airport.setLon(val);
        }
    }

    @Override
    public void enterAlt_airport_attr(@NotNull comp.Alt_airport_attrContext ctx) {
        String val = ctx.getText().replace("\"", "").split("=")[1];
        String last = val.substring(val.length()-1);
        if(last != "M" && last != "F"){
            val += "M";
        }
        airport.setAlt(val);
    }

    @Override
    public void enterMagvar_airport_attr(@NotNull comp.Magvar_airport_attrContext ctx) {
        String str = ctx.getText().replace("\"", "");
        float val = Float.parseFloat(str.split("=")[1]);
        if(val < -360 || val > 360)
            System.out.println("Magvar value is out of range");
        else
            airport.setMagvar(val);
    }

    @Override
    public void enterTest_radius_attr(@NotNull comp.Test_radius_attrContext ctx) {
        String val = ctx.getText().replace("\"", "").split("=")[1];
        String last = val.substring(val.length()-1);
        if(last.equals("M") || last.equals("F") || last.equals("N")){
            airport.setTestRadius(val);
        }else{
            System.out.println("Value introduced is not correct");
        }
    }

    @Override
    public void enterTraffic_scalar_attr(@NotNull comp.Traffic_scalar_attrContext ctx) {
        String str = ctx.getText().replace("\"", "").split("=")[1];
        float val = Float.parseFloat(str);
        if(val < 0.01 || val > 1.0)
            System.out.println("Traffic Scalar value is out of range");
        else{
            airport.setTrafficScalar(val);
        }
    }

    @Override
    public void enterRegion_attr(@NotNull comp.Region_attrContext ctx) {
        String str = ctx.getText();
        str = str.replace("\"", "");
        str = str.split("=")[1];
        if(str.length() > 48)
            System.out.println("You can not have more than 48 characters");
        else
            airport.setRegion(str);
    }

    @Override
    public void enterCountry_attr(@NotNull comp.Country_attrContext ctx) {
        String str = ctx.getText();
        str = str.replace("\"", "");
        str = str.split("=")[1];
        if(str.length() > 48)
            System.out.println("You can not have more than 48 characters");
        else
            airport.setCountry(str);
    }

    @Override
    public void exitState_attr(@NotNull comp.State_attrContext ctx) {
        String str = ctx.getText();
        str = str.replace("\"", "");
        str = str.split("=")[1];
        if(str.length() > 48)
            System.out.println("You can not have more than 48 characters");
        else
            airport.setState(str);
    }

    @Override
    public void enterCity_attr(@NotNull comp.City_attrContext ctx) {
        String str = ctx.getText();
        str = str.replace("\"", "");
        str = str.split("=")[1];
        if(str.length() > 48)
            System.out.println("You can not have more than 48 characters");
        else
            airport.setCity(str);
    }

    @Override
    public void enterName_attr(@NotNull comp.Name_attrContext ctx) {
        String str = ctx.getText();
        str = str.replace("\"", "");
        str = str.split("=")[1];
        if(str.length() > 48)
            System.out.println("You can not have more than 48 characters");
        else
            airport.setName(str);
    }
















/*
    @Override
    public void enterFreq_value(comp.Freq_valueContext ctx) {
        String str = ctx.getText();
        float val = Float.parseFloat(str);
        if(val < 108.0 || val > 136.992)
            System.out.println("Frequency value out of range");
    }
*/
    @Override
    public void enterHeading_values(comp.Heading_valuesContext ctx) {
        String str = ctx.getText();
        float val = Float.parseFloat(str);
        if(val < 0.0 || val > 360.0)
            System.out.println("Heading value out of range");
    }

    @Override
    public void enterStrobes_approachlights(comp.Strobes_approachlightsContext ctx) {
        String str = ctx.getText();
        int val = Integer.parseInt(str);
        if(val < 0 )
            System.out.println("Strobes value out of range");
    }

    @Override
    public void enterPitch_vasi(comp.Pitch_vasiContext ctx) {
        String str = ctx.getText();
        float val = Float.parseFloat(str);
        if(val < 0.0 || val > 10.0)
            System.out.println("Pitch value out of range");
    }

    @Override
    public void enterIdent_ils(comp.Ident_ilsContext ctx) {
        String str = ctx.getText();
        String val = str.split("=")[1];
        if(str.length() > 7)
            System.out.println("Ident can not have more than 5 characters");
    }

    @Override
    public void enterWidth_attr(comp.Width_attrContext ctx) {
        String str = ctx.getText();
        float val = Float.parseFloat(str.split("=")[1]);
        if(val < 0.0 || val > 360.0)
            System.out.println("width value out of range");
    }

    @Override
    public void enterWaypointregion_waypoint(comp.Waypointregion_waypointContext ctx) {
        String str = ctx.getText();
        String val = str.split("=")[1];
        if(str.length() != 4)
            System.out.println("Waypoint Region must have exactly 2 characters");
    }

    @Override
    public void enterWaypointident_waypoint(comp.Waypointident_waypointContext ctx) {
        String str = ctx.getText();
        String val = str.split("=")[1];
        if(str.length() > 7)
            System.out.println("Waypoint Ident can not have more than 5 characters");
    }

    @Override
    public void enterName_route(comp.Name_routeContext ctx) {
        String str = ctx.getText();
        String val = str.split("=")[1];
        if(str.length() > 10)
            System.out.println("Route Name can not have more than 8 characters");
    }

    @Override
    public void enterRed_helipad(comp.Red_helipadContext ctx) {
        String str = ctx.getText();
        int val = Integer.parseInt(str.split("=")[1]);
        if(val < 0 || val > 255)
            System.out.println("red value out of range");
    }

    @Override
    public void enterGreen_helipad(comp.Green_helipadContext ctx) {
        String str = ctx.getText();
        int val = Integer.parseInt(str.split("=")[1]);
        if(val < 0 || val > 255)
            System.out.println("green value out of range");
    }

    @Override
    public void enterBlue_helipad(comp.Blue_helipadContext ctx) {
        String str = ctx.getText();
        int val = Integer.parseInt(str.split("=")[1]);
        if(val < 0 || val > 255)
            System.out.println("blue value out of range");
    }

    @Override
    public void enterIndex_taxiway(comp.Index_taxiwayContext ctx) {
        String str = ctx.getText();
        int val = Integer.parseInt(str.split("=")[1]);
        if(val < 0 || val > 3999)
            System.out.println("Taxiway index value out of range");
    }

    @Override
    public void enterNumber_parking(comp.Number_parkingContext ctx) {
        String str = ctx.getText();
        int val = Integer.parseInt(str.split("=")[1]);
        if(val < 0 || val > 3999)
            System.out.println("Taxiway number value out of range");
    }

    @Override
    public void enterTeeoffset1_parking(comp.Teeoffset1_parkingContext ctx) {
        String str = ctx.getText();
        float val = Float.parseFloat(str.split("=")[1]);
        if(val < 0.1 || val > 50.0)
            System.out.println("TeeOffset1 value out of range");
    }

    @Override
    public void enterTeeoffset2_parking(comp.Teeoffset2_parkingContext ctx) {
        String str = ctx.getText();
        float val = Float.parseFloat(str.split("=")[1]);
        if(val < 0.1 || val > 50.0)
            System.out.println("TeeOffset2 value out of range");
    }

    @Override
    public void enterTeeoffset3_parking(comp.Teeoffset3_parkingContext ctx) {
        String str = ctx.getText();
        float val = Float.parseFloat(str.split("=")[1]);
        if(val < 0.1 || val > 50.0)
            System.out.println("TeeOffset3 value out of range");
    }

    @Override
    public void enterTeeoffset4_parking(comp.Teeoffset4_parkingContext ctx) {
        String str = ctx.getText();
        float val = Float.parseFloat(str.split("=")[1]);
        if(val < 0.1 || val > 50.0)
            System.out.println("TeeOffset4 value out of range");
    }

    @Override
    public void enterIndex_taxiname(comp.Index_taxinameContext ctx) {
        String str = ctx.getText();
        int val = Integer.parseInt(str.split("=")[1]);
        if(val < 0 || val > 255)
            System.out.println("taxiname index value out of range");
    }

    @Override
    public void enterName_taxiname(comp.Name_taxinameContext ctx) {
        String str = ctx.getText();
        String val = str.split("=")[1];
        if(str.length() > 10)
            System.out.println("Taxiname Name can not have more than 8 characters");
    }

    @Override
    public void enterName_taxiwaypath(comp.Name_taxiwaypathContext ctx) {
        String str = ctx.getText();
        int val = Integer.parseInt(str.split("=")[1]);
        if(val < 0 || val > 255)
            System.out.println("Taxiname value out of range");
    }


}