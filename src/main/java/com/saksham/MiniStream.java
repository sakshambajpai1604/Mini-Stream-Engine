package com.saksham;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

public class MiniStream<T> {

    private final List<T> data;

    public MiniStream(List<T> data) {
        this.data = data;
    }

    public MiniStream<T> filter(Predicate<T> predicate) {
        List<T> result = new ArrayList<>();

        for (T item : data) {
            if (predicate.test(item)) {
                result.add(item);
            }
        }

        return new MiniStream<>(result);
    }

    public <R> MiniStream<R> map(Function<T, R> mapper) {
        List<R> result = new ArrayList<>();

        for (T item : data) {
            result.add(mapper.apply(item));
        }

        return new MiniStream<>(result);
    }

    public T reduce(T identity, BinaryOperator<T> reducer) {
        T result = identity;

        for (T item : data) {
            result = reducer.apply(result, item);
        }

        return result;
    }

    public List<T> toList() {
        return data;
    }
}
