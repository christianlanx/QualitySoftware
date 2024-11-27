package anagrams.gpt35Turbo.black;
import anagrams.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class AnagramsTest {
    
    @Test
    public void testGroupAnagrams_Example1() {
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        Anagrams anagrams = new Anagrams();
        List<List<String>> result = anagrams.groupAnagrams(input);
        List<List<String>> expected = new ArrayList<>();
        expected.add(Arrays.asList("bat"));
        expected.add(Arrays.asList("nat", "tan"));
        expected.add(Arrays.asList("ate", "eat", "tea"));
        for (int i = 0; i < expected.size(); i++) {
            assertArrayEquals(expected.get(i).toArray(), result.get(i).toArray());
        }
    }
    
    @Test
    public void testGroupAnagrams_Example2() {
        String[] input = {""};
        Anagrams anagrams = new Anagrams();
        List<List<String>> result = anagrams.groupAnagrams(input);
        List<List<String>> expected = new ArrayList<>();
        expected.add(Arrays.asList(""));
        for (int i = 0; i < expected.size(); i++) {
            assertArrayEquals(expected.get(i).toArray(), result.get(i).toArray());
        }
    }
    
    @Test
    public void testGroupAnagrams_Example3() {
        String[] input = {"a"};
        Anagrams anagrams = new Anagrams();
        List<List<String>> result = anagrams.groupAnagrams(input);
        List<List<String>> expected = new ArrayList<>();
        expected.add(Arrays.asList("a"));
        for (int i = 0; i < expected.size(); i++) {
            assertArrayEquals(expected.get(i).toArray(), result.get(i).toArray());
        }
    }
}