package com.andrej.NFwebapp.repository;

import java.util.Arrays;
import java.util.List;

public class Ddmenu {
	private List<String> aromeMenu = Arrays.asList("Apple (Double)",
			"Apple Pie",
			"Apricot",
			"Banana",
			"Blackberry",
			"Blackcurrant",
			"Blueberry",
			"Bubblegum",
			"Cappuccino",
			"Cheesecake (Graham Crust)",
			"Cinnamon Roll",
			"Citrus Mix",
			"Coconut",
			"Cola",
			"Double Chocolate",
			"Dragonfruit",
			"Energy Drink",
			"Forest Fruit",
			"Glazed Doughnut",
			"Grapefruit",
			"Grapes",
			"Greek Yogurt",
			"Green Tea",
			"Heisenberg",
			"Juicy Peach",
			"Kiwi",
			"Lemon Lime",
			"Lemon Sicily",
			"Vanilla Classic",
			"Mango",
			"Marshmallow",
			"Melon",
			"Orange",
			"Orange Creamsicle",
			"Peanut Butter Cup",
			"Pear",
			"Pear Drops",
			"Pina Colada",
			"Pineapple",
			"Pinkman",
			"Raspberry",
			"Rum",
			"Spearmint",
			"Strawberry",
			"Vanilla Bean Ice Cream",
			"Vanilla Custard",
			"Vanilla Swirl",
			"Wild Cherry",
			"Grape Soda",
			"Tangerine",
			"Juicy Lemon",
			"Sweet Tea",
			"Tiger's Blood",
			"Pink Lemonade",
			"Blue Custard",
			"Red Custard",
			"Black Custard",
			"Apri Custard",
			"Trojanc",
			"Pita",
			"Tropic Mix",
			"Summer Breeze",
			"Cherry Coke",
			"Glass Apple",
			"Bounty",
			"Paradise Punch",
			"Grapple",
			"Melon Grejp",
			"NF Jogurt",
			"Lime Pie",
			"Peach Jogurt",
			"Peachream",
			"Lemonade",
			"Yucatan",
			"Bluepear",
			"Synergy",
			"Peach Ice Tea",
			"Unicorn Milk",
			"Bad Drip",
			"Kanzi");
	
	private List<String> nicMenu = Arrays.asList("0","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15");
	
	public void addAroma(String aroma) {
		aromeMenu.add(aroma);
	}
	public List<String> getArome() {
		return aromeMenu;
	}
	
	public void addNic(String nic) {
		nicMenu.add(nic);
	}
	
	public List<String> getNic() {
		return nicMenu;
	}
}
