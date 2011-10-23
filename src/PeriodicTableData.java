/**
 * This is the data for the periodic table.
 * This class is mostly automatically generated via data.pl script in the data directory
 * Note: it is possible to use files (plain text/XML/JSON) or ResourceBundle class to store the data for periodic table,
 * but the current approach should have faster loading times (profiling can be used to determine most optimal approach on actual Kindle devices).
 */
public class PeriodicTableData
{
	int[] Z;
	String[] Symbol;
	String[] Name;
	int[] Group;
	int[] Period;
	String[] Weight;
	double[] Density;
	double[] Melt; // T via K, C, F at 2.5MPa
	double[] Boil;
	double[] Heat; // heat molar capacity/fusion/vaporisation
	double[] Neg;
	double[] Abund;
	int[] Props;
	static int BLOCK_S = 1,
			BLOCK_P = 1<<2,
			BLOCK_D = 1<<3,
			BLOCK_F = 1<<4,
			STATE_GAS = 1<<5,
			STATE_LIQUID = 1<<6,
			STATE_SOLID = 1<<7,
			CATEGORY_METAL = 1<<8,
			CATEGORY_NONMETAL = 1<<9,
			CATEGORY_HALOGEN = 1<<10,
			CATEGORY_NOBEL_GAS = 1<<11,
			CATEGORY_LANTHANIDE = 1<<12,
			CATEGORY_ACTINIDE = 1<<13,
			CATEGORY_ALKALI_METAL = 1<<14,
			CATEGORY_ALKALINE_EARTH_METAL = 1<<15,
			CATEGORY_METALLOID = 1<<16,
			CATGEORY_TRANSITION_METAL = 1<<17;
	
	public static String textHistory =
		"The periodic table of the chemical elements (also known as the periodic table or periodic table of the elements) is a tabular display of the 118 known chemical elements organized by selected properties of their atomic structures. Elements are presented by increasing atomic number, the number of protons in an atom's atomic nucleus.\n"
		+ "The layout of the table has been refined and extended over time, as new elements have been discovered, and new theoretical models have been developed to explain chemical behavior.\n"
		+ "Since the periodic table accurately predicts the abilities of various elements to combine into chemical compounds, use of the periodic table is now ubiquitous within the academic discipline of chemistry, providing a useful framework to classify, systematize, and compare many of the many different forms of chemical behavior. The table has found many applications not only in chemistry and physics, but also in such diverse fields as geology, biology, materials science, engineering, agriculture, medicine, nutrition, environmental health, and astronomy. Its principles are especially important in chemical engineering.\n"
		+ "Production of additional synthetic elements beyond atomic number 118 is being pursued.";
	public static String textAbout = "This is a stub about text.";
	public static String textQuiz = "This will be the periodic table quiz/test.\n\n"
		+ "Element's names will be shown randomly and the user will have to select correct properties of the element.\n\n"
		+ "This should help studying the periodic table.";
	
	public PeriodicTableData()
	{
		Z = new int[118];
		Symbol = new String[118];
		Name = new String[118];
		Group = new int[118];
		Period = new int[118];
		Weight = new String[118];
		Density = new double[118];
		Melt = new double[118];
		Boil = new double[118];
		Heat = new double[118];
		Neg = new double[118];
		Props = new int[118];
		
		InitData();
	}
	
	public static String GetElementPhaseData(int props)
	{
		if((props & STATE_GAS) != 0)
			return "Gas";
		else if((props & STATE_LIQUID) != 0)
			return "Liquid";
		else if((props & STATE_SOLID) != 0)
			return "Solid";
		else
			return "None/unknown";
	}
	
	public static String GetElementBlockData(int props)
	{
		if((props & BLOCK_S) != 0)
			return "s";
		else if((props & BLOCK_P) != 0)
			return "p";
		else if((props & BLOCK_D) != 0)
			return "d";
		else if((props & BLOCK_F) != 0)
			return "f";
		else
			return "None/unknown";
	}
	
	public static String GetElementCategoryData(int props)
	{
		if((props & CATEGORY_METAL) != 0)
			return "Metal";
		else if((props & CATEGORY_NONMETAL) != 0)
			return "Non-metal";
		else if((props & CATEGORY_HALOGEN) != 0)
			return "Halogen";
		else if((props & CATEGORY_NOBEL_GAS) != 0)
			return "Nobel gas";
		else if((props & CATEGORY_LANTHANIDE) != 0)
			return "Lanthanide";
		else if((props & CATEGORY_ACTINIDE) != 0)
			return "Actinide";
		else if((props & CATEGORY_ALKALI_METAL) != 0)
			return "Alkali";
		else if((props & CATEGORY_ALKALINE_EARTH_METAL) != 0)
			return "Alkali";
		else if((props & CATEGORY_METALLOID) != 0)
			return "Metalloid";
		else if((props & CATGEORY_TRANSITION_METAL) != 0)
			return "Transition metal";
		else
			return "None/unknown";
	}
	
