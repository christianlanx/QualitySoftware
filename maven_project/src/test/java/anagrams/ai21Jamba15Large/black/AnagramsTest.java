package anagrams.ai21Jamba15Large.black;
import anagrams.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class AnagramsTest {

    @Test
    void testGroupAnagramsExample1() {
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> expected = Arrays.asList(
                Arrays.asList("bat"),
                Arrays.asList("nat", "tan"),
                Arrays.asList("ate", "eat", "tea")
        );

        Anagrams anagrams = new Anagrams();
        List<List<String>> actual = anagrams.groupAnagrams(input);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testGroupAnagramsExample2() {
        String[] input = {""};
        List<List<String>> expected = Arrays.asList(
                Arrays.asList("")
        );

        Anagrams anagrams = new Anagrams();
        List<List<String>> actual = anagrams.groupAnagrams(input);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testGroupAnagramsExample3() {
        String[] input = {"a"};
        List<List<String>> expected = Arrays.asList(
                Arrays.asList("a")
        );

        Anagrams anagrams = new Anagrams();
        List<List<String>> actual = anagrams.groupAnagrams(input);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testGroupAnagramsWithMultipleGroups() {
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat", "act", "cat", "tac"};
        List<List<String>> expected = Arrays.asList(
                Arrays.asList("bat"),
                Arrays.asList("nat", "tan"),
                Arrays.asList("ate", "eat", "tea"),
                Arrays.asList("act", "cat", "tac")
        );

        Anagrams anagrams = new Anagrams();
        List<List<String>> actual = anagrams.groupAnagrams(input);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testGroupAnagramsWithEmptyInput() {
        String[] input = {};
        List<List<String>> expected = new ArrayList<>();

        Anagrams anagrams = new Anagrams();
        List<List<String>> actual = anagrams.groupAnagrams(input);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testGroupAnagramsWithDuplicates() {
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat", "eat", "tea"};
        List<List<String>> expected = Arrays.asList(
                Arrays.asList("bat"),
                Arrays.asList("nat", "tan"),
                Arrays.asList("ate", "eat", "tea")
        );

        Anagrams anagrams = new Anagrams();
        List<List<String>> actual = anagrams.groupAnagrams(input);

        Assertions.assertEquals(expected, actual);
    }
}