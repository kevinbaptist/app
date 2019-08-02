package ovh.ladon.springboot.zuul.filters;

/**
 * Zuul has four standard filters:
 * -> pre filters are executed before the request is routed,
 * -> route filters can handle the actual routing of the request,
 * -> post filters are executed after the request has been routed, and
 * -> error filters execute if an error occurs in the course of handling the request.
 */
public enum ZuulFilterType {
	PRE, ROUTE, POST, ERROR;


	@Override
	public String toString() {
		return super.toString().toLowerCase();
	}
}
