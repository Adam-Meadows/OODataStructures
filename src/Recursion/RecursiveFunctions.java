package Recursion;

public class RecursiveFunctions {
    public static int factorial(int number){
        if (number == 0) return 1;
        return factorial(number-1);
    }

    public static int combinations(int group, int members){
        if (members == 1) return group;
        if (members == group) return 1;

        return combinations(group - 1, members -1) + combinations(group - 1, members);
    }
}
