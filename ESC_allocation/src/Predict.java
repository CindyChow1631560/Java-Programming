import java.util.List;
import java.util.LinkedHashMap;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.Iterator;
import java.util.Map.Entry;
public class Predict {
	//����һ��Map,��flavorToPut���±��flavor��id��Ӧ
	public static LinkedHashMap mapFlavors = new LinkedHashMap();
	public static String[] predictVm(String[] ecsContent, String[] inputContent) {

		/** =========do your work here========== **/
        
		String[] results = new String[ecsContent.length];
        
		List<Flavor> history = new ArrayList<Flavor>();
		List<String> input = new ArrayList<String>();

		for (int i = 0; i < ecsContent.length; i++) {

			if (ecsContent[i].contains("\t")
					&& ecsContent[i].split("\t").length == 3) {

				String[] array = ecsContent[i].split("\t");
				String uuid = array[0];
				String flavorName = array[1];
				String createTime = array[2];
				Flavor flavor = new Flavor(uuid,flavorName,createTime);
                
				history.add(flavor);
			}
		}
		
		//��ȡinput�еĲ���
				int[] idx = new int[3];//���Ŀ��������������
				int count0=0;
				for (int i = 0;i<inputContent.length;i++) {
						if(inputContent[i].equals("")) {
							idx[count0] = i;//idx
							count0++;
						}		
					}
				String[] phyServer = new String[idx[0]];
				String[] flavorType = new String[idx[1]-idx[0]-2];//flavor�������洢
				String objType = inputContent[idx[2]-1];//ֻ�Ż�һ������
				String[] timeRange = new String[2];//�����ǲ�������ʱ���
				
				for (int i=0;i<idx[0];i++) {
					phyServer[i] = inputContent[i];
				}
				String[] serverInfo = phyServer[0].split(" ");//��¼����������Ĳ�����serverInfo[0]ΪCPU����serverInfo[1]ΪMEM
				
				for (int i=0;i<idx[1]-idx[0]-2;i++) {
					flavorType[i] = inputContent[idx[0]+2+i];
				}
				String[][] flavorInfo = new String[flavorType.length][3];//��¼ÿ��flavor����Ϣ��flavor[][1]ΪCPU��flavor[][2]ΪMEM
				for (int i=0;i<flavorType.length;i++){
					flavorInfo[i] = flavorType[i].split(" ");
				}
				//System.out.println(flavorType[0].substring(8,flavorType[0].indexOf(" ")));
				//System.out.println(Arrays.toString(serverInfo));
				for (int i=0;i<2;i++) {
					timeRange[i] = inputContent[idx[2]+i+1];
					timeRange[i] = timeRange[i].replace("-", "");
				}
				int dayNumber = Integer.parseInt(timeRange[1].substring(0, 8))-Integer.parseInt(timeRange[0].substring(0, 8));
                //System.out.println(dayNumber);
	//List<String> history = new ArrayList<String>();
				
	List<Integer> flavorid_predict = new ArrayList();//������¼ҪԤ���flavor��id
	for (int i=0;i<flavorType.length;i++){
		flavorid_predict.add(flavorType[i].charAt(6)-'0');
	}
	
   
   	for (int i=0;i<history.size();i++){
   		history.get(i).createTime = history.get(i).createTime.substring(0,10).replace("-", "");	
   	}
   	/*
   	String[] results2 =new String[history.size()];
   	for (int i=0;i<history.size();i++){
   		results2[i]=history.get(i).flavorName;
   	}*/
   	
   	//����һ�����������¼ʱ���Ӧ������
   	int[] date = new int[history.size()];
   	date[0]=1;
   	for (int i=1;i<history.size();i++){
   		//System.out.println(history.get(i).createTime.substring(4, 6).equals("01"));
   		date[i]=Integer.parseInt(history.get(i).createTime)-Integer.parseInt(history.get(0).createTime)+1;
   		if(date[i]>100){
   			date[i] = date[i]/100*30+date[i]%100;
   		}
   	}
   //	System.out.println(Arrays.toString(date));
   
   	//������һ�����������¼ÿ����¼��Ӧ��flavor��id
   	int[] flavorid =new int[history.size()];
   	for (int i=0;i<history.size();i++){
   		flavorid[i] = Integer.parseInt(history.get(i).flavorName.substring(6));
   	}
   	
   	
   	int[] copyFlavorid = new int[flavorid.length];
   	for (int i=0;i<flavorid.length;i++){
   		copyFlavorid[i]=flavorid[i];
   	}
   	int[] copyDate = new int[date.length];
   	for (int i=0;i<date.length;i++){
   		copyDate[i]=date[i];
   	}
   	Arrays.sort(copyFlavorid);
   	Arrays.sort(copyDate);
   	//System.out.println(Arrays.toString(flavorid));
   	int m = copyFlavorid[copyFlavorid.length-1];
   	int n = copyDate[copyDate.length-1];
   	
   	//int m=23;
   	//int n=49;
	 //��һ����ά�����¼��i��flavor��j�������
  	 int[][] count = new int[m+1][n+1]; 
  	for(int i=0;i<count.length;i++){
		  for(int j=0;j<count[0].length;j++){
		 count[i][j]=0;
		  }
		}	
  //��ʱ����
  		
  	/*double[][] theta =new double[count.length+1][count[0].length+1];  //����
    for(int i=0;i<theta.length;i++){
   	 for(int j=1;j<count[0].length;j++){
   	 theta[i][j] = 0.5; //��������ʼ��Ϊ0.5
   	 }
    }*/
   //	System.out.println(history.size());
   	for (int i=0;i<history.size();i++){
   		//System.out.println(m);
   		count[flavorid[i]][date[i]] = count[flavorid[i]][date[i]]+1;
   	}
   	
   
   	//��predict_record��¼ҪԤ���ÿ���flavor id������
   	int window=dayNumber+1;
	//System.out.println(count[0].length-window);
   	int[][] predict_record =new int[flavorType.length][window];
 
   	for(int i=0;i<flavorType.length;i++){
   		for (int j=1;j<window;j++){//�ѵ�һ��λ����������¼�´ε�Ԥ��ֵ
   			predict_record[i][j]= count[flavorid_predict.get(i)][count[0].length-j];//��¼��ʱ�����ɽ���Զ��
   		}
   	}
   	for(int i=0;i<predict_record.length;i++){
   		int sum=0;
   		for(int j=1;j<window;j++){
   		    sum=sum+predict_record[i][j];
   		    predict_record[i][0] = sum/(window-1);
   		    for( int k=window-1;k>=1;k--){
   		    	predict_record[i][k]=predict_record[i][k-1];
   		    }
   		}
   	}
   	
	//System.out.println(Arrays.toString(predict_record[0]));
    //System.out.println(Arrays.toString(predict_record[1]));
	//System.out.println(Arrays.toString(predict_record[2]));
	//System.out.println(Arrays.toString(predict_record[3]));
	//System.out.println(Arrays.toString(predict_record[4]));
   	int total_flavorNumber=0;
   	int[] numberOfEachFlavor = new int[flavorType.length];//��������������ҪԤ���ÿ��flavor��������
    for (int i=0;i<flavorType.length;i++){
    	numberOfEachFlavor[i] = 0;
    }
   	for (int i=0;i<predict_record.length;i++){
   		for(int j=1;j<dayNumber;j++){
   			total_flavorNumber=total_flavorNumber+predict_record[i][j];
   			numberOfEachFlavor[i]=numberOfEachFlavor[i]+predict_record[i][j];
   		}
   	}
   	
   	//System.out.println(total_flavorNumber);
   /*double totalObj=0;//��¼�ܹ���Ҫ��CPU������MEN��
   int numberOfphyServer;
   int loop=predict_record.length-1;
   while(loop>=0){
   if (objType=="CPU"){
	   //for (int i=0;i<predict_record.length;i++){
		   totalObj=totalObj+(int)numberOfEachFlavor[loop]*Integer.parseInt(flavorInfo[loop][1]);
	  // }
	   //numberOfphyServer=(int)totalObj/Integer.parseInt(serverInfo[0]);
   }else{
	   //for (int i=0;i<predict_record.length;i++){
		   totalObj=totalObj+(int)numberOfEachFlavor[loop]*Integer.parseInt(flavorInfo[loop][2]);
	   //}
	   //numberOfphyServer=(int)totalObj/(Integer.parseInt(serverInfo[1])*1024);
   }
   loop--;
	}
   */
  //System.out.println(totalObj);
   /*
  LinkedHashMap flavorCPU = new LinkedHashMap();
  LinkedHashMap flavorMEM = new LinkedHashMap();
  for(int i=0;i<flavorid_predict.size();i++){
	  flavorCPU.put(flavorInfo[i][0], Integer.parseInt(flavorInfo[i][1]));
	  flavorMEM.put(flavorInfo[i][0], Integer.parseInt(flavorInfo[i][2])); 
  }*/
  
   List<RequFlavor> predict = new ArrayList();//predict������¼ҪԤ���flavor�����֣�������cpu����mem��
   for(int i=0;i<flavorid_predict.size();i++){
	   String flavor_requ=flavorInfo[i][0];
	   int CPUNum = Integer.parseInt(flavorInfo[i][1]);
	   int MEMCap = Integer.parseInt(flavorInfo[i][2])/1024;//ͳһ��λGB
	   int requ_num = numberOfEachFlavor[i];
	   RequFlavor requflavor = new RequFlavor(flavor_requ,CPUNum,MEMCap,requ_num);
	   predict.add(requflavor);
   }
   
    
   int script = 0;
   List<Integer> flavorToPut = new ArrayList();
   if(objType.equals("CPU")){
   for(int i=0;i<predict.size();i++){
	   if(predict.get(i).requ_num!=0){
		   for(int j=0;j<predict.get(i).requ_num;j++){
			   mapFlavors.put(script, predict.get(i).flavorName);
			   script++;
			   flavorToPut.add(predict.get(i).CPUNum);
		   }
	   }
   }
   }else{
	   for(int i=0;i<predict.size();i++){
		   if(predict.get(i).requ_num!=0){
			   for(int j=0;j<predict.get(i).requ_num;j++){
				   mapFlavors.put(script, predict.get(i));
				   script++;
				   flavorToPut.add(predict.get(i).MEMCap);
			   }
		   }
	   }
   }
  
   //System.out.println(mapFlavors.entrySet());
  
  
  //System.out.println(choose.length);
  int[] w =new int[flavorToPut.size()];
  for(int i=0;i<flavorToPut.size();i++){
	  w[i]=flavorToPut.get(i);
  }
  
  int dimOfType = 0;
  if (objType.equals("MEM")){
	  dimOfType = Integer.parseInt(serverInfo[1]);
  }
  else{
	  dimOfType = Integer.parseInt(serverInfo[0]);
  }
  /*int[][] V = new int[(int)total_flavorNumber][dimOfType];
  for(int i=0;i<V.length;i++){
	  for(int j=0;j<V[0].length;j++){
		  V[i][j]=0;
	  }
  }*/
  int[] choosetemp = new int[total_flavorNumber+1];
  for (int i=0;i<choosetemp.length;i++){
	  choosetemp[i] = 0;
  }
  //System.out.println(choosetemp.length);
  ArrayList<String> outPhyServer = new ArrayList();
  int totalPhyServer=0;//�������������������
  int Serverindex=1;
  int sizeOfFlavorToPut = flavorToPut.size();
 // System.out.println(flavorToPut.size());
  while(sizeOfFlavorToPut>0){
	  if(objType.equals("CPU")){
		  choosetemp = BackPack_Solution(Integer.parseInt(serverInfo[0]),total_flavorNumber,w,w,choosetemp);
		  }else{
			  choosetemp = BackPack_Solution(Integer.parseInt(serverInfo[1]),total_flavorNumber,w,w,choosetemp);
		  }
	  //System.out.println(Arrays.toString(choosetemp));
	  int[] choose = new int[choosetemp.length-1];
      for (int i=1;i<choosetemp.length;i++){
      	choose[i-1] = choosetemp[i]; 
      }
	  ArrayList index = findIndices(choose,1);
	  String[] flavorChoose = new String[index.size()];
	  for(int i=0;i<index.size();i++){
		  flavorChoose[i] = (String)mapFlavors.get(index.get(i));
	  }
	  //System.out.println(x);
	  LinkedHashMap<String,Integer> map = new LinkedHashMap<String,Integer>();
      for(String str:flavorChoose){
    	  Integer num= map.get(str);
    	  map.put(str, num==null?1:num+1);
    	//  System.out.println(map.entrySet());
      }
      //System.out.println(map.entrySet());
      /*Set set= map.entrySet();
      Iterator iter = set.iterator();
      HashMap.Entry<String, Integer> entry;
      while(iter.hasNext()){
    	 entry = (Entry<String, Integer>) iter.next();//ʹ��entry.getKey(),entry.getValue()
      }*/
     /* HashMap<String,Integer> allFlavor = new HashMap();
      for (int i=0;i<flavorInfo.length;i++){
    	 allFlavor.put(flavorInfo[i][0], 0);
    	 
      }
   
      //System.out.println(Arrays.toString(flavorChoose));
      
      
      for (int j=0;j<map.size();j++){
    	  if(map.get(flavorChoose[j])!=0){
    		  allFlavor.replace(flavorChoose[j], map.get(flavorChoose[j]));
    	  }
      
      }*/
      
	  //System.out.println(allFlavor.entrySet());
      Set<String> keySet = map.keySet();//���map�еļ�ֵ
      Iterator<String> iter = keySet.iterator();
	  String temp = Serverindex +" ";
	  while(iter.hasNext()){
		  String nameOfflavor=iter.next();
		  temp = temp+nameOfflavor+" "+map.get(nameOfflavor)+" ";
	  }
	 // for(int i=0;i<flavorChoose.length;i++){
	//	  temp = temp+flavorChoose[i]+" "+map.get(flavorChoose[i])+" ";
	  //}
	  temp =temp.substring(0,temp.length()-1)+"\n";
	  outPhyServer.add(temp);
	  ArrayList<Integer> mark = new ArrayList();//mark������¼choose�б�ɾ���ı��
	  ArrayList<Integer> list = new ArrayList();//��choose����ת��Ϊlist
      for(int i=0;i<choose.length;i++){
   	   list.add(choose[i]);
      }
	  for(int i=0;i<list.size();i++){
		  if((int)list.get(i)==1){
			  list.remove(i);
			  i--;
			  mark.add(i);
		  }
	  }
	  //�ٽ�choose list����ת��������
 	  int[] chooseTp = new int[list.size()];
 	  for(int i=0;i<list.size();i++){
 		  chooseTp[i] = list.get(i);
 	  }
	  choose = Arrays.copyOf(chooseTp, chooseTp.length);
	  choosetemp = Arrays.copyOf(choose, choose.length+1);
	  for(int i=0;i<mark.size();i++){
		  mapFlavors.remove(mark.get(i), mapFlavors.get(mark.get(i)));
	  }
	  totalPhyServer++;
	 // System.out.println(flavorChoose.length);
      sizeOfFlavorToPut = choose.length;
      //System.out.println(sizeOfFlavorToPut);
  }
  
 
   
  results[0]=String.valueOf(total_flavorNumber)+"\n";
  for(int i=1;i<numberOfEachFlavor.length+1;i++){
	  results[i] = flavorInfo[i-1][0]+" "+String.valueOf(numberOfEachFlavor[i-1])+"\n";
  }
 // System.out.println(Arrays.toString(results));
 results[numberOfEachFlavor.length+1]="\r\n";
 results[numberOfEachFlavor.length+2]=String.valueOf(totalPhyServer)+"\n";
 for(int i=numberOfEachFlavor.length+3;i<numberOfEachFlavor.length+3+outPhyServer.size();i++){
	 results[i] = outPhyServer.get(i-numberOfEachFlavor.length-3);
 }
  
   	/* while(row!=0)
   	 {
   		for(int i=1;i<count.length;i++){
     		  for(int j=1;j<count[0].length;j++){
   		 theta = LinearRegression(count,alpha,theta);
     		  }
   		}
   		 --row;
   	 }
   	 
   	 //����ÿ��flavorǰn���weight*count[][i](i=1,2,...49)
   	 double[][] record = new double[flavorid.length-1][flavorType.length];
   	 for (int i=0;i<record.length;i++){
   		 for (int j=0;j<record[0].length;j++){
   			 record[i][j]=0;
   		 }
   	 }
  /* 	for(int i=1;i<count.length;i++){
		  for(int j=1;j<count[0].length;j++){
		 sum[i-1][j-1] = sum[i-1][j-1]+theta[i][j]*count[i][j];
		  }
		}*/
   	/*String[] results1=new String[results.length];
   	for (int i=0;i<results.length;i++){
   	results1[i] = Double.toString(results[i]);
   	}*/
 //System.out.println(Arrays.toString(results));
   	return results;
   	
	} 	 
	
