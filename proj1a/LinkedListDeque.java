public class LinkedListDeque<T> {
    private class IntNode{
        public IntNode prev;
        public T item;
        public IntNode next;

        public IntNode(IntNode p, T i, IntNode n){
            prev = p;
            item = i;
            next = n;
        }
    }

    private IntNode sentinel;
    private int size;

    /*Create an empty deque.*/
    public LinkedListDeque(){
        sentinel = new IntNode(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    public void addFirst(T x){
        sentinel.next = new IntNode(sentinel, x, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        size+=1;
    }

    public void addLast(T x){
        sentinel.prev.next = new IntNode(sentinel.prev, x, sentinel);
        sentinel.prev = sentinel.prev.next;
        size+=1;
    }

    public boolean isEmpty(){
        return (this.size == 0);
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        IntNode p = sentinel;
        while(p.next != sentinel) {
            p = p.next;
            System.out.println(p.item + " ");
        }
    }

    public T removeFirst(){
        if (size == 0){
            return null;
        }
        T first = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.next.prev = sentinel;
        size-=1;
        return first;

    }

    public T removeLast(){
        if (size == 0){
            return null;
        }
        T last = sentinel.prev.item;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        size-=1;
        return last;
    }

    public T get(int index){
        if (size == 0 || index >= size){
            return null;
        }
        IntNode p = sentinel;
        while(index >= 0){
            p = p.next;
            index -= 1;
        }
        return p.item;
    }

    public T getRecursive(int index){
        if (size == 0 || index >= size){
            return null;
        }

        return getRecursiveHelper(sentinel.next, index);
    }

    public T getRecursiveHelper(IntNode p, int i){
        if (i == 0){
            return p.item;
        }
        return getRecursiveHelper(p.next, i-1);
    }

    public LinkedListDeque(LinkedListDeque<T> other){
        sentinel = new IntNode(null, null,null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;

        for (int i=0;i<other.size();i++){
            addLast((T)other.get(i));
        }

    }


}










