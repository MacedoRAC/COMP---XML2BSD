parser grammar comp;

options {tokenVocab= compLexer;}



start : STARTNODE AIRPORT attributes* CLOSE_TAG airport_nodes* START_END_NODE AIRPORT CLOSE_TAG;

airport_nodes : tower_node | services_node | com_node | runway_node | runwayalias_node | waypoint_node+ | helipad_node | taxi_nodes;

taxi_nodes : taxiwaypoint_node+ taxiwayparking_node+ taxiname_node+ taxiwaypath_node+;

attributes : region_attr |
			 country_attr |
			 state_attr |
			 city_attr |
			 name_attr |
			 lat_airport_attr |
			 lon_airport_attr |
			 alt_airport_attr |
			 magvar_airport_attr |
			 ident_airport_attr |
			 test_radius_attr |
			 traffic_scalar_attr;
			 
region_attr : REGION EQUAL VALUE;
country_attr : COUNTRY EQUAL VALUE;
state_attr :  STATE EQUAL VALUE;
city_attr : CITY EQUAL VALUE;
name_attr : NAME EQUAL VALUE;
lat_airport_attr : LAT EQUAL VALUE;
lon_airport_attr : LON EQUAL VALUE;
alt_airport_attr : ALT EQUAL VALUE;
magvar_airport_attr : MAGVAR EQUAL VALUE;
ident_airport_attr : IDENT EQUAL VALUE;
test_radius_attr : AIRPORT_TEST_RADIUS EQUAL VALUE;
traffic_scalar_attr : TRAFFIC_SCALAR EQUAL VALUE;

/* TOWER NODE */
tower_node : STARTNODE TOWER tower_attributes* CLOSE_TAG START_END_NODE TOWER CLOSE_TAG;

tower_attributes : 	(LAT EQUAL VALUE)
					(LON EQUAL VALUE)
					(ALT EQUAL VALUE);

/* SERVICES NODE */
services_node : STARTNODE SERVICES CLOSE_TAG fuel* START_END_NODE SERVICES CLOSE_TAG;

fuel : STARTNODE FUEL typeOfFuel fuelAvail ENDNODE ;

typeOfFuel : TYPE EQUAL VALUE;

fuelAvail : AVAILABILITY EQUAL VALUE;


/* COM NODE */
com_node : STARTNODE COM com_attributes* ENDNODE;

com_attributes : (FREQUENCY EQUAL VALUE) |
				 (TYPE EQUAL VALUE) |
				 (NAME EQUAL VALUE);


/* RUNWAY NODE */
runway_node : STARTNODE RUNWAY runway_attributes* CLOSE_TAG runway_nodes* START_END_NODE RUNWAY CLOSE_TAG;

runway_nodes : markings_node | lights_node | offsetthreshold_node | blastpad_node | overrun_node | approachlights_node | vasi_node | ils_node | runwaystart_node;

runway_attributes: (LAT EQUAL VALUE) |
				   (LON EQUAL VALUE) |
				   (ALT EQUAL VALUE) |
				   (SURFACE EQUAL VALUE) |
				   (HEADING EQUAL VALUE) |
				   (LENGTH  EQUAL VALUE) |
				   (WIDTH EQUAL VALUE) |
				   (NUMBER EQUAL VALUE) |
				   (DESIGNATOR EQUAL VALUE) |
				   (PRIMARY_DESIGNATOR EQUAL VALUE) |
				   (SECONDARY_DESIGNATOR EQUAL VALUE) |
				   (PATTERN_ALT EQUAL VALUE) |
				   (PRIMARY_TAKEOFF EQUAL VALUE) |
				   (PRIMARY_LANDING EQUAL VALUE) |
				   (PRIMARY_PATTERN EQUAL VALUE) |
				   (SECONDARY_TAKEOFF EQUAL VALUE) |
				   (SECONDARY_LANDING EQUAL VALUE) |
				   (SECONDARY_PATTERN EQUAL VALUE) |
				   (PRIMARY_MARKING_BIAS EQUAL VALUE) |
				   (SECONDARY_MARKING_BIAS EQUAL VALUE);
				   
/* MARKINGS NODE */
markings_node : STARTNODE MARKINGS markings_attributes* ENDNODE;

markings_attributes : markings_attr EQUAL VALUE;

