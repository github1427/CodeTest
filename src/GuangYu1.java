import java.util.Arrays;

/**
 * 给定一个整形数组(数组长度大于等于2)，数组元素有正有负，任意两个数相乘，可以得到一个积，求可以得到的最大的积。
 * 要求比较次数尽可能少，尽量不使用语言自带的容器。·
 * 例如数组{1,2,5,8，-10，-100,20,20}，返回1000即（-10*-100）
 */
public class GuangYu1 {
    public static void main(String[] args) {
        int [] array={1,2,5,8,-10,-100,20,20};
        System.out.println(maxMuti(array));
    }
    public static int maxMuti(int[] nums) {
        Arrays.sort(nums);
        return Math.max(nums[0]*nums[1],nums[nums.length-1]*nums[nums.length-2]);
    }
}