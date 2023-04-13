class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
    		return "";
    	char[] prefix = strs[0].toCharArray();
    	int len = prefix.length;
    	for (String str : strs)
    	{
    		len = Math.min(len, str.length());
    		for (int i = len - 1; i >= 0; i-- ){
    			if (prefix[i] != str.charAt(i)) 
    				len = i;
    		}
    	}
    	return String.copyValueOf(prefix, 0, len);
    }
}