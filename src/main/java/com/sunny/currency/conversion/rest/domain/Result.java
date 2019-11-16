package com.sunny.currency.conversion.rest.domain;

import java.util.Objects;

public class Result {

    private String result;

    public String getResult() {
        return result;
    }

    @Override
    public String toString() {
        return "Result{" +
                "result='" + result + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result1 = (Result) o;
        return Objects.equals(result, result1.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result);
    }

    public void setResult(String result) {
        this.result = result;
    }
}
