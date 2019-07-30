package ovh.ladon.patterns.structural.proxy.protection;

public class Thief {
	private String name;

	public Thief(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
}
