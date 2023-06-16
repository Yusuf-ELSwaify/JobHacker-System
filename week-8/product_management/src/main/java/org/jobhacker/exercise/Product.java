package org.jobhacker.exercise;

import lombok.Value;

@Value
public class Product {
	int productId;
	String productName;
	String category;
	double price;

	public Product withPrice(double price) {
		if (this.price == price)
			return this;
		else
			return new Product(productId, productName, category, price);
	}
}
