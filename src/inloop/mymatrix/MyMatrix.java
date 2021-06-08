package inloop.mymatrix;

import java.util.*;

public class MyMatrix<T> implements Matrix<T> {
    private Map<MatrixIndex, T> matrixEntries = new HashMap<>();

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
        if(row >= getRowCount()) throw new IllegalArgumentException("row is out of bounds!");
        if(column >= getColumnCount()) throw new IllegalArgumentException("column is out of bounds!");

        MatrixIndex getter = new MatrixIndex(row, column);
        return matrixEntries.get(getter);
    }

    @Override
    public T put(int row, int column, T value) {
        T returner = matrixEntries.get(new MatrixIndex(row, column));
        matrixEntries.put(new MatrixIndex(row, column), value);
        return returner;
    }

    @Override
    public boolean contains(T value) {
        return matrixEntries.containsValue(value);
    }

    public class DepthFirstIterator implements Iterator<T> {
        private T nextT;
        private int currentRow;
        private int currentColumn;
        private boolean available;

        public DepthFirstIterator(){
            currentRow = 0;
            currentColumn = 0;
            available = true;
        }

        @Override
        public boolean hasNext() {
            while (currentColumn < getColumnCount()) {
                T object = get(currentRow, currentColumn);

                if (!(currentRow + 1 < getRowCount())) {
                    currentRow = 0;
                    currentColumn++;
                }
                else currentRow++;

                if (object != null) {
                    nextT = object;
                    available = true;
                    return true;
                }
            }
            available = false;
            return false;
        }

        @Override
        public T next() {
            if (!available && !hasNext()) throw new NoSuchElementException();
            available = false;
            return nextT;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new DepthFirstIterator();
    }
}