package anagrams.gpt35Turbo.white;
import anagrams.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Arrays;

public class AnagramsTest {

    private Anagrams anagrams;

    @BeforeEach
    public void setUp() {
        anagrams = new Anagrams();
    }

    @Test
    public void testGroupAnagrams() {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> expected = Arrays.asList(
            Arrays.asList("eat", "tea", "ate"),
            Arrays.asList("tan", "nat"),
            Arrays.asList("bat")
        );

        List<List<String>> result = anagrams.groupAnagrams(strs);

        assertEquals(expected.size(), result.size());
        for (int i = 0; i < expected.size(); i++) {
            assertTrue(result.containsAll(expected.get(i)));
        }
    }
}