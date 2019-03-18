package queue;

public class ArrayQueue extends AbstractQueue implements Deque {
    private Object array[] = null;
    private int head = 0;
    private int tail = 0;

    public ArrayQueue() {
        head = tail = 0;
        array = null;
    }

    private boolean nnew() {
        if (array == null) {
            array = new Object[2];
            head = tail = 0;
            return true;
        }
        if ((tail + 1) % array.length == head) {
            Object newArray[] = new Object[array.length * 2];
            int j = head;
            for (int i = head; i != tail; j++, i = (i + 1) % array.length)
                newArray[j] = array[i];
            array = newArray;
            tail = j;
        }
        return true;
    }

    @Override
    public ArrayQueue clone() {
        ArrayQueue ans = new ArrayQueue();
        int u = head;
        while (u != tail) {
            ans.enqueue(array[u]);
            u = (u + 1) % array.length;
        }
        return ans;
    }

    @Override
    public ArrayQueue emptyCopy() {
        return new ArrayQueue();
    }

    @Override
    public boolean enqueueUnsecure(Object t) {
        if (!nnew()) return false;
        array[tail] = t;
        tail = (tail + 1) % array.length;
        if (!nnew()) return false;
        return true;
    }

    @Override
    public Object elementUnsecure() {
        return array[head];
    }

    @Override
    public Object dequeueUnsecure() {
        if (!nnew()) return false;
        Object ans = array[head];
        head = (head + 1) % array.length;
        if (!nnew()) return false;
        return ans;
    }

    @Override
    public void clears() {
        head = tail = 0;
        array = null;
    }

    @Override
    public boolean push(Object t) {
        if (!nnew()) return false;
        head = (head - 1 + array.length) % array.length;
        array[head] = t;
        if (!nnew()) return false;
        return true;
    }

    @Override
    public Object peek() {
        assert !isEmpty();
        return array[(tail - 1 + array.length) % array.length];
    }

    @Override
    public Object remove() {
        assert !isEmpty();
        if (!nnew()) return false;
        tail = (tail - 1 + array.length) % array.length;
        Object ans = array[tail];
        if (!nnew()) return false;
        return ans;
    }

}
