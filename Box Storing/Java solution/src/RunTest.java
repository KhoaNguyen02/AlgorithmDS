import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RunTest {
    private int solve(Scanner scanner) {
        int n = scanner.nextInt();
        Box[] boxes = new Box[n];
        for (int i = 0; i < n; i++) {
            double a = scanner.nextDouble();
            double b = scanner.nextDouble();
            double c = scanner.nextDouble();
            boxes[i] = new Box(a, b, c);
        }
        scanner.close();

        Main main = new Main();
        return main.solve(n, boxes);
    }

    @Test
    public void test1() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/testcase/1.in"));
        int result = solve(scanner);

        Scanner scanner2 = new Scanner(new File("src/testcase/1.ans"));
        int expected = scanner2.nextInt();
        assertEquals(expected, result);
    }

    @Test
    public void test2() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/testcase/2.in"));
        int result = solve(scanner);

        Scanner scanner2 = new Scanner(new File("src/testcase/2.ans"));
        int expected = scanner2.nextInt();
        assertEquals(expected, result);
    }

    @Test
    public void test3() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/testcase/3.in"));
        int result = solve(scanner);

        Scanner scanner2 = new Scanner(new File("src/testcase/3.ans"));
        int expected = scanner2.nextInt();
        assertEquals(expected, result);
    }

    @Test
    public void test4() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/testcase/4.in"));
        int result = solve(scanner);

        Scanner scanner2 = new Scanner(new File("src/testcase/4.ans"));
        int expected = scanner2.nextInt();
        assertEquals(expected, result);
    }

    @Test
    public void test5() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/testcase/5.in"));
        int result = solve(scanner);

        Scanner scanner2 = new Scanner(new File("src/testcase/5.ans"));
        int expected = scanner2.nextInt();
        assertEquals(expected, result);
    }

    @Test
    public void test6() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/testcase/6.in"));
        int result = solve(scanner);

        Scanner scanner2 = new Scanner(new File("src/testcase/6.ans"));
        int expected = scanner2.nextInt();
        assertEquals(expected, result);
    }

    @Test
    public void test7() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/testcase/7.in"));
        int result = solve(scanner);

        Scanner scanner2 = new Scanner(new File("src/testcase/7.ans"));
        int expected = scanner2.nextInt();
        assertEquals(expected, result);
    }

    @Test
    public void test8() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/testcase/8.in"));
        int result = solve(scanner);

        Scanner scanner2 = new Scanner(new File("src/testcase/8.ans"));
        int expected = scanner2.nextInt();
        assertEquals(expected, result);
    }

    @Test
    public void test9() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/testcase/9.in"));
        int result = solve(scanner);

        Scanner scanner2 = new Scanner(new File("src/testcase/9.ans"));
        int expected = scanner2.nextInt();
        assertEquals(expected, result);
    }

    @Test
    public void test10() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/testcase/10.in"));
        int result = solve(scanner);

        Scanner scanner2 = new Scanner(new File("src/testcase/10.ans"));
        int expected = scanner2.nextInt();
        assertEquals(expected, result);
    }

    @Test
    public void test11() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/testcase/11.in"));
        int result = solve(scanner);

        Scanner scanner2 = new Scanner(new File("src/testcase/11.ans"));
        int expected = scanner2.nextInt();
        assertEquals(expected, result);
    }

    @Test
    public void test12() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/testcase/12.in"));
        int result = solve(scanner);

        Scanner scanner2 = new Scanner(new File("src/testcase/12.ans"));
        int expected = scanner2.nextInt();
        assertEquals(expected, result);
    }

    @Test
    public void test13() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/testcase/13.in"));
        int result = solve(scanner);

        Scanner scanner2 = new Scanner(new File("src/testcase/13.ans"));
        int expected = scanner2.nextInt();
        assertEquals(expected, result);
    }

    @Test
    public void test14() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/testcase/14.in"));
        int result = solve(scanner);

        Scanner scanner2 = new Scanner(new File("src/testcase/14.ans"));
        int expected = scanner2.nextInt();
        assertEquals(expected, result);
    }

    @Test
    public void test15() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/testcase/15.in"));
        int result = solve(scanner);

        Scanner scanner2 = new Scanner(new File("src/testcase/15.ans"));
        int expected = scanner2.nextInt();
        assertEquals(expected, result);
    }

    @Test
    public void test16() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/testcase/16.in"));
        int result = solve(scanner);

        Scanner scanner2 = new Scanner(new File("src/testcase/16.ans"));
        int expected = scanner2.nextInt();
        assertEquals(expected, result);
    }

    @Test
    public void test17() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/testcase/17.in"));
        int result = solve(scanner);

        Scanner scanner2 = new Scanner(new File("src/testcase/17.ans"));
        int expected = scanner2.nextInt();
        assertEquals(expected, result);
    }

    @Test
    public void test18() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/testcase/18.in"));
        int result = solve(scanner);

        Scanner scanner2 = new Scanner(new File("src/testcase/18.ans"));
        int expected = scanner2.nextInt();
        assertEquals(expected, result);
    }

    @Test
    public void test19() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/testcase/19.in"));
        int result = solve(scanner);

        Scanner scanner2 = new Scanner(new File("src/testcase/19.ans"));
        int expected = scanner2.nextInt();
        assertEquals(expected, result);
    }

    @Test
    public void test20() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/testcase/20.in"));
        int result = solve(scanner);

        Scanner scanner2 = new Scanner(new File("src/testcase/20.ans"));
        int expected = scanner2.nextInt();
        assertEquals(expected, result);
    }

    @Test
    public void test21() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/testcase/21.in"));
        int result = solve(scanner);

        Scanner scanner2 = new Scanner(new File("src/testcase/21.ans"));
        int expected = scanner2.nextInt();
        assertEquals(expected, result);
    }

    @Test
    public void test22() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/testcase/22.in"));
        int result = solve(scanner);

        Scanner scanner2 = new Scanner(new File("src/testcase/22.ans"));
        int expected = scanner2.nextInt();
        assertEquals(expected, result);
    }

    @Test
    public void test23() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/testcase/23.in"));
        int result = solve(scanner);

        Scanner scanner2 = new Scanner(new File("src/testcase/23.ans"));
        int expected = scanner2.nextInt();
        assertEquals(expected, result);
    }

    @Test
    public void test24() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/testcase/24.in"));
        int result = solve(scanner);

        Scanner scanner2 = new Scanner(new File("src/testcase/24.ans"));
        int expected = scanner2.nextInt();
        assertEquals(expected, result);
    }

    @Test
    public void test25() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/testcase/25.in"));
        int result = solve(scanner);

        Scanner scanner2 = new Scanner(new File("src/testcase/25.ans"));
        int expected = scanner2.nextInt();
        assertEquals(expected, result);
    }

    @Test
    public void test26() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/testcase/26.in"));
        int result = solve(scanner);

        Scanner scanner2 = new Scanner(new File("src/testcase/26.ans"));
        int expected = scanner2.nextInt();
        assertEquals(expected, result);
    }
}