markings_attr : ALTERNATE_THRESHOLD | 
				ALTERNATE_TOUCHDOWN | 
				ALTERNATE_FIXED_DISTANCE | 
				ALTERNATE_PRECISION | 
				LEADING_ZERO_IDENT | 
				NO_THRESHOLD_END_ARROWS | 
				EDGES | 
				THRESHOLD | 
				FIXED_DISTANCE | 
				TOUCHDOWN | 
				DASHES | 
				IDENT | 
				PRECISION | 
				EDGE_PAVEMENT | 
				SINGLE_END | 
				PRIMARY_CLOSED | 
				SECONDARY_CLOSED | 
				PRIMARY_STOL | 
				SECONDARY_STOL;

/* LIGHTS NODE */
lights_node : STARTNODE LIGHTS lights_attributes* ENDNODE;

lights_attributes : lights_center | lights_edge | lights_centerred;

lights_center : CENTER EQUAL VALUE;

lights_edge : EDGE EQUAL VALUE;

lights_centerred : CENTER_RED EQUAL VALUE;


/* OFFSET_THRESHOLD NODE */
offsetthreshold_node : STARTNODE OFFSETTHRESHOLD offsetthreshold_attr* ENDNODE;

offsetthreshold_attr : end_attr | length_attr | width_attr | surface_attr;

end_attr : END EQUAL VALUE;

length_attr : LENGTH EQUAL VALUE;

surface_attr: SURFACE EQUAL VALUE;

/* BLASTPAD NODE */
blastpad_node : STARTNODE BLASTPAD blastpad_attr* ENDNODE;

blastpad_attr : end_attr | length_attr | width_attr | surface_attr;

/* OVERRUN NODE */
overrun_node : STARTNODE OVERRUN overrun_attr* ENDNODE;

overrun_attr : end_attr | length_attr | width_attr | surface_attr;

/* APPROACH LIGHTS NODE */
approachlights_node : STARTNODE APPROACHLIGHTS approachlights_attr* ENDNODE;

approachlights_attr : end_attr | system_approachlights | strobes_approachlights | reil_approachlights | touchdown_approachlights | endlights_approachlights;

system_approachlights : SYSTEM EQUAL VALUE;

strobes_approachlights : STROBES EQUAL VALUE; /* falta semantica */

reil_approachlights : REIL EQUAL VALUE;

touchdown_approachlights : TOUCHDOWN EQUAL VALUE;

endlights_approachlights : END_LIGHTS EQUAL VALUE;

/* VASI NODE */
vasi_node : STARTNODE VASI vasi_attr* ENDNODE;

vasi_attr : end_attr | type_vasi | side_vasi | biasX | biasZ | spacing_vasi | pitch_vasi;

type_vasi : TYPE EQUAL VALUE;

side_vasi : SIDE EQUAL VALUE;

spacing_vasi : SPACING EQUAL VALUE;

pitch_vasi : PITCH EQUAL VALUE; /* falta semantica */

/* ILS NODE */
ils_node : STARTNODE ILS ils_attr* CLOSE_TAG ils_nodes* START_END_NODE ILS CLOSE_TAG;

ils_nodes : glideslope_node | dme_node | visualmodel_node;

ils_attr : lat_attr | lon_attr | alt_attr | heading_attr | freq_attr | end_attr | range_ils | magvar_attr | ident_ils | width_attr | name_ils | backcourse_ils;

lat_attr : LAT EQUAL VALUE;

lon_attr : LON EQUAL VALUE;

alt_attr : ALT EQUAL VALUE;

heading_attr : HEADING EQUAL VALUE; /* falta semantica */

freq_attr : FREQUENCY EQUAL VALUE; /* falta semantica */

range_ils : RANGE EQUAL VALUE; /* falta semantica */

magvar_attr : MAGVAR EQUAL VALUE; /* falta semantica*/

ident_ils : IDENT EQUAL VALUE; /*falta semantica */

width_attr : WIDTH EQUAL VALUE; /*falta semantica */

name_ils : NAME EQUAL VALUE; /*falta semantica */

backcourse_ils : BACK_COURSE EQUAL VALUE;

/* RUNWAYSTART_NODE */
runwaystart_node : STARTNODE RUNWAYSTART_NODE runwaystart_attr* end_runwaynode? ENDNODE;

