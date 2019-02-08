package com.kjy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Timestamp;

public class TestDataInsertModule {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = null;                                      
		PreparedStatement pstmt = null;
		String url = "jdbc:cubrid:localhost:30000:html:::?charset=utf-8";        
		String id = "converter";                                                   
		String pw = "infra1122!";                                                
		Class.forName("cubrid.jdbc.driver.CUBRIDDriver");                   
		conn=DriverManager.getConnection(url,id,pw);             

		String sql = "INSERT INTO `CONVERT` (FILENAME, ORIGINALNAME, FILEPATH, RESULTPATH, TYPE, STATUS, EXTENSION, AUTHOR, MEMO, PASSWORD, CREATE_DATE, START_DATE, COMPLETE_DATE) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?);";    
		pstmt = conn.prepareStatement(sql);
		int dataCount = 4000000;
		String[] types={"PNG","HTOD","DTOH","RSLT","PDF","HTML","HTOP","SAVE","AP"};
		for(int i=0; i< dataCount; i++){
			String fileName=i+"_test.html";
			String orgPath="/orgpath";
			String rstPath="/resultpath";
			String status="S";
			Timestamp stamp = new Timestamp(System.currentTimeMillis());
			pstmt.setString(1,fileName);
			pstmt.setString(2,fileName);
			pstmt.setString(3,orgPath);
			pstmt.setString(4,rstPath);
			pstmt.setString(5,types[i%9]);
			pstmt.setString(6,status);
			pstmt.setString(7,"html");
			pstmt.setString(8,"author1");
			pstmt.setString(9,"");
			pstmt.setString(10,"password1");
			pstmt.setTimestamp(11, stamp);    
			pstmt.setTimestamp(12, stamp);    
			pstmt.setTimestamp(13, stamp);    
			int result = pstmt.executeUpdate();
			System.out.println("i:"+i+" result:"+result);
		}
		if(pstmt != null) 
			pstmt.close();
		if(conn != null) 
			conn.close();
	}
}
