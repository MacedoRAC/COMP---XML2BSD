import java.lang.Float;
import java.lang.Integer;
import java.lang.String;
import java.lang.System;

import Nodes.*;

import java.util.HashMap;
import java.util.Map;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

public class MyCompListener extends compBaseListener {
	String floatnumber = "[+-]?[0-9]+(\\.[0-9]+)?";
	String ident = "[A-Za-z]{0,5}";
	String heading = "0*([0-2]?[0-9]?[0-9]|3[0-5][0-9]|360)(\\.[0-9]+)?";
	String range = "[0-9]+[FMN]";
	String string = "[a-zA-Z0-9]";
	String trafficScallar = "[0-9]+[FMN]";
	String unsigned_int = "[0-9]*";
	String altitude_value = "[+-]?[0-9]+(\\.[0-9]+)?[FM]?";
	String string8 = "[A-Za-z0-9]{0,8}";

	Integer airportCounter =0;

	Integer  fuelCounter =0;
	Integer  towerCounter=0;
	Integer  runwayCounter=0;
	Integer  markingsCounter=0;
	Integer  lightsCounter=0;
	Integer  offsetThresholdCounter=0;
	Integer  approachLightsCounter=0;
	Integer  vasiCounter=0;
	Integer  ilsCounter=0;
	Integer  glideSlopeCounter=0;
	Integer  runwayStartCounter=0;
	Integer  blastPadCounter=0;
	Integer  overrunCounter=0;
	Integer  taxiwayPointCounter=0;
	Integer  taxiwayParkingCounter=0;
	Integer  taxiNameCounter=0;
	Integer  taxiwayPathCounter=0;
	Integer visualModelCounter = 0;
	Integer vertexCounter = 0;
	Integer servicesCounter = 0;
	private Integer runwayAliasCounter =0;
	private Integer helipadCounter =0;
	private Integer dmeCounter = 0;


	String receivingAttributs = ""; //serve para saber a que atributo se vai adicionar o name

	Map<String,Map<String,String>> airportAttributs = new HashMap<String,Map<String,String>>(); 

	Map<String,Map<String,String>> ilsAttributs = new HashMap<String,Map<String,String>>();
	Map<String,Map<String,String>> visualModelAttributs = new HashMap<String,Map<String,String>>();
	Map<String,Map<String,String>> vertexAttributs = new HashMap<String,Map<String,String>>();
	Map<String,Map<String,String>> towerAttributs = new HashMap<String,Map<String,String>>();
	Map<String,Map<String,String>> runwayAttributs = new HashMap<String,Map<String,String>>();
	Map<String,Map<String,String>> runwayAliasAttributs = new HashMap<String,Map<String,String>>();
	Map<String,Map<String,String>> helipadAttributs = new HashMap<String,Map<String,String>>();
	Map<String,Map<String,String>> runway_startAttributs = new HashMap<String,Map<String,String>>();
	Map<String,Map<String,String>> taxiwayPointAttributs = new HashMap<String,Map<String,String>>();
	Map<String,Map<String,String>> taxiwayParkingAttributs = new HashMap<String,Map<String,String>>();
	Map<String,Map<String,String>> taxiwayNameAttributs = new HashMap<String,Map<String,String>>();
	Map<String,Map<String,String>> taxiwayPathAttributs = new HashMap<String,Map<String,String>>();
	Map<String,Map<String,String>> markingsAttributs = new HashMap<String,Map<String,String>>();
	Map<String,Map<String,String>> lightsAttributs = new HashMap<String,Map<String,String>>();
	Map<String,Map<String,String>> offsetThresholdAttributs = new HashMap<String,Map<String,String>>();
	Map<String,Map<String,String>> blastPadAttributs = new HashMap<String,Map<String,String>>();
	Map<String,Map<String,String>> overrunAttributs = new HashMap<String,Map<String,String>>();
	Map<String,Map<String,String>> approachLightsAttributs = new HashMap<String,Map<String,String>>();
	Map<String,Map<String,String>> vasiAttributs = new HashMap<String,Map<String,String>>();
	Map<String,Map<String,String>> glide_scopeAttributs = new HashMap<String,Map<String,String>>();
	Map<String,Map<String,String>> dmeAttributs = new HashMap<String,Map<String,String>>();
	Map<String,Map<String,String>> fuelAttributs = new HashMap<String,Map<String,String>>();

	Map<String,String> airportElements = new HashMap<String,String>();
	Map<String,String> runwayElements = new HashMap<String,String>();
	private Map<String,String>  ilsElements = new HashMap<String,String>();
	private Map<String, String> servicesElements = new HashMap<String,String>();
	
	
	
	
	@Override public void enterDesignator_attr(@NotNull comp.Designator_attrContext ctx) {
		String str = ctx.getText();
		String val = protectedSplit(str); if(isNull(val)) System.out.println("Error: enterDesignator value not expected! Val was: " + val);else
			if (!val.equals("NONE" )&& !val.equals("C") && !val.equals("CENTER") && !val.equals("L") && !val.equals("LEFT" )&& !val.equals("R") && !val.equals("RIGHT" )&& !val.equals("W" )&& !val.equals("WATER") && !val.equals("A") && !val.equals("B"))
				System.out.println("Error: Designator value not expected! Got " + val);
			else
				addAttribute(str.split("=")[0], str.split("=")[1].split("\"")[1]);
	}

	
	@Override public void exitDesignator_attr(@NotNull comp.Designator_attrContext ctx) { }


	@Override public void enterIls_attr(@NotNull comp.Ils_attrContext ctx) { }


	@Override public void exitIls_attr(@NotNull comp.Ils_attrContext ctx) { }


	@Override public void enterLength_attr(@NotNull comp.Length_attrContext ctx) {
		String str = ctx.getText();
		String val = protectedSplit(str); if(isNull(val)) System.out.println("Error: enterLength value not expected! Val was: " + val);else
			if (!val.matches(altitude_value))
				System.out.println("Error: Length value not expected! Got " + val);
			else
				addAttribute(str.split("=")[0], str.split("=")[1].split("\"")[1]);
	}


	@Override public void exitLength_attr(@NotNull comp.Length_attrContext ctx) { }


	@Override public void enterEnd_attr(@NotNull comp.End_attrContext ctx) {
		String str = ctx.getText();
		String val = protectedSplit(str); if(isNull(val)) System.out.println("Error: enterEnd value not expected! Val was: " + val);else
			if (!val.equals("PRIMARY") && !val.equals("SECONDARY"))
				System.out.println("Error: End value not expected! Got " + val);
			else
				addAttribute(str.split("=")[0], str.split("=")[1].split("\"")[1]);
	}


	@Override public void exitEnd_attr(@NotNull comp.End_attrContext ctx) { }


	@Override public void enterLights_edge(@NotNull comp.Lights_edgeContext ctx) {
		String str = ctx.getText();
		String val = protectedSplit(str); if(isNull(val)) System.out.println("Error: enterEdge value not expected! Val was: " + val);else
			if (!val.equals("NONE") && !val.equals("LOW") && !val.equals("MEDIUM") && !val.equals("HIGH"))
				System.out.println("Error: Edge value not expected! Got " + val);
			else
				addAttribute(str.split("=")[0], str.split("=")[1].split("\"")[1]);
	}


	@Override public void exitLights_edge(@NotNull comp.Lights_edgeContext ctx) { }


	@Override public void enterLat_attr(@NotNull comp.Lat_attrContext ctx) {
		String str = ctx.getText();
		Double val = Double.parseDouble(str.split("=")[1].split("\"")[1]);
		if (val >= 90 || val <= -90)
			System.out.println("Error: lattitude value not expected! Got " + val);
		else
			addAttribute(str.split("=")[0], str.split("=")[1].split("\"")[1]);
	}


	@Override public void exitLat_attr(@NotNull comp.Lat_attrContext ctx) { }


	@Override public void enterServices_node(@NotNull comp.Services_nodeContext ctx) {
		servicesCounter++;
	}


	@Override public void exitServices_node(@NotNull comp.Services_nodeContext ctx) {
		airportElements.put("Services"+servicesCounter.toString(), "Airport"+airportCounter.toString());
	}


	@Override public void enterRoute_nodes(@NotNull comp.Route_nodesContext ctx) { }


	@Override public void exitRoute_nodes(@NotNull comp.Route_nodesContext ctx) { }


	@Override public void enterAlt_attr(@NotNull comp.Alt_attrContext ctx) {
		String str = ctx.getText();
		String val = protectedSplit(str); if(isNull(val)) System.out.println("Error: enterAltitude value not expected! Val was: " + val);else
			if (!val.matches(altitude_value))
				System.out.println("Error: Altitude value not expected! Val was: " + val);
			else
				addAttribute(str.split("=")[0], str.split("=")[1].split("\"")[1]);
	}


	@Override public void exitAlt_attr(@NotNull comp.Alt_attrContext ctx) { }


	@Override public void enterRoutetype(@NotNull comp.RoutetypeContext ctx) { }


	@Override public void exitRoutetype(@NotNull comp.RoutetypeContext ctx) { }


	@Override public void enterIndex_taxiway(@NotNull comp.Index_taxiwayContext ctx) {
		String str = ctx.getText();
		System.out.println(str);
		try
		{
			Integer val = Integer.parseInt(str.split("=")[1].split("\"")[1]);
			if (val > 3999 || val < 0)
				System.out.println("Error: Index value not expected! Got " + val);
			else
				addAttribute(str.split("=")[0], str.split("=")[1].split("\"")[1]);

		}
		catch (Exception e)
		{
			System.out.println("Error: Index value not expected! Got "+str);
		}
	}


	@Override public void exitIndex_taxiway(@NotNull comp.Index_taxiwayContext ctx) {
		String str = ctx.getText();
		System.out.println(str);
		try
		{
			int val = Integer.parseInt(str.split("=")[1].split("\"")[1]);
			if (val > 3999 || val < 0)
				System.out.println("Error: Index value not expected! Got " + val);
			else
				addAttribute(str.split("=")[0], str.split("=")[1].split("\"")[1]);

		}
		catch (Exception e)
		{
			System.out.println("Error: Index value not expected! Got "+str);
		}
	}


	@Override public void enterTower_node(@NotNull comp.Tower_nodeContext ctx) {
		receivingAttributs = "Tower";
		towerCounter++;
	}

