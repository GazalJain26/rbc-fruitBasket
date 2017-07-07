package com.fruitbasket.service;

import java.util.ArrayList;
import java.util.List;

import com.fruitbasket.constant.FruitBasketConstant;
import com.fruitbasket.exception.FruitBasketServiceException;
import com.fruitbasket.model.Fruit;

public class FruitBasketServiceImpl implements FruitBasketService {
	private  List<Fruit> fruitList = new ArrayList<>();
	String exceptionMsg;

	@Override
	public void addtoBasket(Fruit fruit) throws FruitBasketServiceException {
		if(checkInputObject(fruit)){
			fruitList.add(fruit);
		}
	}

	/**
	 * this method will validate user input
	 * 
	 * @return
	 */
		private boolean checkInputObject(Fruit fruit) throws FruitBasketServiceException {
		boolean flag = false;
		if(fruit==null){
			throw new FruitBasketServiceException(FruitBasketConstant.SELECT_FRUIT);
		}
		else if (fruit.getQuantity() <= 0) {
			throw new FruitBasketServiceException(FruitBasketConstant.WRONG_VALUE);
		} else if (fruit.getFruitName() == null) {
			throw new FruitBasketServiceException(FruitBasketConstant.WRONG_NAME);
		} else {
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean removeFromBasket(Fruit fruit) throws FruitBasketServiceException {
		if (fruit == null || fruitList.size() == 0) {
			throw new FruitBasketServiceException(FruitBasketConstant.SELECT_FRUIT);
		} else {
			return fruitList.remove(fruit);
		}

	}

	@Override
	public double calculateBill() throws FruitBasketServiceException {
		double totalCost = 0.0;
		double ItemCost = 0.0;
		if (fruitList.size() == 0) {
			throw new FruitBasketServiceException(FruitBasketConstant.EMPTY_CART);
		} else {
			for (Fruit fruitItem : fruitList) {
				ItemCost = (fruitItem.getFruitName().getPrice() * fruitItem.getQuantity());
				totalCost = totalCost + ItemCost;
			}
			return totalCost;
		}
	}

}
