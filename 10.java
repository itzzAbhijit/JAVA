import java.util.Scanner;

class Matrix {
    int row, col;
    double M[][];

    Matrix(int row, int col) {
        this.row = row;
        this.col = col;
        this.M = new double[this.row][this.col];
    }

    void readMatrix() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++) {
                this.M[i][j] = sc.nextDouble();
            }
        }
    }

    Matrix ADD(Matrix M2) {
        if (this.row != M2.row || this.col != M2.col) {
            System.out.println("Addition not possible: Dimensions do not match.");
            return null;
        }

        Matrix result = new Matrix(this.row, this.col);
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++) {
                result.M[i][j] = this.M[i][j] + M2.M[i][j];
            }
        }
        return result;
    }

    Matrix SUB(Matrix M2) {
        if (this.row != M2.row || this.col != M2.col) {
            System.out.println("Subtraction not possible: Dimensions do not match.");
            return null;
        }

        Matrix result = new Matrix(this.row, this.col);
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++) {
                result.M[i][j] = this.M[i][j] - M2.M[i][j];
            }
        }
        return result;
    }

    Matrix MULTIPLY(Matrix M2) {
        if (this.col != M2.row) {
            System.out.println("Multiplication not possible: Incompatible dimensions.");
            return null;
        }

        Matrix result = new Matrix(this.row, M2.col);
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < M2.col; j++) {
                result.M[i][j] = 0;
                for (int k = 0; k < this.col; k++) {
                    result.M[i][j] += this.M[i][k] * M2.M[k][j];
                }
            }
        }
        return result;
    }

    Matrix TRANSPOSE() {
        Matrix result = new Matrix(this.col, this.row);
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++) {
                result.M[j][i] = this.M[i][j];
            }
        }
        return result;
    }

    void DISPLAY() {
        System.out.println("Matrix (" + this.row + "x" + this.col + "):");
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++) {
                System.out.print(this.M[i][j] + "\t");
            }
            System.out.println();
        }
    }
}

public class MatrixMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows and columns for Matrix A: ");
        int r1 = sc.nextInt();
        int c1 = sc.nextInt();
        Matrix A = new Matrix(r1, c1);
        System.out.println("Enter elements of Matrix A:");
        A.readMatrix();

        System.out.print("Enter number of rows and columns for Matrix B: ");
        int r2 = sc.nextInt();
        int c2 = sc.nextInt();
        Matrix B = new Matrix(r2, c2);
        System.out.println("Enter elements of Matrix B:");
        B.readMatrix();

        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Addition (A + B)");
            System.out.println("2. Subtraction (A - B)");
            System.out.println("3. Multiplication (A x B)");
            System.out.println("4. Transpose of Matrix A");
            System.out.println("5. Transpose of Matrix B");
            System.out.println("6. Exit");
            System.out.print("Enter your choice (1-6): ");
            choice = sc.nextInt();

            Matrix result;
            switch (choice) {
                case 1:
                    result = A.ADD(B);
                    if (result != null) {
                        System.out.println("Result of A + B:");
                        result.DISPLAY();
                    }
                    break;
                case 2:
                    result = A.SUB(B);
                    if (result != null) {
                        System.out.println("Result of A - B:");
                        result.DISPLAY();
                    }
                    break;
                case 3:
                    result = A.MULTIPLY(B);
                    if (result != null) {
                        System.out.println("Result of A x B:");
                        result.DISPLAY();
                    }
                    break;
                case 4:
                    result = A.TRANSPOSE();
                    System.out.println("Transpose of Matrix A:");
                    result.DISPLAY();
                    break;
                case 5:
                    result = B.TRANSPOSE();
                    System.out.println("Transpose of Matrix B:");
                    result.DISPLAY();
                    break;
                case 6:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 6);

        sc.close();
    }
}