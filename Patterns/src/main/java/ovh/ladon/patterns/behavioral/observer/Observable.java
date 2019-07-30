package ovh.ladon.patterns.behavioral.observer;

public interface Observable {
	void subscribe(UserObserver userObserver);
	void unsubscribe(UserObserver userObserver);
	void notifyObservers();
}
