package inloop.mymatrix;

import java.util.*;

public class MyMatrix<T> implements Matrix<T>, Iterator<T> {
    private HashMap<MatrixIndex, T> matrixEntries;

    @Override
    public int getRowCount() {
        int row = 0;
        for (MatrixIndex mi : matrixEntries.keySet()){
            int miRow = mi.getRow() + 1;
            if (miRow >= row) row = miRow;
        }
        return row;
    }

    @Override
    public int getColumnCount() {
        int column = 0;
        for (MatrixIndex mi : matrixEntries.keySet()){
            int miColumn = mi.getColumn() + 1;
            if (miColumn >= column) column = miColumn;
        }
        return column;
    }

    @Override
    public int getObjectCount() {
        return matrixEntries.size();
    }

    @Override
    public int getDistinctObjectCount() {
        Set<T> distinct = new HashSet<>(matrixEntries.values());
        return distinct.size();
    }

    @Override
    public T get(int row, int column) {
        MatrixIndex getter = new MatrixIndex(row, column);
        return matrixEntries.get(getter);
    }

    @Override
    public T put(int row, int column, T value) {
        T returner = get(row, column);
        matrixEntries.put(new MatrixIndex(row, column), value);
        return returner;
    }

    @Override
    public boolean contains(T value) {
        return matrixEntries.containsValue(value);
    }

    public class DepthFirstIterator {
        public DepthFirstIterator(){

        }
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public T next() {
        return null;
    }

    @Override
    public void remove() {
        Iterator.super.remove();
    }

}