	@Override public void exitTower_node(@NotNull comp.Tower_nodeContext ctx) {
		airportElements.put("Tower"+towerCounter.toString(), "Airport"+airportCounter.toString());
	}


	@Override public void enterLights_centerred(@NotNull comp.Lights_centerredContext ctx) {
		String str = ctx.getText();
		String val = protectedSplit(str); if(isNull(val)) System.out.println("Error: enterCenterRed value not expected! Val was: " + val);
		else
			if (!val.equals("TRUE") && !val.equals("FALSE"))
				System.out.println("Error: CenterRed value not expected! Val was: " + val);
			else
				addAttribute(str.split("=")[0], str.split("=")[1].split("\"")[1]);
	}


	@Override public void exitLights_centerred(@NotNull comp.Lights_centerredContext ctx) { }


	@Override public void enterHelipad_attr(@NotNull comp.Helipad_attrContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitHelipad_attr(@NotNull comp.Helipad_attrContext ctx) { }


	@Override public void enterEnd_taxiwaypath(@NotNull comp.End_taxiwaypathContext ctx) {
		String str = ctx.getText();
		try{
			Double val = Double.parseDouble(str.split("=")[1].split("\"")[1]);
			if (val >= 255 || val < 0)
				System.out.println("Error: TaxiwayPathEnd value not expected! Got " + val);
			else
				addAttribute(str.split("=")[0], str.split("=")[1].split("\"")[1]);
		}
		catch(Exception e)
		{
			System.out.println("Error: TaxiwayPathEnd value not expected! Got " + str);
		}
	}


	@Override public void exitEnd_taxiwaypath(@NotNull comp.End_taxiwaypathContext ctx) { }


	@Override public void enterSpacing_vasi(@NotNull comp.Spacing_vasiContext ctx) {
		String str = ctx.getText();
		String val = protectedSplit(str); if(isNull(val)) System.out.println("Error: enterSpacing value not expected! Val was: " + val);else
			if (!val.matches(altitude_value))
				System.out.println("Error: Spacing value not expected! Got " + val);
			else
				addAttribute(str.split("=")[0], str.split("=")[1].split("\"")[1]);
	}


	@Override public void exitSpacing_vasi(@NotNull comp.Spacing_vasiContext ctx) { }


	@Override public void enterIls_node(@NotNull comp.Ils_nodeContext ctx) { }


	@Override public void exitIls_node(@NotNull comp.Ils_nodeContext ctx) { }


	@Override public void enterTaxiwaypath_designator(@NotNull comp.Taxiwaypath_designatorContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitTaxiwaypath_designator(@NotNull comp.Taxiwaypath_designatorContext ctx) { }


	@Override public void enterSystem_approachlights(@NotNull comp.System_approachlightsContext ctx) {
		String str = ctx.getText();
		String val = protectedSplit(str); if(isNull(val)) System.out.println("Error: enterSystem value not expected! Val was: " + val);else
			if (!val.equals("NONE") && !val.equals("ALSF1") && !val.equals("ALSF2") && !val.equals("CALVERT") && !val.equals("CALVERT2") && !val.equals("MALS") && !val.equals("MALSF") && !val.equals("MALSR") && !val.equals("ODALS") && !val.equals("RAIL") && !val.equals("SALS") && !val.equals("SALSF") && !val.equals("SSALF") && !val.equals("SSALR") && !val.equals("SSALS"))
				System.out.println("Error: System value not expected! Got " + val);
			else
				addAttribute(str.split("=")[0], str.split("=")[1].split("\"")[1]);
	}


	@Override public void exitSystem_approachlights(@NotNull comp.System_approachlightsContext ctx) { }


	@Override public void enterInstanceid_visualmodel(@NotNull comp.Instanceid_visualmodelContext ctx) {
		String str = ctx.getText();
		String val = protectedSplit(str); if(isNull(val)) System.out.println("Error: enterInstanceId value not expected! Val was: " + val);else
			if(!val.matches(str) && val.length()>48){
				System.out.println("Error: Name value out of bounds! Val size must be minor then 48 but was " + val.length());
			}
			else
				addAttribute(str.split("=")[0], str.split("=")[1].split("\"")[1]);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitInstanceid_visualmodel(@NotNull comp.Instanceid_visualmodelContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterAirport_nodes(@NotNull comp.Airport_nodesContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitAirport_nodes(@NotNull comp.Airport_nodesContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterCenterlinelighted_taxiwaypath(@NotNull comp.Centerlinelighted_taxiwaypathContext ctx) {
		String str = ctx.getText();
		String val = protectedSplit(str); if(isNull(val)) System.out.println("Error: enterCenterLineLighted value not expected! Val was: " + val);else
			if (!val.equals("TRUE") && !val.equals("FALSE"))
				System.out.println("Error: CenterLineLighted value not expected! Got " + val);
			else
				addAttribute(str.split("=")[0], str.split("=")[1].split("\"")[1]);
	}


	@Override public void exitCenterlinelighted_taxiwaypath(@NotNull comp.Centerlinelighted_taxiwaypathContext ctx) { }


	@Override public void enterName_taxiwaypath(@NotNull comp.Name_taxiwaypathContext ctx) {
		String str = ctx.getText();
		String val = protectedSplit(str); if(isNull(val)) System.out.println("Error: taxiwayNameString value not expected! Val was: " + val);else
			if(!val.matches(string8))
				System.out.println("Error: taxiwayNameString Name value not expected! Got " + val);
			else
				addAttribute(str.split("=")[0], str.split("=")[1].split("\"")[1]);
	}


	@Override public void exitName_taxiwaypath(@NotNull comp.Name_taxiwaypathContext ctx) { }


	@Override public void enterBiasX(@NotNull comp.BiasXContext ctx) {
		String str = ctx.getText();
		String val = protectedSplit(str); if(isNull(val)) System.out.println("Error: enterBiasX value not expected! Val was: " + val);else
			if(!val.matches(altitude_value))
				System.out.println("Error: BiasX value not expected! Got " + val);
			else
				addAttribute(str.split("=")[0], str.split("=")[1].split("\"")[1]);
	}


	@Override public void exitBiasX(@NotNull comp.BiasXContext ctx) { }


	@Override public void enterSurface_attr(@NotNull comp.Surface_attrContext ctx) {
		String str = ctx.getText();
		String val = protectedSplit(str); if(isNull(val)) System.out.println("Error: enterSurface value not expected! Val was: " + val);else
			if (!val.equals("ASPHALT" )&& !val.equals("BITUMINOUS") && !val.equals("BRICK") && !val.equals("CLAY" )&& !val.equals("CEMENT" )&& !val.equals("CONCRETE" )&& !val.equals("CORAL") && !val.equals("DIRT") && !val.equals("GRASS" )&& !val.equals("GRAVEL") && !val.equals("ICE" )&& !val.equals("MACADAM" )&& !val.equals("OIL_TREATED" )&& !val.equals("PLANKS") && !val.equals("SAND" )&& !val.equals("SHALE") && !val.equals("SNOW" )&& !val.equals("STEEL_MATS" )&& !val.equals("TARMAC") && !val.equals("UNKNOWN") && !val.equals("WATER"))
				System.out.println("Error: Surface value not expected! Got " + val);
			else
				addAttribute(str.split("=")[0], str.split("=")[1].split("\"")[1]);
	}


	@Override public void exitSurface_attr(@NotNull comp.Surface_attrContext ctx) { }


	@Override public void enterHelipad_node(@NotNull comp.Helipad_nodeContext ctx) {
		helipadCounter++;
		receivingAttributs = "Helipad";
		String str = ctx.getText();
		String val = protectedSplit(str); if(isNull(val)) System.out.println("Error: enterHelipad value not expected! Val was: " + val);else
			if (!val.matches(altitude_value))
				System.out.println("Error: Helipad value not expected! Got " + val);
			else
				addAttribute(str.split("=")[0], str.split("=")[1].split("\"")[1]);
	}


	@Override public void exitHelipad_node(@NotNull comp.Helipad_nodeContext ctx) {
		airportElements.put("Helipad"+helipadCounter.toString(), "Airport"+airportCounter.toString());
	}


	@Override public void enterReil_approachlights(@NotNull comp.Reil_approachlightsContext ctx) { }


	@Override public void exitReil_approachlights(@NotNull comp.Reil_approachlightsContext ctx) { }


	@Override public void enterPrevious_attr(@NotNull comp.Previous_attrContext ctx) { }


	@Override public void exitPrevious_attr(@NotNull comp.Previous_attrContext ctx) { }


	@Override public void enterNext_attr(@NotNull comp.Next_attrContext ctx) { }


	@Override public void exitNext_attr(@NotNull comp.Next_attrContext ctx) { }


	@Override public void enterTeeoffset4_parking(@NotNull comp.Teeoffset4_parkingContext ctx) {
		String str = ctx.getText();
		Double val = Double.parseDouble(str.split("=")[1].split("\"")[1]);
		if (val < 0.1 || val > 50.0)
			System.out.println("Error: TeeOffSet4 value not expected! Got " + val);
		else
			addAttribute(str.split("=")[0], str.split("=")[1].split("\"")[1]);
	}


	@Override public void exitTeeoffset4_parking(@NotNull comp.Teeoffset4_parkingContext ctx) { }


	@Override public void enterLeftedge_taxiwaypath(@NotNull comp.Leftedge_taxiwaypathContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitLeftedge_taxiwaypath(@NotNull comp.Leftedge_taxiwaypathContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterRunwaystart_attr(@NotNull comp.Runwaystart_attrContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitRunwaystart_attr(@NotNull comp.Runwaystart_attrContext ctx) { }


	@Override public void enterMarkings_node(@NotNull comp.Markings_nodeContext ctx) {
		markingsCounter++;
		receivingAttributs = "Markings";
	}


	@Override public void exitMarkings_node(@NotNull comp.Markings_nodeContext ctx) {
		runwayElements.put("Markings"+markingsCounter.toString(), "Runway"+runwayCounter.toString());
	}


	@Override public void enterTaxiwaypath_number(@NotNull comp.Taxiwaypath_numberContext ctx) {
		String str = ctx.getText();
		int num;
		String val = protectedSplit(str); if(isNull(val)) System.out.println("Error: enterTaxiwayPathNumber value not expected! Val was: " + val);
		else
			if (!val.equals("EAST") && !val.equals("NORTH") && !val.equals("NORTHEAST") && !val.equals("NORTHWEST") && !val.equals("SOUTH" )&& !val.equals("SOUTHEAST") && !val.equals("SOUTHWEST" )&& !val.equals("WEST"))
			{
				if(val.length() < 3)
				{
					num = Integer.parseInt(val);
					if(num < 0 || num > 36 )
						System.out.println("Error: TaxiwayPathNumber value not expected! Got " + val);
					else
						addAttribute(str.split("=")[0], str.split("=")[1].split("\"")[1]);
				}
				else
					System.out.println("Error: TaxiwayPathNumber value not expected! Got " + val);
			}
	}


	@Override public void exitTaxiwaypath_number(@NotNull comp.Taxiwaypath_numberContext ctx) { }


	@Override public void enterTaxiname_attr(@NotNull comp.Taxiname_attrContext ctx) { }


	@Override public void exitTaxiname_attr(@NotNull comp.Taxiname_attrContext ctx) { }


	@Override public void enterNext_node(@NotNull comp.Next_nodeContext ctx) { }


	@Override public void exitNext_node(@NotNull comp.Next_nodeContext ctx) { }


	@Override public void enterVertex_attr(@NotNull comp.Vertex_attrContext ctx) { }


	@Override public void exitVertex_attr(@NotNull comp.Vertex_attrContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterName_ils(@NotNull comp.Name_ilsContext ctx) {
		String str = ctx.getText();
		String val = protectedSplit(str); if(isNull(val)) val="";else
			if(!val.matches(str) && val.length()>48)
				System.out.println("Error: Name value out of bounds! Val size must be minor then 48 but was " + val.length());
			else
				addAttribute(str.split("=")[0], str.split("=")[1].split("\"")[1]);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitName_ils(@NotNull comp.Name_ilsContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterWaypoint_node(@NotNull comp.Waypoint_nodeContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitWaypoint_node(@NotNull comp.Waypoint_nodeContext ctx) { }


	@Override public void enterAltitudeMinimum_attr(@NotNull comp.AltitudeMinimum_attrContext ctx) {
		String str = ctx.getText();
		String val = protectedSplit(str); if(isNull(val)) System.out.println("Error: enterPatternAltitude value not expected! Val was: " + val);else
			if (!val.matches(altitude_value) )
				System.out.println("Error: PatternAltitude value not expected! Got " + val);
			else
				addAttribute(str.split("=")[0], str.split("=")[1].split("\"")[1]);
	}


	@Override public void exitAltitudeMinimum_attr(@NotNull comp.AltitudeMinimum_attrContext ctx) { }


	@Override public void enterRed_helipad(@NotNull comp.Red_helipadContext ctx) {
		String str = ctx.getText();
		int val = Integer.parseInt(str.split("=")[1].split("\"")[1]);
		if(val < 0 || val > 255)
			System.out.println("Error: Red value out of bounds! Expected [0,255] but got " + val);
		else
		{
			addAttribute(str.split("=")[0], str.split("=")[1].split("\"")[1]);
		}
	}


	@Override public void exitRed_helipad(@NotNull comp.Red_helipadContext ctx) { }


	@Override public void enterCity_attr(@NotNull comp.City_attrContext ctx) {
		String str = ctx.getText();
		String val = protectedSplit(str); if(isNull(val)) System.out.println("Error: enterCity value not expected! Val was: " + val);else
			if(!val.matches(string) && val.length()>48)
				System.out.println("Error: City value out of bounds! Val size must be minor then 48 but was " + val.length());
			else
				addAttribute(str.split("=")[0], str.split("=")[1].split("\"")[1]);
	}


	@Override public void exitCity_attr(@NotNull comp.City_attrContext ctx) { }


	@Override public void enterEndlights_approachlights(@NotNull comp.Endlights_approachlightsContext ctx) { }


	@Override public void exitEndlights_approachlights(@NotNull comp.Endlights_approachlightsContext ctx) { }


	@Override public void enterGlideslope_node(@NotNull comp.Glideslope_nodeContext ctx) {
		receivingAttributs = "Glide_slope";
		glideSlopeCounter++;
	}


	@Override public void exitGlideslope_node(@NotNull comp.Glideslope_nodeContext ctx) {
		ilsElements.put("Glide_slope"+glideSlopeCounter.toString(), "Ils"+ilsCounter.toString());
	}


	@Override public void enterRunwaystart_node(@NotNull comp.Runwaystart_nodeContext ctx) {
		runwayStartCounter++;
		String str = ctx.getText();
		String val = protectedSplit(str); if(isNull(val)) System.out.println("Error: enterRunway_start value not expected! Val was: " + val);else
			if (!val.equals("RUNWAY"))
				System.out.println("Error: Runway_start value not expected! Got " + val);
			else
				addAttribute(str.split("=")[0], str.split("=")[1].split("\"")[1]);
	}


	@Override public void exitRunwaystart_node(@NotNull comp.Runwaystart_nodeContext ctx) {
		airportElements.put("Runway_start"+runwayStartCounter.toString(), "Airport"+airportCounter.toString());
	}

	@Override public void enterPrevious_node(@NotNull comp.Previous_nodeContext ctx) { }

	
	@Override public void exitPrevious_node(@NotNull comp.Previous_nodeContext ctx) { }


	@Override public void enterVertex_node(@NotNull comp.Vertex_nodeContext ctx) {
		receivingAttributs = "Vertex";
		vertexCounter++;
	}


	@Override public void exitVertex_node(@NotNull comp.Vertex_nodeContext ctx) { }


	@Override public void enterTaxiname_node(@NotNull comp.Taxiname_nodeContext ctx) {
		taxiNameCounter++;
		receivingAttributs = "TaxiwayName";
	}

	
	@Override public void exitTaxiname_node(@NotNull comp.Taxiname_nodeContext ctx) { 
		airportElements.put("TaxiwayName"+taxiNameCounter.toString(), "Airport"+airportCounter.toString());
	}


	@Override public void enterMarkings_attributes(@NotNull comp.Markings_attributesContext ctx) { }


	@Override public void exitMarkings_attributes(@NotNull comp.Markings_attributesContext ctx) { }


	@Override public void enterLeftedgelighted_taxiwaypath(@NotNull comp.Leftedgelighted_taxiwaypathContext ctx) {
		String str = ctx.getText();
		String val = protectedSplit(str); if(isNull(val)) val = "FALSE";
		if (!val.equals("TRUE") && !val.equals("FALSE"))
			System.out.println("Error: LeftEdgeLighted value not expected! Got " + val);
		else
			addAttribute(str.split("=")[0], str.split("=")[1].split("\"")[1]);
	}


	@Override public void exitLeftedgelighted_taxiwaypath(@NotNull comp.Leftedgelighted_taxiwaypathContext ctx) { }


	@Override public void enterCom_node(@NotNull comp.Com_nodeContext ctx) { }


	@Override public void exitCom_node(@NotNull comp.Com_nodeContext ctx) { }


	@Override public void enterBiasY(@NotNull comp.BiasYContext ctx) {
		String str = ctx.getText();
		String val = protectedSplit(str); if(isNull(val)) System.out.println("Error: enterBiasY value not expected! Val was: " + val);else
			if(!val.matches(altitude_value))
				System.out.println("Error: BiasY value not expected! Got " + val);
			else
				addAttribute(str.split("=")[0], str.split("=")[1].split("\"")[1]);
	}


	@Override public void exitBiasY(@NotNull comp.BiasYContext ctx) { }


	@Override public void enterBiasZ(@NotNull comp.BiasZContext ctx) {
		String str = ctx.getText();
		String val = protectedSplit(str); if(isNull(val)) System.out.println("Error: enterBiasZ value not expected! Val was: " + val);else
			if(!val.matches(altitude_value))
				System.out.println("Error: Biaz value not expected! Got " + val);
			else
				addAttribute(str.split("=")[0], str.split("=")[1].split("\"")[1]);
	}


	@Override public void exitBiasZ(@NotNull comp.BiasZContext ctx) { }


	@Override public void enterType_helipad(@NotNull comp.Type_helipadContext ctx) { }

	
	@Override public void exitType_helipad(@NotNull comp.Type_helipadContext ctx) { }


	@Override public void enterAirlinecodes_parking(@NotNull comp.Airlinecodes_parkingContext ctx) { }


	@Override public void exitAirlinecodes_parking(@NotNull comp.Airlinecodes_parkingContext ctx) { }


	@Override public void enterGlideslope_attr(@NotNull comp.Glideslope_attrContext ctx) { }


	@Override public void exitGlideslope_attr(@NotNull comp.Glideslope_attrContext ctx) { }


	@Override public void enterRoute_node(@NotNull comp.Route_nodeContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitRoute_node(@NotNull comp.Route_nodeContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterName_route(@NotNull comp.Name_routeContext ctx) {
		String str = ctx.getText();
		String val = protectedSplit(str); if(isNull(val)) val="";else
			if(!val.matches(str) && val.length()>48)
				System.out.println("Error: Name value out of bounds! Val size must be minor then 48 but was " + val.length());
			else
				addAttribute(str.split("=")[0], str.split("=")[1].split("\"")[1]);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitName_route(@NotNull comp.Name_routeContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterClosed_helipad(@NotNull comp.Closed_helipadContext ctx) {
		String str = ctx.getText();
		String val = protectedSplit(str); if(isNull(val)) System.out.println("Error: enterPrimaryClosed value not expected! Val was: " + val);else
			if (!val.equals("TRUE") && !val.equals("FALSE"))
				System.out.println("Error: PrimaryClosed value not expected! Val was: " + val);
			else
				addAttribute(str.split("=")[0], str.split("=")[1].split("\"")[1]);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitClosed_helipad(@NotNull comp.Closed_helipadContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterEnd_runwaynode(@NotNull comp.End_runwaynodeContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitEnd_runwaynode(@NotNull comp.End_runwaynodeContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterTower_attributes(@NotNull comp.Tower_attributesContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitTower_attributes(@NotNull comp.Tower_attributesContext ctx) { }


	@Override public void enterMagvar_airport_attr(@NotNull comp.Magvar_airport_attrContext ctx) {
		String str = ctx.getText();
		Double val = Double.parseDouble(str.split("=")[1].split("\"")[1]);
		if (val >= 360 || val <= -360)
			System.out.println("Error: Magvar value not expected! Got " + val);
		else
			addAttribute(str.split("=")[0], str.split("=")[1].split("\"")[1]);
	}


	@Override public void exitMagvar_airport_attr(@NotNull comp.Magvar_airport_attrContext ctx) { }


	@Override public void enterWidth_helipad(@NotNull comp.Width_helipadContext ctx) {
		String str = ctx.getText();
		String val = protectedSplit(str); if(isNull(val)) System.out.println("Error: enterWidth value not expected! Val was: " + val);else
			if(!val.matches(altitude_value))
				System.out.println("Error: width value not expected! Got " + val);
			else
				addAttribute(str.split("=")[0], str.split("=")[1].split("\"")[1]);
	}


	@Override public void exitWidth_helipad(@NotNull comp.Width_helipadContext ctx) { }


	@Override public void enterTest_radius_attr(@NotNull comp.Test_radius_attrContext ctx) {
		String str = ctx.getText();
		String val = protectedSplit(str); if(isNull(val)) System.out.println("Error: enterAirportTestRadius value not expected! Val was: " + val);else
			if (!val.matches(altitude_value))
				System.out.println("Error: AirportTestRadius value not expected! Val was: " + val);
			else
				addAttribute(str.split("=")[0], str.split("=")[1].split("\"")[1]);
	}


	@Override public void exitTest_radius_attr(@NotNull comp.Test_radius_attrContext ctx) { }


	@Override public void enterHeading_attr(@NotNull comp.Heading_attrContext ctx) {
		String str = ctx.getText();
		try
		{

			String val = protectedSplit(str); if(isNull(val)) System.out.println("Error: enterHeading value not expected! Val was: " + val);else
				if(!val.matches(heading))
					System.out.println("Error: Heading value not expected! Got " + val);
				else
					addAttribute(str.split("=")[0], str.split("=")[1].split("\"")[1]);
		}
		catch(Exception e)
		{
			System.out.println("Error: Heading value not expected! Got " + str);
		}
	}


	@Override public void exitHeading_attr(@NotNull comp.Heading_attrContext ctx) { }


	@Override public void enterVisualmodel_node(@NotNull comp.Visualmodel_nodeContext ctx) {
		visualModelCounter++;
		receivingAttributs = "Visual_model";
	}


	@Override public void exitVisualmodel_node(@NotNull comp.Visualmodel_nodeContext ctx) {
		ilsElements.put("Visual_model"+visualModelCounter.toString(), "Ils"+ilsCounter.toString());
	}


	@Override public void enterApproachlights_attr(@NotNull comp.Approachlights_attrContext ctx) { }


	@Override public void exitApproachlights_attr(@NotNull comp.Approachlights_attrContext ctx) { }


	@Override public void enterLights_node(@NotNull comp.Lights_nodeContext ctx) {
		lightsCounter++;
		receivingAttributs = "Lights";
	}


	@Override public void exitLights_node(@NotNull comp.Lights_nodeContext ctx) {
		runwayElements.put("Lights"+lightsCounter.toString(), "Runway"+runwayCounter.toString());
	}


	@Override public void enterOverrun_attr(@NotNull comp.Overrun_attrContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitOverrun_attr(@NotNull comp.Overrun_attrContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterRoute_attr(@NotNull comp.Route_attrContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitRoute_attr(@NotNull comp.Route_attrContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterAttributes(@NotNull comp.AttributesContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitAttributes(@NotNull comp.AttributesContext ctx) { }


	@Override public void enterRadius_taxiway(@NotNull comp.Radius_taxiwayContext ctx) {
		String str = ctx.getText();
		String val = protectedSplit(str); if(isNull(val)) System.out.println("Error: enterRadius value not expected! Val was: " + val);else
			if (!val.matches(altitude_value))
				System.out.println("Error: Radius value not expected! Val was: " + val);
			else
				addAttribute(str.split("=")[0], str.split("=")[1].split("\"")[1]);
	}


	@Override public void exitRadius_taxiway(@NotNull comp.Radius_taxiwayContext ctx) { }


	@Override public void enterApproachlights_node(@NotNull comp.Approachlights_nodeContext ctx) {
		approachLightsCounter++;
		receivingAttributs = "ApproachLights";
	}


	@Override public void exitApproachlights_node(@NotNull comp.Approachlights_nodeContext ctx) { 
		runwayElements.put("ApproachLights"+approachLightsCounter.toString(), "Runway"+runwayCounter.toString());
	}


	@Override public void enterRunway_node(@NotNull comp.Runway_nodeContext ctx) {
		runwayCounter++;
	}


	@Override public void exitRunway_node(@NotNull comp.Runway_nodeContext ctx) {
		airportElements.put("Runway"+runwayCounter.toString(), "Airport"+airportCounter.toString());
	}


	@Override public void enterVisualmodel_attr(@NotNull comp.Visualmodel_attrContext ctx) { }


	@Override public void exitVisualmodel_attr(@NotNull comp.Visualmodel_attrContext ctx) { }


	@Override public void enterTeeoffset3_parking(@NotNull comp.Teeoffset3_parkingContext ctx) {
		String str = ctx.getText();
		Double val = Double.parseDouble(str.split("=")[1].split("\"")[1]);
		if (val < 0.1 || val > 50.0)
			System.out.println("Error: TeeOffSet3 value not expected! Got " + val);
		else
			addAttribute(str.split("=")[0], str.split("=")[1].split("\"")[1]);
	}


	@Override public void exitTeeoffset3_parking(@NotNull comp.Teeoffset3_parkingContext ctx) { }


	@Override public void enterDrawdetail(@NotNull comp.DrawdetailContext ctx) {
		String str = ctx.getText();
		String val = protectedSplit(str); if(isNull(val)) System.out.println("Error: enterDrawDetail value not expected! Val was: " + val);else
			if (!val.equals("TRUE") && !val.equals("FALSE"))
				System.out.println("Error: DrawDetail value not expected! Got " + val);
			else
				addAttribute(str.split("=")[0], str.split("=")[1].split("\"")[1]);
	}


	@Override public void exitDrawdetail(@NotNull comp.DrawdetailContext ctx) { }


	@Override public void enterAlt_airport_attr(@NotNull comp.Alt_airport_attrContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitAlt_airport_attr(@NotNull comp.Alt_airport_attrContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterTypeOfFuel(@NotNull comp.TypeOfFuelContext ctx) {
		String str = ctx.getText();
		String val = protectedSplit(str); if(isNull(val)) System.out.println("Error: enterFuel_type value not expected! Val was: " + val);else
			if (!val.equals("73") && !val.equals("87") && !val.equals("100") && !val.equals("130") && !val.equals("145") && !val.equals("MOGAS") && !val.equals("JET") && !val.equals("JETA") && !val.equals("JETA1") && !val.equals("JETAP") && !val.equals("JETB") && !val.equals("JET4") && !val.equals("JET5") && !val.equals("UNKNOWN"))
				System.out.println("Error: Fuel_type value not expected! Got " + val);
			else
				addAttribute(str.split("=")[0], str.split("=")[1].split("\"")[1]);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitTypeOfFuel(@NotNull comp.TypeOfFuelContext ctx) { }


	@Override public void enterCenterline_taxiwaypath(@NotNull comp.Centerline_taxiwaypathContext ctx) {
		String str = ctx.getText();
		String val = protectedSplit(str); if(isNull(val)) System.out.println("Error: enterCenterLineLighted value not expected! Val was: " + val);else
			if (!val.equals("TRUE") && !val.equals("FALSE"))
				System.out.println("Error: CenterLineLighted value not expected! Got " + val);
			else
				addAttribute(str.split("=")[0], str.split("=")[1].split("\"")[1]);
	}


	@Override public void exitCenterline_taxiwaypath(@NotNull comp.Centerline_taxiwaypathContext ctx) { }


	@Override public void enterTaxiwaypath_attr(@NotNull comp.Taxiwaypath_attrContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitTaxiwaypath_attr(@NotNull comp.Taxiwaypath_attrContext ctx) { }


	@Override public void enterWaypointregion_waypoint(@NotNull comp.Waypointregion_waypointContext ctx) {
		String str = ctx.getText();
		String val = protectedSplit(str); if(isNull(val)) System.out.println("Error: enterRegion value not expected! Val was: " + val);else
			if(!val.matches(str) && val.length()>48)
				System.out.println("Error: Region value out of bounds! Val size must be minor then 48 but was " + val.length());
			else
				addAttribute(str.split("=")[0], str.split("=")[1].split("\"")[1]);
	}


	@Override public void exitWaypointregion_waypoint(@NotNull comp.Waypointregion_waypointContext ctx) { }


	@Override public void enterStrobes_approachlights(@NotNull comp.Strobes_approachlightsContext ctx) {
		String str = ctx.getText();
		try
		{
			String val = protectedSplit(str); if(isNull(val)) System.out.println("Error: enterStrobes value not expected! Val was: " + val);else
				if (!val.matches(unsigned_int))
					System.out.println("Error: Strobes value not expected! Val was: " + val);
				else
					addAttribute(str.split("=")[0], str.split("=")[1].split("\"")[1]);
		}
		catch(Exception e)
		{

			System.out.println("Error: Strobes value not expected! Val was: " + str);
		}
	}


	@Override public void exitStrobes_approachlights(@NotNull comp.Strobes_approachlightsContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterLength_helipad(@NotNull comp.Length_helipadContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitLength_helipad(@NotNull comp.Length_helipadContext ctx) { }


	@Override public void enterFuel(@NotNull comp.FuelContext ctx) {
		fuelCounter++;
		receivingAttributs = "Fuel";
	}


	@Override public void exitFuel(@NotNull comp.FuelContext ctx) {
		servicesElements.put("Fuel"+fuelCounter.toString(),"Services"+servicesCounter.toString());
	}


	@Override public void enterLon_airport_attr(@NotNull comp.Lon_airport_attrContext ctx) {
		String str = ctx.getText();
		Double val = Double.parseDouble(str.split("=")[1].split("\"")[1]);
		if (val >= 180 || val <= -180)
			System.out.println("Error: Longitude value not expected! Got " + val);
		else
			addAttribute(str.split("=")[0], str.split("=")[1].split("\"")[1]);
	}


	@Override public void exitLon_airport_attr(@NotNull comp.Lon_airport_attrContext ctx) { }


	@Override public void enterWaypointtype_waypoint(@NotNull comp.Waypointtype_waypointContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitWaypointtype_waypoint(@NotNull comp.Waypointtype_waypointContext ctx) { }


	@Override public void enterOverrun_node(@NotNull comp.Overrun_nodeContext ctx) {
		overrunCounter++;
		receivingAttributs = "Overrun";
	}


	@Override public void exitOverrun_node(@NotNull comp.Overrun_nodeContext ctx) {
		runwayElements.put("Overrun"+overrunCounter.toString(), "Runway"+runwayCounter.toString());
	}


	@Override public void enterOffsetthreshold_node(@NotNull comp.Offsetthreshold_nodeContext ctx) {
		offsetThresholdCounter++;
		receivingAttributs = "OffsetThreshold";
	}


	@Override public void exitOffsetthreshold_node(@NotNull comp.Offsetthreshold_nodeContext ctx) {
		runwayElements.put("OffsetThreshold"+offsetThresholdCounter.toString(), "Runway"+runwayCounter.toString());
	}


	@Override public void enterName_parking(@NotNull comp.Name_parkingContext ctx) {
		String str = ctx.getText();
		String val = protectedSplit(str); if(isNull(val)) System.out.println("Error: enterTaxiwayparkingName value not expected! Val was: " + val);else
			if (!val.equals("PARKING") && !val.equals("DOCK") && !val.equals("GATES") && !val.startsWith("GATE_") && !val.equals("NONE") && !val.equals("N_PARKING") && !val.equals("NE_PARKING" )&& !val.equals("NW_PARKING" )&& !val.equals("SE_PARKING" )&& !val.equals("S_PARKING") && !val.equals("SW_PARKING" )&& !val.equals("W_PARKING") && !val.equals("E_PARKING" ))
				System.out.println("Error: TaxiwayparkingName value not expected! Got " + val);
			else
				addAttribute(str.split("=")[0], str.split("=")[1].split("\"")[1]);
	}


	@Override public void exitName_parking(@NotNull comp.Name_parkingContext ctx) { }


	@Override public void enterCom_attributes(@NotNull comp.Com_attributesContext ctx) { }


	@Override public void exitCom_attributes(@NotNull comp.Com_attributesContext ctx) { }


	@Override public void enterLat_airport_attr(@NotNull comp.Lat_airport_attrContext ctx) {
		String str = ctx.getText();
		Double val = Double.parseDouble(str.split("=")[1].split("\"")[1]);
		if (val >= 90 || val <= -90)
			System.out.println("Error: lattitude value not expected! Got " + val);
		else
			addAttribute(str.split("=")[0], str.split("=")[1].split("\"")[1]);
	}


	@Override public void exitLat_airport_attr(@NotNull comp.Lat_airport_attrContext ctx) { }


	@Override public void enterWidth_attr(@NotNull comp.Width_attrContext ctx) {
		String str = ctx.getText();
		String val = protectedSplit(str); if(isNull(val)) System.out.println("Error: enterWidth value not expected! Val was: " + val);else
			if(!val.matches(altitude_value))
				System.out.println("Error: width value not expected! Got " + val);
			else
				addAttribute(str.split("=")[0], str.split("=")[1].split("\"")[1]);
	}


	@Override public void exitWidth_attr(@NotNull comp.Width_attrContext ctx) { }


	@Override public void enterLon_attr(@NotNull comp.Lon_attrContext ctx) {
		String str = ctx.getText();
		Double val = Double.parseDouble(str.split("=")[1].split("\"")[1]);
		if (val >= 180 || val <= -180)
			System.out.println("Error: Longitude value not expected! Got " + val);
		else
			addAttribute(str.split("=")[0], str.split("=")[1].split("\"")[1]);
	}


	@Override public void exitLon_attr(@NotNull comp.Lon_attrContext ctx) { }


	@Override public void enterBlue_helipad(@NotNull comp.Blue_helipadContext ctx) {
		String str = ctx.getText();
		int val = Integer.parseInt(str.split("=")[1].split("\"")[1]);
		if(val < 0 || val > 255)
			System.out.println("Error: Green value out of bounds! Expected [0,255] but got " + val);
		else
		{
			addAttribute(str.split("=")[0], str.split("=")[1].split("\"")[1]);
		}
	}


	@Override public void exitBlue_helipad(@NotNull comp.Blue_helipadContext ctx) { }


	@Override public void enterRange_ils(@NotNull comp.Range_ilsContext ctx) {
		String str = ctx.getText();
		String val = protectedSplit(str); if(isNull(val)) System.out.println("Error: enterRange value not expected! Val was: " + val);else
			if(!val.matches(altitude_value))
				System.out.println("Error: Range value not expected! Got " + val);
			else
				addAttribute(str.split("=")[0], str.split("=")[1].split("\"")[1]);
	}

	
	@Override public void exitRange_ils(@NotNull comp.Range_ilsContext ctx) { }


	@Override public void enterBlastpad_attr(@NotNull comp.Blastpad_attrContext ctx) { }


	@Override public void exitBlastpad_attr(@NotNull comp.Blastpad_attrContext ctx) { }


	@Override public void enterPushback_parking(@NotNull comp.Pushback_parkingContext ctx) {
		String str = ctx.getText();
		String val = protectedSplit(str); if(isNull(val)) System.out.println("Error: enterPush_back value not expected! Val was: " + val);else
			if (!val.equals("NONE") && !val.equals("BOTH") && !val.equals("LEFT") && !val.equals("RIGHT" ))
				System.out.println("Error: Push_back value not expected! Got " + val);
			else
				addAttribute(str.split("=")[0], str.split("=")[1].split("\"")[1]);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitPushback_parking(@NotNull comp.Pushback_parkingContext ctx) { }


	@Override public void enterOrientation_taxiway(@NotNull comp.Orientation_taxiwayContext ctx) {
		String str = ctx.getText();
		String val = protectedSplit(str); if(isNull(val)) System.out.println("Error: Orientation value not expected! Val was: " + val);else
			if (!val.equals("FORWARD") && !val.equals("REVERSE"))
				System.out.println("Error: Orientation value not expected! Expected 'FORWARD' OR 'REVERSE' but got " + val);
			else
				addAttribute(str.split("=")[0], str.split("=")[1].split("\"")[1]);
	}


	@Override public void exitOrientation_taxiway(@NotNull comp.Orientation_taxiwayContext ctx) { }


	@Override public void enterDme_node(@NotNull comp.Dme_nodeContext ctx) {
		receivingAttributs = "Dme";
		dmeCounter++;
	}


	@Override public void exitDme_node(@NotNull comp.Dme_nodeContext ctx) {
		ilsElements.put("Dme"+dmeCounter.toString(), "Ils"+ilsCounter.toString());
	}


	@Override public void enterTaxiwayparking_attr(@NotNull comp.Taxiwayparking_attrContext ctx) { }


	@Override public void exitTaxiwayparking_attr(@NotNull comp.Taxiwayparking_attrContext ctx) { }


	@Override public void enterVasi_node(@NotNull comp.Vasi_nodeContext ctx) {
		receivingAttributs = "Vasi";
		vasiCounter++;
	}


	@Override public void exitVasi_node(@NotNull comp.Vasi_nodeContext ctx) {
		runwayElements.put("Vasi"+vasiCounter.toString(), "Runway"+runwayCounter.toString());
	}


	@Override public void enterName_attr(@NotNull comp.Name_attrContext ctx) {
		String str = ctx.getText();
		String val = protectedSplit(str); if(isNull(val)) val="";else
			if(!val.matches(str) && val.length()>48)
				System.out.println("Error: Name value out of bounds! Val size must be minor then 48 but was " + val.length());
			else
				addAttribute(str.split("=")[0], str.split("=")[1].split("\"")[1]);
	}


	@Override public void exitName_attr(@NotNull comp.Name_attrContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterRunway_attributes(@NotNull comp.Runway_attributesContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitRunway_attributes(@NotNull comp.Runway_attributesContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterWaypointident_waypoint(@NotNull comp.Waypointident_waypointContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitWaypointident_waypoint(@NotNull comp.Waypointident_waypointContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterLights_attributes(@NotNull comp.Lights_attributesContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitLights_attributes(@NotNull comp.Lights_attributesContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterWaypoint_attr(@NotNull comp.Waypoint_attrContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitWaypoint_attr(@NotNull comp.Waypoint_attrContext ctx) { }


	@Override public void enterType_parking(@NotNull comp.Type_parkingContext ctx) {
		String str = ctx.getText();
		String val = protectedSplit(str); if(isNull(val)) System.out.println("Error: TaxiwayparkingType value not expected! Val was: " + val);else
			if (!val.equals("NONE") && !val.equals("DOCKGA") && !val.equals("FUEL") && !val.equals("GATEHEAVY") && !val.equals("GATEMEDIUM") && !val.equals("GATESMALL") && !val.equals("RAMP_CARGO") && !val.equals("RAMP_GA") && !val.equals("RAMP_GA_LARGE") && !val.equals("RAMP_GA_MEDIUM") && !val.equals("RAMPGAMEDIUM") && !val.equals("RAMP_GA_SMALL") && !val.equals("RAMP_MIL_CARGO") && !val.equals("RAMP_MIL_COMBAT") && !val.equals("VEHICLE"))
				System.out.println("Error: TaxiwayparkingType value not expected! Got " + val);
			else
				addAttribute(str.split("=")[0], str.split("=")[1].split("\"")[1]);
	}


	@Override public void exitType_parking(@NotNull comp.Type_parkingContext ctx) { }


	@Override public void enterTeeoffset2_parking(@NotNull comp.Teeoffset2_parkingContext ctx) {
		String str = ctx.getText();
		Double val = Double.parseDouble(str.split("=")[1].split("\"")[1]);
		if (val < 0.1 || val > 50.0)
			System.out.println("Error: TeeOffSet2 value not expected! Got " + val);
		else
			addAttribute(str.split("=")[0], str.split("=")[1].split("\"")[1]);
	}


	@Override public void exitTeeoffset2_parking(@NotNull comp.Teeoffset2_parkingContext ctx) { }


	@Override public void enterBlastpad_node(@NotNull comp.Blastpad_nodeContext ctx) {
		blastPadCounter++;
		receivingAttributs = "BlastPad";
	}


	@Override public void exitBlastpad_node(@NotNull comp.Blastpad_nodeContext ctx) {
		runwayElements.put("BlastPad"+blastPadCounter.toString(), "Runway"+runwayCounter.toString());
	}


	@Override public void enterRunway_nodes(@NotNull comp.Runway_nodesContext ctx) { }


	@Override public void exitRunway_nodes(@NotNull comp.Runway_nodesContext ctx) { }


	@Override public void enterTaxiwayparking_node(@NotNull comp.Taxiwayparking_nodeContext ctx) {
		receivingAttributs = "TaxiwayParking";
		taxiwayParkingCounter++;
	}


	@Override public void exitTaxiwayparking_node(@NotNull comp.Taxiwayparking_nodeContext ctx) {
		airportElements.put("TaxiwayParking"+taxiwayParkingCounter.toString(), "Airport"+airportCounter.toString());
	}


	@Override public void enterTaxiwaypath_node(@NotNull comp.Taxiwaypath_nodeContext ctx) {
		receivingAttributs = "TaxiwayPath";
		taxiwayPathCounter++;
	}


	@Override public void exitTaxiwaypath_node(@NotNull comp.Taxiwaypath_nodeContext ctx) {
		airportElements.put("TaxiwayPath"+taxiwayPathCounter.toString(), "Airport"+airportCounter.toString());
	}


	@Override public void enterState_attr(@NotNull comp.State_attrContext ctx) {
		String str = ctx.getText();
		String val = protectedSplit(str); if(isNull(val)) System.out.println("Error: enterState value not expected! Val was: " + val);else
			if(!val.matches(str) && val.length()>48)
				System.out.println("Error: State value out of bounds! Val size must be minor then 48 but was " + val.length());
			else
				addAttribute(str.split("=")[0], str.split("=")[1].split("\"")[1]);
	}


	@Override public void exitState_attr(@NotNull comp.State_attrContext ctx) { }


	@Override public void enterIls_nodes(@NotNull comp.Ils_nodesContext ctx) {
		ilsCounter++;
		receivingAttributs = "Ils";
	}


	@Override public void exitIls_nodes(@NotNull comp.Ils_nodesContext ctx) {
		runwayElements.put("Ils"+ilsCounter.toString(), "Runway"+runwayCounter.toString());
	}


	@Override public void enterOffsetthreshold_attr(@NotNull comp.Offsetthreshold_attrContext ctx) { }


	@Override public void exitOffsetthreshold_attr(@NotNull comp.Offsetthreshold_attrContext ctx) { }


	@Override public void enterImagecomplexity_visualmodel(@NotNull comp.Imagecomplexity_visualmodelContext ctx) {
		String str = ctx.getText();
		String val = protectedSplit(str); if(isNull(val)) System.out.println("Error: enterImage_complexety value not expected! Val was: " + val);else
			if (!val.equals("VERY_SPARSE") && !val.equals("SPARSE") && !val.equals("NORMAL") && !val.equals("DENSE" )&& !val.equals("VERY_DENSE"))
				System.out.println("Error: Image_complexety value not expected! Got " + val);
			else
				addAttribute(str.split("=")[0], str.split("=")[1].split("\"")[1]);
	}


	@Override public void exitImagecomplexity_visualmodel(@NotNull comp.Imagecomplexity_visualmodelContext ctx) { }


	@Override public void enterCountry_attr(@NotNull comp.Country_attrContext ctx) {
		String str = ctx.getText();
		String val = protectedSplit(str); if(isNull(val)) System.out.println("Error: enterCountry value not expected! Val was: " + val);else
			if(!val.matches(str) && val.length()>48)
				System.out.println("Error: Country value out of bounds! Val size must be minor then 48 but was " + val.length());
			else
				addAttribute(str.split("=")[0], str.split("=")[1].split("\"")[1]);
	}


	@Override public void exitCountry_attr(@NotNull comp.Country_attrContext ctx) { }


	@Override public void enterIdent_airport_attr(@NotNull comp.Ident_airport_attrContext ctx) {
		String str = ctx.getText();
		String val = protectedSplit(str); if(isNull(val)) System.out.println("Error: enterIdent value not expected! Val was: " + val);else
			if(!val.matches(ident))
				System.out.println("Error: Ident value not expected! Got " + val);
			else//valid value
			{
				addAttribute(str.split("=")[0], str.split("=")[1].split("\"")[1]);	

			}
	}


	@Override public void exitIdent_airport_attr(@NotNull comp.Ident_airport_attrContext ctx) { }


	@Override public void enterName_taxiname(@NotNull comp.Name_taxinameContext ctx) {
		String str = ctx.getText();
		String val = protectedSplit(str); if(isNull(val)) val="";else
			if(!val.matches(str) && val.length()>48)
				System.out.println("Error: Name value out of bounds! Val size must be minor then 48 but was " + val.length());
			else
				addAttribute(str.split("=")[0], str.split("=")[1].split("\"")[1]);
	}


	@Override public void exitName_taxiname(@NotNull comp.Name_taxinameContext ctx) { }


	@Override public void enterStart_taxiwaypath(@NotNull comp.Start_taxiwaypathContext ctx) {
		String str = ctx.getText();
		try{
			Double val = Double.parseDouble(str.split("=")[1].split("\"")[1]);
			if (val >= 255 || val < 0)
				System.out.println("Error: TaxiwayPathStart value not expected! Got " + val);
			else
				addAttribute(str.split("=")[0], str.split("=")[1].split("\"")[1]);

		}
		catch (Exception e)
		{
			System.out.println("Error: TaxiwayPathStart value not expected! Got " + str);
		}
	}


	@Override public void exitStart_taxiwaypath(@NotNull comp.Start_taxiwaypathContext ctx) { }


	@Override public void enterFuelAvail(@NotNull comp.FuelAvailContext ctx) {
		String str = ctx.getText();
		String val = protectedSplit(str); if(isNull(val)) System.out.println("Error: CenterRed value not expected! Val was: " + val);else
			if (!val.equals("YES") && !val.equals("NO") && !val.equals("UNKNOWN") &&  !val.equals("PRIOR_REQUEST"))
				System.out.println("Error: Availability value out of bounds! Expected [0,3999] but got " + val);
			else
				addAttribute(str.split("=")[0], str.split("=")[1].split("\"")[1]);
	}


	@Override public void exitFuelAvail(@NotNull comp.FuelAvailContext ctx) { }


	@Override public void enterIdent_ils(@NotNull comp.Ident_ilsContext ctx) {
		String str = ctx.getText();
		String val = protectedSplit(str); if(isNull(val)) System.out.println("Error: enterIdent_ils value not expected! Val was: " + val);else
			if(!val.matches(ident))
				System.out.println("Error: Ident_ils value not expected! Got " + val);
			else
				addAttribute(str.split("=")[0], str.split("=")[1].split("\"")[1]);
	}


	@Override public void exitIdent_ils(@NotNull comp.Ident_ilsContext ctx) { }


	@Override public void enterTaxiwaypoint_attr(@NotNull comp.Taxiwaypoint_attrContext ctx) { }


	@Override public void exitTaxiwaypoint_attr(@NotNull comp.Taxiwaypoint_attrContext ctx) { }


	@Override public void enterRightedgelighted_taxiwaypath(@NotNull comp.Rightedgelighted_taxiwaypathContext ctx) {
		String str = ctx.getText();
		String val = protectedSplit(str); if(isNull(val)) val = "FALSE";
		if (!val.equals("TRUE") && !val.equals("FALSE"))
			System.out.println("Error: RightEdgeLighted value not expected! Got " + val);
		else
			addAttribute(str.split("=")[0], str.split("=")[1].split("\"")[1]);
	}


	@Override public void exitRightedgelighted_taxiwaypath(@NotNull comp.Rightedgelighted_taxiwaypathContext ctx) { }


	@Override public void enterFreq_attr(@NotNull comp.Freq_attrContext ctx) {
		String str = ctx.getText();
		String val = protectedSplit(str); if(isNull(val)) System.out.println("Error: enterFrequency value not expected! Val was: " + val);else
			if(!val.matches(floatnumber))
				System.out.println("Error: Frequency value not expected! Got " + val);
			else
				addAttribute(str.split("=")[0], str.split("=")[1].split("\"")[1]);
	}


	@Override public void exitFreq_attr(@NotNull comp.Freq_attrContext ctx) { }


	@Override public void enterTransparent_helipad(@NotNull comp.Transparent_helipadContext ctx) { }


	@Override public void exitTransparent_helipad(@NotNull comp.Transparent_helipadContext ctx) { }


	@Override public void enterBias_attr(@NotNull comp.Bias_attrContext ctx) { }


	@Override public void exitBias_attr(@NotNull comp.Bias_attrContext ctx) { }


	@Override public void enterDrawsurface(@NotNull comp.DrawsurfaceContext ctx) {
		String str = ctx.getText();
		String val = protectedSplit(str); if(isNull(val)) System.out.println("Error: enterDrawSurface value not expected! Val was: " + val);else
			if (!val.equals("TRUE") && !val.equals("FALSE"))
				System.out.println("Error: drawSurface value not expected! Got " + val);
			else
				addAttribute(str.split("=")[0], str.split("=")[1].split("\"")[1]);
	}


	@Override public void exitDrawsurface(@NotNull comp.DrawsurfaceContext ctx) { }


	@Override public void enterTouchdown_approachlights(@NotNull comp.Touchdown_approachlightsContext ctx) {
		String str = ctx.getText();
		String val = protectedSplit(str); if(isNull(val)) System.out.println("Error: enterAlternateTouchdown value not expected! Val was: " + val);else
			if (!val.equals("TRUE") && !val.equals("FALSE"))
				System.out.println("Error: AlternateTouchdown value not expected! Val was: " + val);
			else
				addAttribute(str.split("=")[0], str.split("=")[1].split("\"")[1]);
	}


	@Override public void exitTouchdown_approachlights(@NotNull comp.Touchdown_approachlightsContext ctx) { }


	@Override public void enterRunwayalias_attr(@NotNull comp.Runwayalias_attrContext ctx) { }


	@Override public void exitRunwayalias_attr(@NotNull comp.Runwayalias_attrContext ctx) { }


	@Override public void enterIndex_taxiname(@NotNull comp.Index_taxinameContext ctx) { }


	@Override public void exitIndex_taxiname(@NotNull comp.Index_taxinameContext ctx) { }


	@Override public void enterWeightlimit_taxiwaypath(@NotNull comp.Weightlimit_taxiwaypathContext ctx) {
		String str = ctx.getText();
		Double val = Double.parseDouble(str.split("=")[1].split("\"")[1]);
		if (val < 0)
			System.out.println("Error: WeightLimit value not expected! Got " + val);
		else
			addAttribute(str.split("=")[0], str.split("=")[1].split("\"")[1]);
	}


	@Override public void exitWeightlimit_taxiwaypath(@NotNull comp.Weightlimit_taxiwaypathContext ctx) { }


	@Override public void enterPitch_vasi(@NotNull comp.Pitch_vasiContext ctx) {
		String str = ctx.getText();
		String val = protectedSplit(str); if(isNull(val)) System.out.println("Error: enterPitch value not expected! Val was: " + val);else
			if(!val.matches(heading))
				System.out.println("Error: Pitch value not expected! Got " + val);
			else
				addAttribute(str.split("=")[0], str.split("=")[1].split("\"")[1]);
	}


	@Override public void exitPitch_vasi(@NotNull comp.Pitch_vasiContext ctx) { }


	@Override public void enterMarkings_attr(@NotNull comp.Markings_attrContext ctx) { }


	@Override public void exitMarkings_attr(@NotNull comp.Markings_attrContext ctx) { }


	@Override public void enterType_vasi(@NotNull comp.Type_vasiContext ctx) {
		String str = ctx.getText();
		String val = protectedSplit(str); if(isNull(val)) System.out.println("Error: enterVasiType value not expected! Val was: " + val);else
			if (!val.equals("PAPI2") && !val.equals("PAPI4") && !val.equals("PVASI") && !val.equals("TRICOLOR") && !val.equals("TVASI" )&& !val.equals("VASI21") && !val.equals("VASI22" )&& !val.equals("VASI23" )&& !val.equals("VASI31") && !val.equals("VASI32") && !val.equals("VASI33") && !val.equals("BALL") && !val.equals("APAP") && !val.equals("PANELS"))
				System.out.println("Error: VasiType value not expected! Got " + val);
			else
				addAttribute(str.split("=")[0], str.split("=")[1].split("\"")[1]);
	}


	@Override public void exitType_vasi(@NotNull comp.Type_vasiContext ctx) { }


	@Override public void enterNumber_attr(@NotNull comp.Number_attrContext ctx) {
		String str = ctx.getText();
		try{


			String val = protectedSplit(str); if(isNull(val)) System.out.println("Error: CenterRed value not expected! Val was: " + val);else
				if(val.equals("00"))
					addAttribute(str.split("=")[0], str.split("=")[1].split("\"")[1]);
			if (!val.equals("EAST") && !val.equals("NORTH") && !val.equals("NORTHEAST" )&& !val.equals("NORTHWEST") && !val.equals("SOUTH") && !val.equals("SOUTHEAST") && !val.equals("SOUTHWEST") && !val.equals("WEST"))
				if(val.startsWith("0")) {
					int value = Integer.parseInt(val);
					if (value < 0 || value > 9) {
						System.out.println("Error: Aprroach_Runway value out of bounds! Expected [00,09] but got " + val);
					}
					else
						addAttribute(str.split("=")[0], str.split("=")[1].split("\"")[1]);
				}
				else
				{
					int value = Integer.parseInt(val);
					if (value < 0 || value > 36)
						System.out.println("Error: Aprroach_Runway value out of bounds! Expected [0,36] but got " + val);
					else
						addAttribute(str.split("=")[0], str.split("=")[1].split("\"")[1]);
				}
		}
		catch(Exception e)
		{
			System.out.println("Error: Number value not expected! Got " + str);
		}
	}


	@Override public void exitNumber_attr(@NotNull comp.Number_attrContext ctx) { }


	@Override public void enterRunwayalias_node(@NotNull comp.Runwayalias_nodeContext ctx) {
		runwayAliasCounter++;
	}


	@Override public void exitRunwayalias_node(@NotNull comp.Runwayalias_nodeContext ctx) {
		airportElements.put("Runway_alias"+runwayAliasCounter.toString(), "Airport"+airportCounter.toString());
	}


	@Override public void enterNumber_parking(@NotNull comp.Number_parkingContext ctx) {
		String str = ctx.getText();
		Double val = Double.parseDouble(str.split("=")[1].split("\"")[1]);
		if (val >= 3999 || val < 0)
			System.out.println("Error: TaxiwayparkingNumber value out of bounds! Expected [0,3999] but got " + val);
		else
			addAttribute(str.split("=")[0], str.split("=")[1].split("\"")[1]);
	}


	@Override public void exitNumber_parking(@NotNull comp.Number_parkingContext ctx) { }


	@Override public void enterGreen_helipad(@NotNull comp.Green_helipadContext ctx) {
		String str = ctx.getText();
		int val = Integer.parseInt(str.split("=")[1].split("\"")[1]);
		if(val < 0 || val > 255)
			System.out.println("Error: Blue value out of bounds! Expected [0,255] but got " + val);
		else
		{
			addAttribute(str.split("=")[0], str.split("=")[1].split("\"")[1]);
		}
	}


	@Override public void exitGreen_helipad(@NotNull comp.Green_helipadContext ctx) { }


	@Override public void enterTaxi_nodes(@NotNull comp.Taxi_nodesContext ctx) { }


	@Override public void exitTaxi_nodes(@NotNull comp.Taxi_nodesContext ctx) { }


	@Override public void enterBackcourse_ils(@NotNull comp.Backcourse_ilsContext ctx) {
		String str = ctx.getText();
		String val = protectedSplit(str); if(isNull(val)) System.out.println("Error: enterBackCourse value not expected! Val was: " + val);else
			if (!val.equals("TRUE") && !val.equals("FALSE"))
				System.out.println("Error: BackCourse value not expected! Val was: " + val);
			else
				addAttribute(str.split("=")[0], str.split("=")[1].split("\"")[1]);
	}


	@Override public void exitBackcourse_ils(@NotNull comp.Backcourse_ilsContext ctx) { }


	@Override public void enterType_taxiway(@NotNull comp.Type_taxiwayContext ctx) { }


	@Override public void exitType_taxiway(@NotNull comp.Type_taxiwayContext ctx) { }


	@Override public void enterRightedge_taxiwaypath(@NotNull comp.Rightedge_taxiwaypathContext ctx) { }


	@Override public void exitRightedge_taxiwaypath(@NotNull comp.Rightedge_taxiwaypathContext ctx) { }


	@Override public void enterStart(@NotNull comp.StartContext ctx) { 
		receivingAttributs = "Airport";
		airportCounter++;
	}


	@Override public void exitStart(@NotNull comp.StartContext ctx) {
		System.out.println("=== SUCCESS ===");
	}


	@Override public void enterMagvar_attr(@NotNull comp.Magvar_attrContext ctx) {
		String str = ctx.getText();
		Double val = Double.parseDouble(str.split("=")[1].split("\"")[1]);
		if (val >= 360 || val <= -360)
			System.out.println("Error: Magvar value not expected! Got " + val);
		else
			addAttribute(str.split("=")[0], str.split("=")[1].split("\"")[1]);
	}


	@Override public void exitMagvar_attr(@NotNull comp.Magvar_attrContext ctx) { }


	@Override public void enterType_runwaystart(@NotNull comp.Type_runwaystartContext ctx) { }


	@Override public void exitType_runwaystart(@NotNull comp.Type_runwaystartContext ctx) { }


	@Override public void enterDme_attr(@NotNull comp.Dme_attrContext ctx) { }


	@Override public void exitDme_attr(@NotNull comp.Dme_attrContext ctx) { }


	@Override public void enterVasi_attr(@NotNull comp.Vasi_attrContext ctx) { }


	@Override public void exitVasi_attr(@NotNull comp.Vasi_attrContext ctx) { }


	@Override public void enterType_taxiwaypath(@NotNull comp.Type_taxiwaypathContext ctx) {
		String str = ctx.getText();
		String val = protectedSplit(str); if(isNull(val)) System.out.println("Error: enterTaxiwayPathType value not expected! Val was: " + val);else
			if (!val.equals("RUNWAY") && !val.equals("PARKING") && !val.equals("TAXI") && !val.equals("PATH") && !val.equals("CLOSED") && !val.equals("VEHICLE"))
				System.out.println("Error: TaxiwayPathType value not expected! Got " + val);
			else
				addAttribute(str.split("=")[0], str.split("=")[1].split("\"")[1]);
	}


	@Override public void exitType_taxiwaypath(@NotNull comp.Type_taxiwaypathContext ctx) { }


	@Override public void enterTeeoffset1_parking(@NotNull comp.Teeoffset1_parkingContext ctx) {
		String str = ctx.getText();
		Double val = Double.parseDouble(str.split("=")[1].split("\"")[1]);
		if (val < 0.1 || val > 50.0)
			System.out.println("Error: TeeOffSet1 value not expected! Got " + val);
		else
			addAttribute(str.split("=")[0], str.split("=")[1].split("\"")[1]);
	}


	@Override public void exitTeeoffset1_parking(@NotNull comp.Teeoffset1_parkingContext ctx) { }


	@Override public void enterTaxiwaypoint_node(@NotNull comp.Taxiwaypoint_nodeContext ctx) {
		taxiwayPointCounter++;
		receivingAttributs = "TaxiwayPoint";
	}


	@Override public void exitTaxiwaypoint_node(@NotNull comp.Taxiwaypoint_nodeContext ctx) {
		airportElements.put("TaxiwayPoint"+taxiwayPointCounter.toString(), "Airport"+airportCounter.toString());
	}


	@Override public void enterRegion_attr(@NotNull comp.Region_attrContext ctx) {
		String str = ctx.getText();
		String val = protectedSplit(str); if(isNull(val)) System.out.println("Error: enterRegion value not expected! Val was: " + val);else
			if(!val.matches(str) && val.length()>48)
				System.out.println("Error: Region value out of bounds! Val size must be minor then 48 but was " + val.length());
			else
				addAttribute(str.split("=")[0], str.split("=")[1].split("\"")[1]);
	}


	@Override public void exitRegion_attr(@NotNull comp.Region_attrContext ctx) { }


	@Override public void enterSide_vasi(@NotNull comp.Side_vasiContext ctx) { }


	@Override public void exitSide_vasi(@NotNull comp.Side_vasiContext ctx) { }


	@Override public void enterBiasxyz_node(@NotNull comp.Biasxyz_nodeContext ctx) { }


	@Override public void exitBiasxyz_node(@NotNull comp.Biasxyz_nodeContext ctx) { }


	@Override public void enterTraffic_scalar_attr(@NotNull comp.Traffic_scalar_attrContext ctx) { }


	@Override public void exitTraffic_scalar_attr(@NotNull comp.Traffic_scalar_attrContext ctx) { }


	@Override public void enterLights_center(@NotNull comp.Lights_centerContext ctx) {
		String str = ctx.getText();
		String val = protectedSplit(str); if(isNull(val)) System.out.println("Error: enterCenter value not expected! Val was: " + val);else
			if (!val.equals("NONE") && !val.equals("LOW") && !val.equals("MEDIUM") && !val.equals("HIGH"))
				System.out.println("Error: Center value not expected! Got " + val);
			else
				addAttribute(str.split("=")[0], str.split("=")[1].split("\"")[1]);
	}


	@Override public void exitLights_center(@NotNull comp.Lights_centerContext ctx) { }


	@Override public void enterName_visualmodel(@NotNull comp.Name_visualmodelContext ctx) {
		String str = ctx.getText();
		String val = protectedSplit(str); if(isNull(val)) val="";else
			if(!val.matches(str) && val.length()>48)
				System.out.println("Error: Name value out of bounds! Val size must be minor then 48 but was " + val.length());
			else
				addAttribute(str.split("=")[0], str.split("=")[1].split("\"")[1]);
	}


	@Override public void exitName_visualmodel(@NotNull comp.Name_visualmodelContext ctx) { }


	@Override public void enterEveryRule(@NotNull ParserRuleContext ctx) { }


	@Override public void exitEveryRule(@NotNull ParserRuleContext ctx) { }


	@Override public void visitTerminal(@NotNull TerminalNode node) { }


	@Override public void visitErrorNode(@NotNull ErrorNode node) { }
	
	public String protectedSplit(String str)
	{
		try{
			return str.split("=")[1].split("\"")[1];
		}
		catch(Exception e)
		{
			return null;
		}
	}


	public boolean isNull(String str)
	{
		try{
			if(str.equals("something"))
				return false;
			else
				return false;
		}
		catch(Exception e)
		{
			return true;
		}
	}


	public void addAttribute(String attName, String attValue)
	{
		Map<String, String> value = new HashMap<String,String>();
		value.put(attName,attValue);
		switch (receivingAttributs) {
		case "Airport":
			if(airportAttributs.containsKey("Airport"+airportCounter.toString()))
			{
				value = airportAttributs.get("Airport"+airportCounter.toString());
				value.put(attName, attValue);
			}
			else
				airportAttributs.put("Airport"+airportCounter.toString(), value);
			break;
		case "Tower":
			if(towerAttributs.containsKey("Tower"+towerCounter.toString()))
			{
				value = towerAttributs.get("Tower"+towerCounter.toString());
				value.put(attName, attValue);
			}
			else
				towerAttributs.put("Tower"+towerCounter.toString(), value);
			break;
		case "Runway":
			if(runwayAttributs.containsKey("Runway"+runwayCounter.toString().toString()))
			{
				value = runwayAttributs.get("Runway"+runwayCounter.toString().toString());
				value.put(attName, attValue);
			}
			else
				runwayAttributs.put("Runway"+runwayCounter.toString(), value);
			break;
		case "Runway_alias":
			if(runwayAliasAttributs.containsKey("Runway_alias"+runwayAliasCounter.toString()))
			{
				value = runwayAliasAttributs.get("Runway_alias"+runwayAliasCounter.toString());
				value.put(attName, attValue);
			}
			else
				runwayAliasAttributs.put("Runway_alias"+runwayAliasCounter.toString(), value);
			break;
		case "Helipad":
			if(helipadAttributs.containsKey("Helipad"+helipadCounter .toString()))
			{
				value = helipadAttributs.get("Helipad"+helipadCounter .toString());
				value.put(attName, attValue);
			}
			else
				helipadAttributs.put("Helipad"+helipadCounter .toString(), value);
			break;
		case "Runway_start":
			if(runway_startAttributs.containsKey("Runway_start"+runwayStartCounter.toString()))
			{
				value = runway_startAttributs.get("Runway_start"+runwayStartCounter.toString());
				value.put(attName, attValue);
			}
			else
				runway_startAttributs.put("Runway_start"+runwayStartCounter.toString(), value);
			break;
		case "TaxiwayPoint":
			if(taxiwayPointAttributs.containsKey("TaxiwayPoint"+taxiwayPointCounter.toString()))
			{
				value = taxiwayPointAttributs.get("TaxiwayPoint"+taxiwayPointCounter.toString());
				value.put(attName, attValue);
			}
			else
				taxiwayPointAttributs.put("TaxiwayPoint"+taxiwayPointCounter.toString(),value);
			break;
		case "TaxiwayParking":
			if(taxiwayParkingAttributs.containsKey("TaxiwayParking"+taxiwayParkingCounter.toString()))
			{
				value = taxiwayParkingAttributs.get("TaxiwayParking"+taxiwayParkingCounter.toString());
				value.put(attName, attValue);
			}
			else
				taxiwayParkingAttributs.put("TaxiwayParking"+taxiwayParkingCounter.toString(), value);
			break;
		case "TaxiwayName":
			if(taxiwayNameAttributs.containsKey("TaxiwayName"+taxiNameCounter.toString()))
			{
				value = taxiwayNameAttributs.get("TaxiwayName"+taxiNameCounter.toString());
				value.put(attName, attValue);
			}
			else
				taxiwayNameAttributs.put("TaxiwayName"+taxiNameCounter.toString(), value);
			break;
		case "TaxiwayPath":
			if(taxiwayPointAttributs.containsKey("TaxiwayPath"+taxiwayPathCounter.toString()))
			{
				value = taxiwayPointAttributs.get("TaxiwayPath"+taxiwayPathCounter.toString());
				value.put(attName, attValue);
			}
			else
				taxiwayPathAttributs.put("TaxiwayPath"+taxiwayPathCounter.toString(), value);
			break;
		case "Lights":
			if(lightsAttributs.containsKey("Lights"+lightsCounter.toString()))
			{
				value = lightsAttributs.get("Lights"+lightsCounter.toString());
				value.put(attName, attValue);
			}
			else
				lightsAttributs.put("Lights"+lightsCounter.toString(), value);
			break;
		case "OffsetThreshold":
			if(offsetThresholdAttributs.containsKey("OffsetThreashold"+offsetThresholdCounter.toString()))
			{
				value = offsetThresholdAttributs.get("OffsetThreashold"+offsetThresholdCounter.toString());
				value.put(attName, attValue);
			}
			else
				offsetThresholdAttributs.put("OffsetThreashold"+offsetThresholdCounter.toString(), value);
			break;
		case "BlastPad":
			if(blastPadAttributs.containsKey("BlastPad"+blastPadCounter.toString()))
			{
				value = blastPadAttributs.get("BlastPad"+blastPadCounter.toString());
				value.put(attName, attValue);
			}
			else
				blastPadAttributs.put("BlastPad"+blastPadCounter.toString(), value);
			break;
		case "Overrun":
			if(overrunAttributs.containsKey("Overrun"+overrunCounter.toString()))
			{
				value = overrunAttributs.get("Overrun"+overrunCounter.toString());
				value.put(attName, attValue);
			}
			else
				overrunAttributs.put("Overrun"+overrunCounter.toString(), value);
			break;
		case "ApproachLights":
			if(approachLightsAttributs.containsKey("ApproachLights"+approachLightsCounter.toString()))
			{
				value = approachLightsAttributs.get("ApproachLights"+approachLightsCounter.toString());
				value.put(attName, attValue);
			}
			else
				approachLightsAttributs.put("ApproachLights"+approachLightsCounter.toString(), value);
			break;
		case "Vasi":
			if(vasiAttributs.containsKey("Vasi"+vasiCounter.toString()))
			{
				value = vasiAttributs.get("Vasi"+vasiCounter.toString());
				value.put(attName, attValue);
			}
			else
				vasiAttributs.put("Vasi"+vasiCounter.toString(), value);
			break;
		case "Visual_model":
			if(visualModelAttributs.containsKey("Visual_model"+visualModelCounter.toString()))
			{
				value = visualModelAttributs.get("Visual_model"+visualModelCounter.toString());
				value.put(attName, attValue);
			}
			else
				visualModelAttributs.put("Visual_model"+visualModelCounter.toString(), value);
			break;
		case "Glide_slope":
			if(glide_scopeAttributs.containsKey("Glide_scope"+glideSlopeCounter.toString()))
			{
				value = glide_scopeAttributs.get("Glide_scope"+glideSlopeCounter.toString());
				value.put(attName, attValue);
			}
			else
				glide_scopeAttributs.put("Glide_scope"+glideSlopeCounter.toString(), value);
			break;
		case "Dme":
			if(dmeAttributs.containsKey("DME"+dmeCounter.toString()))
			{
				value = dmeAttributs.get("DME"+dmeCounter.toString());
				value.put(attName, attValue);
			}
			else
				dmeAttributs.put("DME"+dmeCounter.toString(), value);
			break;
		case "Fuel":
			if(fuelAttributs.containsKey("Fuel"+fuelCounter.toString()))
			{
				value = fuelAttributs.get("Fuel"+fuelCounter.toString());
				value.put(attName, attValue);
			}
			else
				fuelAttributs.put("Fuel"+fuelCounter.toString(), value);
			break;
		case  "Vertex":
			if(vertexAttributs.containsKey("Vertex"+vertexCounter.toString()))
			{
				value = vertexAttributs.get("Vertex"+vertexCounter.toString());
				value.put(attName, attValue);
			}
			else
				vertexAttributs.put("Vertex"+vertexCounter.toString(), value);
			break;
		case "Ils":
			if(ilsAttributs.containsKey("Ils"+ilsCounter.toString()))
			{
				value = vertexAttributs.get("Ils"+ilsCounter.toString());
				value.put(attName, attValue);
			}
			else
				vertexAttributs.put("Ils"+ilsCounter.toString(), value);
			break;
		default:
			break;
		}
	}
}