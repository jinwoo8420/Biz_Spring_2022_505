package com.callor.ems.exec;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class MakeDBUser {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); // 키보드 입력
		StandardPBEStringEncryptor pbEnc = new StandardPBEStringEncryptor(); // 암호화 도구
		Map<String, String> envList = System.getenv(); // 환경변수

		String saltPass = envList.get("NAVER");
		System.out.println("salt Pass" + saltPass);
		if (saltPass == null) {
			System.out.println("NAVER 환경변수 설정 필요");
			return;
		}

		pbEnc.setAlgorithm("PBEWithMD5AndDES");
		pbEnc.setPassword(saltPass);

		String propsDir = "./src/main/webapp/WEB-INF/spring/props";

		Map<String, String[]> secFiles = new TreeMap<String, String[]>();
		secFiles.put("db.connection.properties", new String[] { "mysql.username", "mysql.password" });

		String mysqlProps = "db.connection.properties";
		String mysqlUser = "mysql.username";

		System.out.println(secFiles.get("db.connection.properties")[0]);
		System.out.println(secFiles.get("db.connection.properties")[1]);

		Set<String> files = secFiles.keySet();

		for (String file : files) {
			File propsFile = new File(propsDir, file);

			try {
				PrintWriter out = new PrintWriter(propsFile);

				System.out.println("=".repeat(100));

				System.out.println(file);
				String[] datas = secFiles.get(file);

				for (String data : datas) {
					System.out.printf("%s >> ", data);
					String value = scan.nextLine();
					out.printf("%s=ENC(%s)\n", data, pbEnc.encrypt(value));
				}

				out.flush();
				out.close();
				System.out.println("File Write OK");

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

		}
	}
}