runwaystart_attr : type_runwaystart | lat_attr | lon_attr | alt_attr | heading_attr ;

type_runwaystart : TYPE EQUAL VALUE;

end_runwaynode : END EQUAL VALUE ; 

/* GLIDESLOPE NODE */
glideslope_node : STARTNODE GLIDESLOPE glideslope_attr* ENDNODE;

glideslope_attr : lat_attr | lon_attr | alt_attr | pitch_vasi | range_ils;

/* DME NODE */
dme_node : STARTNODE DME dme_attr* ENDNODE;

dme_attr : lat_attr | lon_attr | alt_attr | range_ils;

/* VISUAL_MODEL NODE */
visualmodel_node : VISUALMODEL visualmodel_attr* CLOSE_TAG biasxyz_node START_END_NODE VISUALMODEL CLOSE_TAG;

visualmodel_attr : heading_attr | imagecomplexity_visualmodel | name_visualmodel | instanceid_visualmodel;

imagecomplexity_visualmodel : IMAGE_COMPLEXITY EQUAL VALUE;

name_visualmodel : NAME EQUAL VALUE;

instanceid_visualmodel : INSTANCE_ID EQUAL VALUE;

/* BIAS_XYZ NODE */
biasxyz_node : STARTNODE BIASXYZ bias_attr* ENDNODE;

bias_attr : biasX | biasY | biasZ;

biasX : BIAS_X EQUAL VALUE;

biasY : BIAS_Y EQUAL VALUE;

biasZ : BIAS_Z EQUAL VALUE;


/* RUNWAYALIAS NODE */
runwayalias_node : STARTNODE RUNWAYALIAS runwayalias_attr* ENDNODE;

runwayalias_attr : number_attr | designator_attr;

designator_attr: DESIGNATOR EQUAL VALUE;

number_attr : NUMBER EQUAL VALUE;

/* VERTEX NODE */
vertex_node : STARTNODE VERTEX vertex_attr* ENDNODE;

vertex_attr : biasX | biasZ | lon_attr | lat_attr;


/* WAYPOINT NODE */
waypoint_node : STARTNODE WAYPOINT waypoint_attr CLOSE_TAG route_node* START_END_NODE WAYPOINT CLOSE_TAG;

waypoint_attr : lat_attr | lon_attr | waypointtype_waypoint | magvar_attr | waypointregion_waypoint | waypointident_waypoint;

waypointtype_waypoint : WAYPOINT_TYPE EQUAL VALUE;

waypointregion_waypoint : WAYPOINT_REGION EQUAL VALUE; /* falta semantica */

waypointident_waypoint : WAYPOINT_IDENT EQUAL VALUE; /* faltas semantica */

/* ROUTE NODE */
route_node : ROUTE route_attr* CLOSE_TAG route_nodes* START_END_NODE ROUTE CLOSE_TAG;

route_nodes : previous_node | next_node;

route_attr : routetype | name_route;

routetype : ROUTE_TYPE EQUAL VALUE;

name_route : NAME EQUAL VALUE; /* falta semantica */

/* PREVIOUS NODE */
previous_node : STARTNODE PREVIOUS previous_attr* ENDNODE;

previous_attr : waypointtype_waypoint | waypointregion_waypoint | waypointident_waypoint | altitudeMinimum_attr;

altitudeMinimum_attr : ALTITUDE_MINIMUM EQUAL VALUE; /* falta semantica */

/* NEXT NODE */
next_node : STARTNODE NEXT next_attr* ENDNODE;

next_attr : waypointtype_waypoint | waypointregion_waypoint | waypointident_waypoint | altitudeMinimum_attr;


/* HELIPAD NODE*/
helipad_node : STARTNODE HELIPAD helipad_attr* ENDNODE;

helipad_attr : lat_attr | lon_attr | alt_attr | surface_attr | heading_attr | length_helipad | width_helipad | type_helipad | closed_helipad | transparent_helipad | red_helipad | green_helipad | blue_helipad ;

length_helipad : LENGTH EQUAL VALUE;

width_helipad : WIDTH EQUAL VALUE;

type_helipad : TYPE EQUAL VALUE;

closed_helipad : CLOSED EQUAL VALUE;

transparent_helipad : TRANSPARENT EQUAL VALUE;

red_helipad : RED EQUAL VALUE; /*FALTA SEMANTICA*/

