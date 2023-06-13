import java.util.Stack;
class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			switch (s.charAt(i)) 
			{
				case '(':
				case '{':
				case '[':
					st.add(s.charAt(i));
					break;
				case '}':
					if (st.empty() || st.pop() != '{')
						return false;
					break;			
				case ')':
					if (st.empty() || st.pop() != '(')
						return false;
					break;	
				case ']':
					if (st.empty() || st.pop() != '[')
						return false;
					break;
			}
		}
		return st.empty();
    }
}