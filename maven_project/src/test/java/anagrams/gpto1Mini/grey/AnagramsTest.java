package anagrams.gpto1Mini.grey;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import anagrams.Anagrams;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class AnagramsTest {

    @Test
    public void testExample1() {
        String[] input = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> expected = Arrays.asList(
            Arrays.asList("bat"),
            Arrays.asList("nat","tan"),
            Arrays.asList("ate","eat","tea")
        );
        
        Anagrams anagrams = new Anagrams();
        List<List<String>> result = anagrams.groupAnagrams(input);
        
        assertEquals(convertToSetOfSets(expected), convertToSetOfSets(result));
    }
    
    @Test
    public void testExample2() {
        String[] input = {""};
        List<List<String>> expected = Arrays.asList(
            Arrays.asList("")
        );
        
        Anagrams anagrams = new Anagrams();
        List<List<String>> result = anagrams.groupAnagrams(input);
        
        assertEquals(convertToSetOfSets(expected), convertToSetOfSets(result));
    }
    
    @Test
    public void testExample3() {
        String[] input = {"a"};
        List<List<String>> expected = Arrays.asList(
            Arrays.asList("a")
        );
        
        Anagrams anagrams = new Anagrams();
        List<List<String>> result = anagrams.groupAnagrams(input);
        
        assertEquals(convertToSetOfSets(expected), convertToSetOfSets(result));
    }
    
    @Test
    public void testEmptyInput() {
        String[] input = {};
        List<List<String>> expected = new ArrayList<>();
        
        Anagrams anagrams = new Anagrams();
        List<List<String>> result = anagrams.groupAnagrams(input);
        
        assertEquals(convertToSetOfSets(expected), convertToSetOfSets(result));
    }
    
    @Test
    public void testSingleAnagramGroup() {
        String[] input = {"abc","bca","cab"};
        List<List<String>> expected = Arrays.asList(
            Arrays.asList("abc","bca","cab")
        );
        
        Anagrams anagrams = new Anagrams();
        List<List<String>> result = anagrams.groupAnagrams(input);
        
        assertEquals(convertToSetOfSets(expected), convertToSetOfSets(result));
    }
    
    @Test
    public void testMultipleAnagramGroups() {
        String[] input = {"abc","bca","xyz","zyx","zxy","foo","oof"};
        List<List<String>> expected = Arrays.asList(
            Arrays.asList("abc","bca"),
            Arrays.asList("xyz","zyx","zxy"),
            Arrays.asList("foo","oof")
        );
        
        Anagrams anagrams = new Anagrams();
        List<List<String>> result = anagrams.groupAnagrams(input);
        
        assertEquals(convertToSetOfSets(expected), convertToSetOfSets(result));
    }
    
    // Helper method to convert List<List<String>> to Set<Set<String>>
    private Set<Set<String>> convertToSetOfSets(List<List<String>> listOfLists) {
        Set<Set<String>> setOfSets = new HashSet<>();
        for(List<String> list : listOfLists) {
            setOfSets.add(new HashSet<>(list));
        }
        return setOfSets;
    }
}