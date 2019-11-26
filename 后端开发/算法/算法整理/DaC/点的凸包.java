package DaC;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author zhaodeyu
 * @classname DaC.点的凸包
 * @description TODO
 * @date 2019-11-26 23:06
 */
public class 点的凸包 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for (int i = 0; i < test; i++) {
            int n = sc.nextInt();
            Point[] points = new Point[n];
            for (int j = 0; j < n; j++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                points[j] = new Point(x, y);
            }
            List<Point> res = calTrees(points);
            if (res.size() < 3) {
                System.out.println(-1);
            } else {
                String str = res.stream()
                        .map(p -> p.x + " " + p.y)
                        .collect(Collectors.joining(", "));
                System.out.println(str);
            }
        }
    }

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int calPoint(Point p, Point q, Point r) {
        return (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);
    }

    public static List<Point> calTrees(Point[] points) {
        Arrays.sort(points, (p, q) -> q.x - p.x == 0 ? q.y - p.y : q.x - p.x);
        Stack<Point> stacks = new Stack<>();
        for (int i = 0; i < points.length; i++) {
            while (stacks.size() >= 2 && calPoint(stacks.get(stacks.size() - 2), stacks.get(stacks.size() - 1), points[i]) > 0)
                stacks.pop();
            stacks.push(points[i]);
        }
        stacks.pop();
        for (int i = points.length - 1; i >= 0; i--) {
            while (stacks.size() >= 2 && calPoint(stacks.get(stacks.size() - 2), stacks.get(stacks.size() - 1), points[i]) > 0)
                stacks.pop();
            stacks.push(points[i]);
        }
        List<Point> res = new ArrayList<>(new HashSet<>(stacks));
        res.sort((p1, p2) -> {
            if (p1.x == p2.x) {
                return p1.y - p2.y;
            }
            return p1.x - p2.x;
        });
        return res;
    }
}