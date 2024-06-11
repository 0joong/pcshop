package pcshop.model.product;

import pcshop.model.part.Memory;

public class PC implements Product {
	private String name;
	private Product CPU;
	private Product memory;
	private int price;
	private String description;
	final int productCode;

	//완제품 pc 등록시 사용할 생성자
	public PC(int productCode, String name, Product CPU, Product memory, int price) {
		this.productCode = productCode;
		this.name = name;
		this.CPU = CPU;
		this.memory = memory;
		this.price = price;
	}
	//완제품 pc 등록시 설명도 같이 추가할 시
	public PC(int productCode, String name, Product CPU, Product memory, int price, String description) {
		this.productCode = productCode;
		this.name = name;
		this.CPU = CPU;
		this.memory = memory;
		this.price = price;
		this.description = description;
	}

	//조립 pc 등록시 사용할 생성자, cpu와 메모리의 가격을 합산하여 가격 초기화
	public PC(int productCode, String name, Product CPU, Product memory) {
		this.productCode = productCode;
		this.name = name;
		this.CPU = CPU;
		this.memory = memory;
		this.price = CPU.getPrice()+ memory.getPrice();
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public Product getCPU() {
		return CPU;
	}
	public Product getMemory() {
		return memory;
	}

	public int getPrice() {
		return price;
	}
	@Override
	public int getProductCode() {
		return this.productCode;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setCPU(Product CPU) {
		this.CPU = CPU;
	}
	public void setMemory(Product memory) {
		this.memory = memory;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		if(description.length() != 0){
			return "PC [" + "제품번호 : " + productCode + ", " + name + ", " + "CPU : " + CPU.getName() + ", " +
					"메모리 : " + ((Memory)memory).getCapacity() + "GB, " + "가격 : " + price + "원]\n" + description;
		}else{
			return "PC [" + "제품번호 : " + productCode + ", " + name + ", " + "CPU : " + CPU.getName() + ", " +
					"메모리 : " + ((Memory)memory).getCapacity() + "GB, " + "가격 : " + price + "원]";
		}
	}
}
