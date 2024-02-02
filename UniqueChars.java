/** String processing exercise 2. */
public class UniqueChars {
    public static void main(String[] args) {  
        String str = args[0];
        System.out.println(uniqueChars(str));
    }

    public static String uniqueChars(String str) {
        
    String result = "";
    for (int i = 0 ; i < str.length() ; i++) {
        char chr = str.charAt(i);     
        boolean unique = true;
       
        if (str.indexOf(chr) < i) {
             unique = false;
        }

        if (str.charAt(i) == ' '){
            unique = true;
        }
            result = unique? result + str.charAt(i) : result;


    }
        return result;
    
  }
}
