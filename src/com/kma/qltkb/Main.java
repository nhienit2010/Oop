package com.kma.qltkb;

import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;  
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	
	public static void main(String[] args) throws IOException {
		// Chạy ứng dụng với trang Login
		Login login = new Login();
		login.setVisible(true);
	}

}
