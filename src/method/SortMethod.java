package method;

import org.junit.Test;

import java.util.Arrays;
public class SortMethod {
    int[] testArr = {1, 55, 23,12,43,34,5,4342,45,31,0,-1,33,45,644};

    public static int[] selectSort(int[] srcList) {
        //给予交换标志

        //如果数组长度为空或着1返回原数组
        if (srcList.length == 0 || srcList.length == 1)
            return srcList;

        //循环n次，每次选择当前次元素i，索引记录
        for (int i = 0; i < srcList.length - 1; i++) {
            int index = i;
            boolean flag = false;
            //每个元素与i 到 n 个元素对比，保存找到的最小值的索引
            for (int j = i + 1; j < srcList.length; j++) {
                if (srcList[index] > srcList[j]) {
                    index = j;
                    flag = true;
                }
            }
            //全部循环完后交换
            if (flag) {
                srcList[i] = srcList[index] + srcList[i];
                srcList[index] = srcList[i] - srcList[index];
                srcList[i] = srcList[i] - srcList[index];
            }

        }
        return srcList;
    }

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
            for (int j = i - 1; j >= 0; j--) {
                //如果次元素比前一个小则交换，一直到比前一个元素大
                if (srcList[j] > srcList[j + 1]) {
                    srcList[j] = srcList[j + 1] + srcList[j];
                    srcList[j + 1] = srcList[j] - srcList[j + 1];
                    srcList[j] = srcList[j] - srcList[j + 1];
                } else
                    break;
            }
        }

        return srcList;
    }

    public static int[] mergeSort(int[] srcList) {
        if (srcList == null)
            return null;
        if (srcList.length == 0 || srcList.length == 1)
            return srcList;
        //拆分
        emergeList(srcList, 0, srcList.length - 1);
        return srcList;
    }

    private static void emergeList(int[] srcList, int left, int right) {
        int median = (left + right) / 2;
        if (left < right) {
            emergeList(srcList, left, median);
            emergeList(srcList, median + 1, right);
            //合并
            combine(srcList, left, median, right);
        }
    }


        private static void combine(int[] srcList, int left, int median, int right){
            int _left = left, _median = median+1, _right = right;
            int start = 0;
            int[] _srcList = new int[right-left+1];
            while (_left <= median && _median <= right) {
                if (srcList[_left] < srcList[_median]) {
                    _srcList[start++] = srcList[_left++];
                } else {
                    _srcList[start++] = srcList[_median++];
                }
            }
            while (_left <= median) {
                _srcList[start++] = srcList[_left++];
            }

            while (_median <= right) {
                _srcList[start++] = srcList[_median++];
            }
            for (int i = 0;i<_srcList.length;i++){
                srcList[i+left] = _srcList[i];
            }
        }



    @Test
    public void testMergeSort() {
        System.out.println(" mergeSort："+Arrays.toString(mergeSort(testArr)));
    }

    @Test
    public void selectTest() {
        System.out.println("selectSort: " + Arrays.toString(selectSort(testArr)));
    }

    @Test
    public void insertTest() {
        System.out.println("insertSort: " + Arrays.toString(insertSort(testArr)));
    }

    @Test
    public void bubbleTest() {
        System.out.println("bubbleSort: " + Arrays.toString(bubbleSort(testArr)));
    }


}
