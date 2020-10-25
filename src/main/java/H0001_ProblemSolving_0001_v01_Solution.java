import java.util.Scanner;

public class H0001_ProblemSolving_0001_v01_Solution {

    public void getSolution() {
        System.out.println("enter two digits");
        Scanner in = new Scanner(System.in);
        int a, b;
        a = in.nextInt();
        b = in.nextInt();
        int sum;
        sum = solveMeFirst(a, b);
        System.out.println(sum);
    }

    private int solveMeFirst(int a, int b) {
        System.out.println("result is ");
        return a + b;
    }
}
