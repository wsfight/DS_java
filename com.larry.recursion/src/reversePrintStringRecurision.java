public class reversePrintStringRecurision {
    public static void main(String[] args) {
        String s = "abcde";
        // reversePrint(0,s);      // e d c b a
        reversePrint02(s.length()-1,s);
    }

    public static void reversePrint(int n, String s) {
        // n 初始为0 即可
        if (n == s.length()) {
            return;
        }
        reversePrint(n + 1, s);
        System.out.println(s.charAt(n));
    }
    public static void reversePrint02(int n,String s){
        if(n == -1){
            return;
        }
        reversePrint02(n-1,s);
        System.out.println(s.charAt(n));     // 相当于正序了.
    }
}
