package bracket.validation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BracketValidationTest
{
  @Test
  public void testPass()
  {
    String testString = "( { } )";
    assertTrue(QueueValidation.validateString(testString));
  }

  @Test
  public void testFail()
  {
    String testString = "{ { )}";
    assertFalse(QueueValidation.validateString(testString));
  }

  @Test
  public void testSpecial()
  {
    String testString1 = "{ ( Hello, World! ) }";
    assertTrue(QueueValidation.validateString(testString1));

    String testString2 = "";
    assertTrue(QueueValidation.validateString(testString2));
  }
}
