import java.util.HashMap;
class Solution {
    public long countOfSubstrings(String word, int k) {
        return atLeastK(word, k) - atLeastK(word, k + 1);
    }

    private long atLeastK(String word, int k) {
        long numValidSubstrings = 0;
        int start = 0;
        int end = 0;
        HashMap<Character, Integer> vowelCount = new HashMap<>();
        int consonantCount = 0;
        String vowels = "aeiou";
        
        while (end < word.length()) {
            char newLetter = word.charAt(end);
            if (vowels.indexOf(newLetter) != -1) {
                vowelCount.put(newLetter, vowelCount.getOrDefault(newLetter, 0) + 1);
            } else {
                consonantCount++;
            }

            while (consonantCount >= k && vowelCount.size() == 5) {
                numValidSubstrings += word.length() - end;

                char startLetter = word.charAt(start);
                if (vowels.indexOf(startLetter) != -1) {
                    vowelCount.put(startLetter, vowelCount.get(startLetter) - 1);
                    if (vowelCount.get(startLetter) == 0) {
                        vowelCount.remove(startLetter);
                    }
                } else {
                    consonantCount--;
                }

                start++;
            }

            end++;
        }

        return numValidSubstrings;
    }
}
