package bahaviour.visitors;

public class TestVisitor {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ItemVisitor[] vv = new ItemVisitor[]{new Book(5,100), new Cloth(42,32)};
		int sum = 0;
		ShopingVisitors sv = new ShopingcartImpl();
		
		for(ItemVisitor v: vv){
			sum +=v.accept(sv);
		}
		
		System.out.print("Total Amount: "+ sum);
		
		

	}

}
