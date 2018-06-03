import java.util.HashSet;

/**
 * 输出给定字符串的全排列
 */
public class FullPermutation {
    public static void main(String[] args) {
        HashSet<String> strings=new HashSet<>();
        char[]chars={'a','b','c'};
        fullPermutation(chars,0,strings);
        for (String s:strings){
            System.out.print(s+" ");
        }
    }
    public static void fullPermutation(char [] chars, int start,HashSet<String> stringHashSet){
        if (start==chars.length-1){
            stringHashSet.add(String.valueOf(chars));
        }else {
            for (int m=start;m<chars.length;m++){
                swap(chars,m,start);
                fullPermutation(chars,start+1,stringHashSet);
                swap(chars,m,start);
            }
        }
    }
    public static void swap(char[] chars,int i,int j){
        char temp;
        temp=chars[i];
        chars[i]=chars[j];
        chars[j]=temp;
    }
}
