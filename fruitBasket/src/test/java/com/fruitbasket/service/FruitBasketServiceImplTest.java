package com.fruitbasket.service;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.fruitbasket.constant.FruitType;
import com.fruitbasket.exception.FruitBasketServiceException;
import com.fruitbasket.model.Fruit;

public class FruitBasketServiceImplTest {
	
	private Fruit fruit;
	private FruitBasketService fruitBasketService;
	
	@Before
	public void initializer(){
		fruitBasketService = new FruitBasketServiceImpl();
		
	}
	
	@Test
	public void addFruitsIntoBasket() throws FruitBasketServiceException{
		Fruit fruit = prepareFruitObj();
		fruitBasketService.addtoBasket(fruit);
	}
	
	
	
	@Test(expected=FruitBasketServiceException.class)
	public void shoudthrowexceptionIfFruitNameIsNull() throws FruitBasketServiceException{
		Fruit fruit = prepareFruitObj();
		fruit.setFruitName(null);
		fruitBasketService.addtoBasket(fruit);
		
	}
	
	@Test(expected=FruitBasketServiceException.class)
	public void shoudthrowexceptionIfQuantityIsNegative() throws FruitBasketServiceException{
		fruit = prepareFruitObj();
		fruit.setQuantity(-1);
		fruitBasketService.addtoBasket(fruit);
	}
	
	
	@Test(expected=FruitBasketServiceException.class)
	public void shoudthrowexceptionIffruitObjIsNull() throws FruitBasketServiceException{
		Fruit fruit=null;
		fruitBasketService.addtoBasket(fruit);
	}
	
	@Test
	public void shouldRemoveFromBasket() throws FruitBasketServiceException{
		fruit = prepareFruitObj();
		fruitBasketService.addtoBasket(fruit);
		assertTrue(fruitBasketService.removeFromBasket(fruit));
	}
	
	@Test
	public void getTotalPrice() throws FruitBasketServiceException{
		Fruit fruit2 = new Fruit();
		fruit2.setFruitName(FruitType.ORANGES);
		fruit2.setQuantity(10);
		 fruit = prepareFruitObj();
		fruitBasketService.addtoBasket(fruit);
		fruitBasketService.addtoBasket(fruit2);
		assertTrue(300.0==fruitBasketService.calculateBill());
	}

	
	@Test(expected = FruitBasketServiceException.class)
	public void shouldThrowExceptionIfBasketIsEmpty() throws FruitBasketServiceException{
		Fruit fruit = prepareFruitObj();
		fruitBasketService.addtoBasket(fruit);
		fruitBasketService.removeFromBasket(fruit);
		fruitBasketService.calculateBill();
	}

	
	private Fruit prepareFruitObj(){
		 Fruit fruit = new Fruit();
		fruit.setFruitName(FruitType.APPLES);
		fruit.setQuantity(10);
		return fruit;
	}
}
