import java.io.*;
import java.util.*;
public class ReadFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
       String fileName = "D:\\competition\\Huawei_software_challenge\\data\\TrainData.txt";
       Object[] data=null;
       String line=null;
       BufferedReader in = new BufferedReader(new FileReader(new File(fileName).getAbsoluteFile()));
       while((line=in.readLine())!=null){
    	   data = line.split(" ");
       }   
    	   in.close();
	}

}
