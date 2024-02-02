
public class LowerCase {
    public static void main(String[] args) {  
        
        System.out.println(lowerCase(args[0]));
    }


    public static String lowerCase(String str) {       
        String result = "";

    int i = 0;
    while (i < str.length()) {
        char ch = str.charAt(i);

        if (Character.isLetter(ch)) {            
            if (ch >= 'A' && ch <= 'Z') {
                result = result + (char) (ch + 32);
            } else {
                result = result + ch;
            }
        } else {
     
            result = result + ch;
        }

        i++;
    }
       
        return result;
    }
}
