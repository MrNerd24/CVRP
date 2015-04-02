package CVRP.utils;

import java.util.Random;

/**
 * This class handels a list that is not limited to a certain lenght.
 * @author Juuso
 * @param <T> The type of items the are to be listed.
 */
public class TLArrayList<T> {
    
    private T[] list;
    private boolean reduceSize;
    private int nextAvailable;
    private int size;
    
    /**
     * Creates a new ArrayList with the deafult settings.
     */
    public TLArrayList() {
        this(16, true);
    }
    
    /**
     * Creates a new ArrayList with a certain capasity.
     * @param capacity The capaciy in the start.
     */
    public TLArrayList(int capacity) {
        this(capacity, true);
    }
    
    /**
     * Creates a new ArrayList that can be made to either reduce it's size when things are removed or to not do it.
     * @param reduceSize True if size should be reduced.
     */
    public TLArrayList(boolean reduceSize) {
        this(8, reduceSize);
    }
    
    /**
     * Creates a new ArrayList with a certain capacity and it can be made to either reduce it's size when things are removed or to not do it.
     * @param capacity Capacity in the start.
     * @param reduceSize True if size should be reduced.
     */
    public TLArrayList(int capacity, boolean reduceSize) {
        this.list = (T[]) new Object[capacity];
        this.reduceSize = reduceSize;
        this.nextAvailable = 0;
        this.size = 0;
    }
    
    /**
     * Returns an item from the index.
     * @param index Index of the item
     * @return Returns the item from the index.
     */
    public T get(int index) {
        return list[index];
    }
    
    /**
     * Adds a new item to the end of the list.
     * @param item Item to be added.
     */
    public void add(T item) {
        if (item == null) {
            return;
        }
        int index = nextAvailable;
        list[index] = item;
        setAsReserved(index);
        size++;
        if (size() == list.length) {
            makeBigger();
        }
    }
    
    /**
     * Sets an item to the index.
     * @param index index of the item
     * @param item Item that the index should contain.
     */
    public void set(int index, T item) {
        if (item == null) {
            remove(index);
            return;
        }
        if (index >= list.length) {
            makeBigger(index + 1);
        }
        if (isAvailable(index)) {
            this.list[index] = item;
            setAsReserved(index);
            size++;
        } else {
            this.list[index] = item;
        }
        if (reduceSize) {
            if (size() == list.length) {
                makeBigger();
            }
        }
        
    }
    
    /**
     * Removes an item from the list.
     * @param item Item to be removed
     * @return Returns the index that this item was found from.
     */
    public int remove(T item) {
        int index = indexOf(item);
        if (index < 0) {
            return -1;
        }
        remove(index);
        return index;
    }
    
    /**
     * Removes an item from a index.
     * @param index the index where the item should be removed.
     * @return Returns the removed item.
     */
    public T remove(int index) {
        if (index >= list.length || index < 0) {
            return null;
        }
        T item = list[index];
        list[index] = null;
        setAsAvailable(index);
        if (item != null) {
            size--;
        }
        
        if (reduceSize) {
            reduceSize();
        }
        return item;
    }
    
    /**
     * Tells if the list contains an item
     * @param item Item to be found
     * @return True if the list contains the item, false otherwise.
     */
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
    
    /**
     * Removes everything from the list.
     */
    public void clear() {
        this.list = (T[]) new Object[8];
        size = 0;
        checkNextAvailable();
    }
    
    /**
     * Returns the index of an item
     * @param item Item to be searched
     * @return The index of the item, -1 if the item doesn't exist.
     */
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
    
