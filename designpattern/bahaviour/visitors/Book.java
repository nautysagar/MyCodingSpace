package bahaviour.visitors;

public class Book implements ItemVisitor{
	
	int numberOfbooks;
	int price;
	
	public Book(int numberOfbooks, int price){
		this.numberOfbooks = numberOfbooks;
		this.price = price;
	}

	public int getNumberOfbooks() {
		return numberOfbooks;
	}



	public void setNumberOfbooks(int numberOfbooks) {
		this.numberOfbooks = numberOfbooks;
	}



	public int getPrice() {
		return price;
	}



	public void setPrice(int price) {
		this.price = price;
	}



	@Override
	public int accept(ShopingVisitors visit) {
		// TODO Auto-generated method stub
		return visit.visit(this);
	}

}
