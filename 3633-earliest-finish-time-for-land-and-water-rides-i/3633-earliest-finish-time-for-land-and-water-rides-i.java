class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration,
                                  int[] waterStartTime, int[] waterDuration) {

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < landStartTime.length; i++) {

            int landFinish = landStartTime[i] + landDuration[i];

            for (int j = 0; j < waterStartTime.length; j++) {

                int waterFinish;

                if (waterStartTime[j] >= landFinish) {
                    waterFinish = waterStartTime[j] + waterDuration[j];
                } else {
                    waterFinish = landFinish + waterDuration[j];
                }

                ans = Math.min(ans, waterFinish);
            }
        }
        for (int i = 0; i < waterStartTime.length; i++) {

            int waterFinish = waterStartTime[i] + waterDuration[i];

            for (int j = 0; j < landStartTime.length; j++) {

                int landFinish;

                if (landStartTime[j] >= waterFinish) {
                    landFinish = landStartTime[j] + landDuration[j];
                } else {
                    landFinish = waterFinish + landDuration[j];
                }

                ans = Math.min(ans, landFinish);
            }
        }

        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna