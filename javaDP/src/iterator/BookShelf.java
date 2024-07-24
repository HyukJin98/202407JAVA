package iterator;

import java.util.Iterator;

public class BookShelf implements Iterable<Book> {
	private Book[] books;
	private int last = 0;
	@Override
	public Iterator<Book> iterator() {
		// TODO Auto-generated method stub
		return new BookShelfIterator(this);
	}
	
	public BookShelf(int maxsize) {
		this.books = new Book[maxsize];
	}
	
	public Book getBookAt(int index) {
		return books[index];
	}
	
	public void appendBook(Book book) {
		this.books[last] = book;
		last++;
	}
	
	public int getLength() {
		return last;
	}
	
}
