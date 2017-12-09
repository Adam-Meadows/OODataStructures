package Stack;

//PostFixEvaluator pf = new PostFixEvaluator("4 5 7 2 + - *", new ArrayStack());
//
//System.out.println(pf.getResult());
//
//pf.evaluate("3 4 + 2 * 7 8 /");
//System.out.println(pf.getResult());
//
//pf.evaluate("4 2 3 5 1 - + * + *");
//System.out.println(pf.getResult());

public class PostFixEvaluator {

    String result;

    IStack stack;

    public PostFixEvaluator(String problemText, IStack stack){

        this.stack = stack;
        evaluate(problemText);

    }

    public void evaluate(String problemText){

        stack.clear();

        String expression[] = problemText.split(" ");

        for (String item : expression){
            if (isNumeric(item)){
                stack.push(Double.parseDouble(item));
            }
            else {

                if (stack.count() < 2){
                    result = "not enough operands!";
                    return;
                }

                double a = (double)stack.top();
                stack.pop();
                double b = (double)stack.top();
                stack.pop();

                if (item.compareTo("+") == 0){
                    stack.push(b + a);
                } else if (item.compareTo("-") == 0){
                    stack.push(b - a);
                } else if (item.compareTo("*") == 0){
                    stack.push(b * a);
                } else if (item.compareTo("/") == 0) {
                    stack.push(b / a);
                }
            }
        }

        if (stack.count() > 1){
            result = "not enough operators";
            return;
        }

        result = Double.toString((double)stack.top());
    }

    public String getResult(){
        return result;
    }

    private boolean isNumeric(String test){
        return test.matches("[0-9]*");
    }

}
