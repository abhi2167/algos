package com.ds.codewars.play.passphrase;

public class PassPhrasePlay {

	public static void main(String[] args){
		System.out.println(playPass("I LOVE YOU6!!!", 1));
	}
	
	public static String playPass(String s, int n) {
		// your code
		String [] str = s.split("\\s++");
		StringBuilder result = new StringBuilder();
		for(String word : str){
			StringBuilder sb = new StringBuilder(word);
			//System.out.println(sb);
			for(int i=0;i<sb.length();i++){
				if(Character.isAlphabetic(sb.charAt(i))){
					for(int j=0;j<n;j++){
						int shift = (int)sb.charAt(i);
						if(shift < 90){
							shift++;
						} else {
							shift = 65;
						}
						sb.setCharAt(i, (char) shift);
					}
				} else if(Character.isDigit(sb.charAt(i))){
					sb.setCharAt(i, (char) (48 + 9-Character.getNumericValue(sb.charAt(i))));
				}
			}
			result.append(sb+" ");
		}
		for(int i=0;i<result.length();i++){
			if(Character.isAlphabetic(result.charAt(i))){
				if(i%2 == 0)
					result.setCharAt(i, Character.toUpperCase(result.charAt(i)));
				else
					result.setCharAt(i, Character.toLowerCase(result.charAt(i)));
			}
		}
		return result.reverse().toString().trim();
	}
	
	public static String playPassBest(String s, int n) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetter(c)) {
                if (i % 2 == 0) {
                    c = String.valueOf(c).toUpperCase().charAt(0);
                    if (c + n > 90) c += n - 26;
                    else c += n;
                }
                else {
                    c = String.valueOf(c).toLowerCase().charAt(0);
                    if (c + n > 122) c += n - 26;
                    else c += n;
                }
                result.append(c);
            }
            else if (Character.isDigit(c)) result.append(9 - Integer.parseInt(String.valueOf(c)));
            else result.append(c);
        }
        return result.reverse().toString();
    }
}
