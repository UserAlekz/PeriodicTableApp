#!/usr/bin/perl

# this script is used to generate most of PeriodicTableData.java

%props = (
	'Gas' => "STATE_GAS",
	'Liquid' => "STATE_LIQUID",
	'Solid' => "STATE_SOLID",
	's' => "BLOCK_S",
	'p' => "BLOCK_P",
	'd' => "BLOCK_D",
	'f' => "BLOCK_F",
	'Non-metal' => "CATEGORY_NONMETAL",
	'Noble gas' => "CATEGORY_NOBEL_GAS",
	'Alkali metal' => "CATEGORY_ALKALI_METAL",
	'Alkaline earth metal' => "CATEGORY_ALKALINE_EARTH_METAL",
	'Metalloid' => "CATEGORY_METALLOID",
	'Lanthanide' => "CATEGORY_LANTHANIDE",
	'Actinide' => "CATEGORY_ACTINIDE",
	'Halogen' => "CATEGORY_HALOGEN",
	'Metal' => "CATEGORY_METAL",
	'Transition metal' => "CATGEORY_TRANSITION_METAL",
);

$id = 0;
while($line = <STDIN>)
{
	chomp($line);
	@data = split(/,/, $line);
	#Z	Sym	Name	Grp	Prd	Weight	Density	Melt	Boil	Heat	Neg	Abund	Block	State at STP	Occurrence	Description
	print "\r\n	//@data[2]\r\n";
	print "	Z[$id] = @data[0];\r\n";
	print "	Symbol[$id] = \"@data[1]\";\r\n";
	print "	Name[$id] = \"@data[2]\";\r\n";
	print "	Group[$id] = @data[3];\r\n";
	print "	Period[$id] = @data[4];\r\n";
	print "	Weight[$id] = \"@data[5]\";\r\n";
	print "	Density[$id] = @data[6];\r\n";
	print "	Melt[$id] = @data[7];\r\n";
	print "	Boil[$id] = @data[8];\r\n";
	print "	Heat[$id] = @data[9];\r\n";
	print "	Neg[$id] = @data[10];\r\n";
	print "	//Abund[$id] = @data[11];\r\n";
	print "	Props[$id] = @props{@data[12]} | @props{@data[13]} | @props{@data[15]};\r\n";
	$id++;
}
