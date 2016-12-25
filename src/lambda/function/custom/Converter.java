package lambda.function.custom;

@FunctionalInterface
interface Converter<F, T> {
    T convert(F from);
}