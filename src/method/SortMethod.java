package method;

import org.junit.Test;

import java.util.Arrays;

public class SortMethod {
    int [] testArr = {1,2,4,2,3,44,2,1,333,23,445,21,2};
    public static int[] bubbleSort(int[] srcList) {
        int arrLength = srcList.length;
        boolean flag;
        for (int i = 0; i < arrLength - 1; i++) {
            flag = true;
            //每一轮前一个和后一个比，比较到总元素减当前轮次
            for (int j = 0; j < arrLength - i - 1; j++) {
                if (srcList[j] > srcList[j + 1]) {
                    srcList[j] = srcList[j] + srcList[j + 1];
                    srcList[j + 1] = srcList[j] - srcList[j + 1];
                    srcList[j] = srcList[j] - srcList[j + 1];
                    flag = false;
                }
            }
            //如果某论每次都没进行调换说明排序完成
            if (flag)
                break;
        }

        return srcList;
    }

    public static int[] insertSort(int[] srcList) {
        //如果数组为空或者只有一个元素，返回本身
        if (srcList.length == 0 || srcList.length == 1)
            return srcList;
        //每次取一个新值，从第二个到第n个元素
        for (int i = 1; i < srcList.length; i++) {
            for (int j = i - 1; j > 0; j--) {
                //如果次元素比前一个小则交换，一直到比前一个元素大
                if (srcList[i] < srcList[j]) {
                    srcList[i] = srcList[i]+srcList[j];
                    srcList[j] = srcList[i] - srcList[j];
                    srcList[i] = srcList[i] - srcList[j];
                }else
                    break;
            }
        }



        return srcList;
    }
    @Test
    public void insertTest(){
        System.out.println(Arrays.toString(insertSort(insertSort(testArr))));
    }

    @Test
    public void bubbleTest() {
        System.out.println(Arrays.toString(bubbleSort(testArr)));
    }


}
