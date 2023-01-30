public class DynamicProgramming {

    public static int[][] bilbosMatrix = {
            //Bilbo's matrix-- bottom-up order as TA suggested
            {96, 33, 44, 98, 75, 68, 99, 84}, // R8
            {10, 41,  1, 86, 46, 24, 53, 93}, // R7
            {83, 97, 94, 27, 65, 51, 30,  7}, // R6
            {56, 70, 47, 64, 22, 88, 67, 12}, // R5
            {91, 11, 77, 48, 13, 71, 92, 15}, // R4
            {32, 59, 17, 25, 31,  4, 16, 63}, // R3
            {79,  5, 14, 23, 78, 37, 40, 74}, // R2
            {35, 89, 52, 66, 82, 20, 95, 21}, // R1
    };

    public static int moneyMoves(int row, int place) {
        int nextPlace = 0;

        if (place == 0) {
            if (bilbosMatrix[row - 1][place] > bilbosMatrix[row - 1][place + 1]) {
                nextPlace = place;
            } else if (bilbosMatrix[row - 1][place] < bilbosMatrix[row - 1][row + 1]) {
                nextPlace = place + 1;
            }
        } else if (place == 7) {
            if (bilbosMatrix[row - 1][place] >= bilbosMatrix[row - 1][place - 1]) {
                nextPlace = place;
                //System.out.println(bilbosMatrix[row - 1][nextPlace]);
            } else if (bilbosMatrix[row - 1][place] <= bilbosMatrix[row - 1][place - 1]) {
                nextPlace = place - 1;

            }
        } else {
            if (bilbosMatrix[row - 1][place + 1] >= bilbosMatrix[row - 1][place] && bilbosMatrix[row - 1][place + 1] >= bilbosMatrix[row - 1][place - 1]) {
                nextPlace = place + 1;
            } else if (bilbosMatrix[row - 1][place] >= bilbosMatrix[row - 1][place - 1] && bilbosMatrix[row - 1][place] >= bilbosMatrix[row - 1][place + 1]) {
                nextPlace = place;
                //System.out.println(bilbosMatrix[row - 1][nextPlace]);
            } else if (bilbosMatrix[row - 1][place - 1] >= bilbosMatrix[row - 1][place + 1] && bilbosMatrix[row - 1][place - 1] >= bilbosMatrix[row - 1][place]) {
                nextPlace = place - 1;
            }
        }
        return nextPlace;
    }

    public static void main(String[] args) {

        int max, min;
        max = 8;
        min = 1;
        //origin var is going to be a random index between 8 and 1 (inclusive)
        int origin = (int) (Math.random() * ((max - min) + 1)) + min;

        origin = origin - 1;
        int total = bilbosMatrix[7][origin];
        System.out.println("Bilbo Baggins' starting square");
        System.out.println();
        System.out.println("Row number -> " + 1 + "; Vault number -> " + (origin + 1));
        System.out.println("Value of Vault -> " + bilbosMatrix[7][origin]);
        System.out.println("Total gems collected -> " + total);

        for (int i = 7; i >= 1; i--) {
            origin = moneyMoves(i, origin);
            total = total + bilbosMatrix[i - 1][origin];
            if (i == 1) {
                System.out.println("MOST PRECIOUS PATH :)");
                System.out.println("Row number -> " + (9 - i) + "; Vault number -> " + (origin + 1));
                System.out.println("Value of Vault -> " + bilbosMatrix[i - 1][origin]);
                System.out.println("Total gems collected -> " + total);
                System.out.println();
            } else {
                System.out.println();
                System.out.println("Row number -> " + (9 - i) + "; Vault number -> " + (origin + 1));
                System.out.println("Value of Vault ->  " + bilbosMatrix[i - 1][origin]);
                System.out.println("Total gems collected -> " + total);
                System.out.println();
            }
        }
    }
}

