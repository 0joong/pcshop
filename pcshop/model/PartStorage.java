package pcshop.model;

import pcshop.model.part.CPU;
import pcshop.model.part.Memory;
import pcshop.model.product.Parts;
import pcshop.model.product.Product;

import java.io.IOException;
import java.util.ArrayList;

public class PartStorage {
    public ArrayList<Parts> partList = new ArrayList<>();
    final int MAX_QUANTITY = 10;

    {
        partList.add(new CPU(1001, 120000, "I3-12100", 4, 3.1));
        partList.add(new CPU(1002, 150000, "I3-12400", 6, 3.3));
        partList.add(new CPU(1003, 210000, "I3-12500", 6, 3.5));
        partList.add(new CPU(1004, 240000, "I3-12700", 8, 4.1));
        partList.add(new CPU(1005, 390000, "I3-12900", 12, 4.7));

        partList.add(new Memory(2001, 100000, "삼성 메모리", "DDR5", 16));
        partList.add(new Memory(2002, 120000, "하이닉스 메모리", "DDR5", 32));
        partList.add(new Memory(2003, 150000, "삼성 메모리", "DDR4", 8));
        partList.add(new Memory(2004, 190000, "삼성 메모리", "DDR3", 4));
        partList.add(new Memory(2005, 200000, "삼성 메모리", "DDR2", 2));

    }

    public Product productCodeToProduct(int productCode){
        for(int i = 0; i < partList.size(); i++)
            if(partList.get(i).getProductCode() == productCode)
                return partList.get(i);
        return null;
    }

    public PartStorage() throws IOException {

    }

    public ArrayList<Parts> getPartList(){
        return this.partList;
    }

    public int getNumPart() {
        return partList.size();
    }

    public String getPartInfo(int i) {
        return partList.get(i).toString();
    }

    public boolean isValidPart(int productCode) {
        for (Product p : partList) {
            if (p.getProductCode() == productCode) return true;
        }
        return false;
    }

    public Parts getPartById(int productCode) {
        for (Parts part : partList) {
            if (part.getProductCode() == productCode)
                return part;
        }
        return null;
    }

    public int getMaxQuantity() {
        return MAX_QUANTITY;
    }

    public boolean isEmpty() {
        return partList.isEmpty();
    }

//    public void deleteItem(int bookId) {
//        bookList.remove(getBookById(bookId));
//        isSaved = false;
//    }
    public void addPart(int productCode, String name, int price) {

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
