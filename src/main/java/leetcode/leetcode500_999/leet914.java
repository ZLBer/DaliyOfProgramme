package leetcode.leetcode500_999;

/**
 * Created by libin on 2018/12/28.
 */
//914. X of a Kind in a Deck of Cards
public class leet914 {
    static public boolean hasGroupsSizeX(int[] deck) {
        int count[]=new int[10001];
        for(int c:deck){
            count[c]++;
        }
//        for(int i=0;i<3;i++){
//            System.out.println(count[i]);
//        }
        for(int X=2;X<=10000;X++){
           // System.out.println(X);
            if(deck.length%X!=0) continue;
            else {
                int i=0;
                for(i=0;i<=10000;i++){
                    if(count[i]%X==0)
                        continue;
                    else
                        break;

                }
               // System.out.println(i);
                if(i==10001) return  true;
                      else i=0;
            }
        }
        return false;
    }
//static boolean hasGroupsSizeX(int[] deck) {
//
//    int N = deck.length;
//    int[] count = new int[10000];
//    for (int c: deck)
//        count[c]++;
//
//    List<Integer> values = new ArrayList();
//    for (int i = 0; i < 10000; ++i)
//        if (count[i] > 0)
//            values.add(count[i]);
//
//    search: for (int X = 2; X <= N; ++X)
//        if (N % X == 0) {
//            for (int v: values)
//                if (v % X != 0)
//                    continue search;
//            return true;
//        }
//
//    return false;
//}

    public static void main(String[] args) {
        int test[]={0,0,0,1,1,1,2,2,2};
        System.out.println(hasGroupsSizeX(test));
    }
}