	 /**
     * @param m ��ʾ��������������������������,
     * @param n ��ʾ��Ʒ��������ҪԤ���flavor�ĸ���
     * @param w ��ʾ��Ʒ��������,��ÿ��flavor��cpu������MEM��С
     * @param p ��ʾ��Ʒ��ֵ���飬Ҳ��ÿ��flavor��cpu������MEM��С
     * @param x ��ʾ���flavorѡ�����
     */
    public static int[] BackPack_Solution(int m, int n, int[] w, int[] p, int[] x) {
        //c[i][v]��ʾǰi����Ʒǡ����һ������Ϊm�ı������Ի�õ�����ֵ
        int c[][] = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++)
            c[i][0] = 0;
        for (int j = 0; j < m + 1; j++)
            c[0][j] = 0;

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                //����ƷΪi������Ϊjʱ�������i��������(w[i-1])С������jʱ��c[i][j]Ϊ�����������֮һ��
                //(1)��Ʒi�����뱳���У�����c[i][j]Ϊc[i-1][j]��ֵ
                //(2)��Ʒi���뱳���У��򱳰�ʣ������Ϊj-w[i-1],����c[i][j]Ϊc[i-1][j-w[i-1]]��ֵ���ϵ�ǰ��Ʒi�ļ�ֵ
                if (w[i - 1] <= j) {
                    if (c[i - 1][j] < (c[i - 1][j - w[i - 1]] + p[i - 1])){
                    	//x[i-1]=1;
                        c[i][j] = c[i - 1][j - w[i - 1]] + p[i - 1];
                        
                    }
                    else{
                    	//x[i-1]=0;
                        c[i][j] = c[i - 1][j];
                        
                    }
                } else{
                    c[i][j] = c[i - 1][j];
                    //x[i-1]=0;
                }
               
            }
        }
        for (int i = n; i >= 1; i--)
	    {
	        if (c[i][m]>c[i - 1][m])
	        {
	            x[i] = 1;
	            m = m - w[i-1];
	        }
	        else
	            x[i] = 0;
	    }
       
        return x;
    }
    
    //�ҳ�1Ԫ���±�
    public static ArrayList<Integer> findIndices(int[] array,int elements) {
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	for(int i=0;i<array.length;i++) {
    		if(array[i]==elements) {
    			list.add(i);	
    		}
    				
    	}return list;
    }

}

	/*public static double[][] LinearRegression(int[][] count, double alpha, double[][] theta){
   	  double a = alpha;
   	  double[] Y=new double[count.length-1];
   	  //���ݲ������Ԥ���Y
   	  for(int i=1;i<count.length;i++){
   		  for(int j=1;j<count[0].length;j++){
   		  Y[i-1] = Y[i-1]+theta[i][j]*count[i][j];
   		  }
   	  }
   	  //�ݶ��½�������ÿ������
   	  for (int i=1;i<count.length;i++){
   		  for(int j=1;j<count[0].length;j++){
   		  theta[i][j]=theta[i][j]+a*(count[i][j]-Y[i-1])*count[i][j];
   		  }
   	  }
	return theta;
    }*/


class Flavor{
	String uuid, flavorName, createTime;
	Flavor(String uuid, String flavorname, String createtime)
	{
		this.uuid = uuid;
		this.flavorName = flavorname;
		this.createTime = createtime;
	}
	
}
class RequFlavor{
	String flavorName;
	int CPUNum;
	int MEMCap;
	int requ_num;
	RequFlavor(String flavorName, int CPUNum, int MEMCap, int requ_num){
		this.flavorName = flavorName;
		this.CPUNum = CPUNum;
		this.MEMCap = MEMCap;
		this.requ_num = requ_num;
	}
}

