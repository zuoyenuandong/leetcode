import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class No3007 {

    public static void main(String[] args) {

        System.out.println(findMaximumNumber(9, 1));
    }

    public static long findMaximumNumber(long k, int x) {

        int countValue = 0;
        int num = 1;
        while (num >= 1) {

            int value = 0;
            int temp = num;
            boolean firstFlag = true;
            do  {
                if (firstFlag) {
                    temp = temp >> (x - 1);
                    firstFlag = false;
                } else {
                    temp = temp >> x;
                }

                value += temp & 1;
            } while((temp | 0) != 0);

            countValue += value;
            if (countValue > k ) {
                return num - 1;
            }

            num++;

        }
        return num - 1;
    }
}
