package leetcode;

/**
 * @author wei tan
 * 1736. Latest Time by Replacing Hidden Digits
 */
public class _1736 {
    public String maximumTime(String time) {
      /*
          Judge by two part, split by ':'
      */

        StringBuilder sb = new StringBuilder();

        char firstChar = time.charAt(0);
        char secondChar = time.charAt(1);
        char thirdChar = time.charAt(3);
        char fourthChar = time.charAt(4);

        //the first character
        if (firstChar == '?') {
            sb.append(secondChar == '?'
                    ? '2'
                    : secondChar <= '3' ? '2' : '1');
        } else {
            sb.append(firstChar);
        }

        //the second character
        if (secondChar == '?') {
            sb.append(sb.charAt(0) < '2' ? '9' : '3');
        } else {
            sb.append(secondChar);
        }

        sb.append(':');

        //the third character
        if (thirdChar == '?') {
            sb.append('5');
        } else {
            sb.append(thirdChar);
        }

        //the fourth character
        if (fourthChar == '?') {
            sb.append('9');
        } else {
            sb.append(fourthChar);
        }

        return sb.toString();
    }
}
