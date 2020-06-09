// Object in which orders are saved
// TODO uredi getters in setters

package com.andrej.test.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.andrej.test.listener.NewOrderListener;
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

@EntityListeners(NewOrderListener.class)
@Entity(name="order_test")
@Table(name="order_test")
public class OrderEntity implements Serializable{
    
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
	
	@Column(name="status", columnDefinition="tinyint default 0")
	private int status;
	
	@Column(columnDefinition="date")
	private LocalDate order_date;

	public LocalDate getOrder_date() {
		return order_date;
	}

	public void setOrder_date(LocalDate order_date) {
		this.order_date = order_date;
	}
	
	@OneToMany(cascade=CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name="orderid")
    @JsonProperty("bottle")
    private List<BottleEntity> bottle;

	@Transient
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("bottle")
    public List<BottleEntity> getBottle() {
    	return bottle;
    }

    @JsonProperty("bottle")
    public void setBottle(List<BottleEntity> bottle) {
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
