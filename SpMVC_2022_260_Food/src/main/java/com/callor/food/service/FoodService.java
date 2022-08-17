package com.callor.food.service;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.List;

import com.callor.food.model.FoodItem;

public interface FoodService {
	public String queryString(String search) throws UnsupportedEncodingException;

	public List<FoodItem> getFoodItems(String queryString) throws URISyntaxException;
}
