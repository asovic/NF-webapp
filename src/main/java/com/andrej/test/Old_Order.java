package com.andrej.test;

import java.util.List;
import java.util.Map;

public class Old_Order {
	
	private List<String> aroma;
	private List<String> nic;
	private String datum;
	private String username;
	
	@SuppressWarnings("unchecked")
	public Old_Order(List<Map<String, Object>> input) {
		super();
		for (Map<String, Object> bottle_list : input) {
		    for (Map.Entry<String, Object> bottle : bottle_list.entrySet()) {
		    	if (bottle.getKey().equals("aroma")) {
		    		this.aroma = (List<String>) bottle.getValue();
		    	} else {
		    		this.nic = (List<String>) bottle.getValue();
		    	}
		    }
		}

	}
	public List<String> getAroma() {
		return aroma;
	}
	public void setAroma(List<String> aroma) {
		this.aroma = aroma;
	}
	public List<String> getNic() {
		return nic;
	}
	public void setNic(List<String> nic) {
		this.nic = nic;
	}
	public String getDatum() {
		return datum;
	}
	public void setDatum(String string) {
		this.datum = string;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
}