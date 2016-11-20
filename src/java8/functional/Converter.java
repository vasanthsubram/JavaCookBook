package java8.functional;

@FunctionalInterface
interface Converter<F, T> {
    T convert(F from);
}