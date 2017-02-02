package com.mhk.poc.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="cart")
public class Cart {
	
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Long id;
	
	@Column(name="NAME")
	private String name;
	
	@OneToMany(mappedBy="itemCart") // "itemCart" is referenced from Item class.
	// cascade=CascadeType.ALL is not yet all required as we should save child and parent objects separately.
	private Set<Item> items = new HashSet<Item>();
	
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
	public Set<Item> getItems() {
		return items;
	}
	public void setItems(Set<Item> items) {
		this.items = items;
	}
	
	@Override
	public String toString() {
		return "Cart [id=" + id + ", name=" + name + ", items=" + items + "]";
	}
}
