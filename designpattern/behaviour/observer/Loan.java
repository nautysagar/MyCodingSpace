package behaviour.observer;

import java.util.ArrayList;
import java.util.List;

public class Loan implements Subject {
	private List<Observer> list = new ArrayList<>();

	float interest;

	String bank;

	String type;

	public Loan(float interest, String bank, String type) {
		this.interest = interest;
		this.bank = bank;
		this.type = type;
	}

	public List<Observer> getList() {
		return list;
	}

	public void setList(List<Observer> list) {
		this.list = list;
	}

	public float getInterest() {
		return interest;
	}

	public void setInterest(float interest) {
		this.interest = interest;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public void registerObserver(Observer obj) {
		// TODO Auto-generated method stub

		if (obj != null) {
			list.add(obj);
		}

	}

	@Override
	public void removeObserver(Observer obj) {
		// TODO Auto-generated method stub
		if (obj != null) {
			list.remove(obj);
		}

	}

	@Override
	public void notifyAllObserver(float interest) {
		// TODO Auto-generated method stub
		for (Observer o : list) {
			o.notify(interest);
		}

	}

}
