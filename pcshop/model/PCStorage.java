package pcshop.model;

import pcshop.model.product.PC;
import pcshop.model.product.Parts;
import pcshop.model.product.Product;

import java.io.IOException;
import java.util.ArrayList;

public class PCStorage {
	ArrayList<PC> pcList = new ArrayList<>();
	ArrayList<Parts> partList = new ArrayList<>();
	final int MAX_QUANTITY = 10;
	private String bookFilename = "booklist.txt";
	private int lastId;
	private boolean isSaved;

	public ArrayList getPCList(){
		return pcList;
	}

//	public PCStorage() throws IOException {
//		loadBookListFromFile();
//		generateLastId();
//		isSaved = true;
//	}
	public PCStorage() throws IOException {

	}
	
//	private void generateLastId() {
//		lastId = 0;
//		for (Book book : bookList) {
//			int id = book.getBookId();
//			if (id > lastId) lastId = id;
//		}
//	}

//	private void loadBookListFromFile() throws IOException {
//		FileReader fr;
//		try {
//			fr = new FileReader(bookFilename);
//			BufferedReader br = new BufferedReader(fr);
//			String idStr;
//			while ((idStr = br.readLine()) != null && !idStr.equals("")) {
//				int id = Integer.parseInt(idStr);
//				String title = br.readLine();
//				String author = br.readLine();
//				String publisher = br.readLine();
//				int price = Integer.parseInt(br.readLine());
//				bookList.add(new Book(id, title, author, publisher, price));
//			}
//			fr.close();
//			br.close();
//
//		} catch (FileNotFoundException |  NumberFormatException e) {
//			System.out.println(e.getMessage());
//		}
//	}
	
	public int getNumPC() {
		return pcList.size();
	}

	public String getPCinfo(int i) {
		return pcList.get(i).toString();
	}

	public boolean isValidPC(int productCode) {
		for (PC p : pcList) {
			if (p.getProductCode() == productCode) return true;
		}
		return false;
	}

//	public Book getBookById(int bookId) {
//		for (Book book : bookList) {
//			if (book.getBookId() == bookId)
//				return book;
//		}
//		return null;
//	}

	public int getMaxQuantity() {
		return MAX_QUANTITY;
	}

	public boolean isEmpty() {
		return pcList.size() == 0;
	}

//	public void deleteItem(int bookId) {
//		bookList.remove(getBookById(bookId));
//		isSaved = false;
//	}
	public void addPC(int productCode, String name, Product CPU, Product GPU, Product memory, int price) {

		PC pc = new PC(productCode, name, CPU, GPU, memory, price);
		pcList.add(pc);
	}

	public StringBuilder getPClist() {
		StringBuilder list = new StringBuilder();
		for(PC pc : pcList){
			list.append(pc.toString()).append("\n");
		}

		return list;
	}

//	public void addBook(String title, String author, String publisher, int price) {
//
//		Book book = new Book(++lastId, title, author, publisher, price);
//		bookList.add(book);
//		isSaved = false;
//	}
//
//	public boolean isSaved() {
//		return isSaved;
//	}
//
//	public void saveBookList2File() {
//
//		try {
//			FileWriter fw = new FileWriter(bookFilename);
//			for (Book book : bookList) {
//				fw.write(book.getBookId() + "\n");
//				fw.write(book.getTitle() + "\n");
//				fw.write(book.getAuthor() + "\n");
//				fw.write(book.getPublisher() + "\n");
//				fw.write(book.getPrice() + "\n");
//			}
//			fw.close();
//			isSaved = true;
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}

}
