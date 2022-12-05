package hashmap.repeated.word;

import java.util.HashMap;

public class HashmapRepeatedWord
{
  public static String findFirstWordWithTwoOccurrences(String text)
  {
    HashMap<String, Integer> wordBank = new HashMap<>();
    String word = "";

    for (Character currentChar : text.toCharArray())
    {
      if (Character.isLetterOrDigit(currentChar))
      {
        word += currentChar;
      }
      else
      {
        if (wordBank.getOrDefault(word, 0) != 0)
        {
          return word;
        }
        else
        {
          wordBank.put(word, 1);
        }
        word = "";
      }
    }

    if (wordBank.getOrDefault(word, 0) != 0)
    {
      return word;
    }

    return null;
  }
}
