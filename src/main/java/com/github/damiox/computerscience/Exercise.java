package com.github.damiox.computerscience;

public interface Exercise<T> {

    Results solve(Params<T> params);

    interface Params<T> {
        T getParams();
    }

    interface Results<T> {
        T getResults();
    }

}