	// NOTE: static { ... }
	private void InitData()
	{
		//Hydrogen
		Z[0] = 1;
		Symbol[0] = "H";
		Name[0] = "Hydrogen";
		Group[0] = 1;
		Period[0] = 1;
		Weight[0] = "1.00794(7)2 3 4";
		Density[0] = 0.00008988;
		Melt[0] = 14.175;
		Boil[0] = 20.28;
		Heat[0] = 14.304;
		Neg[0] = 2.20;
		//Abund[0] = 1400;
		Props[0] = BLOCK_S | STATE_GAS | CATEGORY_NONMETAL;

		//Helium
		Z[1] = 2;
		Symbol[1] = "He";
		Name[1] = "Helium";
		Group[1] = 18;
		Period[1] = 1;
		Weight[1] = "4.002602(2)2 4";
		Density[1] = 0.0001785;
		Melt[1] = 0.95;
		Boil[1] = 4.22;
		Heat[1] = 5.193;
		Neg[1] = 0;
		//Abund[1] = 0.008;
		Props[1] = BLOCK_S | STATE_GAS | CATEGORY_NOBEL_GAS;

		//Lithium
		Z[2] = 3;
		Symbol[2] = "Li";
		Name[2] = "Lithium";
		Group[2] = 1;
		Period[2] = 2;
		Weight[2] = "6.941(2)2 3 4 5";
		Density[2] = 0.534;
		Melt[2] = 453.85;
		Boil[2] = 1615;
		Heat[2] = 3.582;
		Neg[2] = 0.98;
		//Abund[2] = 20;
		Props[2] = BLOCK_S | STATE_SOLID | CATEGORY_ALKALI_METAL;

		//Beryllium
		Z[3] = 4;
		Symbol[3] = "Be";
		Name[3] = "Beryllium";
		Group[3] = 2;
		Period[3] = 2;
		Weight[3] = "9.012182(3)";
		Density[3] = 1.85;
		Melt[3] = 1560.15;
		Boil[3] = 2742;
		Heat[3] = 1.825;
		Neg[3] = 1.57;
		//Abund[3] = 2.8;
		Props[3] = BLOCK_S | STATE_SOLID | CATEGORY_ALKALINE_EARTH_METAL;

		//Boron
		Z[4] = 5;
		Symbol[4] = "B";
		Name[4] = "Boron";
		Group[4] = 13;
		Period[4] = 2;
		Weight[4] = "10.811(7)2 3 4";
		Density[4] = 2.34;
		Melt[4] = 2573.15;
		Boil[4] = 4200;
		Heat[4] = 1.026;
		Neg[4] = 2.04;
		//Abund[4] = 10;
		Props[4] = BLOCK_P | STATE_SOLID | CATEGORY_METALLOID;

		//Carbon
		Z[5] = 6;
		Symbol[5] = "C";
		Name[5] = "Carbon";
		Group[5] = 14;
		Period[5] = 2;
		Weight[5] = "12.0107(8)2 4";
		Density[5] = 2.267;
		Melt[5] = 3948.157;
		Boil[5] = 4300;
		Heat[5] = 0.709;
		Neg[5] = 2.55;
		//Abund[5] = 200;
		Props[5] = BLOCK_P | STATE_SOLID | CATEGORY_NONMETAL;

		//Nitrogen
		Z[6] = 7;
		Symbol[6] = "N";
		Name[6] = "Nitrogen";
		Group[6] = 15;
		Period[6] = 2;
		Weight[6] = "14.0067(2)2 4";
		Density[6] = 0.0012506;
		Melt[6] = 63.29;
		Boil[6] = 77.36;
		Heat[6] = 1.04;
		Neg[6] = 3.04;
		//Abund[6] = 19;
		Props[6] = BLOCK_P | STATE_GAS | CATEGORY_NONMETAL;

		//Oxygen
		Z[7] = 8;
		Symbol[7] = "O";
		Name[7] = "Oxygen";
		Group[7] = 16;
		Period[7] = 2;
		Weight[7] = "15.9994(3)2 4";
		Density[7] = 0.001429;
		Melt[7] = 50.5;
		Boil[7] = 90.20;
		Heat[7] = 0.918;
		Neg[7] = 3.44;
		//Abund[7] = 461000;
		Props[7] = BLOCK_P | STATE_GAS | CATEGORY_NONMETAL;

		//Fluorine
		Z[8] = 9;
		Symbol[8] = "F";
		Name[8] = "Fluorine";
		Group[8] = 17;
		Period[8] = 2;
		Weight[8] = "18.9984032(5)";
		Density[8] = 0.001696;
		Melt[8] = 53.63;
		Boil[8] = 85.03;
		Heat[8] = 0.824;
		Neg[8] = 3.98;
		//Abund[8] = 585;
		Props[8] = BLOCK_P | STATE_GAS | CATEGORY_HALOGEN;

		//Neon
		Z[9] = 10;
		Symbol[9] = "Ne";
		Name[9] = "Neon";
		Group[9] = 18;
		Period[9] = 2;
		Weight[9] = "20.1797(6)2 3";
		Density[9] = 0.0008999;
		Melt[9] = 24.703;
		Boil[9] = 27.07;
		Heat[9] = 1.03;
		Neg[9] = 0;
		//Abund[9] = 0.005;
		Props[9] = BLOCK_P | STATE_GAS | CATEGORY_NOBEL_GAS;

		//Sodium
		Z[10] = 11;
		Symbol[10] = "Na";
		Name[10] = "Sodium";
		Group[10] = 1;
		Period[10] = 3;
		Weight[10] = "22.98976928(2)";
		Density[10] = 0.971;
		Melt[10] = 371.15;
		Boil[10] = 1156;
		Heat[10] = 1.228;
		Neg[10] = 0.93;
		//Abund[10] = 23600;
		Props[10] = BLOCK_S | STATE_SOLID | CATEGORY_ALKALI_METAL;

		//Magnesium
		Z[11] = 12;
		Symbol[11] = "Mg";
		Name[11] = "Magnesium";
		Group[11] = 2;
		Period[11] = 3;
		Weight[11] = "24.3050(6)";
		Density[11] = 1.738;
		Melt[11] = 923.15;
		Boil[11] = 1363;
		Heat[11] = 1.023;
		Neg[11] = 1.31;
		//Abund[11] = 23300;
		Props[11] = BLOCK_S | STATE_SOLID | CATEGORY_ALKALINE_EARTH_METAL;

		//Aluminium
		Z[12] = 13;
		Symbol[12] = "Al";
		Name[12] = "Aluminium";
		Group[12] = 13;
		Period[12] = 3;
		Weight[12] = "26.9815386(8)";
		Density[12] = 2.698;
		Melt[12] = 933.4;
		Boil[12] = 2792;
		Heat[12] = 0.897;
		Neg[12] = 1.61;
		//Abund[12] = 82300;
		Props[12] = BLOCK_P | STATE_SOLID | CATEGORY_METAL;

		//Silicon
		Z[13] = 14;
		Symbol[13] = "Si";
		Name[13] = "Silicon";
		Group[13] = 14;
		Period[13] = 3;
		Weight[13] = "28.0855(3)4";
		Density[13] = 2.3296;
		Melt[13] = 1683.15;
		Boil[13] = 3538;
		Heat[13] = 0.705;
		Neg[13] = 1.9;
		//Abund[13] = 282000;
		Props[13] = BLOCK_P | STATE_SOLID | CATEGORY_METALLOID;

		//Phosphorus
		Z[14] = 15;
		Symbol[14] = "P";
		Name[14] = "Phosphorus";
		Group[14] = 15;
		Period[14] = 3;
		Weight[14] = "30.973762(2)";
		Density[14] = 1.82;
		Melt[14] = 317.25;
		Boil[14] = 553;
		Heat[14] = 0.769;
		Neg[14] = 2.19;
		//Abund[14] = 1050;
		Props[14] = BLOCK_P | STATE_SOLID | CATEGORY_NONMETAL;

		//Sulfur
		Z[15] = 16;
		Symbol[15] = "S";
		Name[15] = "Sulfur";
		Group[15] = 16;
		Period[15] = 3;
		Weight[15] = "32.065(5)2 4";
		Density[15] = 2.067;
		Melt[15] = 388.51;
		Boil[15] = 717.8;
		Heat[15] = 0.71;
		Neg[15] = 2.58;
		//Abund[15] = 350;
		Props[15] = BLOCK_P | STATE_SOLID | CATEGORY_NONMETAL;

		//Chlorine
		Z[16] = 17;
		Symbol[16] = "Cl";
		Name[16] = "Chlorine";
		Group[16] = 17;
		Period[16] = 3;
		Weight[16] = "35.453(2)2 3 4";
		Density[16] = 0.003214;
		Melt[16] = 172.31;
		Boil[16] = 239.11;
		Heat[16] = 0.479;
		Neg[16] = 3.16;
		//Abund[16] = 145;
		Props[16] = BLOCK_P | STATE_GAS | CATEGORY_HALOGEN;

		//Argon
		Z[17] = 18;
		Symbol[17] = "Ar";
		Name[17] = "Argon";
		Group[17] = 18;
		Period[17] = 3;
		Weight[17] = "39.948(1)2 4";
		Density[17] = 0.0017837;
		Melt[17] = 83.96;
		Boil[17] = 87.30;
		Heat[17] = 0.52;
		Neg[17] = 0;
		//Abund[17] = 3.5;
		Props[17] = BLOCK_P | STATE_GAS | CATEGORY_NOBEL_GAS;

		//Potassium
		Z[18] = 19;
		Symbol[18] = "K";
		Name[18] = "Potassium";
		Group[18] = 1;
		Period[18] = 4;
		Weight[18] = "39.0983(1)";
		Density[18] = 0.862;
		Melt[18] = 336.5;
		Boil[18] = 1032;
		Heat[18] = 0.757;
		Neg[18] = 0.82;
		//Abund[18] = 20900;
		Props[18] = BLOCK_S | STATE_SOLID | CATEGORY_ALKALI_METAL;

		//Calcium
		Z[19] = 20;
		Symbol[19] = "Ca";
		Name[19] = "Calcium";
		Group[19] = 2;
		Period[19] = 4;
		Weight[19] = "40.078(4)2";
		Density[19] = 1.54;
		Melt[19] = 1112.15;
		Boil[19] = 1757;
		Heat[19] = 0.647;
		Neg[19] = 1;
		//Abund[19] = 41500;
		Props[19] = BLOCK_S | STATE_SOLID | CATEGORY_ALKALINE_EARTH_METAL;

		//Scandium
		Z[20] = 21;
		Symbol[20] = "Sc";
		Name[20] = "Scandium";
		Group[20] = 3;
		Period[20] = 4;
		Weight[20] = "44.955912(6)";
		Density[20] = 2.989;
		Melt[20] = 1812.15;
		Boil[20] = 3109;
		Heat[20] = 0.568;
		Neg[20] = 1.36;
		//Abund[20] = 22;
		Props[20] = BLOCK_D | STATE_SOLID | CATGEORY_TRANSITION_METAL;

		//Titanium
		Z[21] = 22;
		Symbol[21] = "Ti";
		Name[21] = "Titanium";
		Group[21] = 4;
		Period[21] = 4;
		Weight[21] = "47.867(1)";
		Density[21] = 4.54;
		Melt[21] = 1933.15;
		Boil[21] = 3560;
		Heat[21] = 0.523;
		Neg[21] = 1.54;
		//Abund[21] = 5650;
		Props[21] = BLOCK_D | STATE_SOLID | CATGEORY_TRANSITION_METAL;

		//Vanadium
		Z[22] = 23;
		Symbol[22] = "V";
		Name[22] = "Vanadium";
		Group[22] = 5;
		Period[22] = 4;
		Weight[22] = "50.9415(1)";
		Density[22] = 6.11;
		Melt[22] = 2175.15;
		Boil[22] = 3680;
		Heat[22] = 0.489;
		Neg[22] = 1.63;
		//Abund[22] = 120;
		Props[22] = BLOCK_D | STATE_SOLID | CATGEORY_TRANSITION_METAL;

		//Chromium
		Z[23] = 24;
		Symbol[23] = "Cr";
		Name[23] = "Chromium";
		Group[23] = 6;
		Period[23] = 4;
		Weight[23] = "51.9961(6)";
		Density[23] = 7.15;
		Melt[23] = 2130.15;
		Boil[23] = 2944;
		Heat[23] = 0.449;
		Neg[23] = 1.66;
		//Abund[23] = 102;
		Props[23] = BLOCK_D | STATE_SOLID | CATGEORY_TRANSITION_METAL;

		//Manganese
		Z[24] = 25;
		Symbol[24] = "Mn";
		Name[24] = "Manganese";
		Group[24] = 7;
		Period[24] = 4;
		Weight[24] = "54.938045(5)";
		Density[24] = 7.44;
		Melt[24] = 1519.15;
		Boil[24] = 2334;
		Heat[24] = 0.479;
		Neg[24] = 1.55;
		//Abund[24] = 950;
		Props[24] = BLOCK_D | STATE_SOLID | CATGEORY_TRANSITION_METAL;

		//Iron
		Z[25] = 26;
		Symbol[25] = "Fe";
		Name[25] = "Iron";
		Group[25] = 8;
		Period[25] = 4;
		Weight[25] = "55.845(2)";
		Density[25] = 7.874;
		Melt[25] = 1808.15;
		Boil[25] = 3134;
		Heat[25] = 0.449;
		Neg[25] = 1.83;
		//Abund[25] = 56300;
		Props[25] = BLOCK_D | STATE_SOLID | CATGEORY_TRANSITION_METAL;

		//Cobalt
		Z[26] = 27;
		Symbol[26] = "Co";
		Name[26] = "Cobalt";
		Group[26] = 9;
		Period[26] = 4;
		Weight[26] = "58.933195(5)";
		Density[26] = 8.86;
		Melt[26] = 1768.15;
		Boil[26] = 3200;
		Heat[26] = 0.421;
		Neg[26] = 1.88;
		//Abund[26] = 25;
		Props[26] = BLOCK_D | STATE_SOLID | CATGEORY_TRANSITION_METAL;

		//Nickel
		Z[27] = 28;
		Symbol[27] = "Ni";
		Name[27] = "Nickel";
		Group[27] = 10;
		Period[27] = 4;
		Weight[27] = "58.6934(4)";
		Density[27] = 8.912;
		Melt[27] = 1726.15;
		Boil[27] = 3186;
		Heat[27] = 0.444;
		Neg[27] = 1.91;
		//Abund[27] = 84;
		Props[27] = BLOCK_D | STATE_SOLID | CATGEORY_TRANSITION_METAL;

		//Copper
		Z[28] = 29;
		Symbol[28] = "Cu";
		Name[28] = "Copper";
		Group[28] = 11;
		Period[28] = 4;
		Weight[28] = "63.546(3)4";
		Density[28] = 8.96;
		Melt[28] = 1357.75;
		Boil[28] = 2835;
		Heat[28] = 0.385;
		Neg[28] = 1.9;
		//Abund[28] = 60;
		Props[28] = BLOCK_D | STATE_SOLID | CATGEORY_TRANSITION_METAL;

		//Zinc
		Z[29] = 30;
		Symbol[29] = "Zn";
		Name[29] = "Zinc";
		Group[29] = 12;
		Period[29] = 4;
		Weight[29] = "65.38(2)";
		Density[29] = 7.134;
		Melt[29] = 692.88;
		Boil[29] = 1180;
		Heat[29] = 0.388;
		Neg[29] = 1.65;
		//Abund[29] = 70;
		Props[29] = BLOCK_D | STATE_SOLID | CATGEORY_TRANSITION_METAL;

		//Gallium
		Z[30] = 31;
		Symbol[30] = "Ga";
		Name[30] = "Gallium";
		Group[30] = 13;
		Period[30] = 4;
		Weight[30] = "69.723(1)";
		Density[30] = 5.907;
		Melt[30] = 302.91;
		Boil[30] = 2477;
		Heat[30] = 0.371;
		Neg[30] = 1.81;
		//Abund[30] = 19;
		Props[30] = BLOCK_P | STATE_SOLID | CATEGORY_METAL;

		//Germanium
		Z[31] = 32;
		Symbol[31] = "Ge";
		Name[31] = "Germanium";
		Group[31] = 14;
		Period[31] = 4;
		Weight[31] = "72.64(1)";
		Density[31] = 5.323;
		Melt[31] = 1211.45;
		Boil[31] = 3106;
		Heat[31] = 0.32;
		Neg[31] = 2.01;
		//Abund[31] = 1.5;
		Props[31] = BLOCK_P | STATE_SOLID | CATEGORY_METALLOID;

		//Arsenic
		Z[32] = 33;
		Symbol[32] = "As";
		Name[32] = "Arsenic";
		Group[32] = 15;
		Period[32] = 4;
		Weight[32] = "74.92160(2)";
		Density[32] = 5.776;
		Melt[32] = 1090.157;
		Boil[32] = 887;
		Heat[32] = 0.329;
		Neg[32] = 2.18;
		//Abund[32] = 1.8;
		Props[32] = BLOCK_P | STATE_SOLID | CATEGORY_METALLOID;

		//Selenium
		Z[33] = 34;
		Symbol[33] = "Se";
		Name[33] = "Selenium";
		Group[33] = 16;
		Period[33] = 4;
		Weight[33] = "78.96(3)4";
		Density[33] = 4.809;
		Melt[33] = 494.15;
		Boil[33] = 958;
		Heat[33] = 0.321;
		Neg[33] = 2.55;
		//Abund[33] = 0.05;
		Props[33] = BLOCK_P | STATE_SOLID | CATEGORY_NONMETAL;

		//Bromine
		Z[34] = 35;
		Symbol[34] = "Br";
		Name[34] = "Bromine";
		Group[34] = 17;
		Period[34] = 4;
		Weight[34] = "79.904(1)";
		Density[34] = 3.122;
		Melt[34] = 266.05;
		Boil[34] = 332.0;
		Heat[34] = 0.474;
		Neg[34] = 2.96;
		//Abund[34] = 2.4;
		Props[34] = BLOCK_P | STATE_LIQUID | CATEGORY_HALOGEN;

		//Krypton
		Z[35] = 36;
		Symbol[35] = "Kr";
		Name[35] = "Krypton";
		Group[35] = 18;
		Period[35] = 4;
		Weight[35] = "83.798(2)2 3";
		Density[35] = 0.003733;
		Melt[35] = 115.93;
		Boil[35] = 119.93;
		Heat[35] = 0.248;
		Neg[35] = 3;
		//Abund[35] = <0.001;
		Props[35] = BLOCK_P | STATE_GAS | CATEGORY_NOBEL_GAS;

		//Rubidium
		Z[36] = 37;
		Symbol[36] = "Rb";
		Name[36] = "Rubidium";
		Group[36] = 1;
		Period[36] = 5;
		Weight[36] = "85.4678(3)2";
		Density[36] = 1.532;
		Melt[36] = 312.79;
		Boil[36] = 961;
		Heat[36] = 0.363;
		Neg[36] = 0.82;
		//Abund[36] = 90;
		Props[36] = BLOCK_S | STATE_SOLID | CATEGORY_ALKALI_METAL;

		//Strontium
		Z[37] = 38;
		Symbol[37] = "Sr";
		Name[37] = "Strontium";
		Group[37] = 2;
		Period[37] = 5;
		Weight[37] = "87.62(1)2 4";
		Density[37] = 2.64;
		Melt[37] = 1042.15;
		Boil[37] = 1655;
		Heat[37] = 0.301;
		Neg[37] = 0.95;
		//Abund[37] = 370;
		Props[37] = BLOCK_S | STATE_SOLID | CATEGORY_ALKALINE_EARTH_METAL;

		//Yttrium
		Z[38] = 39;
		Symbol[38] = "Y";
		Name[38] = "Yttrium";
		Group[38] = 3;
		Period[38] = 5;
		Weight[38] = "88.90585(2)";
		Density[38] = 4.469;
		Melt[38] = 1799.15;
		Boil[38] = 3609;
		Heat[38] = 0.298;
		Neg[38] = 1.22;
		//Abund[38] = 33;
		Props[38] = BLOCK_D | STATE_SOLID | CATGEORY_TRANSITION_METAL;

		//Zirconium
		Z[39] = 40;
		Symbol[39] = "Zr";
		Name[39] = "Zirconium";
		Group[39] = 4;
		Period[39] = 5;
		Weight[39] = "91.224(2)2";
		Density[39] = 6.506;
		Melt[39] = 2125.15;
		Boil[39] = 4682;
		Heat[39] = 0.278;
		Neg[39] = 1.33;
		//Abund[39] = 165;
		Props[39] = BLOCK_D | STATE_SOLID | CATGEORY_TRANSITION_METAL;

		//Niobium
		Z[40] = 41;
		Symbol[40] = "Nb";
		Name[40] = "Niobium";
		Group[40] = 5;
		Period[40] = 5;
		Weight[40] = "92.90638(2)";
		Density[40] = 8.57;
		Melt[40] = 2741.15;
		Boil[40] = 5017;
		Heat[40] = 0.265;
		Neg[40] = 1.6;
		//Abund[40] = 20;
		Props[40] = BLOCK_D | STATE_SOLID | CATGEORY_TRANSITION_METAL;

		//Molybdenum
		Z[41] = 42;
		Symbol[41] = "Mo";
		Name[41] = "Molybdenum";
		Group[41] = 6;
		Period[41] = 5;
		Weight[41] = "95.96(2)2";
		Density[41] = 10.22;
		Melt[41] = 2890.15;
		Boil[41] = 4912;
		Heat[41] = 0.251;
		Neg[41] = 2.16;
		//Abund[41] = 1.2;
		Props[41] = BLOCK_D | STATE_SOLID | CATGEORY_TRANSITION_METAL;

		//Technetium
		Z[42] = 43;
		Symbol[42] = "Tc";
		Name[42] = "Technetium";
		Group[42] = 7;
		Period[42] = 5;
		Weight[42] = "[98]1";
		Density[42] = 11.5;
		Melt[42] = 2473.15;
		Boil[42] = 5150;
		Heat[42] = 0;
		Neg[42] = 1.9;
		//Abund[42] = <0.001;
		Props[42] = BLOCK_D | STATE_SOLID | CATGEORY_TRANSITION_METAL;

		//Ruthenium
		Z[43] = 44;
		Symbol[43] = "Ru";
		Name[43] = "Ruthenium";
		Group[43] = 8;
		Period[43] = 5;
		Weight[43] = "101.07(2)2";
		Density[43] = 12.37;
		Melt[43] = 2523.15;
		Boil[43] = 4423;
		Heat[43] = 0.238;
		Neg[43] = 2.2;
		//Abund[43] = 0.001;
		Props[43] = BLOCK_D | STATE_SOLID | CATGEORY_TRANSITION_METAL;

		//Rhodium
		Z[44] = 45;
		Symbol[44] = "Rh";
		Name[44] = "Rhodium";
		Group[44] = 9;
		Period[44] = 5;
		Weight[44] = "102.90550(2)";
		Density[44] = 12.41;
		Melt[44] = 2239.15;
		Boil[44] = 3968;
		Heat[44] = 0.243;
		Neg[44] = 2.28;
		//Abund[44] = 0.001;
		Props[44] = BLOCK_D | STATE_SOLID | CATGEORY_TRANSITION_METAL;

		//Palladium
		Z[45] = 46;
		Symbol[45] = "Pd";
		Name[45] = "Palladium";
		Group[45] = 10;
		Period[45] = 5;
		Weight[45] = "106.42(1)2";
		Density[45] = 12.02;
		Melt[45] = 1825.15;
		Boil[45] = 3236;
		Heat[45] = 0.244;
		Neg[45] = 2.2;
		//Abund[45] = 0.015;
		Props[45] = BLOCK_D | STATE_SOLID | CATGEORY_TRANSITION_METAL;

		//Silver
		Z[46] = 47;
		Symbol[46] = "Ag";
		Name[46] = "Silver";
		Group[46] = 11;
		Period[46] = 5;
		Weight[46] = "107.8682(2)2";
		Density[46] = 10.501;
		Melt[46] = 1234.15;
		Boil[46] = 2435;
		Heat[46] = 0.235;
		Neg[46] = 1.93;
		//Abund[46] = 0.075;
		Props[46] = BLOCK_D | STATE_SOLID | CATGEORY_TRANSITION_METAL;

		//Cadmium
		Z[47] = 48;
		Symbol[47] = "Cd";
		Name[47] = "Cadmium";
		Group[47] = 12;
		Period[47] = 5;
		Weight[47] = "112.411(8)2";
		Density[47] = 8.69;
		Melt[47] = 594.33;
		Boil[47] = 1040;
		Heat[47] = 0.232;
		Neg[47] = 1.69;
		//Abund[47] = 0.159;
		Props[47] = BLOCK_D | STATE_SOLID | CATGEORY_TRANSITION_METAL;

		//Indium
		Z[48] = 49;
		Symbol[48] = "In";
		Name[48] = "Indium";
		Group[48] = 13;
		Period[48] = 5;
		Weight[48] = "114.818(3)";
		Density[48] = 7.31;
		Melt[48] = 429.91;
		Boil[48] = 2345;
		Heat[48] = 0.233;
		Neg[48] = 1.78;
		//Abund[48] = 0.25;
		Props[48] = BLOCK_P | STATE_SOLID | CATEGORY_METAL;

		//Tin
		Z[49] = 50;
		Symbol[49] = "Sn";
		Name[49] = "Tin";
		Group[49] = 14;
		Period[49] = 5;
		Weight[49] = "118.710(7)2";
		Density[49] = 7.287;
		Melt[49] = 505.21;
		Boil[49] = 2875;
		Heat[49] = 0.228;
		Neg[49] = 1.96;
		//Abund[49] = 2.3;
		Props[49] = BLOCK_P | STATE_SOLID | CATEGORY_METAL;

		//Antimony
		Z[50] = 51;
		Symbol[50] = "Sb";
		Name[50] = "Antimony";
		Group[50] = 15;
		Period[50] = 5;
		Weight[50] = "121.760(1)2";
		Density[50] = 6.685;
		Melt[50] = 904.05;
		Boil[50] = 1860;
		Heat[50] = 0.207;
		Neg[50] = 2.05;
		//Abund[50] = 0.2;
		Props[50] = BLOCK_P | STATE_SOLID | CATEGORY_METALLOID;

		//Tellurium
		Z[51] = 52;
		Symbol[51] = "Te";
		Name[51] = "Tellurium";
		Group[51] = 16;
		Period[51] = 5;
		Weight[51] = "127.60(3)2";
		Density[51] = 6.232;
		Melt[51] = 722.8;
		Boil[51] = 1261;
		Heat[51] = 0.202;
		Neg[51] = 2.1;
		//Abund[51] = 0.001;
		Props[51] = BLOCK_P | STATE_SOLID | CATEGORY_METALLOID;

		//Iodine
		Z[52] = 53;
		Symbol[52] = "I";
		Name[52] = "Iodine";
		Group[52] = 17;
		Period[52] = 5;
		Weight[52] = "126.90447(3)";
		Density[52] = 4.93;
		Melt[52] = 386.65;
		Boil[52] = 457.4;
		Heat[52] = 0.214;
		Neg[52] = 2.66;
		//Abund[52] = 0.45;
		Props[52] = BLOCK_P | STATE_SOLID | CATEGORY_HALOGEN;

		//Xenon
		Z[53] = 54;
		Symbol[53] = "Xe";
		Name[53] = "Xenon";
		Group[53] = 18;
		Period[53] = 5;
		Weight[53] = "131.293(6)2 3";
		Density[53] = 0.005887;
		Melt[53] = 161.45;
		Boil[53] = 165.03;
		Heat[53] = 0.158;
		Neg[53] = 2.6;
		//Abund[53] = <0.001;
		Props[53] = BLOCK_P | STATE_GAS | CATEGORY_NOBEL_GAS;

		//Caesium
		Z[54] = 55;
		Symbol[54] = "Cs";
		Name[54] = "Caesium";
		Group[54] = 1;
		Period[54] = 6;
		Weight[54] = "132.9054519(2)";
		Density[54] = 1.873;
		Melt[54] = 301.7;
		Boil[54] = 944;
		Heat[54] = 0.242;
		Neg[54] = 0.79;
		//Abund[54] = 3;
		Props[54] = BLOCK_S | STATE_SOLID | CATEGORY_ALKALI_METAL;

		//Barium
		Z[55] = 56;
		Symbol[55] = "Ba";
		Name[55] = "Barium";
		Group[55] = 2;
		Period[55] = 6;
		Weight[55] = "137.327(7)";
		Density[55] = 3.594;
		Melt[55] = 1002.15;
		Boil[55] = 2170;
		Heat[55] = 0.204;
		Neg[55] = 0.89;
		//Abund[55] = 425;
		Props[55] = BLOCK_S | STATE_SOLID | CATEGORY_ALKALINE_EARTH_METAL;

		//Lanthanum
		Z[56] = 57;
		Symbol[56] = "La";
		Name[56] = "Lanthanum";
		Group[56] = 1000;
		Period[56] = 6;
		Weight[56] = "138.90547(7)2";
		Density[56] = 6.145;
		Melt[56] = 1193.15;
		Boil[56] = 3737;
		Heat[56] = 0.195;
		Neg[56] = 1.1;
		//Abund[56] = 39;
		Props[56] = BLOCK_F | STATE_SOLID | CATEGORY_LANTHANIDE;

		//Cerium
		Z[57] = 58;
		Symbol[57] = "Ce";
		Name[57] = "Cerium";
		Group[57] = 1000;
		Period[57] = 6;
		Weight[57] = "140.116(1)2";
		Density[57] = 6.77;
		Melt[57] = 1071.15;
		Boil[57] = 3716;
		Heat[57] = 0.192;
		Neg[57] = 1.12;
		//Abund[57] = 66.5;
		Props[57] = BLOCK_F | STATE_SOLID | CATEGORY_LANTHANIDE;

		//Praseodymium
		Z[58] = 59;
		Symbol[58] = "Pr";
		Name[58] = "Praseodymium";
		Group[58] = 1000;
		Period[58] = 6;
		Weight[58] = "140.90765(2)";
		Density[58] = 6.773;
		Melt[58] = 1204.15;
		Boil[58] = 3793;
		Heat[58] = 0.193;
		Neg[58] = 1.13;
		//Abund[58] = 9.2;
		Props[58] = BLOCK_F | STATE_SOLID | CATEGORY_LANTHANIDE;

		//Neodymium
		Z[59] = 60;
		Symbol[59] = "Nd";
		Name[59] = "Neodymium";
		Group[59] = 1000;
		Period[59] = 6;
		Weight[59] = "144.242(3)2";
		Density[59] = 7.007;
		Melt[59] = 1289.15;
		Boil[59] = 3347;
		Heat[59] = 0.19;
		Neg[59] = 1.14;
		//Abund[59] = 41.5;
		Props[59] = BLOCK_F | STATE_SOLID | CATEGORY_LANTHANIDE;

		//Promethium
		Z[60] = 61;
		Symbol[60] = "Pm";
		Name[60] = "Promethium";
		Group[60] = 1000;
		Period[60] = 6;
		Weight[60] = "[145]1";
		Density[60] = 7.26;
		Melt[60] = 1204.15;
		Boil[60] = 3273;
		Heat[60] = 0;
		Neg[60] = 0;
		//Abund[60] = <0.001;
		Props[60] = BLOCK_F | STATE_SOLID | CATEGORY_LANTHANIDE;

		//Samarium
		Z[61] = 62;
		Symbol[61] = "Sm";
		Name[61] = "Samarium";
		Group[61] = 1000;
		Period[61] = 6;
		Weight[61] = "150.36(2)2";
		Density[61] = 7.52;
		Melt[61] = 1345.15;
		Boil[61] = 2067;
		Heat[61] = 0.197;
		Neg[61] = 1.17;
		//Abund[61] = 7.05;
		Props[61] = BLOCK_F | STATE_SOLID | CATEGORY_LANTHANIDE;

		//Europium
		Z[62] = 63;
		Symbol[62] = "Eu";
		Name[62] = "Europium";
		Group[62] = 1000;
		Period[62] = 6;
		Weight[62] = "151.964(1)2";
		Density[62] = 5.243;
		Melt[62] = 1095.15;
		Boil[62] = 1802;
		Heat[62] = 0.182;
		Neg[62] = 1.2;
		//Abund[62] = 2;
		Props[62] = BLOCK_F | STATE_SOLID | CATEGORY_LANTHANIDE;

		//Gadolinium
		Z[63] = 64;
		Symbol[63] = "Gd";
		Name[63] = "Gadolinium";
		Group[63] = 1000;
		Period[63] = 6;
		Weight[63] = "157.25(3)2";
		Density[63] = 7.895;
		Melt[63] = 1585.15;
		Boil[63] = 3546;
		Heat[63] = 0.236;
		Neg[63] = 1.2;
		//Abund[63] = 6.2;
		Props[63] = BLOCK_F | STATE_SOLID | CATEGORY_LANTHANIDE;

		//Terbium
		Z[64] = 65;
		Symbol[64] = "Tb";
		Name[64] = "Terbium";
		Group[64] = 1000;
		Period[64] = 6;
		Weight[64] = "158.92535(2)";
		Density[64] = 8.229;
		Melt[64] = 1630.15;
		Boil[64] = 3503;
		Heat[64] = 0.182;
		Neg[64] = 1.2;
		//Abund[64] = 1.2;
		Props[64] = BLOCK_F | STATE_SOLID | CATEGORY_LANTHANIDE;

		//Dysprosium
		Z[65] = 66;
		Symbol[65] = "Dy";
		Name[65] = "Dysprosium";
		Group[65] = 1000;
		Period[65] = 6;
		Weight[65] = "162.500(1)2";
		Density[65] = 8.55;
		Melt[65] = 1680.15;
		Boil[65] = 2840;
		Heat[65] = 0.17;
		Neg[65] = 1.22;
		//Abund[65] = 5.2;
		Props[65] = BLOCK_F | STATE_SOLID | CATEGORY_LANTHANIDE;

		//Holmium
		Z[66] = 67;
		Symbol[66] = "Ho";
		Name[66] = "Holmium";
		Group[66] = 1000;
		Period[66] = 6;
		Weight[66] = "164.93032(2)";
		Density[66] = 8.795;
		Melt[66] = 1743.15;
		Boil[66] = 2993;
		Heat[66] = 0.165;
		Neg[66] = 1.23;
		//Abund[66] = 1.3;
		Props[66] = BLOCK_F | STATE_SOLID | CATEGORY_LANTHANIDE;

		//Erbium
		Z[67] = 68;
		Symbol[67] = "Er";
		Name[67] = "Erbium";
		Group[67] = 1000;
		Period[67] = 6;
		Weight[67] = "167.259(3)2";
		Density[67] = 9.066;
		Melt[67] = 1795.15;
		Boil[67] = 3503;
		Heat[67] = 0.168;
		Neg[67] = 1.24;
		//Abund[67] = 3.5;
		Props[67] = BLOCK_F | STATE_SOLID | CATEGORY_LANTHANIDE;

		//Thulium
		Z[68] = 69;
		Symbol[68] = "Tm";
		Name[68] = "Thulium";
		Group[68] = 1000;
		Period[68] = 6;
		Weight[68] = "168.93421(2)";
		Density[68] = 9.321;
		Melt[68] = 1818.15;
		Boil[68] = 2223;
		Heat[68] = 0.16;
		Neg[68] = 1.25;
		//Abund[68] = 0.52;
		Props[68] = BLOCK_F | STATE_SOLID | CATEGORY_LANTHANIDE;

		//Ytterbium
		Z[69] = 70;
		Symbol[69] = "Yb";
		Name[69] = "Ytterbium";
		Group[69] = 1000;
		Period[69] = 6;
		Weight[69] = "173.054(5)2";
		Density[69] = 6.965;
		Melt[69] = 1097.15;
		Boil[69] = 1469;
		Heat[69] = 0.155;
		Neg[69] = 1.1;
		//Abund[69] = 3.2;
		Props[69] = BLOCK_F | STATE_SOLID | CATEGORY_LANTHANIDE;

		//Lutetium
		Z[70] = 71;
		Symbol[70] = "Lu";
		Name[70] = "Lutetium";
		Group[70] = 3;
		Period[70] = 6;
		Weight[70] = "174.9668(1)2";
		Density[70] = 9.84;
		Melt[70] = 1936.15;
		Boil[70] = 3675;
		Heat[70] = 0.154;
		Neg[70] = 1.27;
		//Abund[70] = 0.8;
		Props[70] = BLOCK_D | STATE_SOLID | CATEGORY_LANTHANIDE;

		//Hafnium
		Z[71] = 72;
		Symbol[71] = "Hf";
		Name[71] = "Hafnium";
		Group[71] = 4;
		Period[71] = 6;
		Weight[71] = "178.49(2)";
		Density[71] = 13.31;
		Melt[71] = 2500.15;
		Boil[71] = 4876;
		Heat[71] = 0.144;
		Neg[71] = 1.3;
		//Abund[71] = 3;
		Props[71] = BLOCK_D | STATE_SOLID | CATGEORY_TRANSITION_METAL;

		//Tantalum
		Z[72] = 73;
		Symbol[72] = "Ta";
		Name[72] = "Tantalum";
		Group[72] = 5;
		Period[72] = 6;
		Weight[72] = "180.94788(2)";
		Density[72] = 16.654;
		Melt[72] = 3269.15;
		Boil[72] = 5731;
		Heat[72] = 0.14;
		Neg[72] = 1.5;
		//Abund[72] = 2;
		Props[72] = BLOCK_D | STATE_SOLID | CATGEORY_TRANSITION_METAL;

		//Tungsten
		Z[73] = 74;
		Symbol[73] = "W";
		Name[73] = "Tungsten";
		Group[73] = 6;
		Period[73] = 6;
		Weight[73] = "183.84(1)";
		Density[73] = 19.25;
		Melt[73] = 3680.15;
		Boil[73] = 5828;
		Heat[73] = 0.132;
		Neg[73] = 2.36;
		//Abund[73] = 1.3;
		Props[73] = BLOCK_D | STATE_SOLID | CATGEORY_TRANSITION_METAL;

		//Rhenium
		Z[74] = 75;
		Symbol[74] = "Re";
		Name[74] = "Rhenium";
		Group[74] = 7;
		Period[74] = 6;
		Weight[74] = "186.207(1)";
		Density[74] = 21.02;
		Melt[74] = 3453.15;
		Boil[74] = 5869;
		Heat[74] = 0.137;
		Neg[74] = 1.9;
		//Abund[74] = <0.001;
		Props[74] = BLOCK_D | STATE_SOLID | CATGEORY_TRANSITION_METAL;

		//Osmium
		Z[75] = 76;
		Symbol[75] = "Os";
		Name[75] = "Osmium";
		Group[75] = 8;
		Period[75] = 6;
		Weight[75] = "190.23(3)2";
		Density[75] = 22.61;
		Melt[75] = 3300.15;
		Boil[75] = 5285;
		Heat[75] = 0.13;
		Neg[75] = 2.2;
		//Abund[75] = 0.002;
		Props[75] = BLOCK_D | STATE_SOLID | CATGEORY_TRANSITION_METAL;

		//Iridium
		Z[76] = 77;
		Symbol[76] = "Ir";
		Name[76] = "Iridium";
		Group[76] = 9;
		Period[76] = 6;
		Weight[76] = "192.217(3)";
		Density[76] = 22.56;
		Melt[76] = 2716.15;
		Boil[76] = 4701;
		Heat[76] = 0.131;
		Neg[76] = 2.2;
		//Abund[76] = 0.001;
		Props[76] = BLOCK_D | STATE_SOLID | CATGEORY_TRANSITION_METAL;

		//Platinum
		Z[77] = 78;
		Symbol[77] = "Pt";
		Name[77] = "Platinum";
		Group[77] = 10;
		Period[77] = 6;
		Weight[77] = "195.084(9)";
		Density[77] = 21.46;
		Melt[77] = 2045.15;
		Boil[77] = 4098;
		Heat[77] = 0.133;
		Neg[77] = 2.28;
		//Abund[77] = 0.005;
		Props[77] = BLOCK_D | STATE_SOLID | CATGEORY_TRANSITION_METAL;

		//Gold
		Z[78] = 79;
		Symbol[78] = "Au";
		Name[78] = "Gold";
		Group[78] = 11;
		Period[78] = 6;
		Weight[78] = "196.966569(4)";
		Density[78] = 19.282;
		Melt[78] = 1337.73;
		Boil[78] = 3129;
		Heat[78] = 0.129;
		Neg[78] = 2.54;
		//Abund[78] = 0.004;
		Props[78] = BLOCK_D | STATE_SOLID | CATGEORY_TRANSITION_METAL;

		//Mercury
		Z[79] = 80;
		Symbol[79] = "Hg";
		Name[79] = "Mercury";
		Group[79] = 12;
		Period[79] = 6;
		Weight[79] = "200.59(2)";
		Density[79] = 13.5336;
		Melt[79] = 234.43;
		Boil[79] = 630;
		Heat[79] = 0.14;
		Neg[79] = 2;
		//Abund[79] = 0.085;
		Props[79] = BLOCK_D | STATE_LIQUID | CATGEORY_TRANSITION_METAL;

		//Thallium
		Z[80] = 81;
		Symbol[80] = "Tl";
		Name[80] = "Thallium";
		Group[80] = 13;
		Period[80] = 6;
		Weight[80] = "204.3833(2)";
		Density[80] = 11.85;
		Melt[80] = 577.15;
		Boil[80] = 1746;
		Heat[80] = 0.129;
		Neg[80] = 1.62;
		//Abund[80] = 0.85;
		Props[80] = BLOCK_P | STATE_SOLID | CATEGORY_METAL;

		//Lead
		Z[81] = 82;
		Symbol[81] = "Pb";
		Name[81] = "Lead";
		Group[81] = 14;
		Period[81] = 6;
		Weight[81] = "207.2(1)2 4";
		Density[81] = 11.342;
		Melt[81] = 600.75;
		Boil[81] = 2022;
		Heat[81] = 0.129;
		Neg[81] = 2.33;
		//Abund[81] = 14;
		Props[81] = BLOCK_P | STATE_SOLID | CATEGORY_METAL;

		//Bismuth
		Z[82] = 83;
		Symbol[82] = "Bi";
		Name[82] = "Bismuth";
		Group[82] = 15;
		Period[82] = 6;
		Weight[82] = "208.98040(1)";
		Density[82] = 9.807;
		Melt[82] = 544.67;
		Boil[82] = 1837;
		Heat[82] = 0.122;
		Neg[82] = 2.02;
		//Abund[82] = 0.009;
		Props[82] = BLOCK_P | STATE_SOLID | CATEGORY_METAL;

		//Polonium
		Z[83] = 84;
		Symbol[83] = "Po";
		Name[83] = "Polonium";
		Group[83] = 16;
		Period[83] = 6;
		Weight[83] = "[210]1";
		Density[83] = 9.32;
		Melt[83] = 527.15;
		Boil[83] = 1235;
		Heat[83] = 0;
		Neg[83] = 2;
		//Abund[83] = <0.001;
		Props[83] = BLOCK_P | STATE_SOLID | CATEGORY_METALLOID;

		//Astatine
		Z[84] = 85;
		Symbol[84] = "At";
		Name[84] = "Astatine";
		Group[84] = 17;
		Period[84] = 6;
		Weight[84] = "[210]1";
		Density[84] = 7;
		Melt[84] = 575.15;
		Boil[84] = 610;
		Heat[84] = 0;
		Neg[84] = 2.2;
		//Abund[84] = <0.001;
		Props[84] = BLOCK_P | STATE_SOLID | CATEGORY_HALOGEN;

		//Radon
		Z[85] = 86;
		Symbol[85] = "Rn";
		Name[85] = "Radon";
		Group[85] = 18;
		Period[85] = 6;
		Weight[85] = "[222]1";
		Density[85] = 0.00973;
		Melt[85] = 202.15;
		Boil[85] = 211.3;
		Heat[85] = 0.094;
		Neg[85] = 0;
		//Abund[85] = <0.001;
		Props[85] = BLOCK_P | STATE_GAS | CATEGORY_NOBEL_GAS;

		//Francium
		Z[86] = 87;
		Symbol[86] = "Fr";
		Name[86] = "Francium";
		Group[86] = 1;
		Period[86] = 7;
		Weight[86] = "[223]1";
		Density[86] = 1.87;
		Melt[86] = 300.15;
		Boil[86] = 950;
		Heat[86] = 0;
		Neg[86] = 0.7;
		//Abund[86] = <0.001;
		Props[86] = BLOCK_S | STATE_SOLID | CATEGORY_ALKALI_METAL;

		//Radium
		Z[87] = 88;
		Symbol[87] = "Ra";
		Name[87] = "Radium";
		Group[87] = 2;
		Period[87] = 7;
		Weight[87] = "[226]1";
		Density[87] = 5.5;
		Melt[87] = 973.15;
		Boil[87] = 2010;
		Heat[87] = 0;
		Neg[87] = 0.9;
		//Abund[87] = <0.001;
		Props[87] = BLOCK_S | STATE_SOLID | CATEGORY_ALKALINE_EARTH_METAL;

		//Actinium
		Z[88] = 89;
		Symbol[88] = "Ac";
		Name[88] = "Actinium";
		Group[88] = 2000;
		Period[88] = 7;
		Weight[88] = "[227]1";
		Density[88] = 10.07;
		Melt[88] = 1323.15;
		Boil[88] = 3471;
		Heat[88] = 0.12;
		Neg[88] = 1.1;
		//Abund[88] = <0.001;
		Props[88] = BLOCK_F | STATE_SOLID | CATEGORY_ACTINIDE;

		//Thorium
		Z[89] = 90;
		Symbol[89] = "Th";
		Name[89] = "Thorium";
		Group[89] = 2000;
		Period[89] = 7;
		Weight[89] = "232.03806(2)1 2";
		Density[89] = 11.72;
		Melt[89] = 2028.15;
		Boil[89] = 5061;
		Heat[89] = 0.113;
		Neg[89] = 1.3;
		//Abund[89] = 9.6;
		Props[89] = BLOCK_F | STATE_SOLID | CATEGORY_ACTINIDE;

		//Protactinium
		Z[90] = 91;
		Symbol[90] = "Pa";
		Name[90] = "Protactinium";
		Group[90] = 2000;
		Period[90] = 7;
		Weight[90] = "231.03588(2)1";
		Density[90] = 15.37;
		Melt[90] = 1873.15;
		Boil[90] = 4300;
		Heat[90] = 0;
		Neg[90] = 1.5;
		//Abund[90] = <0.001;
		Props[90] = BLOCK_F | STATE_SOLID | CATEGORY_ACTINIDE;

		//Uranium
		Z[91] = 92;
		Symbol[91] = "U";
		Name[91] = "Uranium";
		Group[91] = 2000;
		Period[91] = 7;
		Weight[91] = "238.02891(3)1";
		Density[91] = 18.95;
		Melt[91] = 1405.15;
		Boil[91] = 4404;
		Heat[91] = 0.116;
		Neg[91] = 1.38;
		//Abund[91] = 2.7;
		Props[91] = BLOCK_F | STATE_SOLID | CATEGORY_ACTINIDE;

		//Neptunium
		Z[92] = 93;
		Symbol[92] = "Np";
		Name[92] = "Neptunium";
		Group[92] = 2000;
		Period[92] = 7;
		Weight[92] = "[237]1";
		Density[92] = 20.45;
		Melt[92] = 913.15;
		Boil[92] = 4273;
		Heat[92] = 0;
		Neg[92] = 1.36;
		//Abund[92] = <0.001;
		Props[92] = BLOCK_F | STATE_SOLID | CATEGORY_ACTINIDE;

		//Plutonium
		Z[93] = 94;
		Symbol[93] = "Pu";
		Name[93] = "Plutonium";
		Group[93] = 2000;
		Period[93] = 7;
		Weight[93] = "[244]1";
		Density[93] = 19.84;
		Melt[93] = 913.15;
		Boil[93] = 3501;
		Heat[93] = 0;
		Neg[93] = 1.28;
		//Abund[93] = <0.001;
		Props[93] = BLOCK_F | STATE_SOLID | CATEGORY_ACTINIDE;

		//Americium
		Z[94] = 95;
		Symbol[94] = "Am";
		Name[94] = "Americium";
		Group[94] = 2000;
		Period[94] = 7;
		Weight[94] = "[243]1";
		Density[94] = 13.69;
		Melt[94] = 1267.15;
		Boil[94] = 2880;
		Heat[94] = 0;
		Neg[94] = 1.3;
		//Abund[94] = 8;
		Props[94] = BLOCK_F | STATE_SOLID | CATEGORY_ACTINIDE;

		//Curium
		Z[95] = 96;
		Symbol[95] = "Cm";
		Name[95] = "Curium";
		Group[95] = 2000;
		Period[95] = 7;
		Weight[95] = "[247]1";
		Density[95] = 13.51;
		Melt[95] = 1340.15;
		Boil[95] = 3383;
		Heat[95] = 0;
		Neg[95] = 1.3;
		//Abund[95] = 0;
		Props[95] = BLOCK_F | STATE_SOLID | CATEGORY_ACTINIDE;

		//Berkelium
		Z[96] = 97;
		Symbol[96] = "Bk";
		Name[96] = "Berkelium";
		Group[96] = 2000;
		Period[96] = 7;
		Weight[96] = "[247]1";
		Density[96] = 14.79;
		Melt[96] = 1259.15;
		Boil[96] = 983;
		Heat[96] = 0;
		Neg[96] = 1.3;
		//Abund[96] = 0;
		Props[96] = BLOCK_F | STATE_SOLID | CATEGORY_ACTINIDE;

		//Californium
		Z[97] = 98;
		Symbol[97] = "Cf";
		Name[97] = "Californium";
		Group[97] = 2000;
		Period[97] = 7;
		Weight[97] = "[251]1";
		Density[97] = 15.1;
		Melt[97] = 1925.15;
		Boil[97] = 1173;
		Heat[97] = 0;
		Neg[97] = 1.3;
		//Abund[97] = 0;
		Props[97] = BLOCK_F | STATE_SOLID | CATEGORY_ACTINIDE;

		//Einsteinium
		Z[98] = 99;
		Symbol[98] = "Es";
		Name[98] = "Einsteinium";
		Group[98] = 2000;
		Period[98] = 7;
		Weight[98] = "[252]1";
		Density[98] = 13.5;
		Melt[98] = 1133.15;
		Boil[98] = 0;
		Heat[98] = 0;
		Neg[98] = 1.3;
		//Abund[98] = 0;
		Props[98] = BLOCK_F | STATE_SOLID | CATEGORY_ACTINIDE;

		//Fermium
		Z[99] = 100;
		Symbol[99] = "Fm";
		Name[99] = "Fermium";
		Group[99] = 2000;
		Period[99] = 7;
		Weight[99] = "[257]1";
		Density[99] = 0;
		Melt[99] = 0;
		Boil[99] = 0;
		Heat[99] = 0;
		Neg[99] = 1.3;
		//Abund[99] = 0;
		Props[99] = BLOCK_F | STATE_SOLID | CATEGORY_ACTINIDE;

		//Mendelevium
		Z[100] = 101;
		Symbol[100] = "Md";
		Name[100] = "Mendelevium";
		Group[100] = 2000;
		Period[100] = 7;
		Weight[100] = "[258]1";
		Density[100] = 0;
		Melt[100] = 0;
		Boil[100] = 0;
		Heat[100] = 0;
		Neg[100] = 1.3;
		//Abund[100] = 0;
		Props[100] = BLOCK_F | STATE_SOLID | CATEGORY_ACTINIDE;

		//Nobelium
		Z[101] = 102;
		Symbol[101] = "No";
		Name[101] = "Nobelium";
		Group[101] = 2000;
		Period[101] = 7;
		Weight[101] = "[259]1";
		Density[101] = 0;
		Melt[101] = 0;
		Boil[101] = 0;
		Heat[101] = 0;
		Neg[101] = 1.3;
		//Abund[101] = 0;
		Props[101] = BLOCK_F | STATE_SOLID | CATEGORY_ACTINIDE;

		//Lawrencium
		Z[102] = 103;
		Symbol[102] = "Lr";
		Name[102] = "Lawrencium";
		Group[102] = 3;
		Period[102] = 7;
		Weight[102] = "[262]1";
		Density[102] = 0;
		Melt[102] = 0;
		Boil[102] = 0;
		Heat[102] = 0;
		Neg[102] = 1.3;
		//Abund[102] = 0;
		Props[102] = BLOCK_D | STATE_SOLID | CATEGORY_ACTINIDE;

		//Rutherfordium
		Z[103] = 104;
		Symbol[103] = "Rf";
		Name[103] = "Rutherfordium";
		Group[103] = 4;
		Period[103] = 7;
		Weight[103] = "[261]1";
		Density[103] = 18.1;
		Melt[103] = 0;
		Boil[103] = 0;
		Heat[103] = 0;
		Neg[103] = 0;
		//Abund[103] = 0;
		Props[103] = BLOCK_D | CATGEORY_TRANSITION_METAL;

		//Dubnium
		Z[104] = 105;
		Symbol[104] = "Db";
		Name[104] = "Dubnium";
		Group[104] = 5;
		Period[104] = 7;
		Weight[104] = "[262]1";
		Density[104] = 39;
		Melt[104] = 0;
		Boil[104] = 0;
		Heat[104] = 0;
		Neg[104] = 0;
		//Abund[104] = 0;
		Props[104] = BLOCK_D | CATGEORY_TRANSITION_METAL;

		//Seaborgium
		Z[105] = 106;
		Symbol[105] = "Sg";
		Name[105] = "Seaborgium";
		Group[105] = 6;
		Period[105] = 7;
		Weight[105] = "[266]1";
		Density[105] = 35;
		Melt[105] = 0;
		Boil[105] = 0;
		Heat[105] = 0;
		Neg[105] = 0;
		//Abund[105] = 0;
		Props[105] = BLOCK_D | CATGEORY_TRANSITION_METAL;

		//Bohrium
		Z[106] = 107;
		Symbol[106] = "Bh";
		Name[106] = "Bohrium";
		Group[106] = 7;
		Period[106] = 7;
		Weight[106] = "[264]1";
		Density[106] = 37;
		Melt[106] = 0;
		Boil[106] = 0;
		Heat[106] = 0;
		Neg[106] = 0;
		//Abund[106] = 0;
		Props[106] = BLOCK_D | CATGEORY_TRANSITION_METAL;

		//Hassium
		Z[107] = 108;
		Symbol[107] = "Hs";
		Name[107] = "Hassium";
		Group[107] = 8;
		Period[107] = 7;
		Weight[107] = "[267]1";
		Density[107] = 41;
		Melt[107] = 0;
		Boil[107] = 0;
		Heat[107] = 0;
		Neg[107] = 0;
		//Abund[107] = 0;
		Props[107] = BLOCK_D | CATGEORY_TRANSITION_METAL;

		//Meitnerium
		Z[108] = 109;
		Symbol[108] = "Mt";
		Name[108] = "Meitnerium";
		Group[108] = 9;
		Period[108] = 7;
		Weight[108] = "[268]1";
		Density[108] = 35;
		Melt[108] = 0;
		Boil[108] = 0;
		Heat[108] = 0;
		Neg[108] = 0;
		//Abund[108] = 0;
		Props[108] = BLOCK_D;

		//Darmstadtium
		Z[109] = 110;
		Symbol[109] = "Ds";
		Name[109] = "Darmstadtium";
		Group[109] = 10;
		Period[109] = 7;
		Weight[109] = "[271]1";
		Density[109] = 0;
		Melt[109] = 0;
		Boil[109] = 0;
		Heat[109] = 0;
		Neg[109] = 0;
		//Abund[109] = 0;
		Props[109] = BLOCK_D;

		//Roentgenium
		Z[110] = 111;
		Symbol[110] = "Rg";
		Name[110] = "Roentgenium";
		Group[110] = 11;
		Period[110] = 7;
		Weight[110] = "[272]1";
		Density[110] = 0;
		Melt[110] = 0;
		Boil[110] = 0;
		Heat[110] = 0;
		Neg[110] = 0;
		//Abund[110] = 0;
		Props[110] = BLOCK_D;

		//Copernicium
		Z[111] = 112;
		Symbol[111] = "Cn";
		Name[111] = "Copernicium";
		Group[111] = 12;
		Period[111] = 7;
		Weight[111] = "[285]1";
		Density[111] = 0;
		Melt[111] = 0;
		Boil[111] = 0;
		Heat[111] = 0;
		Neg[111] = 0;
		//Abund[111] = 0;
		Props[111] = BLOCK_D | CATGEORY_TRANSITION_METAL;

		//Ununtrium
		Z[112] = 113;
		Symbol[112] = "Uut";
		Name[112] = "Ununtrium";
		Group[112] = 13;
		Period[112] = 7;
		Weight[112] = "[284]1";
		Density[112] = 0;
		Melt[112] = 0;
		Boil[112] = 0;
		Heat[112] = 0;
		Neg[112] = 0;
		//Abund[112] = 0;
		Props[112] = BLOCK_P;

		//Ununquadium
		Z[113] = 114;
		Symbol[113] = "Uuq";
		Name[113] = "Ununquadium";
		Group[113] = 14;
		Period[113] = 7;
		Weight[113] = "[289]1";
		Density[113] = 0;
		Melt[113] = 0;
		Boil[113] = 0;
		Heat[113] = 0;
		Neg[113] = 0;
		//Abund[113] = 0;
		Props[113] = BLOCK_P;

		//Ununpentium
		Z[114] = 115;
		Symbol[114] = "Uup";
		Name[114] = "Ununpentium";
		Group[114] = 15;
		Period[114] = 7;
		Weight[114] = "[288]1";
		Density[114] = 0;
		Melt[114] = 0;
		Boil[114] = 0;
		Heat[114] = 0;
		Neg[114] = 0;
		//Abund[114] = 0;
		Props[114] = BLOCK_P;

		//Ununhexium
		Z[115] = 116;
		Symbol[115] = "Uuh";
		Name[115] = "Ununhexium";
		Group[115] = 16;
		Period[115] = 7;
		Weight[115] = "[292]1";
		Density[115] = 0;
		Melt[115] = 0;
		Boil[115] = 0;
		Heat[115] = 0;
		Neg[115] = 0;
		//Abund[115] = 0;
		Props[115] = BLOCK_P;

		//Ununseptium
		Z[116] = 117;
		Symbol[116] = "Uus";
		Name[116] = "Ununseptium";
		Group[116] = 17;
		Period[116] = 7;
		Weight[116] = "[295]1";
		Density[116] = 0;
		Melt[116] = 0;
		Boil[116] = 0;
		Heat[116] = 0;
		Neg[116] = 0;
		//Abund[116] = 0;
		Props[116] = BLOCK_P;

		//Ununoctium
		Z[117] = 118;
		Symbol[117] = "Uuo";
		Name[117] = "Ununoctium";
		Group[117] = 18;
		Period[117] = 7;
		Weight[117] = "[294]1";
		Density[117] = 0;
		Melt[117] = 0;
		Boil[117] = 0;
		Heat[117] = 0;
		Neg[117] = 0;
		//Abund[117] = 0;
		Props[117] = BLOCK_P;
	}
}