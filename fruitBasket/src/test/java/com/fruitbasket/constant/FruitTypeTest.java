package com.fruitbasket.constant;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FruitTypeTest {

	@Test
	public void checFruitPriceByFruitName() {
		FruitType fruitName = FruitType.valueOf("APPLES");
		assertEquals(fruitName.getPrice(),10);
	}

	@Test
	public void checkEnumValue() {
		assertEquals("APPLES", FruitType.APPLES.name());
	}

}
