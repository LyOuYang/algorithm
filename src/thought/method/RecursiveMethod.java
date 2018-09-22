package thought.method;

import org.junit.Test;

public class RecursiveMethod {
    public int maxWater(int[] blocks){
        int result = maxWater(blocks, 0, blocks.length - 1);
        return result;
    }

    /**
     *  得到数组前后木板中较小的minBorder
     *  遍历start+1到end-1，得到最大值的索引index
     *  如果b>minBord,递归调用方法
     *  如果b<=minBord,返回minBord*(end-start)
     * @param blocks 原数组
     * @param start  查找开始的索引
     * @param end    查找结束的索引
     * @return
     */
    private int maxWater(int[] blocks, int start, int end) {
        int minBorderIndex;
        int result;
        if(blocks[start]>blocks[end])
            minBorderIndex = end;
        else
            minBorderIndex = start;
        int index = minBorderIndex;
        for (int i = start + 1; i < end; i++) {
            if (blocks[i]>blocks[index]){
                index = i;
            }
        }
        if (minBorderIndex!=index){
             result = maxWater(blocks, start, index)+ maxWater(blocks, index, end);
        }else
            return blocks[minBorderIndex]*(end - start);
        return result;
    }

    @Test
    public void testMaxWater() {
        int[] testArr = {2,3,4,1,111};
        System.out.println(maxWater(testArr));

    }
}
