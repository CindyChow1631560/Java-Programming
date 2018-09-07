package algorithm;
import java.util.*;
public class Sy {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int number  = getSymmetry(str);
        System.out.println(number);
	}
    private static int getSymmetry(String str) {
        /* 返回对称最大的字符数 */
        int max = 0;
        /* 字符串的 char数组 */
        char[] c = str.toCharArray();
        /* 数组的长度*/
        int len = c.length;
        for (int i = 0; i < len - 1; i++) {
            /* 对称中心 */
            if (c[i] == c[i + 1]) {
                /* 对称的字符数 */
                int symmetryNum = 2;
                /* 从对称中心到左右两边的距离中，返回最小的一个*/
                int shorter = Math.min(i, len - i - 1);
                /* 向左移动的位置*/
                int left = i;
                /* 向右移动的位置*/
                int right = i + 1;
                /* 遍历shorter次，找出对称中心两侧的对称字符*/
                while (shorter-- > 0) {
                    /* 越界跳出循环；不对称跳出循环*/
                    if (left <= 0 || right >= len - 1 || c[--left] != c[++right]) {
                        break;
                    }
                    /* 对称记录对称的字符数*/
                    symmetryNum = symmetryNum + 2;
                }
                /* 设定最大的对称字符数 */
                if (symmetryNum >= max) {
                    max = symmetryNum;
                }
            }
        }
        return max;
    }

}
