public class GaussJordon {

    /*
     What do we have to do?
     MAJOR : Manipulate the code given for Gaussian Elimination to perform Gauss-Jordon Elimination
            NEEDS TO :
                    solve a system of linear equations in n unknowns with the form Ax = b
                    (A is an n x n matrix of real coefficients)
                    (b is a column vector with n real entries)
     */

    public static int GaussJordanElim(double a[][], int n) {
        int i;
        int j;
        int k;
        int c;
        int fl = 0;// printed vars on separate lines to keep track since there are a lot

        for (i = 0; i < n; i++) {
            if (a[i][i] == 0) {
                c = 1;
                while ((i + c) < n && a[i + c][i] == 0)
                    c++;
                if ((i + c) == n) {
                    fl = 1;
                    break;
                }
                for (j = i, k = 0; k <= n; k++) {
                    double temp = a[j][k];
                    a[j][k] = a[j + c][k];
                    a[j + c][k] = temp;
                }
            }
            for (j = 0; j < n; j++) {
                if (i != j) {
                    double zoiks = a[j][i] / a[i][i];// named it zoiks bc I didn't know what else to name it lol
                    for (k = 0; k <= n; k++)
                        a[j][k] = a[j][k] - (a[i][k]) * zoiks;
                }
            }
        }
        return fl;
    }

    public static void result(double array[][], int n, int fl) {// since it's a matrix we can't just do
        // a print statement, so I made a helper method to make it print the values
        System.out.println("Result ");
        if (fl == 2)
            System.out.println("Infinitely Many Solutions");
        else if (fl == 3)
            System.out.println("No Solution");
    }

    public static int check(double[][] array, int n) {
        int i, j;
        double sum;

        int fl = 3;
        for (i = 0; i < n; i++) {
            sum = 0;
            for (j = 0; j < n; j++)
                sum = sum + array[i][j];
            if (sum == array[i][j])
                fl = 2;
        }
        return fl;
    }

    public static void printMatrix(double arr[][], int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n; j++)
                System.out.print(arr[i][j] + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        double arrayOfInts[][] = {
                //array we were given in problem
                {1,  1, 1,  1,  1,  1,  1,  1, 1,  1, 1,  1, 364},
                {1,  1, 0,  0,  0,  0,  0,  0, 0,  0, 0,  0,   4},
                {0,  0, 1,  1,  0,  0,  0,  0, 0,  0, 0,  0,  16},
                {0,  0, 0,  0,  1,  1,  0,  0, 0,  0, 0,  0,  36},
                {0,  0, 0,  0,  0,  0,  1,  1, 0,  0, 0,  0,  64},
                {0,  0, 0,  0,  0,  0,  0,  0, 1,  1, 0,  0, 100},
                {1,  0, 0,  0,  0,  0,  0,  0, 0,  0, 0,  1,  79},
                {0,  0, 1,  0,  0,  0,  0,  0, 0,  1, 0,  0,  61},
                {0,  0, 0,  0,  0,  4, -3,  0, 0,  0, 0,  0,   0},
                {0,  0, 0,  3, -2,  0,  0,  0, 0,  0, 0,  0,   0},
                {0,  0, 0,  1,  0,  0,  0,  0, 1, -1, 0,  0,   0},
                {1, -1, 1, -1,  1, -1,  1, -1, 1, -1, 1, -1, -42}
        };

        System.out.println();
        System.out.println("Starting Matrix");
        printMatrix(arrayOfInts, 12);
        System.out.println();
        int n = 12, fl = 0;
        fl = GaussJordanElim(arrayOfInts, n);
        if (fl == 1)
            fl = check(arrayOfInts, n);

        for (int i = 0; i < n; i++) {
            arrayOfInts[i][n] = arrayOfInts[i][n] / arrayOfInts[i][i];
            arrayOfInts[i][i] = 1;
        }
        System.out.println("Augmented Matrix");
        printMatrix(arrayOfInts, n);
        System.out.println();
        System.out.println();
        result(arrayOfInts, n, fl);

        for (int i = 0; i < n; i++) {
            System.out.println("x of " + (i + 1) + ": " + arrayOfInts[i][n]);
        }
        System.out.println();
    }
}






