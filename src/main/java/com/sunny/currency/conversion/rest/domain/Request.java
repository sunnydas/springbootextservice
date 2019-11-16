package com.sunny.currency.conversion.rest.domain;

import java.util.Objects;

public class Request {

    private int a;

    private int b;

    public int getA() {
        return a;
    }

    @Override
    public String toString() {
        return "Request{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }

    public void setA(int a) {
        this.a = a;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Request request = (Request) o;
        return a == request.a &&
                b == request.b;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
}
