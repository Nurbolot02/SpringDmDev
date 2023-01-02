package org.ntg.spring.ntg;

import java.lang.ref.Reference;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Queue;
import java.util.TreeSet;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class main {
    public static void main(String[] args) {
        HashSet<Value> values = new HashSet<>();
        Value value = new Value(1, 1.0);
        Value value2 = new Value(1, 1.0);

        values.add(value);
        values.add(value2);

        System.out.println(values);

    }


    static class Value {
        private int a;
        private double b;

        public Value(int a, double b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Value value = (Value) o;
            return a == value.a && Double.compare(value.b, b) == 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b);
        }

        @Override
        public String toString() {
            return "Value{" +
                    "a=" + a +
                    ", b=" + b +
                    '}';
        }
    }
}
