import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class SellAndBuy {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        while (scanner.hasNext()){
            Map<Integer,Integer> mapS=new TreeMap<>();
            Map<Integer,Integer> mapB=new TreeMap<>();
            String input=scanner.nextLine();
            String str[]=input.split(" ");
            int n=Integer.valueOf(str[0]);
            int s=Integer.valueOf(str[1]);
            for (int i=0;i<n;i++){
                String [] strings=scanner.nextLine().split(" ");
                int p=Integer.valueOf(strings[1]);
                int q=Integer.valueOf(strings[2]);
                if (strings[0].equals("S")){
                    if (!mapS.containsKey(p)){
                        mapS.put(p,q);
                    }else {
                        mapS.put(p,mapS.get(p)+q);
                    }
                }else if (strings[0].equals("B")){
                    if (!mapB.containsKey(p)){
                        mapB.put(p,q);
                    }else {
                        mapB.put(p,mapB.get(p)+q);
                    }
                }
            }
            java.lang.Object[] intsS =mapS.keySet().toArray();
            java.lang.Object[] intsB =mapB.keySet().toArray();
            int l1=intsS.length;
            int l2=intsB.length;
            if (l1<s&&l1!=0){
                for (int i=0;i<l1;i++){
                    System.out.println("S"+" "+intsS[l1-1-i]+" "+mapS.get(intsS[l1-1-i]));
                }
            }else if (l1!=0){
                for (int i=0;i<s;i++){
                    System.out.println("S"+" "+intsS[l1-1-i]+" "+mapS.get(intsS[l1-1-i]));
                }
            }
            if (l2<s&&l2!=0){
                for (int i=0;i<l2;i++){
                    System.out.println("B"+" "+intsB[l2-1-i]+" "+mapB.get(intsB[l2-1-i]));
                }
            }else if(l2!=0){
                for (int i=0;i<s;i++){
                    System.out.println("B"+" "+intsB[l2-1-i]+" "+mapB.get(intsB[l2-1-i]));
                }
            }
        }
    }
}
