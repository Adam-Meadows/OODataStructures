package Stack;

public class BracketChecker {

    private String test;
    private IStack stack;

    public BracketChecker(String test) {
        this.test = test;
        stack = new ArrayStack(test.length());
    }

    public boolean CorrectSyntax(){

        for (int i = 0; i < test.length(); i++){

            char currentChar = test.charAt(i);

            if (isOpenBracket(currentChar)){
                stack.push(currentChar);
            }
            else if (isCloseBracket(currentChar)){
                if (stack.isEmpty()) return false;

                if ((char)stack.top() == getOpenBracketFor(currentChar)){
                    stack.pop();
                }
                else return false;
            }
        }

        return stack.isEmpty();
    }

    private boolean isOpenBracket(char c){
        return "{[(".indexOf(c) >= 0;
    }

    private boolean isCloseBracket(char c){
        return "}])".indexOf(c) >= 0;
    }

    private char getOpenBracketFor(char c){
        if (c == '}') return '{';
        if (c == ']') return '[';
        if (c == ')') return '(';

        return '.';
    }

}