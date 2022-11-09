package bracket.validation;

import stack.and.queue.Stack;

public class QueueValidation
{
  public static boolean validateString(String string)
  {
    Stack<Character> stack = new Stack<>();

    char[] characters = string.toCharArray();
    for (int i = 0; i < characters.length; i++)
    {
      Character currentChar = characters[i];
      if (equalsEndingBracket(currentChar))
      {
        Character matchingBracket = getMatchingBracket(currentChar);
        if (matchingBracket == stack.peek())
        {
          stack.pop();
          continue;
        }
        else
        {
          return false;
        }
      }
      else if(equalsOpeningBracket(currentChar))
      {
        stack.push(currentChar);
      }
      else {
        continue;
      }

    }

    return true;

  }

  private static boolean equalsEndingBracket(Character character)
  {
    return character.equals(')') || character.equals(']') || character.equals('}');
  }

  private static boolean equalsOpeningBracket(Character character)
  {
    return character.equals('(') || character.equals('[') || character.equals('{');
  }


  private static Character getMatchingBracket(Character character)
  {
    return switch (character)
      {
        case '(' -> ')';
        case '[' -> ']';
        case '{' -> '}';
        case ')' -> '(';
        case ']' -> '[';
        case '}' -> '{';
        default -> null;
      };

  }

}
