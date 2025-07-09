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
	class TestCheckProduct {

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
	}

	@org.junit.jupiter.api.Test
	void updateProduct() {
	}

	@org.junit.jupiter.api.Test
	void removeProduct() {
	}
}