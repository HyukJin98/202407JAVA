package drive;

import shop.CartDAO;
import shop.CartProduct;

public class Ex3 {
	public static void main(String[] args) {
		CartDAO dao = new CartDAO();
		for(CartProduct cartProduct : dao.viewCart()) {
			System.out.println(cartProduct);
		}
	}
}
