package CVRP.utils;

import java.lang.reflect.Array;

public class TLArrayList<T> {
    
    private T[] list;
    private boolean reduceSize;
    private int nextAvailable;
    private int capacity;
    private int size;
    
    public TLArrayList() {
        this(16, true);
    }
    
    public TLArrayList(int capacity) {
        this(capacity, true);
    }
    
    public TLArrayList(boolean reduceSize) {
        this(16, reduceSize);
    }
    
    public TLArrayList(int capacity, boolean reduceSize) {
        this.list = (T[]) new Object[capacity];
        this.reduceSize = reduceSize;
        this.nextAvailable = 0;
        this.capacity = capacity;
        this.size = 0;
    }
    
    public T get(int index) {
        return list[index];
    }
    
    public void add(T item) {
        int index = nextAvailable;
        list[index] = item;
        setAsReserved(index);
        size++;
        if (size() == list.length) {
            makeBigger();
        }
    }
    
    public void set(int index, T item) {
        if (index >= list.length) {
            makeBigger(index+1);
        }
        if (isAvailable(index)) {
            this.list[index] = item;
            setAsReserved(index);
            size++;
        } else {
            this.list[index] = item;
        }
        if (size() == list.length) {
            makeBigger();
        }
    }
    
    public int remove(T item) {
        int index = indexOf(item);
        remove(index);
        return index;
    }
    
    public T remove(int index) {
        T item = list[index];
        list[index] = null;
        setAsAvailable(index);
        size--;
        if (reduceSize) {
            reduceSize();
        }
        return item;
    }
    
    public boolean contains(T item) {
        if (item == null) {
            throw new NullPointerException("Parameter item was null");
        }
        for (T t : list) {
            if (t != null && t.equals(item)) {
                return true;
            }
        }
        return false;
    }
    
    public void clear() {
        this.list = (T[]) new Object[capacity];
        size = 0;
    }
    
    public int indexOf(T item) {
        if (item == null) {
            throw new NullPointerException("Parameter item was null");
        }
        for (int i = 0; i < list.length; i++) {
            if (list[i] != null && list[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }
    
    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        } else {
            return false;
        }
    }
    
    public T[] toArray() {
        if (reduceSize) {
            return copy(size());
        } else {
            return copy(list.length);
        }
    }
    
    private boolean isAvailable(int index) {
        if (list[index] == null) {
            return true;
        } else {
            return false;
        }
    }
    
    private void setAsReserved(int index) {
        if (nextAvailable == index) {
            for (int i = index+1; i < list.length; i++) {
                if (isAvailable(i)) {
                    nextAvailable = i;
                    break;
                }
            }
        }
    }
    
    private void setAsAvailable(int index) {
        if (nextAvailable > index) {
            nextAvailable = index;
        }
    }
    
    private void makeBigger() {
        int newCapacity = 2*capacity;
        this.list = copy(newCapacity);
        checkNextAvailable();
    }
    
    private void makeBigger(int newCapacity) {
        this.list = copy(newCapacity);
        checkNextAvailable();
    }
    
    public int size() {
        return size;
    }
    
    private void reduceSize() {
        this.list = copy(size);
    }
    
    private T[] copy(int newCapacity) {
        if (!reduceSize) {
            T[] newList;
            newList = (T[]) new Object[newCapacity];
            for (int i = 0; i < newList.length; i++) {
                T item = this.list[i];
                if (item != null) {
                    newList[i] = item;
                } else {
                    newList[i] = null;
                }
            }
            return newList;
        } else {
            T[] newList;
            newList = (T[]) new Object[newCapacity];
            int newIndex = 0;
            int oldIndex = 0;
            while (newIndex < newList.length) {
                if (isAvailable(oldIndex)) {
                    oldIndex++;
                } else {
                    newList[newIndex] = this.list[oldIndex];
                    newIndex++;
                    oldIndex++;
                }
                if (this.list.length <= oldIndex) {
                    break;
                }
                
            }
            return newList;
        }
        
    }

    private void checkNextAvailable() {
        for (int i = 0; i < list.length; i++) {
            if (list[i] == null) {
                nextAvailable = i;
                break;
            }
        }
    }

    
}
