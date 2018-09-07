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
        /* ���ضԳ������ַ��� */
        int max = 0;
        /* �ַ����� char���� */
        char[] c = str.toCharArray();
        /* ����ĳ���*/
        int len = c.length;
        for (int i = 0; i < len - 1; i++) {
            /* �Գ����� */
            if (c[i] == c[i + 1]) {
                /* �ԳƵ��ַ��� */
                int symmetryNum = 2;
                /* �ӶԳ����ĵ��������ߵľ����У�������С��һ��*/
                int shorter = Math.min(i, len - i - 1);
                /* �����ƶ���λ��*/
                int left = i;
                /* �����ƶ���λ��*/
                int right = i + 1;
                /* ����shorter�Σ��ҳ��Գ���������ĶԳ��ַ�*/
                while (shorter-- > 0) {
                    /* Խ������ѭ�������Գ�����ѭ��*/
                    if (left <= 0 || right >= len - 1 || c[--left] != c[++right]) {
                        break;
                    }
                    /* �ԳƼ�¼�ԳƵ��ַ���*/
                    symmetryNum = symmetryNum + 2;
                }
                /* �趨���ĶԳ��ַ��� */
                if (symmetryNum >= max) {
                    max = symmetryNum;
                }
            }
        }
        return max;
    }

}
