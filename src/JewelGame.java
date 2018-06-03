/**
 * 题目0.【宝石游戏】宝石游戏在13*6的格子里进行。
 * 游戏给出红色、蓝色、黄色、橘黄色、绿色、和柴色的宝石。
 * 当任何三个以上宝石具有相同颜色并且在一条直线（横竖斜）时，这些宝石可以消去。
 * 提示：输入：第一行n表示n组测试数据。
 * 下面每一个测试数据包含一个13 X 6的字符表，
 * 其中B表示蓝色，R表示红色，O表示橘黄色、Y表示黄色，G表示绿色，P表示紫色，W表示此处没有宝石。
 * 接下来三行，每行包含一个字符，表示新来的宝石下落的位置。输出：每一个测试样例，输出当所有宝石落下后游戏的状态。
 */
public class JewelGame {
    public static void main(String[] args) {
        //首先游戏地图初始化为W
        char[][] gameMap = initArray();
        //下落的三连宝石1
        char[][] newJewel1 = initArray();
        newJewel1[0][0] = 'B';
        newJewel1[1][0] = 'B';
        newJewel1[2][0] = 'O';
        //下落的三连宝石2
        char[][] newJewel2 = initArray();
        newJewel2[0][1] = 'B';
        newJewel2[1][1] = 'B';
        newJewel2[2][1] = 'O';
        //下落的三连宝石3
        char[][] newJewel3 = initArray();
        newJewel3[0][2] = 'B';
        newJewel3[1][2] = 'B';
        newJewel3[2][2] = 'Y';
        char[][] newJewel4 = initArray();
        newJewel4[0][3] = 'B';
        newJewel4[1][3] = 'G';
        newJewel4[2][3] = 'P';
        beforeEliminateStatus(gameMap, newJewel1);
        beforeEliminateStatus(gameMap, newJewel2);
        beforeEliminateStatus(gameMap, newJewel4);
        int[] index = beforeEliminateStatus(gameMap, newJewel3);
        //判断宝石3中的第一块宝石是否能消除
        eliminate(gameMap, index);
        //判断宝石3中的第二块宝石是否能消除
        index[0] += 1;
        eliminate(gameMap, index);
        //判断宝石3中的第三块宝石是否能消除
        index[0] += 1;
        eliminate(gameMap, index);
        //消除后的状态更新
        updateStatus(gameMap);
        //显示最后状态
        for (char[] aGameMap : gameMap) {
            for (int j = 0; j < gameMap[0].length; j++) {
                System.out.print(aGameMap[j] + " ");
            }
            System.out.println();
        }
    }

    //初始化二维数组元素都为‘W’
    public static char[][] initArray() {
        char[][] chars = new char[13][6];
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars[0].length; j++) {
                chars[i][j] = 'W';
            }
        }
        return chars;
    }

    //新石头下落后，游戏地图中的状态,并返回新宝石落下后所在地图中的位置
    public static int[] beforeEliminateStatus(char[][] gameMap, char[][] newJewel) {
        int[] index = new int[2];
        for (int i = 0; i < newJewel[0].length; i++) {
            if (newJewel[0][i] != 'W') {
                index[1] = i;
                for (int j = gameMap.length - 1; j >= 3; j--) {
                    if (gameMap[j][i] == 'W') {
                        index[0] = j - 2;
                        gameMap[j - 2][i] = newJewel[0][i];
                        gameMap[j - 1][i] = newJewel[1][i];
                        gameMap[j][i] = newJewel[2][i];
                        break;
                    }
                }
            }
        }
        return index;
    }

    //对满足条件的宝石进行消除
    public static void eliminate(char[][] gameMap, int[] index) {
        int row = index[0], col = index[1];
        int ele = gameMap[index[0]][index[1]];
        //判断宝石左侧是否能消除，若能，则消除
        if (col >= 2) {
            if (gameMap[row][col - 1] == ele && gameMap[row][col - 2] == ele) {
                gameMap[row][col] = 'W';
                gameMap[row][col - 1] = 'W';
                gameMap[row][col - 2] = 'W';
                if (col <= gameMap[0].length - 3) {
                    if (gameMap[row][col + 1] == ele && gameMap[row][col + 2] == ele) {
                        gameMap[row][col + 1] = 'W';
                        gameMap[row][col + 2] = 'W';
                    } else if (gameMap[row][col + 1] == ele) {
                        gameMap[row][col + 1] = 'W';
                    }
                }
            }
        }
        //判断宝石垂直方向是否能消除，若能，则消除
        if (row >= 2) {
            if (gameMap[row - 1][col] == ele && gameMap[row - 2][col] == ele) {
                gameMap[row][col] = 'W';
                gameMap[row - 1][col] = 'W';
                gameMap[row - 2][col] = 'W';
                if (row <= gameMap.length - 3) {
                    if (gameMap[row + 1][col] == ele && gameMap[row + 2][col] == ele) {
                        gameMap[row + 1][col] = 'W';
                        gameMap[row + 2][col] = 'W';
                    } else if (gameMap[row + 1][col] == ele) {
                        gameMap[row + 1][col] = 'W';
                    }
                }
            }
        }
        //判断宝石左斜方向是否能消除，若能，则消除
        if (col >= 2 && row >= 2) {
            if (gameMap[row - 1][col - 1] == ele && gameMap[row - 2][col - 2] == ele) {
                gameMap[row][col] = 'W';
                gameMap[row - 1][col - 1] = 'W';
                gameMap[row - 2][col - 2] = 'W';
                if (col <= gameMap[0].length - 3 && row <= gameMap.length - 3) {
                    if (gameMap[row + 1][col + 1] == ele && gameMap[row + 2][col + 2] == ele) {
                        gameMap[row + 1][col + 1] = 'W';
                        gameMap[row + 2][col + 2] = 'W';

                    } else if (gameMap[row + 1][col + 1] == ele) {
                        gameMap[row + 1][col + 1] = 'W';
                    }
                }
            }
        }

        //判断宝石右斜方向是否能消除，若能，则消除
        if (col <= gameMap[0].length - 3 && row >= 2) {
            if (gameMap[row - 1][col + 1] == ele && gameMap[row - 2][col + 2] == ele) {
                gameMap[row][col] = 'W';
                gameMap[row - 1][col + 1] = 'W';
                gameMap[row - 2][col + 2] = 'W';
                if (row <= gameMap.length - 3 && col >= 2) {
                    if (gameMap[row + 1][col - 1] == ele && gameMap[row + 2][col - 2] == ele) {
                        gameMap[row + 1][col - 1] = 'W';
                        gameMap[row + 2][col - 2] = 'W';
                    } else if (gameMap[row + 1][col - 1] == ele) {
                        gameMap[row + 1][col - 1] = 'W';
                    }
                }
            }
        }
    }

    //消除后的状态更新
    public static void updateStatus(char[][] gameMap) {
        for (int i = gameMap.length - 1; i > 0; i--) {
            for (int j = 0; j < gameMap[0].length; j++) {
                if (gameMap[i][j] == 'W') {
                    gameMap[i][j] = gameMap[i - 1][j];
                    gameMap[i - 1][j] = 'W';
                }
            }
        }
    }
}
