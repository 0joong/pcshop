package pcshop.model.product;

public class PC implements Product {
	private String name;
	private Product CPU;
	private Product GPU;
	private Product memory;
	private int price;
	private int productCode;

	public PC(int productCode, String name, Product CPU, Product GPU, Product memory, int price) {
		this.productCode = productCode;
		this.name = name;
		this.CPU = CPU;
		this.GPU = GPU;
		this.memory = memory;
		this.price = price;
	}

	public PC(int productCode, String name, Product CPU, Product memory, int price) {
		this.productCode = productCode;
		this.name = name;
		this.CPU = CPU;
		this.memory = memory;
		this.price = price;
	}

	public PC(int productCode, String name, Product CPU, Product memory) {
		this.productCode = productCode;
		this.name = name;
		this.CPU = CPU;
		this.memory = memory;
	}

	public String getName() {
		return name;
	}

	public Product getCPU() {
		return CPU;
	}

	public Product getGPU() {
		return GPU;
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

	public void setGPU(Product GPU) {
		this.GPU = GPU;
	}

	public void setMemory(Product memory) {
		this.memory = memory;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "PC{" +
				"name='" + name + '\'' +
				", CPU='" + CPU + '\'' +
				", GPU='" + GPU + '\'' +
				", memory='" + memory + '\'' +
				", price=" + price +
				'}';
	}
}
