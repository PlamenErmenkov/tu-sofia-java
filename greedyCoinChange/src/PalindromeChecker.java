public class PalindromeChecker {
    public static void main(String[] args) {
    }

    private static boolean isPalindrome(String str) {
        String cleanStr = str.toLowerCase();

        int length = cleanStr.length();
        int i = 0, j = length - 1;

        while (i < j) {
            while (i < length && !Character.isLetter(cleanStr.charAt(i))) {
                i++;
            }

            while (j >= 0 && !Character.isLetter(cleanStr.charAt(j))) {
                j--;
            }

            if (i < j && cleanStr.charAt(i) != cleanStr.charAt(j)) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }
}
