package queue;

import java.util.function.Predicate;
import java.util.function.*;


abstract class AbstractQueue implements Queue {
    private int size = 0;

    protected abstract boolean enqueueUnsecure(Object t);

    public boolean enqueue(Object t) {
        assert t != null;
        ++size;
        return enqueueUnsecure(t);
    }

    ;

    protected abstract Object elementUnsecure();

    public Object element() {
        assert !isEmpty();
        return elementUnsecure();
    }

    ;

    protected abstract Object dequeueUnsecure();

    public Object dequeue() {
        assert !isEmpty();
        --size;
        return dequeueUnsecure();
    }

    ;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public abstract void clears();

    public void clear() {
        size = 0;
        clears();
    }

    public abstract AbstractQueue emptyCopy();

    public AbstractQueue filter(Predicate<Object> P) {
        AbstractQueue ans = (AbstractQueue) this.emptyCopy();
        ans.clear();
        int s = this.size();
        for (int j = 0; j < s; ++j) {
            Object t = this.dequeue();
            if (P.test(t))
                ans.enqueue(t);
            this.enqueue(t);
        }
        return ans;
    }

    public AbstractQueue map(Function<Object, Object> P) {
        AbstractQueue ans = (AbstractQueue) this.emptyCopy();
        ans.clear();
        int s = this.size();
        for (int j = 0; j < s; ++j) {
            Object t = this.dequeue();
            this.enqueue(t);
            t = P.apply(t);
            ans.enqueue(t);
        }
        return ans;
    }

}
