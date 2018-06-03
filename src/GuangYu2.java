public class GuangYu2 {
    public static void main(String[] args) {
        Monster [] monsters=new Monster[]{
                new Monster(12,24),
                new Monster(18,20),
                new Monster(19,20),
                new Monster(25,30),
                new Monster(10,23),
                new Monster(10,23)
        };
        System.out.println(wonMaxCoin(monsters));
    }

    private static int wonMaxCoin(Monster[] monsters) {
        int len=monsters.length;
        //maxCoin[i][j]表示当消灭怪物i,剩余时间j,此时获得的最大金币数
        int [][]maxCoin=new int[len+1][41];
        for (int i=1;i<len+1;i++){
            for (int j=1;j<41;j++){
                if (monsters[i-1].costTime<=j){
                    maxCoin[i][j]=Math.max(maxCoin[i-1][j],maxCoin[i-1][j-monsters[i-1].costTime]+monsters[i-1].coinNum);
                }else {
                    maxCoin[i][j]=maxCoin[i-1][j];
                }
            }
        }
        return maxCoin[len][40];
    }

}
class Monster{
    int costTime;
    int coinNum;

    Monster(int costTime, int coinNum) {
        this.costTime = costTime;
        this.coinNum = coinNum;
    }
}