package anagrams.mistralLarge.black;
import anagrams.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class AnagramsTest {

    private Anagrams anagrams;

    @BeforeEach
    public void setUp() {
        anagrams = new Anagrams();
    }

    @Test
    public void testGroupAnagramsExample1() {
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> expected = Arrays.asList(
                Arrays.asList("bat"),
                Arrays.asList("nat", "tan"),
                Arrays.asList("ate", "eat", "tea")
        );
        List<List<String>> result = anagrams.groupAnagrams(input);
        assertAnagramGroupsEqual(expected, result);
    }

    @Test
    public void testGroupAnagramsExample2() {
        String[] input = {""};
        List<List<String>> expected = Arrays.asList(
                Arrays.asList("")
        );
        List<List<String>> result = anagrams.groupAnagrams(input);
        assertAnagramGroupsEqual(expected, result);
    }

    @Test
    public void testGroupAnagramsExample3() {
        String[] input = {"a"};
        List<List<String>> expected = Arrays.asList(
                Arrays.asList("a")
        );
        List<List<String>> result = anagrams.groupAnagrams(input);
        assertAnagramGroupsEqual(expected, result);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void testGroupAnagrams(String[] input, List<List<String>> expected) {
        List<List<String>> result = anagrams.groupAnagrams(input);
        assertAnagramGroupsEqual(expected, result);
    }

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"},
                        Arrays.asList(
                                Arrays.asList("bat"),
                                Arrays.asList("nat", "tan"),
                                Arrays.asList("ate", "eat", "tea")
                        )),
                Arguments.of(new String[]{""},
                        Arrays.asList(
                                Arrays.asList("")
                        )),
                Arguments.of(new String[]{"a"},
                        Arrays.asList(
                                Arrays.asList("a")
                        )),
                Arguments.of(new String[]{"listen", "silent", "enlist"},
                        Arrays.asList(
                                Arrays.asList("listen", "silent", "enlist")
                        )),
                Arguments.of(new String[]{"hello", "billion", "llohe"},
                        Arrays.asList(
                                Arrays.asList("hello", "llohe"),
                                Arrays.asList("billion")
                        ))
        );
    }

    private void assertAnagramGroupsEqual(List<List<String>> expected, List<List<String>> actual) {
        assertEquals(expected.size(), actual.size());
        for (List<String> expectedGroup : expected) {
            assertTrue(actual.stream().anyMatch(actualGroup -> {
                if (actualGroup.size() != expectedGroup.size()) {
                    return false;
                }
                for (String word : expectedGroup) {
                    if (!actualGroup.contains(word)) {
                        return false;
                    }
                }
                return true;
            }));
        }
    }
}