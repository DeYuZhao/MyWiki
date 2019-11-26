package Search;

import java.util.Scanner;

/**
 * @author zhaodeyu
 * @classname Search.漆狗屋
 * @description
 * Dilpreet wants to paint his dog- Buzo's home that has n boards with different lengths[A1, A2,..., An].
 * He hired k painters for this work and each painter takes 1 unit time to paint 1 unit of the board.
 * The problem is to find the minimum time to get this job done under the constraints that
 * any painter will only paint continuous sections of boards, say board {2, 3, 4} or only board {1} or nothing but not board {2, 4, 5}.
 * @date 2019-11-25 22:55
 */
public class 漆狗屋 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long times = scanner.nextLong();
        for (int i = 0; i < times; i++) {
            int head = scanner.nextInt();
            int bookNum = scanner.nextInt();
            int[] books = new int[bookNum];
            for (int j = 0; j < bookNum; j++) {
                books[j] = scanner.nextInt();
            }
            int[][] dp = new int[head + 1][bookNum + 1];
            for (int j = 0; j < bookNum + 1; j++) {
                dp[1][j] = sum(books, 0, j);
            }
            for (int j = 0; j < head + 1; j++) {
                dp[j][1] = books[0];
            }
            for (int j = 2; j < head + 1; j++) {
                for (int k = 2; k < bookNum + 1; k++) {
                    int best = Integer.MAX_VALUE;
                    for (int l = 1; l < k; l++) {
                        best = Math.min(best, Math.max(dp[j - 1][l], sum(books, l, k)));
                    }
                    dp[j][k] = best;
                }
            }
            System.out.println(dp[head][bookNum]);
        }
    }
    private static int sum(int[] is, int start, int end) {
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += is[i];
        }
        return sum;
    }
}
