package queue;

public class LinkedQueue extends AbstractQueue {
    protected class Node {
        Node next;
        Object val;

        Node() {
            next = null;
            val = null;
        }

        Node(Object t) {
            next = null;
            val = t;
        }
    }

    private Node begin;
    private Node end;
    private int len;

    public LinkedQueue() {
        begin = null;
        end = null;
        len = 0;
    }

    @Override
    public LinkedQueue clone() {
        LinkedQueue ans = new LinkedQueue();
        Node u = begin;
        while (u != end) {
            ans.enqueue(u.val);
            u = u.next;
        }
        if (u != null)
            ans.enqueue(u.val);
        return ans;
    }

    @Override
    public LinkedQueue emptyCopy() {
        return new LinkedQueue();
    }

    @Override
    public boolean enqueueUnsecure(Object t) {
        Node nw = new Node(t);
        len++;
        if (end == null) {
            begin = nw;
            end = nw;
            return true;
        }
        end.next = nw;
        end = nw;
        return true;
    }

    @Override
    public Object elementUnsecure() {
        return begin.val;
    }

    @Override
    public Object dequeueUnsecure() {
        Object ans = begin.val;
        len--;
        if (begin == end) {
            begin = end = null;
        } else {
            begin = begin.next;
        }
        return ans;
    }

    @Override
    public void clears() {
        len = 0;
        begin = null;
        end = null;
    }

}
