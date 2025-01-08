import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Practice {

	public static void main(String[] args) {

		String str = "31585345412328548353232546681";
		BigInteger nr = new BigInteger(str);
		BigInteger sqrt = nr.sqrt();
		System.out.println(sqrt);
		BigInteger nr1 = new BigInteger(str);
		System.out.println(nr.sqrt() + "  " + nr.sqrt().add(BigInteger.ONE));
		BigInteger val = nr.multiply(nr1);
		if (nr.multiply(nr1).compareTo(val) == 0) {
			System.out.println("equl");
		}

		// Scanner sc = new Scanner(System.in);
		// String str = sc.nextLine();

		// int op1 = 0, op2 = 0;

		// int prev1 = str.charAt(0) - 48;
		// int prev2 = prev1 > 0 ? 0 : 1;
		// op2 += 1;

		// for (int i = 1; i < str.length(); i++) {

		// // operations1
		// int pres1 = str.charAt(i) - 48;
		// int pres2 = pres1;

		// if (prev1 == 1 && pres1 == 1) {
		// prev1 = 0;
		// op1 += 1;
		// } else if (prev1 == 0 && pres1 == 0) {
		// prev1 = 1;
		// op1 += 1;
		// } else if ((prev1 == 0 && pres1 == 1) || (prev1 == 1 || pres1 == 0)) {
		// prev1 = pres1;
		// }

		// // operations2
		// if (prev2 == 1 && pres2 == 1) {
		// prev2 = 0;
		// op2 += 1;
		// } else if (prev2 == 0 && pres2 == 0) {
		// prev2 = 1;
		// op2 += 1;
		// } else if ((prev2 == 0 && pres2 == 1) || (prev2 == 1 || pres2 == 0)) {
		// prev2 = pres2;
		// }

		// }
		// System.out.println(op1 + " " + op2);

		// sc.close();
	}
}

// public static int longestDangerousRange(ArrayList<Integer> height, int n) {
// // Write your code here
// Queue<Integer> queue = new LinkedList<>();
// boolean greater = false;
// int count, finalCount = -1, lastQueueEle = -1;
// queue.add(height.get(0));
// for (int i = 1; i < height.size();) {
// if (queue.size() == 1) {
// System.out.println(queue.peek() + " " + height.get(i));
// if (queue.peek().equals(height.get(i))) {
// i++;
// continue;
// }
// queue.add(height.get(i));
// lastQueueEle = height.get(i);
// if (height.get(i) > height.get(i - 1)) {
// greater = false;
// } else {
// greater = true;
// }
// i++;
// }

// else if (lastQueueEle != height.get(i) && height.get(i) > height.get(i - 1)
// == greater) {
// queue.add(height.get(i));
// lastQueueEle = height.get(i);
// greater = !greater;
// i++;
// }

// else {
// count = queue.size();
// if (finalCount == -1) {
// finalCount = count;
// } else if (finalCount < count) {
// finalCount = count;
// }

// while (queue.size() != 1) {
// queue.poll();
// }
// }
// }
// count = queue.size();
// if (finalCount < count) {
// finalCount = count;
// }

// return finalCount;
// }

// public static int threePointer(ArrayList<Integer> X, ArrayList<Integer> Y,
// ArrayList<Integer> Z) {
// // Write your code here.
// int[] arr = new int[1];
// arr[0] = Integer.MIN_VALUE;
// threePointerHelper(X, Y, Z, 0, 0, 0, arr);
// return arr[0];
// }

// private static void threePointerHelper(ArrayList<Integer> A,
// ArrayList<Integer> B, ArrayList<Integer> C, int i,
// int j, int k, int[] arr) {
// if (i == A.size() || j == B.size() || k == C.size()) {
// return;
// }
// // System.out.println(i+" "+j+" "+k);

// int nr1 = A.get(i);
// int nr2 = B.get(j);
// int nr3 = C.get(k);
// int res = Math.max(Math.abs(nr1 - nr2), Math.max(Math.abs(nr2 - nr3),
// Math.abs(nr3 - nr1)));
// if (arr[0] == Integer.MIN_VALUE || arr[0] > res) {
// arr[0] = res;
// } else {
// return;
// }

// threePointerHelper(A, B, C, i, j, k + 1, arr);
// k = 0;
// threePointerHelper(A, B, C, i, j + 1, k, arr);
// j = 0;
// k = 0;
// threePointerHelper(A, B, C, i + 1, j, k, arr);
// }

// public static int minimumDifference(int n, int[] arr) {

// // Write your code here

// return minimumDifferenceHelper(arr, 0, arr.length - 1, 0, 0);
// }

// private static int minimumDifferenceHelper(int[] arr, int i, int j, int sum1,
// int sum2) {
// if (i > j) {
// return Math.abs(sum1 - sum2);
// }

// if (i == j) {
// int value1 = Math.abs(sum1 + arr[i] - sum2);
// int value2 = Math.abs(sum1 - sum2 - arr[i]);
// if (value1 < value2) {
// return value1;
// } else {
// return value2;
// }
// }

