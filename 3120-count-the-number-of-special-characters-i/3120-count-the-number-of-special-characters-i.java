class Solution {
    public int numberOfSpecialChars(String word) {
        int upper[]= new int[26];
        int lower[]= new int[26];
        for(int i=0;i<word.length();i++){
            if(word.charAt(i)>='a'&&word.charAt(i)<='z'){
                lower[word.charAt(i)-'a']++;
            }else{
                upper[word.charAt(i)-'A']++;
            }
        }
        int count=0;
        for(int i=0;i<26;i++){
            if(upper[i]>0&&lower[i]>0)count++;
        }
        return count;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna