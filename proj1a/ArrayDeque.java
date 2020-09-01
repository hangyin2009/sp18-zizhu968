public class ArrayDeque {
    int items[];
    int size;

    public ArrayDeque(){
        items = new int[100];
        size = 0;
    }

    public void addFirst(int x){
        if(size == items.length){
            resize(2*size);
        }
        for(int i = size-1; i == 0; i--){
            items[i+1] = items[i];
        }
        items[0] = x;
        size += 1;
    }

    public void resize(int capacity){
        int[] a = new int[capacity];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }

    public void addLast(int x){
        if(size == items.length){
            resize(2*size);
        }
        items[size] = x;
        size += 1;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        for(int i = 0; i < size; i++){
            System.out.println(items[i]);
        }
    }

    public int removeFirst(){
        int f = items[0];
        for(int i = 0; i < size; i++){
            items[i] = items[i+1];
        }
        items[size-1] = 0;
        size -= 1;
        return f;
    }

    public int removeLast(){
        int f = items[size-1];
        items[size-1] = 0;
        size -= 1;
        return f;
    }

    public int get(int index){
        return items[index];
    }

}
