class Solution {
    public int numberOfSpecialChars(String word) {
        int upper[]= new int[26];
        int lower[]= new int[26];
        int count=0;
        Arrays.fill(lower,-1);
        Arrays.fill(upper,-1);
        for(int i=0;i<word.length();i++){
            if(word.charAt(i)>='a'&&word.charAt(i)<='z'){
                lower[word.charAt(i)-'a']=i;
            }
            else{
                if(upper[word.charAt(i)-'A']==-1)
                upper[word.charAt(i)-'A']=i;
            }
        }
        for(int j=0;j<26;j++){
            if(lower[j]!=-1&&upper[j]!=-1&&lower[j]<upper[j])count++;
        }
        return count;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna