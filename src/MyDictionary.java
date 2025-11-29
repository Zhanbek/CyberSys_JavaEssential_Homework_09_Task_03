import java.util.Arrays;

public class MyDictionary<K, V> {
    private static final int INITIAL_CAPACITY = 16;
    private int capacity;
    private int size;
    private Object[] keysArray;
    private Object[] valuesArray;

    public MyDictionary() {
        this(INITIAL_CAPACITY);
    }

    public MyDictionary(int capacity) {
        this.capacity = capacity;
        this.keysArray = new Object[capacity];
        this.valuesArray = new  Object[capacity];
        this.size = 0;
    }

    private void increaseCapacity(int newCapacity) {
        capacity = newCapacity;
        Object[] newKeysArray = Arrays.copyOf(keysArray, capacity);
        Object[] newValuesArray = Arrays.copyOf(valuesArray, capacity);

        keysArray = newKeysArray;
        valuesArray = newValuesArray;

    }

    public int containsKey(K key) {
        for (int i = 0; i < size; i++) {
            if (key.equals(keysArray[i])) {
                return i; // Якщо ключ знайдений, то повертаємо його Індекс
            }
        }
        return -1; // Якщо ключ не знайдено
    }

    public void put(K key, V value) throws IllegalArgumentException{
        if (key == null)
            throw new IllegalArgumentException("Передане значення ключа є null!");

        int index = containsKey(key);
        if (index != -1) {
            // Якщо ключ знайдено
            valuesArray[index] = value;
        } else {
            // Якщо ключ не знайдений, то створюємо його
            if (size >= capacity) {
                increaseCapacity(capacity * 2 + 1);
            }
            keysArray[size] = key;
            valuesArray[size] = value;
            size++;
        }
    }

    private void checkBoundaries(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Помилка! Індекс " + index + " виходить за допустимі межі словника: [0,  " + (size - 1) + "]");
        }
    }

    public K getKeyByIndex(int index) throws IndexOutOfBoundsException {
        checkBoundaries(index);
        return (K) keysArray[index];
    }

    public V getValueByIndex(int index) throws IndexOutOfBoundsException {
        checkBoundaries(index);
        return (V) valuesArray[index];
    }

    public V getValueByKey(K key) {
        for (int i = 0; i < size; i++) {
            if (key.equals(keysArray[i])) {
                return (V) valuesArray[i];
            }
        }
        return null;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        if (size == 0)  return "Словник порожній!";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size - 1; i++) {
            sb.append("[ ").append(keysArray[i]).append(" : ").append(valuesArray[i]).append(" ]").append("\n");
        }
        sb.append("[ ").append(keysArray[size - 1]).append(" : ").append(valuesArray[size - 1]).append(" ]");
        return sb.toString();
    }
}
