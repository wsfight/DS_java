public class Ex01infixToSuffix {
    public static void main(String[] args) {
        // 1.遇到非运算符 直接拼串
        // 2.遇到+ - * /
        //  - 它的优先级比栈顶元素高的,入栈
        //  - 否则把栈里的元素优先级 >= 它的都出栈,它在入栈
        // 3.遍历完成,栈里剩余运算符依次出栈
        // 4.带()
        //  - 左括号直接入栈,左括号优先级最低
        //  - 右括号就把栈里到左括号的全部出栈,包括左括号
        System.out.println(infixToSuffix("a+b"));        // ab+
        System.out.println(infixToSuffix("a+b-c"));      // ab+c-
        System.out.println(infixToSuffix("a+b*c"));      // abc*+
        System.out.println(infixToSuffix("a*b-c"));      // ab*c-
        System.out.println(infixToSuffix("(a+b)*c"));       // ab+c*
        System.out.println(infixToSuffix("(a+b*c-d)*e"));   // abc*+d-e*
        System.out.println(infixToSuffix("a*(b+c)"));   // abc+*
    }
    // 定义个算术的优先级
    static int priority(char c){
        return switch (c){
            case '*','/' ->2;
            case '+','-' ->1;
            case '(' ->0;       // 左括号优先级最低
            default -> throw new IllegalArgumentException("不合法的运算符:" + c);
        };
    }

   static String infixToSuffix(String exp){
        // ! 此处无括号版本
        LinkedListStack<Character> s = new LinkedListStack<Character>();
        StringBuilder sb = new StringBuilder(exp.length());
        for(int i = 0;i < exp.length();i++){
            char c = exp.charAt(i);
            switch (c){
                case '*', '/', '+' ,'-' ->{
                    if(s.isEmpty()){
                        s.push(c);
                    }else{
                        while(!s.isEmpty() && priority(s.peek()) >= priority(c)){
                                // 如果栈内元素优先级都高或者等于,则出栈
                                char temp = s.pop();
                                sb.append(temp);
                            }
                            s.push(c);
                    }

                }
                case ')' ->{

                    while(!s.isEmpty()&&s .peek() != '('){
                        sb.append(s.pop());
                    }
                    s.pop();    // 把左括号直接弹出

                }
                case '(' ->{
                    s.push(c);
                }
                default -> {
                    // 此处就应该是字符和左括号
                     sb.append(c);
                }
            }
        }
        while(!s.isEmpty()){
            sb.append(s.pop());
        }

        return sb.toString();
    }
}
