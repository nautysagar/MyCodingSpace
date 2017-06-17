package bahaviour.visitors;

public class ShopingcartImpl implements ShopingVisitors{
	int sum =0;
	
	
	@Override
	public int visit(Book book) {
		sum = book.numberOfbooks * book.price;
		System.out.println("Sum of book Purchased: " + sum);
		return sum;
	}

	@Override
	public int visit(Cloth cloth) {
		sum = cloth.numberOfcloths * cloth.price;
		System.out.println("Sum of cloth Purchased: " + sum);
		return sum;
	}

}
