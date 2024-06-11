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
			"5. 주문"//,
			//"6. 고객센터"
	};
	
	String[] adminMenuList = {
			"0. 종료",
			"1. 완제품 관리",
			"2. 부품 관리",
			"3. 주문 확인",
			"4. 매출 확인"
	};

	String[] partList = {
			"1. CPU",
			"2. MEMORY"
	};

	String[] cpuInformationList = {
			"1. price",
			"2. name",
			"3. core",
			"4. clock"
	};

	String[] memoryInformationList = {
			"1. price",
			"2. name",
			"3. core",
			"4. clock"
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
			case 1 -> viewPCEstimate();//견적pc구매
			case 2 -> viewFinishedPC();//완제품pc구매
			case 3 -> viewCart();//장바구니보기
			case 4 -> resetCart();//리셋카트
			case 5 -> order();//주문
//			case 6 -> adminMode(); admin mode 미완성
			case 0 -> end();
			default -> view.showMessage("잘못된 메뉴 번호입니다.");
			}
		} while (menu != 0);	
	}

	private void adminMode() {
		menu = view.selectMenu(adminMenuList);

		switch (menu) {
			case 1 -> finishedPCManagement();
			case 2 -> partManagement();
			case 3 -> orderConfirmation();
			case 4 -> salesConfirmation();
			case 0 -> end();
			default -> view.showMessage("잘못된 메뉴 번호입니다.");
		}

	}

	private void finishedPCManagement() {
	}

	private void setPartInformation(String str) {
	}

	private void partManagement() {
		int menu = view.selectMenu(partList);

		switch(menu){
			case 1 -> setPartInformation("cpu");
			case 2 -> setPartInformation("memory");
		}

	}

	private void salesConfirmation() {
	}

	private void orderConfirmation() {
	}



	// 완제품 PC 목록
	private void viewFinishedPC() {
		view.displayFinishedPCList(mPCStorage);
		int productCode;

		productCode = view.selectFinishedPC(mPCStorage);

		mCart.addItem(mPCStorage.productCodeToProduct(productCode));

		view.showMessage(">> 선택한 컴퓨터가 성공적으로 추가되었습니다.");
	}

	//견적
	private void viewPCEstimate() {
		Product selectedCPU;
		Product selectedMemory;
		int productCode;

		view.showMessage("중앙처리장치 선택 : ");
		productCode = view.selectParts(mPartStorage, "CPU");
		selectedCPU = mPartStorage.getPartById(productCode);
		mCart.addItem(selectedCPU);

		view.showMessage("메모리 선택 : ");
		productCode = view.selectParts(mPartStorage, "Memory");
		selectedMemory = mPartStorage.getPartById(productCode);
		mCart.addItem(selectedMemory);

		mCart.addItem(new PC(6001, "사용자 정의 PC", selectedCPU, selectedMemory));
		view.displaySelectedPartList(selectedCPU, selectedMemory);//product 가변인자 전달
	}

	private void order(){
		viewCart();
		view.showMessage(mCart.getTotalPrice() + "원이 결제되었습니다.");
		mCart.resetCart();
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
