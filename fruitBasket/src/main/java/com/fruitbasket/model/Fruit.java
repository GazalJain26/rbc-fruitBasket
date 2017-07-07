package com.fruitbasket.model;

import com.fruitbasket.constant.FruitType;

public class Fruit {

	private FruitType fruitName;
	private Integer quantity;

	public FruitType getFruitName() {
		return fruitName;
	}

	public void setFruitName(FruitType fruitName) {
		this.fruitName = fruitName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


}
