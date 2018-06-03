import java.util.ArrayList;
import java.util.List;

public class BusCost {
    public static void main(String[] args) {
        int [] nums={10,21,31,40,49,58,69,79,90,101};
        System.out.println(minimumCost(nums));
        List<Integer> list=new ArrayList<>();
        list.add(null);
    }
    public static int minimumCost(int []nums){
        int len=nums.length;
        int [] dp=new int[len+1];
        for (int i=1;i<dp.length;i++){
            dp[i]=Math.min(nums[i-1],dp[i-1]+nums[0]);
        }
        return dp[10]+dp[5];
    }
}
