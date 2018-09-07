import java.util.List;
import java.util.LinkedHashMap;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.Iterator;
import java.util.Map.Entry;
public class Predict {
	//定义一个Map,将flavorToPut的下标和flavor的id对应
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
		
		//读取input中的参数
				int[] idx = new int[3];//共四块参数，三个空行
				int count0=0;
				for (int i = 0;i<inputContent.length;i++) {
						if(inputContent[i].equals("")) {
							idx[count0] = i;//idx
							count0++;
						}		
					}
				String[] phyServer = new String[idx[0]];
				String[] flavorType = new String[idx[1]-idx[0]-2];//flavor数量不存储
				String objType = inputContent[idx[2]-1];//只优化一种类型
				String[] timeRange = new String[2];//不考虑不连续多时间段
				
				for (int i=0;i<idx[0];i++) {
					phyServer[i] = inputContent[i];
				}
				String[] serverInfo = phyServer[0].split(" ");//记录物理服务器的参数，serverInfo[0]为CPU数，serverInfo[1]为MEM
				
				for (int i=0;i<idx[1]-idx[0]-2;i++) {
					flavorType[i] = inputContent[idx[0]+2+i];
				}
				String[][] flavorInfo = new String[flavorType.length][3];//记录每种flavor的信息，flavor[][1]为CPU，flavor[][2]为MEM
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
				
	List<Integer> flavorid_predict = new ArrayList();//用来记录要预测的flavor的id
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
   	
   	//构造一个辅助数组记录时间对应的数字
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
   
   	//构造另一个辅助数组记录每条记录对应的flavor的id
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
	 //用一个二维数组记录第i个flavor第j天的数量
  	 int[][] count = new int[m+1][n+1]; 
  	for(int i=0;i<count.length;i++){
		  for(int j=0;j<count[0].length;j++){
		 count[i][j]=0;
		  }
		}	
  //简化时间表达
  		
  	/*double[][] theta =new double[count.length+1][count[0].length+1];  //参数
    for(int i=0;i<theta.length;i++){
   	 for(int j=1;j<count[0].length;j++){
   	 theta[i][j] = 0.5; //将参数初始化为0.5
   	 }
    }*/
   //	System.out.println(history.size());
   	for (int i=0;i<history.size();i++){
   		//System.out.println(m);
   		count[flavorid[i]][date[i]] = count[flavorid[i]][date[i]]+1;
   	}
   	
   
   	//用predict_record记录要预测的每天的flavor id的数量
   	int window=dayNumber+1;
	//System.out.println(count[0].length-window);
   	int[][] predict_record =new int[flavorType.length][window];
 
   	for(int i=0;i<flavorType.length;i++){
   		for (int j=1;j<window;j++){//把第一个位置留出来记录下次的预测值
   			predict_record[i][j]= count[flavorid_predict.get(i)][count[0].length-j];//记录的时间是由近及远的
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
   	int[] numberOfEachFlavor = new int[flavorType.length];//此数组用来计算要预测的每种flavor的总数量
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
   /*double totalObj=0;//记录总共需要的CPU数或者MEN数
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
  
   List<RequFlavor> predict = new ArrayList();//predict用来记录要预测的flavor的名字，数量，cpu数，mem数
   for(int i=0;i<flavorid_predict.size();i++){
	   String flavor_requ=flavorInfo[i][0];
	   int CPUNum = Integer.parseInt(flavorInfo[i][1]);
	   int MEMCap = Integer.parseInt(flavorInfo[i][2])/1024;//统一单位GB
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
  int totalPhyServer=0;//所需物理服务器的总数
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
    	 entry = (Entry<String, Integer>) iter.next();//使用entry.getKey(),entry.getValue()
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
      Set<String> keySet = map.keySet();//获得map中的键值
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
	  ArrayList<Integer> mark = new ArrayList();//mark用来记录choose中被删除的标号
	  ArrayList<Integer> list = new ArrayList();//将choose数组转换为list
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
	  //再将choose list重新转换成数组
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
   	 
   	 //计算每个flavor前n天的weight*count[][i](i=1,2,...49)
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
     * @param m 表示背包（物理服务器）的最大容量,
     * @param n 表示商品个数，即要预测的flavor的个数
     * @param w 表示商品重量数组,即每个flavor的cpu数或者MEM大小
     * @param p 表示商品价值数组，也是每个flavor的cpu数或者MEM大小
     * @param x 表示这个flavor选中与否
     */
    public static int[] BackPack_Solution(int m, int n, int[] w, int[] p, int[] x) {
        //c[i][v]表示前i件物品恰放入一个重量为m的背包可以获得的最大价值
        int c[][] = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++)
            c[i][0] = 0;
        for (int j = 0; j < m + 1; j++)
            c[0][j] = 0;

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                //当物品为i件重量为j时，如果第i件的重量(w[i-1])小于重量j时，c[i][j]为下列两种情况之一：
                //(1)物品i不放入背包中，所以c[i][j]为c[i-1][j]的值
                //(2)物品i放入背包中，则背包剩余重量为j-w[i-1],所以c[i][j]为c[i-1][j-w[i-1]]的值加上当前物品i的价值
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
    
    //找出1元素下标
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
   	  //根据参数求出预测的Y
   	  for(int i=1;i<count.length;i++){
   		  for(int j=1;j<count[0].length;j++){
   		  Y[i-1] = Y[i-1]+theta[i][j]*count[i][j];
   		  }
   	  }
   	  //梯度下降法更新每个参数
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

