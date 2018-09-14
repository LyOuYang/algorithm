package method;

import org.junit.Test;
import java.util.HashSet;
import java.util.Set;

public class Factors {
    @Test
    public  void factorTest(){
        System.out.println(getFactorsList(28));
    }
    public static Set<Integer> getFactorsList(int number) {
        //ArrayList <Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        set.add(1);
        if (number != 0)
            set.add(number);
        //f从2开始，
        //如果%2!=0,那么f++，一直到number/2
        //如果%f == 0,那么就是因子
        for (int f = 2; f <= number / 2; f++) {
            if (number % f == 0) {
                number /= f;
                set.add(f);
            }

        }
        return set;
    }
}
