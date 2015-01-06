package main;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.openqa.selenium.WebDriver;

import jsoupTest.JsoupTest;

public class Main {

	private static String[][] testType = new String[][]{{"cmweibo","移动微博"},{"sinaweibo","新浪微博"}} ;
	
	public static void main(String[] args) {
		double d = new Double("3") ;
		double d2 = new Double("4") ;
		int i = (int)Math.floor(new Double(d/d2)*100) ;
		System.out.println(i);
	}
	
	public static <T> void fun( List<T> list) {
		
	}
	
	
}
