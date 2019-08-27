package com.example.model;

import java.io.Serializable;

public class CartLine implements Serializable{
	

	private Item item;
	private int qty;

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	@Override
	public String toString() {
		return "CartLine [item=" + item + ", qty=" + qty + "]";
	}


}
