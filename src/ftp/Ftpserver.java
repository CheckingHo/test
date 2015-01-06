package ftp;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;
import java.net.URL;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;


public class Ftpserver {

	private static FTPClient ftp  = null ;
	
	
	
	private final static String PATH = "ftp://192.168.8.101/hshscrenncap/" ;
	
	/**
	 * 
	 * 功能描述：连接ftp服务器
	 * 
	 * @throws Exception 
	 * @author <a href="mailto:hezhuojin@etonetech.com">何卓锦  </a>
	 * @version 1.0.0
	 * @since 1.0.0
	 * create on: 2014年12月9日
	 */
	public static void connectFtpServer() throws Exception{
		ftp = new FTPClient() ;
		FTPClientConfig conf = new FTPClientConfig();
		conf.setServerLanguageCode("zh");
		ftp.configure(conf);
		URL url = new URL(PATH) ;
		try {
			ftp.connect(url.getHost()) ;
			  //文件类型,默认是ASCII  
			 //ftp.setFileType(FTPClient.BINARY_FILE_TYPE) ;  
			 int replyCode = ftp.getReplyCode() ;
			 if ((!FTPReply.isPositiveCompletion(replyCode))) {  
	                // 关闭Ftp连接
				 	ftp.disconnect() ;
	                throw new Exception("登录FTP服务器失败,请检查!");  
	            }
			 if(!ftp.login("etone", "etone")) {
				 ftp.disconnect();
			 }
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 
	 * 功能描述：ftp连接配置
	 * 
	 * @return 
	 * @author <a href="mailto:hezhuojin@etonetech.com">何卓锦  </a>
	 * @version 1.0.0
	 * @since 1.0.0
	 * create on: 2014年12月9日
	 */
	private static FTPClientConfig getFtpConfig() {
		String systemKey = FTPClientConfig.SYST_NT;  
        String serverLanguageCode = "zh";  
        FTPClientConfig conf = new FTPClientConfig(systemKey);  
        conf.setServerLanguageCode(serverLanguageCode) ;  
        conf.setDefaultDateFormatStr("yyyy-MM-dd hh:mm:ss");  
        return conf;  
	}
	
	/*
	public static BufferedInputStream downloadFile(String remotePath , String fieName) throws IOException {
		BufferedOutputStream output = null ;
		try {
			if(!ftp.changeWorkingDirectory(remotePath+"/")) {
				new Exception("Ftp服务器当前路径不存在") ;
			}
		input = new BufferedInputStream(ftp.retrieveFileStream(fieName)) ;
		return input ;
	}*/
	
	
	public static void downloadFile(String remotePath , String fileName) {
		BufferedOutputStream output = null ;
		try {
			if(!ftp.changeWorkingDirectory(remotePath+"/")) {
				new Exception("Ftp服务器当前路径不存在") ;
			}
			// 列出当前工作路径下的文件列表  
            FTPFile[] fileList = ftp.listFiles() ;
            if (fileList == null || fileList.length == 0) {  
                System.out.println("服务器当前路径下不存在文件！");  
            }  
            for (FTPFile ftpfile : fileList) {  
                if (ftpfile.getName().equals(fileName)) {  
                	File localFilePath = new File("e://" + File.separator  + ftpfile.getName());  
                	output = new BufferedOutputStream(new FileOutputStream(localFilePath));  
                  	ftp.retrieveFile(ftpfile.getName(), output);  
                }  
            }  
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static BufferedInputStream getInput(String remotePath) throws Exception{
		File file = new File(remotePath) ;
		String path = file.getParent() ;
		String filename = file.getName() ;
		BufferedInputStream input = null ;
		if(!ftp.changeWorkingDirectory(path)) {
			throw new Exception("Ftp服务器当前路径不存在") ;
		}
		
		// 列出当前工作路径下的文件列表  
        FTPFile[] fileList = ftp.listFiles() ;
        if (fileList == null || fileList.length == 0) {  
            throw new Exception("服务器当前路径下不存在文件") ;
        }  
		for(FTPFile ftpfile : fileList) {
			if(ftpfile.getName().equals(filename)) {
				input = new BufferedInputStream(ftp.retrieveFileStream(filename)) ;
			}
		}
        
        if(input == null) {
        	throw new Exception("服务器不存在文件") ;
        }
		return input ;
	}
	
	
	public static void upload(String file) {
		try {
			InputStream in = new FileInputStream(file) ;
			try {
				ftp.changeWorkingDirectory("/hshscrenncap") ;
				ftp.storeFile(new File(file).getName(), in) ;
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	public static void main(String[] args) {
		//for(int i = 0 ; i < 50 ; i ++) {
			try {
				connectFtpServer();
//				System.out.println("beginTime:" + System.currentTimeMillis());
//				InputStream input = getInput("hshscrenncap/2014-12-11/3542730531714481418279011422.jpg") ;
//				System.out.println("endTime:" + System.currentTimeMillis()) ;
//				BufferedImage image = ImageIO.read(input) ;
//				ImageIO.write(image, "png", new File("e:/ha.png")) ;
			} catch (Exception e) {
				e.printStackTrace();
			}
		//}
			upload("e:/needknows.doc");
	}
	
	
}
