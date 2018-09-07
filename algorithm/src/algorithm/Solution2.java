package algorithm;
import java.util.Scanner;
public class Solution2 {
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		StringBuffer mm = new StringBuffer();
	}
	static StringBuffer stringBuffer;//��̬ȫ�ֱ�����һ�����ڽ����ַ�����stringbuffer
	
	/**
	 * ��������Ǻ��ģ������Ѵ��������ת���ɺ�������ַ���
	 * @param num �����������Ӧ��������21��֮��
	 * @return ����һ���ַ������ַ������Ǻ��﷭��
	 */
	public static String transInt(long num){
		
		stringBuffer=new StringBuffer();//ÿ��ʹ��֮ǰ���һ�Σ���Ȼ�������һ�ε�ֵ
		
		//�ȿ��ж��ٸ���
		if(num/10000/10000>0){
				int yi = (int)(num/10000/10000);//���������ȥ����֮��Ĵ����󣬵ó��ж��ٸ�һ��
				changeGe(yi); //����Щһ��ת������λ������ʮһ
				stringBuffer.append("��");//���ϡ��ڡ��ͱ����ʮһ��
		}
		if((num/10000%10000)>0){//ȥ��ǧλ�����º���λ�����ϣ���ʣ�µ���λ��û��ֵ
			int wan = (int)(num/10000);//����ʣ�µ������ж�����,��Ϊֻ�����λѭ��4�飬���Ը�λ��ʲô��������
			
			changeGe(wan); 
			stringBuffer.append("��");
			
	}
		if(num>=20|num<10){
			int qian = (int)(num%10000);//��ȥ�������Ժ�ȡ�࿴����ʣ����
			
			changeGe(qian);
		}
		if(num>=10&&num<20){
				littleThan20((int) num);//ʮ��20֮�����ת�����򲻴�һ������һʮ��Ӧд��ʮ�������Ե�����һ������������İ�������
			}
		if(num!=0){//һ�¼��д������������������stringbuffer��ǰ�����ġ��㡯������3510351��д����������ʮһ����������ʮһ��Ϊ�˷�ֹ���ֲ����ĳ�ͻ������ǰ���0��ȥ
			if(stringBuffer.length()>=0&&stringBuffer.charAt(0)=='��'){
				stringBuffer.deleteCharAt(0);
			}
		}
		if(num == 0){
			stringBuffer.append('��');
		}
		return stringBuffer.toString();
	}
	
	
	
	/**
	 * �����ڣ��򣬸��ȵ�λ��ȡ����λ�������뱾������������ת��Ϊ���ģ�Ȼ�������溯������ϡ��ڡ����򡯵�
	 * @param qian Ҫ�������λ��
	 * @return ����λ������Ϊ��ǧ���ټ�ʮ������1234����Ϊһǧ������ʮ��
	 */
	public static void changeGe(int qian){
		StringBuffer littleBuffer = new StringBuffer();//ÿ��λ���һ�����ִ����뵽�ⲿstringbuffer��
			
			for (int i = 0; i < 4; i++) {
				int ibit = qian%10;//ȡ�����λ���н���
				qian = qian/10;//����λ������һλ���������λɾ��
				
				if(ibit!=0){//����λ��Ϊ�㣬��һһӳ�����
				littleBuffer.append(chineseName(i));
				littleBuffer.append(chineseBit(ibit));
				//����λΪ�㣬��Ҫ����λ��ǰһλ�Ƿ�ҲΪ�㣬��Ϊ���򱾷�ʡ�ԣ���Ϊ�����������ֻ��һ���㣬��1001���˴���Ҫע���ָֹ��Խ��
					}else if(littleBuffer.length()>0&&littleBuffer.charAt(littleBuffer.length()-1)=='��'){
						
					}else{
						littleBuffer.append("��");
					}
				}
			if(littleBuffer.charAt(0)=='��'){//��2505520����ֶ�����ʮ�� �� ��ٶ�ʮ �� ��������˴���if�ǽ�ĩβ������ȥ���Ӻ���ǰ������
				System.out.println("��λ��ĩβΪ0");
				littleBuffer.deleteCharAt(0);
			}
			stringBuffer.append(littleBuffer.reverse());//��Ϊ�Ǵ����λ���н���������Ҫ��ת
			
			}
	
	/**
	 * ʮ��20֮�����ת�����򲻴�һ������һʮ��Ӧд��ʮ�������Ե�����һ������������İ�������
	 * @param num
	 * @return
	 */
	public static void littleThan20(int num) {
		int i = num%10;
		stringBuffer.append("ʮ");
		stringBuffer.append(chineseBit(i));
	}
		
			
		
		
	
	/**
	 * 
	 * @param i �����ĳλ��
	 * @return ����������ĺ���
	 */
	public static String chineseBit(int i){
		String ibit = "��";
		
		switch (i) {
		case 0:
			ibit = "��";
			break;
		case 1:
			ibit = "һ";
			break;
		case 2:
			ibit = "��";
			break;
		case 3:
			ibit = "��";
			break;
		case 4:
			ibit = "��";
			break;
		case 5:
			ibit = "��";
			break;
		case 6:
			ibit = "��";
			break;
		case 7:
			ibit = "��";
			break;
		case 8:
			ibit = "��";
			break;
		case 9:
			ibit = "��";
			break;

		default:
			break;
		}
		return ibit;
	}
	
	/**
	 * �õ�����λ�ĺ��ֱ�ʾ
	 * @param tens ����������Ǳ�ʾ���ǵڼ�λ
	 * @return ���ؽ��ƺ���
	 */
	public static String chineseName(int tens){
		String name = null;
		switch (tens) {
		case 0:
			name = "";
			break;
		case 1:
			name = "ʮ";
			break;
		case 2:
			name = "��";
			break;
		case 3:
			name = "ǧ";
			break;
		
		
		default:
			break;
		}
		return name;
	}
	
	public static String transDouble(double myDouble){
		String dbString = Double.toString(myDouble);
		String xiaoShu = dbString.replaceAll(".*\\u002E", "");
		String zhengShu = dbString.replaceAll("\\u002E.*","" );
		System.out.println("����"+zhengShu);
		System.out.println("С��"+xiaoShu);
		String intPartion = transInt(Long.parseLong(zhengShu));
		String disPartion = "";
		for (int i = 0; i < xiaoShu.length(); i++) {
			disPartion+=chineseBit(xiaoShu.charAt(i)-48);
		}
		return intPartion+"��"+disPartion;
	}
}
