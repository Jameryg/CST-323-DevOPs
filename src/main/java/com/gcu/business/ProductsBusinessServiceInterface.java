package com.gcu.business;

import java.util.List;

import com.gcu.model.ProductsModel;

public interface ProductsBusinessServiceInterface 
{
	public List<ProductsModel> getProducts();
	public void addProduct(ProductsModel productsModel);
}
