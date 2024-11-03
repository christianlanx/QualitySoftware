package anagrams.copilot.prompt1;


import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

import anagrams.Anagrams;

public class anagramscopilotTest {

    @Test
    public void testGroupAnagrams_Example1() {
        Anagrams solution = new Anagrams();
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> expected = Arrays.asList(
                Arrays.asList("bat"),
                Arrays.asList("nat", "tan"),
                Arrays.asList("ate", "eat", "tea")
        );
        List<List<String>> result = solution.groupAnagrams(strs);
        assertEquals(convertToSetList(expected), convertToSetList(result));
    }

    @Test
    public void testGroupAnagrams_Example2() {
        Anagrams solution = new Anagrams();
        String[] strs = {""};
        List<List<String>> expected = Arrays.asList(
                Arrays.asList("")
        );
        List<List<String>> result = solution.groupAnagrams(strs);
        assertEquals(convertToSetList(expected), convertToSetList(result));
    }

    @Test
    public void testGroupAnagrams_Example3() {
        Anagrams solution = new Anagrams();
        String[] strs = {"a"};
        List<List<String>> expected = Arrays.asList(
                Arrays.asList("a")
        );
        List<List<String>> result = solution.groupAnagrams(strs);
        assertEquals(convertToSetList(expected), convertToSetList(result));
    }

    private List<List<String>> convertToSetList(List<List<String>> list) {
        List<List<String>> setList = new ArrayList<>();
        for (List<String> sublist : list) {
            setList.add(new ArrayList<>(sublist));
        }
        return setList;
    }
}

