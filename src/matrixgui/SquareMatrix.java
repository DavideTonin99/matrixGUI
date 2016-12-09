package matrixgui;

/**
 * Represents a square matrix
 * @author Davide Tonin
 * @version 3.0 2016-11-28
 */
public class SquareMatrix extends Matrix{
    
    /**
     * Base constructor
     * @param size the size of the matrix 
     */
    public SquareMatrix(int size) {
        super(size, size);
    }
    
    /**
     * Complete constructor
     * @param size the size of the matrix
     * @param elements the elements of the matrix
     */
    public SquareMatrix(int size, double[][] elements) {
        super(size, size, elements);
    }
    
    /**
     * Complete constructor
     * @param elements the elements of the matrix
     */
    public SquareMatrix(double[][] elements) {
        super(elements.length, elements.length, elements);
    }
        
    /**
     * Return the size of the matrix
     * @return numberOfRows() the size
     */
    public int size() {
        return numberOfRows();
    }
    
    /**
     * Return the sum of two matrixes
     * @param m1 the first SquareMatrix
     * @param m2 the second SquareMatrix
     * @return the sum of the two matrixes
     * @throws Exception matrixes with different dimension
     */
    public static SquareMatrix add(SquareMatrix m1, SquareMatrix m2) throws Exception{
        SquareMatrix result;
        
        if (m1.size() == m2.size()) {
            result = new SquareMatrix(m1.size());
            for (int row=0; row<m1.size(); row++) {
                for(int col=0; col<m1.size(); col++) {
                    double value = m1.get(row, col) + m2.get(row, col);
                    result.set(row, col, value);
                }
            }
        } else {
            throw new Exception("Le due matrici devo avere la stessa dimensione");
        }
        return result;
    }
        
    /**
     * Add an other matrix to the current matrix
     * @param other other SquareMatrix
     * @throws Exception matrixes with different dimension
     */
    public void add(SquareMatrix other) throws Exception{
        if (this.size() == other.size()) {
            for (int row=0; row<this.size(); row++) {
                for(int col=0; col<this.size(); col++) {
                    double value = this.get(row, col) + other.get(row, col);
                    this.set(row, col, value);
                }
            }
        } else {
            throw new Exception("Le due matrici devo avere la stessa dimensione");
        }
    }
    
    /**
     * Calculates the traspose matrix of the current matrix
     */
    public void traspose() {
        for (int row = 0; row < this.numberOfRows(); row++) {
            for (int col = row; col < this.numberOfCols(); col++) {
                double value = this.get(row, col);
                this.set(row, col, this.get(col, row));
                this.set(col, row, value);
            }
        }
    }
    
    /**
     * Calculates the traspose matrix of a matrix
     * @param matrix the matrix
     * @return matrix the traspose matrix
     */
    public static SquareMatrix traspose(SquareMatrix matrix) {
        for (int row = 0; row < matrix.numberOfRows(); row++) {
            for (int col = row; col < matrix.numberOfCols(); col++) {
                double value = matrix.get(row, col);
                matrix.set(row, col, matrix.get(col, row));
                matrix.set(col, row, value);
            }
        }
        return matrix;
    }
    
    /**
     * Return if the current matrix is identity
     * @return true if is identity, else false
     */
    public boolean isIdentity() {
        
        for (int row = 0; row < this.numberOfRows(); row++) {
            for (int col = 0; col < this.numberOfCols(); col++) {
                if (row == col) {
                    if (this.get(row, col) != 1) {
                        return false;
                    }
                }
                else {
                    if (this.get(row, col) != 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    /**
     * Return if the matrix is identity
     * @return true if is identity, else false
     */
    public static boolean isIdentity(SquareMatrix matrix) {
        
        for (int row = 0; row < matrix.numberOfRows(); row++) {
            for (int col = 0; col < matrix.numberOfCols(); col++) {
                if (row == col) {
                    if (matrix.get(row, col) != 1) {
                        return false;
                    }
                }
                else {
                    if (matrix.get(row, col) != 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    /**
     * Return if the current matrix is orthogonal
     * @return true if it is orthogonal, else false
     */
    public boolean isOrthogonal() {
        try {
            Matrix product = this.product(traspose(this));
            return this.isIdentity();
        }catch(Exception e) {
            System.out.println("Errore, nel traspose la matrice deve essere quadrata");
            return false;
        }
    }
    
    /**
     * Return if a matrix is orthogonal
     * @param matrix the matrix
     * @return true if it is orthogonal, else false
     */
    public static boolean isOrthogonal(SquareMatrix matrix) {
        try {
            Matrix product = matrix.product(traspose(matrix));
            return matrix.isIdentity();
        }catch(Exception e) {
            System.out.println("Errore, nel traspose la matrice deve essere quadrata");
            return false;
        }
    }
}

