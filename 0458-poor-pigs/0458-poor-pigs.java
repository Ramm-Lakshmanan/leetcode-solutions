class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int round = minutesToTest / minutesToDie + 1;
        return (int) Math.ceil(Math.log10(buckets) / Math.log10(round));
    }
}