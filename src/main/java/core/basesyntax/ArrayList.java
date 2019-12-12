package core.basesyntax;


import java.util.Arrays;

/**
 * <p>Реалізувати свій ArrayList який імплементує інтерфейс List. Дотриматися основних вимог щодо
 * реалізації ArrayList (default capacity, newCapacity...)</p>
 */
public class ArrayList<T> implements List<T> {

    private static final int BEGINNER_CAPACITY = 10;
    private Object[] array;
    private int realCapacity;
    private int size;

    public ArrayList() {
        this.array = new Object[BEGINNER_CAPACITY];
        this.realCapacity = BEGINNER_CAPACITY;
    }

    @Override
    public void add(T value) {
        newSize();
        array[size] = value;
        size++;
    }

    @Override
    public void add(T value, int index) {
        if (index >= size || index < 0){
            throw new ArrayIndexOutOfBoundsException(index);
        }

        for (int i = size() ; i > index; i--){
            array[i] = array[i - 1];
        }
        array[index] = value;
        size++;
    }

    @Override
    public void addAll(List<T> list) {
        for (int i = 0; i < list.size(); i++){
            newSize();
            array[size] = list.get(i);
            size++;
        }

    }

    @Override
    public T get(int index) {
        if (index >= size){
            throw new ArrayIndexOutOfBoundsException();
        }
        return (T)array[index];
    }

    @Override
    public void set(T value, int index) {
        if (index >= size || index < 0){
            throw new ArrayIndexOutOfBoundsException(index);
        }
        array[index] = value;
    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public T remove(T t) {
        return null;
    }

    @Override
    public int size() {
        return size;
    }
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    private void newSize(){
        if (size() == array.length){
            realCapacity = realCapacity * 3 /2;
        }
        array = Arrays.copyOf(array, realCapacity);
    }
}
