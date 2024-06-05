package pcshop.view;

import java.util.Scanner;

import pcshop.model.Cart;
import pcshop.model.Customer;
import pcshop.model.PCStorage;
import pcshop.model.PartStorage;
import pcshop.model.part.CPU;
import pcshop.model.part.GPU;
import pcshop.model.part.Memory;
import pcshop.model.product.Parts;
import pcshop.model.product.Product;

public class ConsoleView {

	// 환영 인사 출력
	public void displayWelcome() {
		String welcome = "*****************************************\n"
				       + "*     Welcome to Young Joong PCShop     *\n"
				       + "*****************************************";
		System.out.println(welcome);	
	}

	// 메뉴 번호 입력 받기
	public int selectMenu(String[] menuList) {
		
		displayMenu(menuList);
		
		int menu;
		do {
			menu = readNumber(">> 메뉴 선택 : ");	
			if (menu < 0 || menu >= menuList.length)
				System.out.println("0부터 " + (menuList.length-1) + "까지의 숫자를 입력하세요.");
		} while (menu < 0 || menu >= menuList.length);
		return menu;
	}

	// 메뉴 출력
	private void displayMenu(String[] menuList) {
		System.out.println("=========================================");
		for (int i = 1; i < menuList.length; i++) {
			System.out.println(menuList[i]);
		}
		System.out.println(menuList[0]);
		System.out.println("=========================================");
	}
	
	
	// 장바구니 보여주기
	public void displayCart(Cart cart) {
		for(int i = 0; i < cart.getNumItems() ; i++)
			System.out.println(cart.getItemList().get(i).toString());
		System.out.println(cart.getTotalPrice());
	}
	
	/////////////////////  공용 모듈 ////////////////////////
	
	// 입력된 문자열을 입력했을 때만 true를 반환하는 confirm용
	public boolean askConfirm(String message, String yes) {
		
		System.out.print(message);
		
		Scanner input = new Scanner(System.in);
		if (input.nextLine().equals(yes)) return true;
		return false;
		
	}
	
	// 숫자 입력 받기 (숫자가 아닌 문자를 넣으면 예외 처리하고 다시 입력받기)
	public int readNumber(String message) {
		if (message != null || !message.equals(""))
			System.out.print(message);
		
		Scanner input = new Scanner(System.in);
		try {
			int number = input.nextInt();
			return number;
		} catch (Exception e) {
			System.out.print("숫자를 입력하세요 :");
			return readNumber(message);
		}
	}
	// 입력된 문자열 출력
	public void showMessage(String message) {
		System.out.println(message);
	}
	// 문자열 입력 받기
	public String inputString(String msg) {
		Scanner in = new Scanner(System.in);
		System.out.print(msg);
		return in.nextLine();
	}

	public void displayFinishedPCList(PCStorage pc) {
			StringBuilder list = new StringBuilder();
			for(Object p : pc.getPCList()){
				list.append(p.toString()).append("\n");
			}
			System.out.println(list);
	}

	public void displayPartsSelectMenu(PartStorage partStorage, String product) {
		System.out.println("PC견적 부품 선택");
		System.out.println(product + "선택");
		selectParts(partStorage, product);
	}

	public int selectParts(PartStorage partStorage, String parts) {
		showPartsList(parts, partStorage);
		int partsCode = readNumber(">> " + parts + "productcode 입력 : ");

		return partsCode;
	}

	public void showPartsList(String product, PartStorage partStorage){
		if(product.equalsIgnoreCase("cpu")){
			for(Parts p : partStorage.getPartList())
				if(p instanceof CPU)
					System.out.println(p);
		}else if(product.equalsIgnoreCase("memory")){
			for(Parts p : partStorage.getPartList())
				if(p instanceof Memory)
					System.out.println(p);
		}else if(product.equalsIgnoreCase("gpu")){
			for(Parts p : partStorage.getPartList())
				if(p instanceof GPU)
					System.out.println(p);
		}
	}

//	public void displaySelectedPartList(Product cpu, Product memory) {
//		showMessage("선택된 CPU : ");
//		showMessage(cpu.toString());
//		showMessage("선택된 memory : ");
//		showMessage(memory.toString());
//	}
	public void displaySelectedPartList(Product... products) {
		for(Product p : products)
			showMessage(p.toString());
//		showMessage("선택된 CPU : ");
//		showMessage(cpu.toString());
//		showMessage("선택된 memory : ");
//		showMessage(memory.toString());
	}
}