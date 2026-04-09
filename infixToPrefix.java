import java.util.*;
/* 
two stacks --> 1 operand stack and 1 operator stack
scan from left to right
if operand push to operand stack
if operator push to operator stack
check precedence of operator and top of operator stack
if clashes insert them before the curr output and put it back to the operand stack
*/
public class infixToPrefix {
    private static int precedence(char c) {
        switch(c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }
    private static String prefix(String infix){
        int length = infix.length();
        Stack<Character> sym = new Stack<>(); // stack for operators
        Stack<String> operand = new Stack<>(); // stack for operands
        for(int i = 0; i < length; i++) {
            char c = infix.charAt(i);
            if(Character.isLetterOrDigit(c)) {
                operand.push(c + "");
            }
            else if(c == '(') {
                sym.push(c);
            }
            else if(c == ')'){
                while(!sym.isEmpty() && sym.peek() != '(') {
                    String op2 = operand.pop();
                    String op1 = operand.pop();
                    char operator = sym.pop();
                    String temp = operator + op1 + op2;
                    operand.push(temp);
                }
                sym.pop();
            }
            else {
                while(!sym.isEmpty() && precedence(c) <= precedence(sym.peek())) {
                    String op2 = operand.pop();
                    String op1 = operand.pop();
                    char operator = sym.pop();
                    String temp = operator + op1 + op2;
                    operand.push(temp);
                }
                sym.push(c);
            }
        }
        while(!sym.isEmpty()) {
            String op2 = operand.pop();
            String op1 = operand.pop();
            char operator = sym.pop();
            String temp = operator + op1 + op2;
            operand.push(temp);
        }
        return operand.pop();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String infix = sc.nextLine();
        System.out.println("Infix expression: " + infix);
        String prefix = prefix(infix);
        System.out.println("Prefix expression: " + prefix);
    }
}
