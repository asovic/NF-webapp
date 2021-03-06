package com.andrej.NFwebapp.entities;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"aroma",
"nic"
})

@Entity(name = "bottle")
@Table(name = "bottle")
public class BottleEntity {
	
    @Id
    @GeneratedValue
    private Long id;

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	private Long orderid;

	@JsonProperty("aroma")
    private String aroma;
    
    @JsonProperty("nic")
    private String nic;
    
    @Transient
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("aroma")
    public String getAroma() {
    	return aroma;
    }

    @JsonProperty("aroma")
    public void setAroma(String aroma) {
    	this.aroma = aroma;
    }

    @JsonProperty("nic")
    public String getNic() {
    	return nic;
    }

    @JsonProperty("nic")
    public void setNic(String nic) {
    	this.nic = nic;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
    	return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
    	this.additionalProperties.put(name, value);
    }

	public Long getOrder_id() {
		return orderid;
	}

}
