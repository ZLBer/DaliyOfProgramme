package leetcode;

public class leet1507 {
    public String reformatDate(String date) {
      String[] arr=date.split(" ");
      String []month=new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
      StringBuilder stringBuilder=new StringBuilder();
      stringBuilder.append(arr[2]+"-");

        for (int i = 0; i < month.length; i++) {
            if(arr[1].equals(month[i])){
                if(i<9){
                    stringBuilder.append("0");
                }
                stringBuilder.append((i+1)+"-");break;
            }
        }

        if(arr[0].charAt(1)>='0'&&arr[0].charAt(1)<='9'){
            stringBuilder.append(arr[0].substring(0,2));
        }else {
          stringBuilder.append("0"+arr[0].charAt(0));
        }
        return stringBuilder.toString();
    }
}
