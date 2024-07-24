package iterator;

import java.util.Iterator;

public class Main {
	public static void main(String[] args) {
		BookShelf bookShelf = new BookShelf(4);
		bookShelf.appendBook(new Book("Around the World in 80 Days"));
		bookShelf.appendBook(new Book("sex"));
		bookShelf.appendBook(new Book("Cinderella"));
		bookShelf.appendBook(new Book("정보처리기사 혁진이 화이팅"));
		
		Iterator<Book> it = bookShelf.iterator();
		while(it.hasNext()) {
			Book book = it.next();
			System.out.println(book.getName());
		}
		System.out.println();
		
		for(Book book : bookShelf) {
			System.out.println(book.getName());
		}
		System.out.println();
	}
}
