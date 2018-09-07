
public class isNumeric {
public boolean isNumericMain(char[] str) {
	boolean sign=false,hasE=false,decimal=false;
	for(int i=0;i<str.length;i++){
		if(str[i]=='+' || str[i]=='-'){
		if(sign && str[i-1]!='e' && str[i-1]!='E') return false;
		if(!sign && i>0 && str[i-1]!='e' && str[i-1]!='E') return false;
		sign=true;
		}else if(str[i]=='E' || str[i]=='e'){
			if(hasE) return false;
			if(i==str.length-1) return false;
			hasE=true;
		}else if(str[i]=='.'){
			if(hasE || decimal) return false;
			decimal=true;
			
		}else if(str[i]<'0' || str[i]>'9'){
			return false;
		}
	}
	return true;
        
    }
}
