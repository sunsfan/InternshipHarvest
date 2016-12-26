package cn.sunteng.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/*
 * 
 * 读取文件记录中的内容，文件每行的格式为 学生id，时间，进出寝室（0代表进，1代表出）
 * 计算每个学生总共的进出次数和在寝室的平均时间（小时）
 * 以学生id  进出次数  平均时间的格式打出来
 */
public class Process {
	//map存储数据
	private static Map<Integer, TreeMap<String, String>> map;
	//日期格式
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	//源文件
	private static String[] srcArr = { "D:\\dorm_test\\dorm_test.txt", "D:\\dorm_test\\dorm_train.txt" };

	public static void main(String[] args) throws ParseException {
		for (String srcPath : srcArr) {
			String desPath = srcPath.substring(0, srcPath.length() - 4) + "_result.txt";
			readTxt(srcPath);
			writeTxt(desPath);
		}
	}

	private static void writeTxt(String desPath) throws ParseException {
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(desPath)));
			for (Integer s : map.keySet()) {
				TreeMap<String, String> treeMap = map.get(s);
				//总次数
				int times = treeMap.size();
				//筛选条件
				if (treeMap.firstEntry().getValue().equals("1")) {
					treeMap.remove(treeMap.firstKey());
				}
				if (treeMap.size() != 0 && treeMap.lastEntry().getValue().equals("0")) {
					treeMap.remove(treeMap.lastKey());
				}
				//计算平均时间
				List<String> list = new ArrayList<String>(1000);
				for (String s1 : treeMap.keySet()) {
					list.add(s1);
				}
				int days = 0;
				long during = 0;
				if (list.size() >= 2) {
					for (int i = 0; i < list.size() - 1; i += 2) {
						long temp1 = (sdf.parse(list.get(i + 1)).getTime() - sdf.parse(list.get(i)).getTime()) / 60000;
						if (temp1 >= 0) {
							during += temp1;
						}
					}
					Date dEnd = sdf.parse(list.get(list.size() - 1));
					Date dStart = sdf.parse(list.get(0));
					days = daysBetween(dStart, dEnd) + 1;
					if (days >= 1) {
						//写入目标文件
						bw.write(s + " " + times + " " + during / (60 * days));
						bw.newLine();
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	/*
	 * 两个日期之间的间隔天数
	 * 
	 */
	private static int daysBetween(Date smdate, Date bdate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		smdate = sdf.parse(sdf.format(smdate));
		bdate = sdf.parse(sdf.format(bdate));
		Calendar cal = Calendar.getInstance();
		cal.setTime(smdate);
		long time1 = cal.getTimeInMillis();
		cal.setTime(bdate);
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 3600 * 24);

		return Integer.parseInt(String.valueOf(between_days));
	}

	/*
	 * 把原始数据存入map中
	 * 
	 */
	private static void readTxt(String srcPath) {
		map = new TreeMap<Integer, TreeMap<String, String>>();
		String line = null;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(srcPath)));
			while ((line = br.readLine()) != null) {
				String[] arr = line.trim().split(",");
				int id = Integer.parseInt(arr[0]);
				String time = arr[1].substring(1, arr[1].length() - 1);
				String type = arr[2].substring(1, arr[2].length() - 1);
				if (!map.containsKey(id)) {
					TreeMap<String, String> tm = new TreeMap<String, String>();
					tm.put(time, type);
					map.put(id, tm);
				} else {
					TreeMap<String, String> temp = map.get(id);
					temp.put(time, type);
					map.put(id, temp);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
