package queue;

public interface Deque extends Queue {
    //Pre: deque is valid
    boolean push(Object t); //push element in deque
    //Post: push element t in front of Deque and return true or cann't manage it and return false

    //Pre: non empty deque
    Object peek(); //return end of deque
    //Post: return object end of deque of crash

    //Pre: non empty deque
    Object remove(); //return and remove end of deque
    //Post: return end of deque and delete him or false

}
