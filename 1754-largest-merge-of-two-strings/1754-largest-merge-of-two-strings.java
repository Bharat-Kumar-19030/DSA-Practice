class Solution {
    public String largestMerge(String word1, String word2) {
        StringBuilder sb= new StringBuilder();
        int i=0,j=0;
        while(i<word1.length()&&j<word2.length()){
            if(word1.charAt(i)>word2.charAt(j)){
                sb.append(word1.charAt(i));
                i++;
            }
            else if(word1.charAt(i)==word2.charAt(j)){
                int a=i,b=j;
                while(a<word1.length()&&b<word2.length()&&word1.charAt(a)==word2.charAt(b)){
                    a++;b++;
                }
                if(a==word1.length()&&b==word2.length()){
                    sb.append(word1.charAt(i));
                    i++;
                }
                else if(a==word1.length()){
                    sb.append(word2.charAt(j));
                    j++;
                }
                else if(b==word2.length()){
                    sb.append(word1.charAt(i));
                    i++;
                }
                else{
                    if(word1.charAt(a)>word2.charAt(b)){
                        sb.append(word1.charAt(i));
                        i++;
                    }else{
                        sb.append(word2.charAt(j));
                        j++;
                    }
                }
            }
            else{
                sb.append(word2.charAt(j));
                j++;
            }
        }
        while(i<word1.length()){
            sb.append(word1.charAt(i));
            i++;
        }
        while(j<word2.length()){
            sb.append(word2.charAt(j));
            j++;
        }
        return sb.toString();
    }
}