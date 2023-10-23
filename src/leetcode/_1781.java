package leetcode;

/**
 * @author wei tan
 */
public class _1781 {
    public int beautySum(String s) {
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            int[] alphabet = new int[26];
            for (int j = i; j < s.length(); j++) {
                alphabet[s.charAt(j) - 'a']++;
                int min = Integer.MAX_VALUE;
                int max = Integer.MIN_VALUE;
                for (int value : alphabet) {
                    if (value == 0) {
                        continue;
                    }

                    min = Math.min(min, value);
                    max = Math.max(max, value);
                }
                result += max - min;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new _1781().beautySum("kcgdnprqxcmpcavjzjgvgekzsvoejxwrdsidzitpzcegxrrrnayndadtqwqswuinzyhdewzzvukqbzobylcporryqpurrzzmidrjcgtfoeyycrsbpbinbzweirmlamaajudtaermybbopxknkwalbnowfsevnodehzdalgailizfvnenmfuatxieorjaybxilmjsslalgeecmsbqwdjntfoaizbpmxekrtesrguepsevaymfwetnddblkbrirhrxrxvrpnqtazyurmwmlxtxczsypiycedwdgyzelbyapgfmedpzbfjfmbtydaqnshncgciqhatuzzpjklomxxqkdvrcwpotadandkwkfnrgiugpxyfjzzwkfdlvytfufxpsdwgmrqzufghuyq"));
    }
}
