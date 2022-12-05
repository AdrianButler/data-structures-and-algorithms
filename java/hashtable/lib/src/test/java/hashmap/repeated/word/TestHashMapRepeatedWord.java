package hashmap.repeated.word;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TestHashMapRepeatedWord
{
  @Test
  void testRepeatedWord()
  {
    String result = HashmapRepeatedWord.findFirstWordWithTwoOccurrences("Test Bob Test");
    assertEquals("Test", result);


  }

  @Test
  void testRepeatedWordWithUniqueData()
  {
    String result = HashmapRepeatedWord.findFirstWordWithTwoOccurrences("Test Bob");
    assertNull(result);
  }

  @Test
  void testRepeatedWordWithEmptyString()
  {
    String result = HashmapRepeatedWord.findFirstWordWithTwoOccurrences("");
    assertNull(result);
  }
}
