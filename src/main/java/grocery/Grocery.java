package grocery;

//	--	IMPORTS
import java.util.HashMap;
import java.util.Scanner;


public class Grocery {

	static Scanner in = new Scanner(System.in);

	//	--	MAIN PROGRAM
	public static void main(String[] args) {

		//	Initializations
		HashMap<String, Integer> products = new HashMap<>();

		String menuChoice = ""; boolean isRunning = true;
		while(isRunning) {
			clearScreen();
			printStore();
			System.out.print("\uD83C\uDFEA :: ");
			menuChoice = in.next();
			switch(menuChoice) {
				case "1":
					viewInventory(products);
					break;
				case "2":
					break;
				case "3":
					break;
				case "4":
					break;
				case "5":
					break;
				case "0":
					System.out.println("\uD83C\uDFEA :: Adios!");
					isRunning = false;
					break;
				default:
					break;
			}
		}
 	}

	//	STORE METHODS
	public static HashMap<String, Integer> addProduct(String product, int quantity, HashMap<String, Integer> products) {
		return products;
	}

	public static void viewInventory(HashMap<String, Integer> products) {
		in.nextLine();
		clearScreen();
		System.out.println("╔═══════════════════════════════════════════════════════╗");
		System.out.println("║                     \uD83D\uDCCB  Inventory  \uD83D\uDCCB                   ║");
		if (products.isEmpty()) {
			System.out.println("╠═══════════════════════════════════════════════════════╣");
			System.out.println("║   No products found in your inventory.                ║");
		} else {
			System.out.println("╠═════════════════════════════════════════╦═════════════╣");
			System.out.println("║   Product Name                          ║   Stock     ║");
			products.forEach((name, qty) -> {
				System.out.println("║   " + name + "\t" + qty);
			});
		}
		System.out.println("╠═══════════════════════════════════════════════════════╣");
		System.out.println("╚═══════════════════════════════════════════════════════╝");
		System.out.print("Press ENTER to continue..."); String enter = "";
		in.nextLine();
	}

	public static String checkProduct(String key, HashMap<String, Integer> products) {
		return "";
	}

	public static HashMap<String, Integer> updateProduct(String key, int newQuantity, HashMap<String, Integer> products) {
		return products;
	}

	public static HashMap<String, Integer> removeProduct(String key, HashMap<String, Integer> products) {
		return products;
	}

	//	CLASS METHODS
	public static void printStore() {
		System.out.println("╔═══════════════════════════════════════════════════════╗");
		System.out.println("║          \uD83C\uDFEA  GCash Sari-Sari Store Management  \uD83C\uDFEA       ║");
		System.out.println("╠═══════════════════════════════════════════════════════╣");
		System.out.println("║                                                       ║");
		System.out.println("║   [1] View Inventory                                  ║");
		System.out.println("║   [2] Add Product                                     ║");
		System.out.println("║   [3] Check Product                                   ║");
		System.out.println("║   [4] Update Stock                                    ║");
		System.out.println("║   [5] Remove Product                                  ║");
		System.out.println("║   [0] Exit                                            ║");
		System.out.println("║                                                       ║");
		System.out.println("╠═══════════════════════════════════════════════════════╣");
		System.out.println("╚═══════════════════════════════════════════════════════╝");
	}

	public static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

}