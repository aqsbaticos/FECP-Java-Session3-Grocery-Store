package grocery;
import grocery.Grocery;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
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

		String newProduct = "Banana";
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

		products.put("Banana", 5);
		String existingProduct = "Banana";
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

		String newProduct = "Milk";
		int zeroQuantity = 0;

		HashMap<String, Integer> updatedProducts = Grocery.addProduct(newProduct, zeroQuantity, products);

		assertNotNull(updatedProducts);
		assertEquals(1, updatedProducts.size());
		assertTrue(updatedProducts.containsKey(newProduct));
		assertEquals(zeroQuantity, updatedProducts.get(newProduct));

	}

	@org.junit.jupiter.api.Test
	void viewInventory() {
	}

	@org.junit.jupiter.api.Test
	void checkProduct() {
	}

	@org.junit.jupiter.api.Test
	void updateProduct() {
	}

	@org.junit.jupiter.api.Test
	void removeProduct() {
	}
}