package jsoupTest;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.io.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupTest {

	Document doc ;
	
	/**
	 * 解析字符串
	 */
	public JsoupTest(String html) {
		doc = Jsoup.parse(html) ;
	}
	
	
	/**
	 * 解析html文件
	 * */
	public JsoupTest(File file) {
		try{
			doc = Jsoup.parse(file, "GBK") ;
		} catch (Exception e) {
			e.printStackTrace() ;
		}
	}
	
	
	/**
	 * 解析url
	 * */
	public JsoupTest(String url , String path) {
		try{
			doc = Jsoup.connect(url).get() ;
		} catch (Exception e) {
			e.printStackTrace() ;
		}
	}
	
	
	/**
	 * 通过id判断元素是否存在
	 * */
	public boolean elementIsExistById(String id) {
		Elements elements = doc.select(id) ;
		Element element = elements.get(0).child(0) ;
		System.out.println(element);
		if(elements.isEmpty()) {
			return false ;
		} else {
			return true ;
		}
	}
	
	
	/**
	 * 输出html代码
	 * */
	public String getSource() {
		return doc.toString() ;
	}
	
	
	public Document getDoc() {
		return doc ;
	}
	
	
}
