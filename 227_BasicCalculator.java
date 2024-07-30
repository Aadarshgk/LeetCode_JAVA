import java.util.Stack;
class Solution {
    Stack<Character> op = new Stack<>();
    Stack<Integer> numStack = new Stack<>();

    public int calculate(String s) {
        int len = s.length(), i = 0, num = -1;
        while (i < len) {
            char temp = s.charAt(i);
            if (temp == ' ') {
                if (num != -1) {
                    numStack.push(num);
                    num = -1;
                }
                i++;
                continue;
            }

            if (Character.isDigit(temp)) {
                if(num==-1){
                    num=0;
                }
                num = num * 10 + (temp - '0');
            } else {
                if (num != -1) {
                    numStack.push(num);
                    num = -1;
                }

                while (!op.isEmpty() && precedence(op.peek())>=precedence(temp)) {
                    evaluate(op.pop());
                }

                op.push(temp);
            }
            i++;
        }

        if (num != -1) {
            numStack.push(num);
            num=-1;
        }

        while (!op.isEmpty()) {
            evaluate(op.pop());
        }

        return numStack.pop();
    }

    public void evaluate(char operation) {
        int num2 = numStack.pop();
        int num1 = numStack.pop();
        switch (operation) {
            case '+':
                numStack.push(num1 + num2);
                break;
            case '-':
                numStack.push(num1 - num2);
                break;
            case '*':
                numStack.push(num1 * num2);
                break;
            case '/':
                numStack.push(num1 / num2);
                break;
        }
    }

    public int precedence(char a){
        if(a=='+' || a=='-') return 1;
        return 2;
    }
}