import java.util.Scanner;

class LeetCode7July {

    private static boolean isEligible(int i, int j, char[][] grid) {

        int nrOfX = 0, nrofY = 0;

        for (int rows = 0; rows < i; rows++) {
            for (int columns = 0; columns < j; columns++) {
                if (grid[rows][columns] == 'X') {
                    nrOfX++;
                } else if (grid[rows][columns] == 'Y') {
                    nrofY++;
                }
            }
        }

        if (nrOfX == nrofY && nrOfX >= 1) {
            return true;
        }
        return false;

    }

    private static void helper(int i, int j, int r, int c, char[][] grid, int[] count, int[][] dynamicArray) {

        if (r <= 1 && c <= 1) {
            return;
        }

        else if (i - 1 == grid.length || j - 1 == grid[0].length) {
            return;
        }

        else {
            boolean isEligible = isEligible(i, j, grid);
            if (isEligible) {
                count[0] += 1;
            }
        }

        System.out.println(i + " " + j);

        helper(i, j + 1, r, c, grid, count);
        helper(i + 1, j, r, c, grid, count);
        helper(i + 1, j + 1, r, c, grid, count);

    }

    public static void main(String[] args) {
        int r = 4;
        int c = 3;

        char[][] grid = new char[r][c];

        int[][] dynamicArray = new int[r][c];

        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                grid[i][j] = sc.next().charAt(0);
            }
        }

        int count[] = { 0 };

        helper(0, 0, r, c, grid, count, dynamicArray);

        System.out.println(count[0]);

        sc.close();

    }
}