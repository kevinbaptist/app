package ovh.ladon.springboot.zuul.filters;

public enum ZuulFilterType {
	PRE, ROUTE, POST, ERROR;


	@Override
	public String toString() {
		return super.toString().toLowerCase();
	}
}
