package ch2.collections;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Cwind
 * Date: 2015/6/21
 * Email: billchen01@163.com
 */
public class CircularArrayQueueTest {
    public static void main(String[] args){
        Queue<String> q = new CircularArrayQueue<String>(5);
        q.add("Amy");
        q.add("Bob");
        q.add("Carl");
        q.add("Deedee");
        q.add("Emile");
        q.remove();
        q.add("Fifi");
        q.remove();
        for(String s : q){
            System.out.println(s);
        }
    }

}

class CircularArrayQueue<E> extends AbstractQueue<E>{

    private E[] elements;
    private int head;
    private int tail;
    private int count;
    private int modcount;

    public CircularArrayQueue(int capacity) {
        elements = (E[]) new Object[capacity];
        count = 0;
        head = 0;
        tail = 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new QueueIterator();
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean offer(E e) {
        assert e != null;
        if(count < elements.length){
            elements[tail] = e;
            tail = (tail +1) % elements.length;
            count++;
            modcount++;
            return true;
        }else {
            return false;
        }

    }

    @Override
    public E poll() {
        if(count==0){
            return null;
        }
        E r = elements[head];
        head = (head + 1) % elements.length;
        count--;
        modcount++;
        return r;

    }

    @Override
    public E peek() {
        if(count==0){
            return null;
        }
        return elements[head];
    }

    private class QueueIterator implements Iterator<E>{

        public QueueIterator() {
            modcountAtConstruction = modcount;
        }

        @Override
        public boolean hasNext() {
            if(modcount != modcountAtConstruction){
                throw new ConcurrentModificationException();
            }
            return offset < count;
        }

        @Override
        public E next() {
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            E r = elements[(head + offset)%elements.length];
            offset++;
            return r;
        }

        public void remove(){
            throw new UnsupportedOperationException();
        }

        private int offset;
        private int modcountAtConstruction;
    }
}