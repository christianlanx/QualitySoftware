package NQueens.ai21Jamba15Large.white;

import NQueens.Nqueens;
import java.util.List;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NqueensTest {

    @Test
    void testSolveNQueens_3() {
        Nqueens nqueens = new Nqueens();
        List<List<String>> expected = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        list1.add("Q..");
        list1.add("...");
        list1.add("..Q");
        List<String> list2 = new ArrayList<>();
        list2.add(".Q.");
        list2.add("Q..");
        list2.add("...");
        List<String> list3 = new ArrayList<>();
        list3.add("...");
        list3.add("Q..");
        list3.add(".Q.");
        expected.add(list1);
        expected.add(list2);
        expected.add(list3);
        assertEquals(expected, nqueens.solveNQueens(3));
    }

    @Test
    void testSolveNQueens_4() {
        Nqueens nqueens = new Nqueens();
        List<List<String>> expected = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        list1.add("Q...");
        list1.add("...Q");
        list1.add(".Q..");
        list1.add("..Q.");
        List<String> list2 = new ArrayList<>();
        list2.add("..Q.");
        list2.add("Q...");
        list2.add("...Q");
        list2.add(".Q..");
        expected.add(list1);
        expected.add(list2);
        assertEquals(expected, nqueens.solveNQueens(4));
    }

    @Test
    void testSolveNQueens_5() {
        Nqueens nqueens = new Nqueens();
        List<List<String>> expected = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        list1.add("Q....");
        list1.add("..Q..");
        list1.add(".Q...");
        list1.add("...Q.");
        list1.add("....Q");
        List<String> list2 = new ArrayList<>();
        list2.add(".Q...");
        list2.add("....Q");
        list2.add("Q....");
        list2.add("...Q.");
        list2.add("..Q..");
        expected.add(list1);
        expected.add(list2);
        assertEquals(expected, nqueens.solveNQueens(5));
    }

    @Test
    void testSolveNQueens_6() {
        Nqueens nqueens = new Nqueens();
        List<List<String>> expected = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        list1.add("Q.....");
        list1.add("..Q...");
        list1.add(".Q....");
        list1.add("...Q..");
        list1.add("....Q.");
        list1.add(".....Q");
        List<String> list2 = new ArrayList<>();
        list2.add("..Q...");
        list2.add("Q.....");
        list2.add("...Q..");
        list2.add(".Q....");
        list2.add(".....Q");
        list2.add("....Q.");
        expected.add(list1);
        expected.add(list2);
        assertEquals(expected, nqueens.solveNQueens(6));
    }

    @Test
    void testSolveNQueens_7() {
        Nqueens nqueens = new Nqueens();
        List<List<String>> expected = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        list1.add("Q......");
        list1.add("..Q....");
        list1.add(".Q.....");
        list1.add("...Q...");
        list1.add("....Q..");
        list1.add(".....Q.");
        list1.add("......Q");
        List<String> list2 = new ArrayList<>();
        list2.add("..Q....");
        list2.add("Q......");
        list2.add("...Q...");
        list2.add(".Q.....");
        list2.add("....Q..");
        list2.add(".....Q.");
        list2.add("......Q");
        expected.add(list1);
        expected.add(list2);
        assertEquals(expected, nqueens.solveNQueens(7));
    }
}