package queue;

public interface Queue {
    //Pre: T is object
    public boolean enqueue(Object t); //add element in queue
    //Post: return true if arg T in queue and false in all different cases

    //Pre: queue is valid
    public Object element(); //get first in queue
    //Post: return first element in queue(peek), or throws AssertException

    //Pre: queue is valid
    public Object dequeue(); //get first in queue and delete it
    //Post: return first element in queue(peek) and delete it, or throws AssertException

    //Pre: queue is valid
    public int size(); //get size of queue
    //Post: return size of queue

    //Pre: queue is valid
    public boolean isEmpty(); //get bool is queue empty
    //Post: return true if queue is empty else return false

    //Pre: queue is valid
    public void clear(); // clear queue
    //Post: queue has size = 0 with no elements

}
