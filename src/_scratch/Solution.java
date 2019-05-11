package _scratch;

import java.io.IOException;

public class Solution {

  // Complete the superReducedString function below.
  static String superReducedString(String s) {
    String original = s;
    String reduced;
    for(;;){
      reduced = removeDuplicates(original);
      if(reduced.length()==original.length()){
        break;
      }
      original=reduced;
    }
    return reduced;
  }

  static String removeDuplicates(String s){
    StringBuffer buf = new StringBuffer();

    for(int i=0;i<s.length();i++){
      if(i==s.length()-1){
        buf.append(s.charAt(s.length()-1));
        break;
      }
      if(s.charAt(i)!=s.charAt(i+1)){
        buf.append(s.charAt(i));
      } else{
        i=i+1;
      }
    }
    return buf.toString();
  }

  public static void main(String[] args) throws IOException {

    System.out.println(superReducedString("baab"));

    System.out.println(superReducedString("aa"));

    System.out.println(superReducedString("aaabccddd"));
  }
}
