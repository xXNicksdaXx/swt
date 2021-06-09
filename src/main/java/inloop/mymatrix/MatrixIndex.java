package inloop.mymatrix;

public class MatrixIndex{
    private int row;
    private int column;

    public MatrixIndex(int row, int column){
        if (row < 0) throw new IllegalArgumentException("row cannot be negative!");
        if (column < 0) throw new IllegalArgumentException("column cannot be negative!");

        this.row = row;
        this.column =column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    @Override
    public boolean equals(Object o){
        if (o == null) throw new NullPointerException("o cannot be null!");
        if (!(o instanceof MatrixIndex)) return false;
        return o.hashCode() == hashCode();
    }

    @Override
    public int hashCode(){
        return getRow() * 100 + getColumn() * 10;
    }
}
