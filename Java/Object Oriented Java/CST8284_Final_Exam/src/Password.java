public class Password extends AbstractPassword {
	public Password(String password) {
		setPassword(password);
	}
	public String first(String password) {
		StringBuffer sb = new StringBuffer();
		sb.append(password);
		for(int i =0; i<sb.length();i++) {
			Character c=sb.charAt(i);
			if(Character.isLowerCase(c)) {
				sb.replace(i,i+1,Character.toUpperCase(c)+"");					
			}else {
				sb.replace(i,i+1,Character.toLowerCase(c)+"");
			}
		}return sb.toString();
	}
	public int second(String convertedPassword) {
		StringBuffer sb = new StringBuffer();
		sb.append(convertedPassword);
		int x=0;
		for(int i =0; i<sb.length();i++) {
			Character c=sb.charAt(i);
			int z=c-64;
			if(z>32) {
				z-=32;	//trying to convert ASCII to A/a=1...?
			}
			x += z;	
		}
		return x;
	}		
}
