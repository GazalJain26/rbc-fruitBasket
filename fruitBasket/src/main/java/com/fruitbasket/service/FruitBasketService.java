package com.fruitbasket.service;
/**
 * FruitBasketService to handle all the operation of end user.
 */

import com.fruitbasket.exception.FruitBasketServiceException;
import com.fruitbasket.model.Fruit;

public interface FruitBasketService {
	/**
	 * This method will be used to add fruits into basket
	 * 
	 * @param fruit
	 * @return
	 * @throws ValidationException 
	 */
	public void addtoBasket(Fruit fruit) throws FruitBasketServiceException;

	/**
	 * This method will be used to remove fruits from basket
	 * 
	 * @param fruit
	 * @return
	 */

	public boolean removeFromBasket(Fruit fruit)  throws FruitBasketServiceException;

	/**
	 * This method will be used to calculate bill
	 * 
	 * @return
	 * @throws ValidInputException 
	 */

	public double calculateBill() throws FruitBasketServiceException;

}