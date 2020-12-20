package com.company.products;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.company.products.entites.Products;
import com.company.products.repository.ProductInterface;

@SpringBootTest
class OnlineShoppingApplicationTests {
//
//	@Test
//	void contextLoads() {
//	}
	@Autowired
	private ProductInterface productReporsitory;
	
	@Test
	public void testCreateCart()
	{
		Products product = new Products();
		
		product.setTitle("Airdops");
		product.setCategory("Electronics");
		product.setDescription("Wireless ... Headset for users.");
		product.setPrice(3999.00);
		product.setImage("https://cdn.shopify.com/s/files/1/0057/8938/4802/products/boat-airdopes-131-pink.jpg?v=1607576945");
		productReporsitory.save(product);
		
	}
	
	@Test
	public void testFindCartById()
	{
		Products product = productReporsitory.findById(7).get();
		System.out.println(product);
	}

	@Test
	public void testUpdateCart()
	{
		Products product = productReporsitory.findById(7).get();
		product.setPrice(4050.00);		
		System.out.println(product);
		productReporsitory.save(product);
	}
	
	@Test
	public void testDeleteCartDetails()
	{
		Products product = new Products();
		product.setId(7);	
		productReporsitory.delete(product);
		System.out.println(product);
	}
}
