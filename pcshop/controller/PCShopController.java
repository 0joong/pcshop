package pcshop.controller;

import pcshop.model.*;
import pcshop.model.product.PC;
import pcshop.model.product.Product;
import pcshop.view.ConsoleView;

public class PCShopController {

	ConsoleView view;
	PCStorage mPCStorage;
	PartStorage mPartStorage;
	Cart mCart;
	Customer mCustomer;
	Admin mAdmin;
	
	String[] menuList = {
			"0. 종료",
			"1. PC 견적",
			"2. 완제품 PC",
			"3. 장바구니 보기",
			"4. 장바구니 비우기",
			"5. 주문",
			"6. 고객센터"
	};
	
	String[] adminMenuList = {
			"0. 종료",
			"1. 판매 제품 관리",
			"2. 주문 확인",
			"3. 매출 확인"
	};
	
	public PCShopController(PCStorage PCStorage, PartStorage partStorage, Cart cart, ConsoleView view) {
		mPartStorage = partStorage;
		this.view = view;
		mPCStorage = PCStorage;
		mCart = cart;
		mAdmin = new Admin();
	}

	public void start() {
		welcome();
//		registerCustomerInfo();
		
		int menu;
		
		do {
			menu = view.selectMenu(menuList);
			
			switch (menu) {
			case 1 -> viewPCEstimate();
			case 2 -> viewFinishedPC();
			case 3 -> viewCart();
			case 4 -> resetCart();
//			case 5 -> order();
//			case 6 -> adminMode();
			case 0 -> end();
			default -> view.showMessage("잘못된 메뉴 번호입니다.");
			}
		} while (menu != 0);	
	}

	// 완제품 PC 목록
	private void viewFinishedPC() {
		view.displayFinishedPCList(mPCStorage);
	}

	private void viewPCEstimate() {
		Product cpu;
		Product memory;
		int productCode;

		view.showMessage("cpu 선택 : ");
		productCode = view.selectParts(mPartStorage, "CPU");
		cpu = mPartStorage.getPartById(productCode);
		mCart.addItem(cpu);

		view.showMessage("memory 선택 : ");
		productCode = view.selectParts(mPartStorage, "Memory");
		memory = mPartStorage.getPartById(productCode);
		mCart.addItem(memory);

		mCart.addItem(new PC(1, "사용자정의PC", cpu, memory));
		view.displaySelectedPartList(cpu, memory);//product 가변인자 전달
	}


	// 환영 인사
	private void welcome() {
		view.displayWelcome();
	}

	
	// 장바구니 보기
	private void viewCart() {
		view.displayCart(mCart);
	}

	// 장바구니 비우기
	private void resetCart() {
		view.displayCart(mCart);
		
		if (!mCart.isEmpty()) {
			if (view.askConfirm(">> 장바구니를 비우려면 yes를 입력하세요 : ", "yes")) {
				mCart.resetCart();
				view.showMessage(">> 장바구니를 비웠습니다.");
			}
		}
	}
	
	int menu;
	// 종료
	private void end() {
		view.showMessage(">> Young Joong PCSHOP을 종료합니다.");
	}
}
