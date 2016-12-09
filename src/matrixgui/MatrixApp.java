package matrixgui;

/**
 * Test for the matrix class
 * @author Davide Tonin
 * @version 3.0 2016-11-28
 */
public class MatrixApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double[][] elementsMatrix1 = {{1, 2}};
        double[][] elementMatrix2 = {{1, 2, 1}, {0, 3, -1}};
        Matrix matrix1 = new Matrix(1, 2, elementsMatrix1);
        Matrix matrix2 = new Matrix(2, 3, elementMatrix2);
        System.out.println("matrix1: ");
        System.out.println(matrix1);
        System.out.println("matrix2: ");
        System.out.println(matrix2);
        System.out.println("equals: " + matrix1.equals(matrix2));
        
        matrix1.scalarProduct(10);
        System.out.println("\nscalar product matrix1*10: ");
        System.out.println(matrix1);
        
        double[][] eSquareMatrix1 = {{1, 2}, {3, 4}};
        double[][] eSquareMatrix2 = {{2, 3}, {3, 5}};
        double[][] eSquareMatrix3 = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        SquareMatrix squareMatrix1 = new SquareMatrix(eSquareMatrix1);
        SquareMatrix squareMatrix2 = new SquareMatrix(eSquareMatrix2);
        SquareMatrix squareMatrix3 = new SquareMatrix(eSquareMatrix3);
        System.out.println("square matrix 1:");
        System.out.println(squareMatrix1);
        System.out.println("square matrix 2:");
        System.out.println(squareMatrix2);
        System.out.println("square matrix 3:");
        System.out.println(squareMatrix3);
        
        try{
        squareMatrix1.add(squareMatrix2);
        } catch(Exception e) {
            System.out.println("Addizione non possibile, le matrici devono essere dello stesso ordine");
        }
        System.out.println("square matrix 1 dopo la somma con square matrix 2:");
        System.out.println(squareMatrix1);
        System.out.println("Square matrix 1 isIdentity: " + squareMatrix1.isIdentity());
        System.out.println("Square matrix 1 isOrthogonal: " + squareMatrix1.isOrthogonal());
        System.out.println("Square matrix 3 isIdentity: " + squareMatrix3.isIdentity());
        System.out.println("Square matrix 3 isOrthogonal: " + squareMatrix3.isOrthogonal());
    }    
}

