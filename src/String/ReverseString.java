package String;

public class ReverseString {

//    public String reverseWords(String s) {
//        StringBuilder res = new StringBuilder();
//        int start = s.length()-1;
//        while(start>=0){
//            while(start>=0 && s.charAt(start)==' '){
//                start--;
//            }
//            if(start<0) break;
//            int end = start;
//            while(start>=0 && s.charAt(start)!=' '){
//                start--;
//            }
//            if(res.isEmpty()){
//                res.append(s.substring(start+1,end+1));
//                //res+=arr[i];
//            }else{
//                res.append(" ");
//                res.append(s.substring(start+1,end+1));
//                //res+=" "+arr[i];
//            }
//        }
//        return res.toString();
//    }

    public String reverseWords(String s) {
        String [] arr = s.split(" ");
        //String res = "";
        StringBuilder res = new StringBuilder();
        for(int i=arr.length-1;i>=0;i--){
            if(arr[i].isEmpty()){
                continue;
            }
            if(res.isEmpty()){
                res.append(arr[i]);
                //res+=arr[i];
            }else{
                res.append(" "+arr[i]);
                //res+=" "+arr[i];
            }
        }
        return res.toString();
    }
    public static void main(String[] args) {
        ReverseString ob = new ReverseString();
        System.out.println(ob.reverseWords("  hello world  "));

    }
}
