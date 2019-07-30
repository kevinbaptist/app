package ovh.ladon.patterns.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public class Product implements Observable{
	private boolean inStock;
	private List<UserObserver> users;

	public Product() {
		this.inStock = false;
		this.users = new ArrayList<>();
	}

	public boolean isInStock() {
		return inStock;
	}

	public void setInStock(boolean inStock) {
		this.inStock = inStock;
		notifyObservers();
	}

	@Override
	public void subscribe(UserObserver userObserver) {
		users.add(userObserver);
	}

	@Override
	public void unsubscribe(UserObserver userObserver) {
		users.remove(userObserver);
	}

	@Override
	public void notifyObservers() {
		users.forEach(user->user.update(this));
	}
}
