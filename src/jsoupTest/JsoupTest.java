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
	 * �����ַ���
	 */
	public JsoupTest(String html) {
		doc = Jsoup.parse(html) ;
	}
	
	
	/**
	 * ����html�ļ�
	 * */
	public JsoupTest(File file) {
		try{
			doc = Jsoup.parse(file, "GBK") ;
		} catch (Exception e) {
			e.printStackTrace() ;
		}
	}
	
	
	/**
	 * ����url
	 * */
	public JsoupTest(String url , String path) {
		try{
			doc = Jsoup.connect(url).get() ;
		} catch (Exception e) {
			e.printStackTrace() ;
		}
	}
	
	
	/**
	 * ͨ��id�ж�Ԫ���Ƿ����
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
	 * ���html����
	 * */
	public String getSource() {
		return doc.toString() ;
	}
	
	
	public Document getDoc() {
		return doc ;
	}
	
	
}