green_helipad : GREEN EQUAL VALUE; /*FALTA SEMANTICA*/

blue_helipad : BLUE EQUAL VALUE; /*FALTA SEMANTICA*/


/* TAXiWAY_POINT NODE */
taxiwaypoint_node : STARTNODE TAXIWAYPOINT taxiwaypoint_attr* ENDNODE;

taxiwaypoint_attr: index_taxiway | type_taxiway | orientation_taxiway | lat_attr | lon_attr | biasX | biasZ;

index_taxiway : INDEX EQUAL VALUE; /* falta semantica */

type_taxiway : TYPE EQUAL VALUE;

orientation_taxiway : ORIENTATION EQUAL VALUE;

/*TAXIWAYPARKING NODE  */
taxiwayparking_node : STARTNODE TAXIWAYPARKING taxiwayparking_attr* ENDNODE;

taxiwayparking_attr : index_taxiway | lat_attr | lon_attr | biasX | biasZ | heading_attr | radius_taxiway | type_parking | name_parking | number_parking | airlinecodes_parking | pushback_parking | teeoffset1_parking | teeoffset2_parking | teeoffset3_parking  | teeoffset4_parking;

radius_taxiway : RADIUS EQUAL VALUE; /* semantica */

type_parking : TYPE EQUAL VALUE;

name_parking : NAME EQUAL VALUE;

number_parking : NUMBER EQUAL VALUE; /* semantica */

airlinecodes_parking : AIRLINE_CODES EQUAL VALUE; /* semantica */

pushback_parking : PUSHBACK EQUAL VALUE; /* ver documentação */

teeoffset1_parking : TEE_OFFSET_1 EQUAL VALUE; /* semantica */

teeoffset2_parking : TEE_OFFSET_2 EQUAL VALUE; /* semantica */

teeoffset3_parking : TEE_OFFSET_3 EQUAL VALUE; /* semantica */

teeoffset4_parking : TEE_OFFSET_4 EQUAL VALUE; /* semantica */

/* TAXINAME NODE */
taxiname_node : STARTNODE TAXINAME taxiname_attr* ENDNODE;

taxiname_attr : index_taxiname | name_taxiname;

index_taxiname : INDEX EQUAL VALUE; /* semantica */

name_taxiname : NAME EQUAL VALUE; /* semantica */

/* TAXIWAY PATH NODE */
taxiwaypath_node : STARTNODE TAXIWAYPATH taxiwaypath_attr* ENDNODE;

taxiwaypath_attr : type_taxiwaypath | start_taxiwaypath | end_taxiwaypath | width_attr | weightlimit_taxiwaypath | surface_attr | drawsurface | drawdetail | centerline_taxiwaypath | centerlinelighted_taxiwaypath | leftedge_taxiwaypath | leftedgelighted_taxiwaypath | rightedge_taxiwaypath | rightedgelighted_taxiwaypath | taxiwaypath_number | taxiwaypath_designator | name_taxiwaypath;

type_taxiwaypath : TYPE EQUAL VALUE;

taxiwaypath_number : NUMBER EQUAL VALUE;

taxiwaypath_designator : DESIGNATOR EQUAL VALUE;

start_taxiwaypath : START EQUAL VALUE; /* semantica */

end_taxiwaypath : END EQUAL VALUE; /* semantica */

weightlimit_taxiwaypath : WEIGHT_LIMIT EQUAL VALUE;

centerline_taxiwaypath : CENTER_LINE EQUAL VALUE; /* semantica */

centerlinelighted_taxiwaypath : CENTER_LINE_LIGHTED EQUAL VALUE; /* semantica */

leftedge_taxiwaypath : LEFT_EDGE EQUAL VALUE; /* semantica */

leftedgelighted_taxiwaypath : LEFT_EDGE_LIGHED EQUAL VALUE; /* semantica */

rightedge_taxiwaypath : RIGHT_EDGE EQUAL VALUE; /* semantica */

rightedgelighted_taxiwaypath : RIGHT_EDGE_LIGHTED EQUAL VALUE; /* semantica */

name_taxiwaypath : NAME EQUAL VALUE; /* semantica */

drawsurface : DRAW_SURFACE EQUAL VALUE;

drawdetail : DRAW_DETAIL EQUAL VALUE;