package streams.customFunctionalInterface;

public interface Converter<F,T> {
  T convert(F from);
}