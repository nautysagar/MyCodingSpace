package bahaviour.visitors;

public class Cloth implements ItemVisitor {

	int numberOfcloths;
	int price;

	
	public Cloth(int numberOfcloths, int price){
		this.numberOfcloths = numberOfcloths;
		this.price = price;
	}
	
	public int getNumberOfcloths() {
		return numberOfcloths;
	}

	public void setNumberOfcloths(int numberOfcloths) {
		this.numberOfcloths = numberOfcloths;
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
