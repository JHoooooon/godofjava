public class MethodVarargs {
    public static void main(String [] args) {
        MethodVarargs vavargs = new MethodVarargs();
        vavargs.calcuateNumbersWithArray(new int[] {1, 2, 3, 4, 5});
        vavargs.calcuateNumbers(1, 2, 3, 4, 5);
    }

    public void calcuateNumbersWithArray(int [] numbers) {}
    public void calcuateNumbers(int ...numbers) {
        int total = 0;

        for (int number:numbers) {
            total += number;
        }

        System.out.println(total);
    }
}
