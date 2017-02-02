package com.mhk.poc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ITEM")
public class Item {
	
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Long id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="QUANTITY")
	private Integer quantity;
	
	@ManyToOne
	@JoinColumn(name="cart_id")
	private Cart itemCart;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Cart getItemCart() {
		return itemCart;
	}
	public void setItemCart(Cart itemCart) {
		this.itemCart = itemCart;
	}
	
	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", quantity=" + quantity + "]";
	}
}
