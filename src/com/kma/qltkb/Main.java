package com.kma.qltkb;

import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;  
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

public class Main {
	public static Scanner sc = new Scanner(System.in);

	public static void showSubject(String date) throws IOException {
		ParseXLS parse = new ParseXLS();
		System.out.println("> Mon hoc cua ngay thu " + date);
		String data[] = parse.findSubjects(date).replace("[", "").replace("]", "").replaceAll("\n", "").split(",");
		if (data[0].equals("null")) {
			System.out.println("Khong co mon nao");
			return;
		}
		for (int i=0; i<data.length; ++i) {
				String subject = data[i].substring(0, data[i].indexOf('(')).strip();
				String room = data[i].substring(data[i].indexOf('(') + 1, data[i].indexOf(')')).strip();
				System.out.println("Hoc mon " + subject + " tai "  + room);
		}
	}
	public static void main(String[] args) throws IOException {
	   //DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM");  
	   //LocalDateTime now = LocalDateTime.now();  
	   //System.out.println(dtf.format(now));
		
		System.out.print("Nhap ngay: ");
		int day = sc.nextInt();
		System.out.print("Nhap thang: ");
		int month = sc.nextInt();
		
		int count = 7;
		int d = day, m = month;
		
		while (count >= 0) {
			String date = "";
			d += 1;
			if (d > 31) {
				d = 1;
				if (m+1 > 12) m=1; else	m += 1;
			}
			//d += 1;
			if ( (d) < 10) date +="0" + String.valueOf(d); else date += d;
			date += "/";
			if (m < 10) date +="0"+m; else date += m;
			try {
				showSubject(date);
			}catch(StringIndexOutOfBoundsException e) {
				System.out.println("Khong co mon hoc nao!!");
			}
			count-=1;
		}
	}

}
