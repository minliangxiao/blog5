package club.huangliang.utils;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mchange.v2.c3p0.ComboPooledDataSource;
/*
 * 考虑空指针异常的情况	
 */


public class DBTools {

	private static ComboPooledDataSource dataSource = new ComboPooledDataSource("mysql");
	
	public static Connection getConnection() {
		Connection connection = null;
		
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return connection;
	}
	
	public static int update(String sql, Object...obj) throws SQLException {
		
		int n = 0;
		
		Connection con = getConnection();
		
		PreparedStatement pstmt =null;
		
		try {
			pstmt = con.prepareStatement(sql);
			
			if(obj != null) {
				for (int i = 0; i < obj.length; i++) {
					pstmt.setObject(i + 1, obj[i]);
				}
			}
			
			n = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null) pstmt.close();
			if(con != null) con.close();
		}
		
		return n;
	}
	
	public static <T> List<T> query(String sql, Class<T> clazz, Object...obj) throws SQLException{
		List<T> list = new ArrayList<T>();
		
		Connection con = getConnection();
		
		PreparedStatement pstmt = null;
		
		ResultSet rs = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			
			if(obj != null) {
				for (int i = 0; i < obj.length; i++) {
					pstmt.setObject(i + 1, obj[i]);
				}
			}
			
			rs = pstmt.executeQuery();
			
			ResultSetMetaData metaData = rs.getMetaData();
			
			String columnName;
			Object columnValue;
			if(rs==null) {
				return list;
			}
			while (rs.next()) {
				T t = clazz.newInstance();
				
				for (int i = 1; i < metaData.getColumnCount() + 1; i++) {
					columnName = metaData.getColumnName(i);
					columnValue = rs.getObject(columnName);
					
					Field f = clazz.getDeclaredField(columnName);
					
					f.setAccessible(true);
					
					f.set(t, columnValue);
				}
				list.add(t);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(con != null) con.close();
		}
		
		
		return list;
	}	
	

	
	
	
	
	
	
	
	
	
}
