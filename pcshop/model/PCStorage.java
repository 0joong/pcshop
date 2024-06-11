package pcshop.model;

import pcshop.model.part.CPU;
import pcshop.model.part.Memory;
import pcshop.model.product.PC;
import pcshop.model.product.Product;
import java.io.IOException;
import java.util.ArrayList;

public class PCStorage {
	ArrayList<PC> pcList = new ArrayList<>();

	{
		addPC(9001, "사무용 컴퓨터", new CPU(1001, 120000, "I3-12100", 4, 3.1),
				new Memory(2001, 100000, "삼성 메모리", "DDR5", 16), 1000000, "사무용 컴퓨터입니다.");

		addPC(9002, "평범한 컴퓨터", new CPU(1003, 210000, "I3-12500", 6, 3.5),
				new Memory(2001, 100000, "삼성 메모리", "DDR5", 16), 2000000, "평범한 컴퓨터입니다.");

		addPC(9003, "고사양 컴퓨터", new CPU(1005, 390000, "I3-12900", 12, 4.7),
				new Memory(2001, 100000, "삼성 메모리", "DDR5", 16), 3000000, "성능이 매우 좋은 고성능 게이밍 컴퓨터입니다.");
	}

	public ArrayList getPCList(){
		return pcList;
	}

	public PCStorage() throws IOException {

	}
	public Product productCodeToProduct(int productCode){
		for(int i = 0; i < pcList.size(); i++)
			if(pcList.get(i).getProductCode() == productCode)
				return pcList.get(i);
		return null;
	}
	
	public int getNumPC() {
		return pcList.size();
	}

	public String getPCinfo(int i) {
		return pcList.get(i).toString();
	}

	//productcode로 유효한 pc인지 검사
	public boolean isValidPC(int productCode) {
		for (PC p : pcList) {
			if (p.getProductCode() == productCode) return true;
		}
		return false;
	}

	//pc객체로 유효한 pc인지 검사
	public boolean isValidPC(Product pc){
		int productCodeOfPC = pc.getProductCode();

		for(PC code : pcList){
			if(code.getProductCode() == productCodeOfPC){
				return true;
			}
		}
		return false;
	}

	public boolean isEmpty() {
		return pcList.size() == 0;
	}

	public void addPC(int productCode, String name, Product CPU, Product memory, int price) {

		PC pc = new PC(productCode, name, CPU, memory, price);
		pcList.add(pc);
	}
	public void addPC(int productCode, String name, Product CPU, Product memory, int price, String description) {

		PC pc = new PC(productCode, name, CPU, memory, price, description);
		pcList.add(pc);
	}

	public StringBuilder getPClist() {
		StringBuilder list = new StringBuilder();
		for(PC pc : pcList){
			list.append(pc.toString()).append("\n");
		}

		return list;
	}
}
