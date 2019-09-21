package leetcode.leetcode1_499;

public class leet13 {

    // mine
/*    public int romanToInt(String s) {
   Map<Character,Integer> roman=new HashMap<>();
   roman.put('I',1);
   roman.put('V',5);
   roman.put('X',10);
        roman.put('L',50);
        roman.put('C',100);
        roman.put('D',500);
        roman.put('M',1000);
        Map<String,Integer> twoRoman=new HashMap<>();
        twoRoman.put("IV",4);
        twoRoman.put("IX",9);
        twoRoman.put("XL",40);
        twoRoman.put("XC",90);
        twoRoman.put("CD",400);
        twoRoman.put("CM",900);
int result=0;
int i=0;
   for(;i<s.length()-1;i++){
       if(roman.get(s.charAt(i+1))<=roman.get(s.charAt(i))){
       result+=roman.get(s.charAt(i));
       }else {
           result+=twoRoman.get(s.charAt(i)+""+s.charAt(i+1));
           i++;
       }
   }

   if(i==s.length()-1) result+=roman.get(s.charAt(i));
   return result;
    }*/


/*
    public int romanToInt(String s) {
        int sum=0;
        //因为每种字符都不会重复
        if(s.indexOf("IV")!=-1){sum-=2;}
        if(s.indexOf("IX")!=-1){sum-=2;}
        if(s.indexOf("XL")!=-1){sum-=20;}
        if(s.indexOf("XC")!=-1){sum-=20;}
        if(s.indexOf("CD")!=-1){sum-=200;}
        if(s.indexOf("CM")!=-1){sum-=200;}

        char c[]=s.toCharArray();
        int count=0;

        for(;count<=s.length()-1;count++){
            if(c[count]=='M') sum+=1000;
            if(c[count]=='D') sum+=500;
            if(c[count]=='C') sum+=100;
            if(c[count]=='L') sum+=50;
            if(c[count]=='X') sum+=10;
            if(c[count]=='V') sum+=5;
            if(c[count]=='I') sum+=1;

        }

        return sum;

    }
*/


//倒着遍历
    public static int romanToInt(String s) {
        int res = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            switch (c) {
                case 'I':
                    res += (res >= 5 ? -1 : 1);
                    break;
                case 'V':
                    res += 5;
                    break;
                case 'X':
                    res += 10 * (res >= 50 ? -1 : 1);
                    break;
                case 'L':
                    res += 50;
                    break;
                case 'C':
                    res += 100 * (res >= 500 ? -1 : 1);
                    break;
                case 'D':
                    res += 500;
                    break;
                case 'M':
                    res += 1000;
                    break;
            }
        }
        return res;
    }
}
