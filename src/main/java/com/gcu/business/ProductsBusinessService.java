package com.gcu.business;

import java.util.ArrayList; 
import java.util.List;

import com.gcu.model.OrderModel;
import com.gcu.model.ProductsModel;

public class ProductsBusinessService implements ProductsBusinessServiceInterface
{
	// The list of products
	List<ProductsModel> products;
	
	public ProductsBusinessService() 
	{
		this.products = new ArrayList<ProductsModel>();
	}
	
	public List<ProductsModel> getProducts() 
	{
		// Return the list of products 
		return products;
	}
	
	public void addProduct(ProductsModel productsModel)
	{
		// Adds a product to the list
		products.add(new ProductsModel(productsModel.getJpgImage(), productsModel.getTapeMeasureLength(), productsModel.getTMMU(), productsModel.getTapeWeight(), productsModel.getTapeDescription()));
	}
}
