class Solution {
    public boolean checkIfPangram(String sentence) {
        int freq = 0;

        for (Character c : sentence.toCharArray())
        	freq |= (1 << ((int)c) - 'a');
        
        return freq == (1 << 26) - 1;
    }
}