package anagrams.ai21Jamba.prompt1;
import anagrams.Anagrams;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class AnagramsTest {

    @Test
    public void testGroupAnagramsExample1() {
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> expected = Arrays.asList(
            Arrays.asList("bat"),
            Arrays.asList("nat", "tan"),
            Arrays.asList("ate", "eat", "tea")
        );
        assertEquals(expected, new Anagrams().groupAnagrams(input));
    }

    @Test
    public void testGroupAnagramsExample2() {
        String[] input = {""};
        List<List<String>> expected = Arrays.asList(Arrays.asList(""));
        assertEquals(expected, new Anagrams().groupAnagrams(input));
    }

    @Test
    public void testGroupAnagramsExample3() {
        String[] input = {"a"};
        List<List<String>> expected = Arrays.asList(Arrays.asList("a"));
        assertEquals(expected, new Anagrams().groupAnagrams(input));
    }

    @Test
    public void testGroupAnagramsWithMultipleGroups() {
        String[] input = {"abc", "bca", "def", "fed", "ghi", "ihg", "xyz", "zyx"};
        List<List<String>> expected = Arrays.asList(
            Arrays.asList("abc", "bca"),
            Arrays.asList("def", "fed"),
            Arrays.asList("ghi", "ihg"),
            Arrays.asList("xyz", "zyx")
        );
        assertEquals(expected, new Anagrams().groupAnagrams(input));
    }

    @Test
    public void testGroupAnagramsWithNoAnagrams() {
        String[] input = {"abc", "def", "ghi", "xyz"};
        List<List<String>> expected = Arrays.asList(
            Arrays.asList("abc"),
            Arrays.asList("def"),
            Arrays.asList("ghi"),
            Arrays.asList("xyz")
        );
        assertEquals(expected, new Anagrams().groupAnagrams(input));
    }

    @Test
    public void testGroupAnagramsWithDuplicates() {
        String[] input = {"abc", "bca", "abc", "def", "fed", "def"};
        List<List<String>> expected = Arrays.asList(
            Arrays.asList("abc", "bca"),
            Arrays.asList("def", "fed")
        );
        assertEquals(expected, new Anagrams().groupAnagrams(input));
    }

    @Test
    public void testGroupAnagramsWithLargeInput() {
        String[] input = new String[10000];
        for (int i = 0; i < 10000; i++) {
            input[i] = String.valueOf(i % 10);
        }
        List<List<String>> expected = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            List<String> group = new ArrayList<>();
            for (int j = 0; j < 1000; j++) {
                group.add(String.valueOf(i));
            }
            expected.add(group);
        }
        assertEquals(expected, new Anagrams().groupAnagrams(input));
    }
}