    /**
     * Tells if the list is empty
     * @return True if the list is empty
     */
    public boolean isEmpty() {
        if (size() <= 0) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Returns the list as an array
     * @return List as an array.
     */
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
        if (reduceSize) {
            if (nextAvailable < size()) {
                reduceSize();
            }
        }
        if (nextAvailable == index) {
            for (int i = index + 1; i < list.length; i++) {
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
        
        this.list = copy(list.length * 2);
        checkNextAvailable();
    }
    
    private void makeBigger(int newCapacity) {
        this.list = copy(newCapacity);
        checkNextAvailable();
    }
    
    /**
     * Returns the size of the list.
     * @return Size
     */
    public int size() {
        if (!reduceSize) {
            return list.length;
        }
        return size;
    }
    
    /**
     * Reduces the list. Gets rid of null values.
     */
    public void reduceSize() {
        this.list = copy(size + 3);
        calculateSize();
        checkNextAvailable();
    }
    
    private T[] copy(int newCapacity) {
        if (!reduceSize) {
            T[] newList;
            newList = (T[]) new Object[newCapacity];
            for (int i = 0; i < Math.min(newList.length, list.length); i++) {
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
    
    /**
     * Sorts the list using merge sort.
     * @param list ArrayList to be sorted
     * @return Sorted list.
     */
    public static TLArrayList sort(TLArrayList list) {
        if (list.reduceSize) {
            list.reduceSize();
        }
        int index = -1;
        for (int i = 0; i < list.list.length; i++) {
            if (list.get(i) != null) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return list;
        }
        Class[] Interfaces = list.get(index).getClass().getInterfaces();
        for (Class class1 : Interfaces) {
            if (class1.equals(Comparable.class)) {
                list = mergeSort(list);
                return list;
            }
        }
        throw new IllegalArgumentException("List doesn't contain objects that implement Comparable interface");
        
    }
    
    /**
     * Shuffles a list.
     * @param list List to be shuffled.
     */
    public static void shuffle(TLArrayList list) {
        Random random = new Random();
        for (int i = list.list.length - 1; i > 0; i--) {
            int randomIndex = random.nextInt(i);
            Object holder = list.list[randomIndex];
            list.list[randomIndex] = list.list[i];
            list.list[i] = holder;
        }
        if (list.reduceSize) {
            list.reduceSize();
        }
    }
    
    private static TLArrayList<Comparable> mergeSort(TLArrayList<Comparable> unsorted) {
        if (unsorted.size <= 1) {
            return unsorted;
        }
        
        int middle = unsorted.size() / 2;
        TLArrayList<Comparable> left = new TLArrayList<Comparable>();
        TLArrayList<Comparable> right = new TLArrayList<Comparable>();
        
        for (int i = 0; i < middle; i++) {
            left.add(unsorted.get(i));
        }
        for (int i = middle; i < unsorted.size(); i++) {
            right.add(unsorted.get(i));
        }
        
        left = mergeSort(left);
        right = mergeSort(right);
        
        return merge(left, right);
        
    }
    
    private static TLArrayList<Comparable> merge(TLArrayList<Comparable> left, TLArrayList<Comparable> right) {
        TLArrayList<Comparable> answer = new TLArrayList<Comparable>();
        int answerIndex = 0;
        int leftIndex = 0;
        int rightIndex = 0;
        while (left.size() - leftIndex > 0 || right.size() - rightIndex > 0) {
            if (left.size() - leftIndex > 0 && right.size() - rightIndex > 0) {
                
                Comparable leftValue = left.get(leftIndex);
                Comparable rightValue = right.get(rightIndex);
                int compareTo;
                
                if (leftValue == null && rightValue == null) {
                    compareTo = 0;
                } else if (leftValue == null) {
                    compareTo = 1;
                } else if (rightValue == null) {
                    compareTo = -1;
                } else {
                    compareTo = leftValue.compareTo(rightValue);
                }
                
                if (compareTo <= 0) {
                    answer.set(answerIndex, left.get(leftIndex));
                    answerIndex++;
                    leftIndex++;
                } else {
                    answer.set(answerIndex, right.get(rightIndex));
                    answerIndex++;
                    rightIndex++;
                }
                
            } else if (left.size() - leftIndex > 0) {
                answer.set(answerIndex, left.get(leftIndex));
                answerIndex++;
                leftIndex++;
            } else if (right.size() - rightIndex > 0) {
                answer.set(answerIndex, right.get(rightIndex));
                answerIndex++;
                rightIndex++;
            }
        }
        return answer;
    }
    
    private void calculateSize() {
        size = 0;
        for (int i = 0; i < list.length; i++) {
            if (list[i] != null) {
                size++;
            }
        }
    }
    
}
