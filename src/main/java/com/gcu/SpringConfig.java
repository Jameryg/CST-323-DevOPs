package com.gcu;

import org.springframework.context.annotation.Bean;
//Preconceived imports
import org.springframework.context.annotation.Configuration;

import com.gcu.business.LoginBusinessService;
//Custom imports 
import com.gcu.business.OrdersBusinessService;
import com.gcu.business.OrdersBusinessServiceInterface;
import com.gcu.business.ProductsBusinessService;
import com.gcu.business.ProductsBusinessServiceInterface;

@Configuration 
public class SpringConfig
{
	// Bean annotation is applied at the method level 
	@Bean(name="ordersBusinessService", initMethod="init", destroyMethod="destroy")
	public OrdersBusinessServiceInterface getOrdersBusiness()
	{
		// Returns defines which java class is invoked 
		// that implements the OrdersBusinessServiceInterface
		return new OrdersBusinessService();
	}
	
	@Bean(name="productsBusinessService")
	public ProductsBusinessServiceInterface getProductsBusiness()
	{
		return new ProductsBusinessService();
	}
	
	@Bean(name="loginBusinessService")
	public LoginBusinessService getLoginBusiness()
	{
		return new LoginBusinessService();
	}
}