package com.andrej.test;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
"bottle"
})

@Entity(name="order_test")
@Table(name="order_test")
public class Order implements Serializable{
    
	private static final long serialVersionUID = 8994124296617397940L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="username")
	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	@Column(columnDefinition="date")
	LocalDate order_date = LocalDate.now();

	public LocalDate getOrder_date() {
		return order_date;
	}

	public void setOrder_date(LocalDate order_date) {
		this.order_date = order_date;
	}
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="order_id")
    @JsonProperty("bottle")
    private List<Bottle> bottle;

	@Transient
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("bottle")
    public List<Bottle> getBottle() {
    	return bottle;
    }

    @JsonProperty("bottle")
    public void setBottle(List<Bottle> bottle) {
    	this.bottle = bottle;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
    	return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
    	this.additionalProperties.put(name, value);
    }

}
