package ru.reeson2003.simpleobject;

/**
 * Created by Pavel Gavrilov
 */
public class MySimpleObject {
    private MySimpleObject() {
    }

    public static <A> Value1<A> of(A value1) {
        return new Value1<>(value1);
    }

    public static <A, B> Value2<A, B> of(A value1, B value2) {
        return new Value2<>(value1, value2);
    }

    public static <A, B, C> Value3<A, B, C> of(A value1, B value2, C value3) {
        return new Value3<>(value1, value2, value3);
    }

    public static <A, B, C, D> Value4<A, B, C, D> of(A value1, B value2, C value3, D value4) {
        return new Value4<>(value1, value2, value3, value4);
    }

    public static <A, B, C, D, E> Value5<A, B, C, D, E> of(A value1, B value2, C value3, D value4, E value5) {
        return new Value5<>(value1, value2, value3, value4, value5);
    }

    public static class Value1<A> {
        public final A value1;

        private Value1(A value1) {
            this.value1 = value1;
        }
    }

    public static class Value2<A, B> extends Value1<A> {
        public final B value2;

        private Value2(A value1, B value2) {
            super(value1);
            this.value2 = value2;
        }
    }

    public static class Value3<A, B, C> extends Value2<A, B> {
        public final C value3;

        private Value3(A value1, B value2, C value3) {
            super(value1, value2);
            this.value3 = value3;
        }
    }

    public static class Value4<A, B, C, D> extends Value3<A, B, C> {
        public final D value4;

        private Value4(A value1, B value2, C value3, D value4) {
            super(value1, value2, value3);
            this.value4 = value4;
        }
    }

    public static class Value5<A, B, C, D, E> extends Value4<A, B, C, D> {
        public final E value5;

        private Value5(A value1, B value2, C value3, D value4, E value5) {
            super(value1, value2, value3, value4);
            this.value5 = value5;
        }
    }
}
