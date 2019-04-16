package org.jmodelica.util;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayUtil {

    @SafeVarargs
    public static <T> T[] concat(T[] first, T[]... rest) {
        int len = first.length;
        for (T[] part : rest) {
            len += part.length;
        }

        Class<?> type = first.getClass().getComponentType();
        @SuppressWarnings("unchecked")
        T[] res = (T[]) Array.newInstance(type, len);

        System.arraycopy(first, 0, res, 0, first.length);
        int pos = first.length;
        for (T[] part : rest) {
            System.arraycopy(part, 0, res, pos, part.length);
            pos += part.length;
        }

        return res;
    }

    @SafeVarargs
    public static <T> T[] append(T[] arr, T... vals) {
        return concat(arr, vals);
    }

    /**
     * Creates an array.
     * 
     * @param <T>       The type of the elements contained within the array.
     * @param elements  The elements the array consists of.
     * @return          an array containing {@code elements}.
     */
    public static <T> T[] array(T[] elements) {
        return Arrays.asList(elements).toArray(Arrays.copyOf(elements, 0));
    }

}
