class Solution {

    class TrieNode {
        TrieNode[] child = new TrieNode[26];
        int bestIndex = -1;
    }

    TrieNode root = new TrieNode();
    String[] wordsContainer;

    private void updateBest(TrieNode node, int idx) {
        if (node.bestIndex == -1) {
            node.bestIndex = idx;
            return;
        }

        int currLen = wordsContainer[node.bestIndex].length();
        int newLen = wordsContainer[idx].length();

        if (newLen < currLen ||
            (newLen == currLen && idx < node.bestIndex)) {
            node.bestIndex = idx;
        }
    }

    private void insert(String word, int idx) {
        TrieNode curr = root;

        updateBest(curr, idx);

        for (int i = word.length() - 1; i >= 0; i--) {
            int c = word.charAt(i) - 'a';

            if (curr.child[c] == null) {
                curr.child[c] = new TrieNode();
            }

            curr = curr.child[c];
            updateBest(curr, idx);
        }
    }

    private int query(String word) {
        TrieNode curr = root;

        for (int i = word.length() - 1; i >= 0; i--) {
            int c = word.charAt(i) - 'a';

            if (curr.child[c] == null) {
                break;
            }

            curr = curr.child[c];
        }

        return curr.bestIndex;
    }

    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        this.wordsContainer = wordsContainer;

        for (int i = 0; i < wordsContainer.length; i++) {
            insert(wordsContainer[i], i);
        }

        int[] ans = new int[wordsQuery.length];

        for (int i = 0; i < wordsQuery.length; i++) {
            ans[i] = query(wordsQuery[i]);
        }

        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna