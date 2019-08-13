package ovh.ladon.lambda;

@FunctionalInterface
public interface GenericCalculate<T> {
	T calc(T x, T y);
}