// if (sum1 < sum2) {
// return minimumDifferenceHelper(arr, i + 1, j, sum1 + arr[i], sum2);
// }

// else if (sum1 > sum2) {
// return minimumDifferenceHelper(arr, i, j - 1, sum1, sum2 + arr[j]);
// }

// else {
// return minimumDifferenceHelper(arr, i + 1, j - 1, sum1 + arr[i], sum2 +
// arr[j]);
// }

// }

// public static int firstCircularTour(ArrayList<Integer> petrol,
// ArrayList<Integer> distance, int n) {
// // Write your code here.

// if (n == 1) {
// return 0;
// }

// BigInteger petrolAdded = new BigInteger("0");

// BigInteger zero = new BigInteger("0");

// for (int i = 0; i < n; i++) {
// boolean cond = false;
// for (int j = i; j < n && !cond; j++) {
// BigInteger petrolBI = new BigInteger(String.valueOf(petrol.get(j)));
// BigInteger distanceBI = new BigInteger(String.valueOf(distance.get(j)));
// petrolAdded = petrolAdded.add(petrolBI.subtract(distanceBI));
// cond = petrolAdded.compareTo(zero) < 0;
// }
// for (int j = 0; j < i && !cond; j++) {
// BigInteger petrolBI = new BigInteger(String.valueOf(petrol.get(j)));
// BigInteger distanceBI = new BigInteger(String.valueOf(distance.get(j)));
// petrolAdded = petrolAdded.add(petrolBI.subtract(distanceBI));
// cond = petrolAdded.compareTo(zero) < 0;
// }

// if (cond) {
// petrolAdded = new BigInteger("0");
// continue;
// } else {
// return i;
// }
// }

// return -1;
// }

// private static int optimalStratergyOfGameHelper(int[] coins, int n, int i,
// int j, int sum, boolean p1) {
// if (i >= j) {
// // System.out.println("done");
// return sum;
// }

// if (p1) {
// if (coins[i] > coins[j]) {
// i++;
// } else {
// j--;
// }
// }

// // System.out.println("i " + i + " j " + j + " sum " + (sum + coins[i]));
// int amount1 = optimalStratergyOfGameHelper(coins, n, i + 1, j, sum +
// coins[i], true);
// // System.out.println("i " + i + " j " + j + " sum " + (sum + coins[j]));
// int amount2 = optimalStratergyOfGameHelper(coins, n, i, j - 1, sum +
// coins[j], true);

// if (amount1 > amount2) {
// return amount1;
// }
// return amount2;
// }

// public static int optimalStrategyOfGame(int[] coins, int n) {
// // Write your code here.
// return optimalStratergyOfGameHelper(coins, n, 0, n - 1, 0, false);
// }

// public static void main(String[] args) {
// // ArrayList<Integer> height=new ArrayList<>();
// Scanner sc = new Scanner(System.in);
// // int n=sc.nextInt();
// // for(int i=0;i<n;i++){
// // height.add(sc.nextInt());
// // }
// // int longestlength=longestDangerousRange(height, n);
// // System.out.println(longestlength);

// // more flaws more adjustments
// // ArrayList<Integer> X=new ArrayList<>();
// // ArrayList<Integer> Y=new ArrayList<>();
// // ArrayList<Integer> Z=new ArrayList<>();

// // int a=sc.nextInt();
// // for(int i=0;i<a;i++){
// // X.add(sc.nextInt());
// // }

// // int b=sc.nextInt();
// // for(int i=0;i<b;i++){
// // Y.add(sc.nextInt());
// // }

// // int c=sc.nextInt();
// // for(int i=0;i<c;i++){
// // Z.add(sc.nextInt());
// // }

// // threePointer(X, Y, Z);

// // int n = sc.nextInt();

// // ArrayList<Integer> petrol = new ArrayList<>();
// // ArrayList<Integer> distance = new ArrayList<>();
// // for (int i = 0; i < n; i++) {
// // petrol.add(sc.nextInt());
// // distance.add(sc.nextInt());
// // }
// // System.out.println(firstCircularTour(petrol, distance, n));

// // int[] arr = new int[n];
// // for (int i = 0; i < n; i++) {
// // arr[i] = sc.nextInt();
// // }

// // System.out.println(minimumDifference(n, arr));
// int testcases = sc.nextInt();
// while (testcases > 0) {
// int n = sc.nextInt();
// int[] coins = new int[n];
// for (int i = 0; i < n; i++) {
// coins[i] = sc.nextInt();
// }
// System.out.println(optimalStrategyOfGame(coins, n));
// testcases--;
// }
// sc.close();
// }
// }

// // 1
// // 10
// // 2 24 25 46 49 64 68 74 77 98
// // 10
// // 4 4 33 46 47 47 51 53 79 88
// // 10
// // 10 15 17 22 34 46 55 59 71 76