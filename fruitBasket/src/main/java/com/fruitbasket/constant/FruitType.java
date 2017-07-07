package com.fruitbasket.constant;

public enum FruitType {

	BANANA(10), ORANGES(20), APPLES(10), LEMONS(20), PEACHES(20);

	private int price;

	FruitType(int price) {
		this.price = price;
	}

	public int getPrice() {
		return price;
	}

}
