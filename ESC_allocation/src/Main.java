
public class Main {
	public static void main(String[] args) {

		
		String[] args1={"D:\\competition\\Huawei_software_challenge\\data\\data_2016_1.txt",
			       "D:\\competition\\Huawei_software_challenge\\data\\input.txt",
			       "D:\\competition\\Huawei_software_challenge\\data\\Output.txt"};
		if (args1.length != 3) {
			System.err
					.println("please input args: ecsDataPath, inputFilePath, resultFilePath");
			return;
		}
        
	
		String ecsDataPath = args1[0];
		String inputFilePath = args1[1];
		String resultFilePath = args1[2];

		LogUtil.printLog("Begin");

		// 读取输入文件
		String[] ecsContent = FileUtil.read(ecsDataPath, null);
		String[] inputContent = FileUtil.read(inputFilePath, null);

		// 功能实现入口
		String[] resultContents = Predict.predictVm(ecsContent, inputContent);
		// 写入输出文件
		if (hasResults(resultContents)) {
			FileUtil.write(resultFilePath, resultContents, false);
		} else {
			FileUtil.write(resultFilePath, new String[] { "NA" }, false);
		}
		LogUtil.printLog("End");
	}

	private static boolean hasResults(String[] resultContents) {
		if (resultContents == null) {
			return false;
		}
		for (String contents : resultContents) {
			if (contents != null && !contents.trim().isEmpty()) {
				return true;
			}
		}
		return false;
	}

}