package matrixgui;

/**
 * Test for the matrix class
 * @author Davide Tonin
 * @version 3.0 2016-11-28
 */
public class Matrix {
    private int nRows;
    private int nCols;
    private double[][] elements;
    
    /**
     * Base constructor
     * @param nRows the number of the matrix's rows
     * @param nCols the number of the matrix's columns
     */
    public Matrix(int nRows, int nCols) {
        this.nRows = nRows;
        this.nCols = nCols;
        this.elements = new double[nRows][nCols];
    }
    
    
    /**
     * Complete constructor
     * @param nRows the number of the matrix's rows
     * @param nCols the number of the matrix's columns
     * @param elements matrix's elements
     */
    public Matrix(int nRows, int nCols, double[][] elements) {
        this.nRows = nRows;
        this.nCols = nCols;
        this.elements = elements;
    }
    
    /**
     * Return the element at (row, col) of the matrix
     * @param row the row
     * @param col the column
     * @return the element
     */
    public double get(int row, int col) {
        try{
           return elements[row][col]; 
        }catch(Exception e) {
            System.out.println(row + ", " + col + "; Error: out of index!");
            return 0;
        }
    }
    
    /**
     * Set the new value at (row, col) of the matrix
     * @param row the row
     * @param col the column
     * @param value the new value
     */
    public void set(int row, int col, double value) {
        elements[row][col] = value;
    }
    
    /**
     * Return the number of the columns
     * @return nCols
     */
    public int numberOfCols() {
        return nCols;
    }
    
    /**
     * Return the number of the rows
     * @return nRows
     */
    public int numberOfRows() {
        return nRows;
    }
    
    @Override
    public boolean equals(Object matrix) {
        if (nRows == ((Matrix)matrix).numberOfRows() && nCols == ((Matrix)matrix).numberOfCols()) {
            for(int row = 0; row < nRows; row++) {
                for(int col = 0; col < nCols; col++) {
                    if (this.get(row, col) != ((Matrix)matrix).get(row, col)) {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }
    
    /**
     * Calculates the scalar product of the current matrix
     * @param n the moltiplicator
     */
    public void scalarProduct(double n) {
        for(int row = 0; row < nRows; row++) {
            for(int col = 0; col < nCols; col++) {
                double value = get(row, col)*n;
                set(row, col, value);
            }
        }
    }
    
    /**
     * Return the scalar product between a matrix and a number
     * @param matrix the matrix
     * @param n the number
     * @return the result
     */
    public static Matrix scalarProduct(Matrix matrix, double n) {
        for(int row = 0; row < matrix.numberOfRows(); row++) {
            for(int col = 0; col < matrix.numberOfCols(); col++) {
                double value = matrix.get(row, col)*n;
                matrix.set(row, col, value);
            }
        }
        return matrix;
    }
    
    /**
     * Return the product between the current matrix and an other
     * @param other an other matrix
     * @return the result
     * @throws Exception if the product isn't possible
     */
    public Matrix product(Matrix other) throws Exception{
        if (this.numberOfCols() == other.numberOfRows()) {
            
            Matrix result = new Matrix(this.numberOfRows(), other.numberOfCols());
            double product = 0;
            for (int row = 0; row < this.numberOfRows(); row++) {
                for (int col = 0; col < other.numberOfCols(); col++) {
                    product = 0;
                    for (int rowOther = 0; rowOther < other.numberOfRows(); rowOther++) {
                        double element = other.get(rowOther, col);
                        product += (element*this.get(row, rowOther));
                    }
                    result.set(row, col, product);
                }
            }
            return result;
        }
        else {
            throw new Exception("Non è possibile eseguire il prodotto di queste matrici");
        }
    }
    
   
    /**
     * Return the product between two matrixes
     * @param m1 the first matrix
     * @param m2 the second matrix
     * @return result the result
     * @throws Exception if the product isn't possible
     */
    public static Matrix product(Matrix m1, Matrix m2) throws Exception{
        if (m1.numberOfCols() == m2.numberOfRows()) {
            
            Matrix result = new Matrix(m1.numberOfRows(), m2.numberOfCols());
            double product = 0;
            for (int row = 0; row < m1.numberOfRows(); row++) {
                for (int col = 0; col < m2.numberOfCols(); col++) {
                    product = 0;
                    for (int rowOther = 0; rowOther < m2.numberOfRows(); rowOther++) {
                        double element = m2.get(rowOther, col);
                        product += (element*m1.get(row, rowOther));
                    }
                    result.set(row, col, product);
                }
            }
            return result;
        }
        else {
            throw new Exception("Non è possibile eseguire il prodotto di queste matrici");
        }
    }
    
    @Override 
    public String toString() {
        String str = "";
        
        for(int row = 0; row < nRows; row++) {
            for(int col = 0; col < nCols; col++) {
                str += elements[row][col] + "\t";
            }
            str += "\n";
        }
        return str;
    }
}
