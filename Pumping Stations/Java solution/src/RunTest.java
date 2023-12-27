import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RunTest {
    private int timeLimit;
    private Graph readInput(Scanner scanner) {
        int v = scanner.nextInt();
        int w = scanner.nextInt();
        int e = scanner.nextInt();
        timeLimit = scanner.nextInt();
        Graph graph = new Graph(v+1, w);
        graph.addEdge(0, 1, 0);
        for (int i = 0; i < w; i++) {
            graph.addPumpingStation(scanner.nextInt());
        }
        for (int i = 0; i < e; i++) {
            graph.addEdge(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        }
        return graph;
    }

    @Test
    public void test1() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/testcase/1.in"));
        Graph graph = readInput(scanner);
        Main main = new Main();
        int result = main.solve(graph, timeLimit);

        Scanner scanner2 = new Scanner(new File("src/testcase/1.ans"));
        int expected = scanner2.nextInt();
        assertEquals(result, expected);
    }

    @Test
    public void test2() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/testcase/2.in"));
        Graph graph = readInput(scanner);
        Main main = new Main();
        int result = main.solve(graph, timeLimit);

        Scanner scanner2 = new Scanner(new File("src/testcase/2.ans"));
        int expected = scanner2.nextInt();
        assertEquals(result, expected);
    }

    @Test
    public void test3() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/testcase/3.in"));
        Graph graph = readInput(scanner);
        Main main = new Main();
        int result = main.solve(graph, timeLimit);

        Scanner scanner2 = new Scanner(new File("src/testcase/3.ans"));
        int expected = scanner2.nextInt();
        assertEquals(result, expected);
    }

    @Test
    public void test4() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/testcase/4.in"));
        Graph graph = readInput(scanner);
        Main main = new Main();
        int result = main.solve(graph, timeLimit);

        Scanner scanner2 = new Scanner(new File("src/testcase/4.ans"));
        int expected = scanner2.nextInt();
        assertEquals(result, expected);
    }

    @Test
    public void test5() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/testcase/5.in"));
        Graph graph = readInput(scanner);
        Main main = new Main();
        int result = main.solve(graph, timeLimit);

        Scanner scanner2 = new Scanner(new File("src/testcase/5.ans"));
        int expected = scanner2.nextInt();
        assertEquals(result, expected);
    }

    @Test
    public void test6() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/testcase/6.in"));
        Graph graph = readInput(scanner);
        Main main = new Main();
        int result = main.solve(graph, timeLimit);

        Scanner scanner2 = new Scanner(new File("src/testcase/6.ans"));
        int expected = scanner2.nextInt();
        assertEquals(result, expected);
    }

    @Test
    public void test7() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/testcase/7.in"));
        Graph graph = readInput(scanner);
        Main main = new Main();
        int result = main.solve(graph, timeLimit);

        Scanner scanner2 = new Scanner(new File("src/testcase/7.ans"));
        int expected = scanner2.nextInt();
        assertEquals(result, expected);
    }

    @Test
    public void test8() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/testcase/8.in"));
        Graph graph = readInput(scanner);
        Main main = new Main();
        int result = main.solve(graph, timeLimit);

        Scanner scanner2 = new Scanner(new File("src/testcase/8.ans"));
        int expected = scanner2.nextInt();
        assertEquals(result, expected);
    }

    @Test
    public void test9() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/testcase/9.in"));
        Graph graph = readInput(scanner);
        Main main = new Main();
        int result = main.solve(graph, timeLimit);

        Scanner scanner2 = new Scanner(new File("src/testcase/9.ans"));
        int expected = scanner2.nextInt();
        assertEquals(result, expected);
    }

    @Test
    public void test10() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/testcase/10.in"));
        Graph graph = readInput(scanner);
        Main main = new Main();
        int result = main.solve(graph, timeLimit);

        Scanner scanner2 = new Scanner(new File("src/testcase/10.ans"));
        int expected = scanner2.nextInt();
        assertEquals(result, expected);
    }

    @Test
    public void test11() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/testcase/11.in"));
        Graph graph = readInput(scanner);
        Main main = new Main();
        int result = main.solve(graph, timeLimit);

        Scanner scanner2 = new Scanner(new File("src/testcase/11.ans"));
        int expected = scanner2.nextInt();
        assertEquals(result, expected);
    }

    @Test
    public void test12() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/testcase/12.in"));
        Graph graph = readInput(scanner);
        Main main = new Main();
        int result = main.solve(graph, timeLimit);

        Scanner scanner2 = new Scanner(new File("src/testcase/12.ans"));
        int expected = scanner2.nextInt();
        assertEquals(result, expected);
    }

    @Test
    public void test13() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/testcase/13.in"));
        Graph graph = readInput(scanner);
        Main main = new Main();
        int result = main.solve(graph, timeLimit);

        Scanner scanner2 = new Scanner(new File("src/testcase/13.ans"));
        int expected = scanner2.nextInt();
        assertEquals(result, expected);
    }

    @Test
    public void test14() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/testcase/14.in"));
        Graph graph = readInput(scanner);
        Main main = new Main();
        int result = main.solve(graph, timeLimit);

        Scanner scanner2 = new Scanner(new File("src/testcase/14.ans"));
        int expected = scanner2.nextInt();
        assertEquals(result, expected);
    }

    @Test
    public void test15() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/testcase/15.in"));
        Graph graph = readInput(scanner);
        Main main = new Main();
        int result = main.solve(graph, timeLimit);

        Scanner scanner2 = new Scanner(new File("src/testcase/15.ans"));
        int expected = scanner2.nextInt();
        assertEquals(result, expected);
    }

    @Test
    public void test16() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/testcase/16.in"));
        Graph graph = readInput(scanner);
        Main main = new Main();
        int result = main.solve(graph, timeLimit);

        Scanner scanner2 = new Scanner(new File("src/testcase/16.ans"));
        int expected = scanner2.nextInt();
        assertEquals(result, expected);
    }

    @Test
    public void test17() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/testcase/17.in"));
        Graph graph = readInput(scanner);
        Main main = new Main();
        int result = main.solve(graph, timeLimit);

        Scanner scanner2 = new Scanner(new File("src/testcase/17.ans"));
        int expected = scanner2.nextInt();
        assertEquals(result, expected);
    }

    @Test
    public void test18() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/testcase/18.in"));
        Graph graph = readInput(scanner);
        Main main = new Main();
        int result = main.solve(graph, timeLimit);

        Scanner scanner2 = new Scanner(new File("src/testcase/18.ans"));
        int expected = scanner2.nextInt();
        assertEquals(result, expected);
    }

    @Test
    public void test19() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/testcase/19.in"));
        Graph graph = readInput(scanner);
        Main main = new Main();
        int result = main.solve(graph, timeLimit);

        Scanner scanner2 = new Scanner(new File("src/testcase/19.ans"));
        int expected = scanner2.nextInt();
        assertEquals(result, expected);
    }

    @Test
    public void test20() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/testcase/20.in"));
        Graph graph = readInput(scanner);
        Main main = new Main();
        int result = main.solve(graph, timeLimit);

        Scanner scanner2 = new Scanner(new File("src/testcase/20.ans"));
        int expected = scanner2.nextInt();
        assertEquals(result, expected);
    }

    @Test
    public void test21() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/testcase/21.in"));
        Graph graph = readInput(scanner);
        Main main = new Main();
        int result = main.solve(graph, timeLimit);

        Scanner scanner2 = new Scanner(new File("src/testcase/21.ans"));
        int expected = scanner2.nextInt();
        assertEquals(result, expected);
    }

    @Test
    public void test22() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/testcase/22.in"));
        Graph graph = readInput(scanner);
        Main main = new Main();
        int result = main.solve(graph, timeLimit);

        Scanner scanner2 = new Scanner(new File("src/testcase/22.ans"));
        int expected = scanner2.nextInt();
        assertEquals(result, expected);
    }

    @Test
    public void test23() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/testcase/23.in"));
        Graph graph = readInput(scanner);
        Main main = new Main();
        int result = main.solve(graph, timeLimit);

        Scanner scanner2 = new Scanner(new File("src/testcase/23.ans"));
        int expected = scanner2.nextInt();
        assertEquals(result, expected);
    }

    @Test
    public void test24() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/testcase/24.in"));
        Graph graph = readInput(scanner);
        Main main = new Main();
        int result = main.solve(graph, timeLimit);

        Scanner scanner2 = new Scanner(new File("src/testcase/24.ans"));
        int expected = scanner2.nextInt();
        assertEquals(result, expected);
    }

    @Test
    public void test25() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/testcase/25.in"));
        Graph graph = readInput(scanner);
        Main main = new Main();
        int result = main.solve(graph, timeLimit);

        Scanner scanner2 = new Scanner(new File("src/testcase/25.ans"));
        int expected = scanner2.nextInt();
        assertEquals(result, expected);
    }

    @Test
    public void test26() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/testcase/26.in"));
        Graph graph = readInput(scanner);
        Main main = new Main();
        int result = main.solve(graph, timeLimit);

        Scanner scanner2 = new Scanner(new File("src/testcase/26.ans"));
        int expected = scanner2.nextInt();
        assertEquals(result, expected);
    }

    @Test
    public void test27() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/testcase/27.in"));
        Graph graph = readInput(scanner);
        Main main = new Main();
        int result = main.solve(graph, timeLimit);

        Scanner scanner2 = new Scanner(new File("src/testcase/27.ans"));
        int expected = scanner2.nextInt();
        assertEquals(result, expected);
    }

    @Test
    public void test28() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/testcase/28.in"));
        Graph graph = readInput(scanner);
        Main main = new Main();
        int result = main.solve(graph, timeLimit);

        Scanner scanner2 = new Scanner(new File("src/testcase/28.ans"));
        int expected = scanner2.nextInt();
        assertEquals(result, expected);
    }

    @Test
    public void test29() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/testcase/29.in"));
        Graph graph = readInput(scanner);
        Main main = new Main();
        int result = main.solve(graph, timeLimit);

        Scanner scanner2 = new Scanner(new File("src/testcase/29.ans"));
        int expected = scanner2.nextInt();
        assertEquals(result, expected);
    }

    @Test
    public void test30() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/testcase/30.in"));
        Graph graph = readInput(scanner);
        Main main = new Main();
        int result = main.solve(graph, timeLimit);

        Scanner scanner2 = new Scanner(new File("src/testcase/30.ans"));
        int expected = scanner2.nextInt();
        assertEquals(result, expected);
    }

    @Test
    public void test31() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/testcase/31.in"));
        Graph graph = readInput(scanner);
        Main main = new Main();
        int result = main.solve(graph, timeLimit);

        Scanner scanner2 = new Scanner(new File("src/testcase/31.ans"));
        int expected = scanner2.nextInt();
        assertEquals(result, expected);
    }

    @Test
    public void test32() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/testcase/32.in"));
        Graph graph = readInput(scanner);
        Main main = new Main();
        int result = main.solve(graph, timeLimit);

        Scanner scanner2 = new Scanner(new File("src/testcase/32.ans"));
        int expected = scanner2.nextInt();
        assertEquals(result, expected);
    }

    @Test
    public void test33() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/testcase/33.in"));
        Graph graph = readInput(scanner);
        Main main = new Main();
        int result = main.solve(graph, timeLimit);

        Scanner scanner2 = new Scanner(new File("src/testcase/33.ans"));
        int expected = scanner2.nextInt();
        assertEquals(result, expected);
    }

    @Test
    public void test34() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/testcase/34.in"));
        Graph graph = readInput(scanner);
        Main main = new Main();
        int result = main.solve(graph, timeLimit);

        Scanner scanner2 = new Scanner(new File("src/testcase/34.ans"));
        int expected = scanner2.nextInt();
        assertEquals(result, expected);
    }
}