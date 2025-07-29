import java.util.Random;

public class MyTool {
  public static String getCode(){
    //認証コードを生成するメソッドです。
    StringBuilder str = new StringBuilder();
    Random random = new Random();

    char[] roma = new char[52];
    char code = 'A';
    for (int i = 0; i < 26; i++) {
      roma[i] = (char)(code + i);
      roma[i + 26] = (char)(code + i + 32);
    }

    char[] chars = new char[5];

    for (int i = 0; i < chars.length - 1; i++) {
      chars[i] = (roma[random.nextInt(roma.length)]);
    }

    chars[4] = (char)('1' + random.nextInt(9));

    for (int i = chars.length - 1; i > 0; i--) {
      int j = random.nextInt(i + 1);
      char temp = chars[i];
      chars[i] = chars[j];
      chars[j] = temp;
    }

    for (char c : chars) {
      str.append(c);
    }

    return str.toString();
  }
}
