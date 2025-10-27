/*
 * Name: Ulysses Burden III
 * Assignment: Lab - Arrays and Lists - Calculator Application
 * Date: Oct 25, 2025
 */

import java.util.ArrayList;

// MemoryStore class to handle memory storage
public class MemoryStore {
    // Single value storage
    private Integer singleValue = null;

    public void storeSingle(int value) {
        singleValue = value;
    }

    // Check if single value is stored
    public boolean hasSingle() {
        return singleValue != null;
    }

    // Get the stored single value
    public int getSingle() {
        return singleValue;
    }

    // Replace the
    public void clearSingle() {
        singleValue = null;
    }

    private static final int MAX_SIZE = 10;
    private final ArrayList<Integer> collection = new ArrayList<>(MAX_SIZE);

    public boolean isCollectionFull() {
        return collection.size() >= MAX_SIZE;
    }

    public void addToCollection(int value) {
        if (isCollectionFull()) {
            return;
        }
        collection.add(value);

    }

    public int countCollection() {
        return collection.size();
    }

    public ArrayList<Integer> getAll() {
        return new ArrayList<>(collection);
    }

    public int removeByIndex(int zeroBasedIndex) {
        if (zeroBasedIndex < 0 || zeroBasedIndex >= collection.size()) {
            throw new IndexOutOfBoundsException("Invalid index: " + zeroBasedIndex);
        }
        return collection.remove(zeroBasedIndex);
    }

    public int sum() {
        int total = 0;
        for (int v : collection) {
            total += v;
        }
        return total;
    }

    public double average() {
        int n = collection.size();
        if (n == 0)
            return 0.0;
        return (double) sum() / n;
    }

    public int diffFirstLast() {
        int n = collection.size();
        if (n < 2) {
            throw new IllegalStateException("Need at least two values to compute difference.");
        }
        int first = collection.get(0);
        int last = collection.get(n - 1);
        return last - first;
    }

    public void clearCollection() {
        collection.clear();
    }
}
