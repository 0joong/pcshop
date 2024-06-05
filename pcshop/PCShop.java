package pcshop;

import java.io.IOException;

import pcshop.controller.PCShopController;
import pcshop.model.PCStorage;
import pcshop.model.Cart;
import pcshop.model.PartStorage;
import pcshop.view.ConsoleView;

public class PCShop {
	public static void main(String[] args) throws IOException {
		// model 생성
		PCStorage PCStorage = new PCStorage();//완제품 PC 저장 모델
		PartStorage partStorage = new PartStorage();//PC 부품 저장 모델
		Cart cart = new Cart();
		
		// view 생성
		ConsoleView view = new ConsoleView();
		
		// controller 생성 (model, view)
		PCShopController controller = new PCShopController(PCStorage, partStorage, cart, view);
		controller.start();
		
		
	}

}
