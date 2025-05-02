public class TextProcessor {
  public static void main(String[] args) {
    String input1 = "Hello World!";
    int shift = 3;
    String replaced = replaceLetters(input1, shift);
    System.out.println("Replaced Letters: " + replaced);

    String input2 = "   Hello World!   ";
    String stripped = stripFromBothEnd(input2);
    System.out.println("Stripped Text: '" + stripped + "'");

    String input3 = "aabbccddeeff";
    String noRepeats = removeRepeatingChars(input3);
    System.out.println("Without Repeating Chars: " + noRepeats);

    String input4 = "aaabbcdee";
    String compressed = compressText(input4);
    System.out.println("Compressed Text: " + compressed);
  }

  public static String replaceLetters(String variable_1, int j) {
    StringBuilder strBuilder_1 = new StringBuilder();

    for (int i = 0; i < variable_1.length(); i++) {
      char letter = variable_1.charAt(i);

      if (Character.isLetter(letter)) {
        if (Character.isLowerCase(letter)) {
          letter = (char) ((letter - 'a' + j) % 26 + 'a');
        } else if (Character.isUpperCase(letter)) {
          letter = (char) ((letter - 'A' + j) % 26 + 'A');
        }
      }
      strBuilder_1.append(letter);
    }
    return strBuilder_1.toString();
  }

  public static String stripFromBothEnd(String variable_2) {
    StringBuilder strBuilder_2 = new StringBuilder();
    int i = 0;
    int j = variable_2.length() - 1;

    while (i <= j && Character.isWhitespace(variable_2.charAt(i))) {
      i++;
    }

    while (j >= i && Character.isWhitespace(variable_2.charAt(j))) {
      j--;
    }
    strBuilder_2.append(variable_2, i, j + 1);
    return strBuilder_2.toString();
  }

  public static String removeRepeatingChars(String variable_3) {
    StringBuilder strBuilder_3 = new StringBuilder();

    for (int i = 0; i < variable_3.length(); i++) {
      char character = variable_3.charAt(i);
      if (strBuilder_3.indexOf(String.valueOf(character)) == -1) {
        strBuilder_3.append(character);
      }
    }
    return strBuilder_3.toString();
  }

  public static String compressText(String variable_4) {
    StringBuilder strBuilder_4 = new StringBuilder();

    for (int i = 0; i < variable_4.length(); i++) {
      char character = variable_4.charAt(i);
      int j = 1;

      // Ardışık tekrar eden karakterleri say
      while (i + 1 < variable_4.length() && variable_4.charAt(i + 1) == character) {
        i++;
        j++;
      }

      // Karakteri ve sayısını sonuca ekle
      strBuilder_4.append(character);
      if (j > 1) {
        strBuilder_4.append(j);
      }
    }

    return strBuilder_4.toString();
  }
}
