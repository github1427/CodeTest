import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            Set<Integer> set =new TreeSet<>();
            String [] strings=scanner.nextLine().split(" ");
            int n=Integer.valueOf(strings[0]);
            int m=Integer.valueOf(strings[1]);
            String [] strings1=scanner.nextLine().split(" ");
            String [] strings2=scanner.nextLine().split(" ");
            for (String s:strings1){
                set.add(Integer.valueOf(s));
            }
            for (String s:strings2){
                set.add(Integer.valueOf(s));
            }
            int l=set.size();
            Object[] arr =set.toArray();
            for (int i=0;i<l;i++){
                if (i!=l-1){
                    System.out.print(arr[i]+" ");
                }else {
                    System.out.println(arr[i]);
                }
            }
        }
    }
}
