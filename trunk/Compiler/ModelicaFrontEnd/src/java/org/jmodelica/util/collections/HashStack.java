package org.jmodelica.util.collections;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

public class HashStack<T> {
    
    private final Deque<T> stack = new ArrayDeque<T>();
    private final HashMap<T,Integer> counter = new HashMap<T,Integer>();
    
    
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public T peek() {
        return stack.peek();
    }

    public T pop() {
        T val = stack.pop();
        if (val == null) {
            return val;
        }
        int count = counter.get(val) - 1;
        if (count == 0) {
            counter.remove(val);
        } else {
            counter.put(val, count);
        }
        return val;
    }

    public void push(T item) {
        Integer count = counter.get(item);
        if (count == null) {
            count = 1;
        } else {
            count++;
        }
        counter.put(item, count);
        stack.push(item);
    }

    public boolean contains(Object o) {
        return counter.containsKey(o);
    }

}
