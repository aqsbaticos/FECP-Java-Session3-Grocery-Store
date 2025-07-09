package grocery;
import grocery.Grocery;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

class GroceryTest {

	private HashMap<String, Integer> products;

	@BeforeEach
	void setup() {
		this.products = new HashMap<>();
	}

	@Test
	void addProduct_addNewProductValidQuantity() {

		String newProduct = "banana";
		int quantity = 30;

		HashMap<String, Integer> updatedProducts = Grocery.addProduct(newProduct, quantity, products);

		//	Assertions
		assertNotNull(updatedProducts);
		assertEquals(1, updatedProducts.size());
		assertTrue(updatedProducts.containsKey(newProduct));
		assertEquals(quantity, updatedProducts.get(newProduct));
		assertEquals(products, updatedProducts);

	}

	@Test
	void addProduct_updateExistingProductQuantity() {

		products.put("banana", 5);
		String existingProduct = "banana";
		int newQuantity = 12;

		HashMap<String, Integer> updatedProducts = Grocery.addProduct(existingProduct, newQuantity, products);

		assertNotNull(updatedProducts);
		assertEquals(1, updatedProducts.size());
		assertTrue(updatedProducts.containsKey(existingProduct));
		assertEquals(newQuantity, updatedProducts.get(existingProduct));
		assertEquals(products, updatedProducts);

	}

	@Test
	void addProduct_addZeroQuantity() {

		String newProduct = "milk";
		int zeroQuantity = 0;

		HashMap<String, Integer> updatedProducts = Grocery.addProduct(newProduct, zeroQuantity, products);

		assertNotNull(updatedProducts);
		assertEquals(1, updatedProducts.size());
		assertTrue(updatedProducts.containsKey(newProduct));
		assertEquals(zeroQuantity, updatedProducts.get(newProduct));

	}

	@Nested
	class TestCheckUpdateProduct {

		@BeforeEach
		void populate() {
			products.put("apple", 10);
			products.put("banana", 5);
			products.put("orange", 0);		//	0
		}

		@Test
		void checkProduct_existingProductPositiveStock() {

			String productKey = "apple";
			String expected = "    APPLE IN STOCK: 10";

			String result = Grocery.checkProduct(productKey, products);

			assertEquals(expected, result);
		}

		@Test
		void checkProduct_existingProductZeroStock() {

			String productKey = "orange";
			String expected = "    ORANGE IN STOCK: 0";

			String result = Grocery.checkProduct(productKey, products);

			assertEquals(expected, result);
		}

		@Test
		void checkProduct_nonExistingProduct() {

			String productKey = "grape";
			String expected = "";

			String result = Grocery.checkProduct(productKey, products);

			assertEquals(expected, result);

		}

		@Test
		void updateProduct_existingProductPositiveQuantity() {

			String productKey = "apple";
			int newQuantity = 15;
			int initialSize = products.size();

			HashMap<String, Integer> updatedProducts = Grocery.updateProduct(productKey, newQuantity, products);

			//	Assertions
			assertNotNull(updatedProducts);
			assertEquals(initialSize, updatedProducts.size());
			assertTrue(updatedProducts.containsKey(productKey));
			assertEquals(newQuantity, updatedProducts.get(productKey));
			assertEquals(products, updatedProducts);

		}

		@Test
		void updateProduct_existingProductZeroQuantity() {

			String productKey = "banana";
			int newQuantity = 0;
			int initialSize = products.size();

			HashMap<String, Integer> updatedProducts = Grocery.updateProduct(productKey, newQuantity, products); // Call Grocery.updateProduct

			// Assertions
			assertEquals(initialSize, updatedProducts.size());
			assertEquals(newQuantity, updatedProducts.get(productKey));

		}

		@Test
		void updateProduct_addNewProduct() {

			String newProductKey = "grapes";
			int newQuantity = 20;
			int initialSize = products.size();

			HashMap<String, Integer> updatedProducts = Grocery.updateProduct(newProductKey, newQuantity, products);

			// Assertions
			assertEquals(initialSize, updatedProducts.size(), "HashMap size should not increase by one.");
			assertFalse(updatedProducts.containsKey(newProductKey), "HashMap should not contain the product updated.");

		}

	}

	@org.junit.jupiter.api.Test
	void removeProduct() {
	}
}