interface LinearList {
    public boolean isEmpty();
    public int size();
    public Object get(int index);
    public int indexOf(Object element);
    public Object remove(int index, Object obj);
    public void add(int index, Object obj);
    public String toString();
}

public class Linear implements LinearList {
    protected Object[] arrayList;
    protected int size;

    public Linear(int initialCapacity) {
        if (initialCapacity < 1)
            throw new IllegalArgumentException("Initial Capacity must be more than one!");
        arrayList = new Object[initialCapacity];
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public Object get(int index) {
        checkIndex(index);
        return arrayList[index];
    }

    public int indexOf(Object element) {
        for (int i = 0; i < size; i++) {
            if (arrayList[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(Object element) {
        for (int i = size - 1; i >= 0; i--) {
            if (arrayList[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    public Object remove(int index, Object obj) {
        checkIndex(index);
        if (!arrayList[index].equals(obj)) {
            return null;
        }
        Object removed = arrayList[index];
        for (int i = index; i < size - 1; i++) {
            arrayList[i] = arrayList[i + 1];
        }
        arrayList[--size] = null;
        return removed;
    }

    public Object remove(int index) {
        checkIndex(index);
        Object removedElement = arrayList[index];
        for (int i = index; i < size - 1; i++) {
            arrayList[i] = arrayList[i + 1];
        }
        arrayList[--size] = null;
        return removedElement;
    }

    public void removeRange(int fromIndex, int toIndex) {
        if (fromIndex < 0 || toIndex > size || fromIndex > toIndex)
            throw new IndexOutOfBoundsException("Invalid range");

        int numRemoved = toIndex - fromIndex;
        for (int i = fromIndex; i < size - numRemoved; i++) {
            arrayList[i] = arrayList[i + numRemoved];
        }

        for (int i = size - numRemoved; i < size; i++) {
            arrayList[i] = null;
        }

        size -= numRemoved;
    }

    public void add(int index, Object obj) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Index = " + index + ", size = " + size);

        if (size == arrayList.length) {
            Object[] newArray = new Object[arrayList.length * 2];
            System.arraycopy(arrayList, 0, newArray, 0, size);
            arrayList = newArray;
        }

        for (int i = size; i > index; i--) {
            arrayList[i] = arrayList[i - 1];
        }
        arrayList[index] = obj;
        size++;
    }

    public Object set(int index, Object element) {
        checkIndex(index);
        Object old = arrayList[index];
        arrayList[index] = element;
        return old;
    }

    public void setSize(int newSize) {
        if (newSize < 0)
            throw new IllegalArgumentException("Size cannot be negative");

        if (newSize > arrayList.length) {
            Object[] newArray = new Object[Math.max(newSize, arrayList.length * 2)];
            System.arraycopy(arrayList, 0, newArray, 0, size);
            arrayList = newArray;
        }

        if (newSize > size) {
            for (int i = size; i < newSize; i++) {
                arrayList[i] = null;
            }
        } else {
            for (int i = newSize; i < size; i++) {
                arrayList[i] = null;
            }
        }

        size = newSize;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            arrayList[i] = null;
        }
        size = 0;
    }

    public void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index = " + index + ", size = " + size);
    }

    public String toString() {
        StringBuffer s = new StringBuffer("[");
        for (int i = 0; i < size; i++) {
            if (arrayList[i] == null) {
                s.append("Null, ");
            } else {
                s.append(arrayList[i].toString() + ", ");
            }
        }
        if (size > 0) {
            s.delete(s.length() - 2, s.length());
        }
        s.append("]");
        return new String(s);
    }

    public static void main(String[] args) {
        Linear list = new Linear(5);

        System.out.println("Is list empty? " + list.isEmpty());

        list.add(0, "Apple");
        list.add(1, "Banana");
        list.add(2, "Cherry");
        list.add(1, "Date");

        System.out.println("List after additions: " + list);
        System.out.println("Size: " + list.size());

        System.out.println("Element at index 2: " + list.get(2));
        System.out.println("Index of 'Cherry': " + list.indexOf("Cherry"));
        System.out.println("Last index of 'Banana': " + list.lastIndexOf("Banana"));

        list.remove(1, "Date");
        System.out.println("List after removing 'Date' at index 1: " + list);

        list.remove(2);
        System.out.println("List after removing element at index 2: " + list);

        list.setSize(6);
        System.out.println("List after resizing to 6: " + list);

        list.set(0, "Apricot");
        System.out.println("List after setting index 0 to 'Apricot': " + list);

        list.removeRange(1, 3);
        System.out.println("List after removing range 1 to 3: " + list);

        list.clear();
        System.out.println("List after clearing: " + list);
        System.out.println("Final size: " + list.size());
        System.out.println("Is list empty? " + list.isEmpty());
    }
}