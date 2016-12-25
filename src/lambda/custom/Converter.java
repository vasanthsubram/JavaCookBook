package lambda.custom;

@FunctionalInterface
interface Converter<F, T> {
    T convert(F from);
}