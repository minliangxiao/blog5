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



public class DBtoos {
	//定义链接常量
	private static String driverclass="com.mysql.jdbc.Driver";
	private static String url="jdbc:mysql://localhost:3306/hl?useUnicode=true&charcaterEncodeing=utf-8";
	private static String username="root";
	private static String passw="178290";
	
	//1.写链接方�?>>链接数据�?
	public static Connection getcon() {
		Connection con=null;
		try {
			//加载链接驱动
			Class.forName(driverclass);
			//�?始链接并获取链接
			con=DriverManager.getConnection(url, username, passw);
			
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	//2.写更新方�?>>对数据库进行更新操作-------知识�?  1.传入参数Object...obj表示Object参数可有可无
	public static int updata(String sql,Object...obj) throws SQLException {
		//定义返回变量
		int renumber=0;
		//获取链接对象，以方便下面的操�?
		Connection con=getcon();
		//创建操作对象
		
		PreparedStatement ps=null;
		try {
			//传入sql语句方便准备执行数据库操�?
			ps=con.prepareStatement(sql);
			
			//判断object对象中的元素的个数以了解sql语句中的?个数再将元素与？进行替换
			if (obj!=null) {
				
			
			for (int i=0;i<obj.length;i++) {
				//将占位符？与obj中的元素进行替换，注意？是从1�?始算�?
				ps.setObject(i+1, obj[i]);
			}
			}
			//执行数据库操�?
			renumber =ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}//关闭资源操作
		finally {
			if(ps!=null)ps.close();
				
			if (con!=null)con.close();
			
		}
		
		return renumber;
	}
	
	//(重点) 3.写查询方�? >>>对数据库进行查询操作   
	/*
	 * 1.知识�?--泛型<E> 
	 * 2. 知识�?---集合List  
	 * 3.反射�?�?(这个我现在都不是很懂--难点)  
	 * 4. 类对象的操作(这个我现在也不是很懂--还是难点)
	 */
	public static <E> List<E> query(String sql,Class<E> clazz,Object...obj) throws InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException, SQLException{
		
		//定义返回集合list对象
		List<E> list =new ArrayList<>();
		//获取链接
		Connection con=getcon();
		//定义�?些需要的变量
		PreparedStatement ps= null;
		ResultSet rSet=null;
		
		try {
			//加载sql语句准备执行
			ps=con.prepareStatement(sql);
			//判断obj的个数�?�过个数知道有多少个占位符？  并进行替�?
			if (obj!=null) {
				for (int i = 0; i < obj.length; i++) {
					ps.setObject(i+1, obj[i]);					
				}
			}
			//执行查询
			rSet =ps.executeQuery();
			//将resultset对象转换成resultsetmetadata对象方便遍历的时候获取到它的列元�?
			ResultSetMetaData rsmd = rSet.getMetaData();
			//遍历 resultset对象并且将元素�?��?��?��?�下面的都是知识�?
			while(rSet.next()) {
				//创建�?个反射类对象》�?��?�反射技术方便封�?
				E e =clazz.newInstance();
				//注意表单直接从一�?始计数所以i必须�?1�?始计�?
				for (int i = 1; i <=rsmd.getColumnCount(); i++) {//rsmd.getColumnCount()获取得到列表里面的列�?
					//表头元素
					String columnName =rsmd.getColumnName(i);
					//通过resultset对象获取表头对应的�??
					Object columnValue=rSet.getObject(columnName);
					//根据表头找到反射对象中对应的属�??
					Field f= clazz.getDeclaredField(columnName);
					//打开访问权限，准备访问clazz的属�?
					f.setAccessible(true);
					//给属性赋�?
					f.set(e, columnValue);
					
					
					
				}
				
				//向list中添加e对象
				list.add(e);
			}
			
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		//关闭资源
		finally {
			if(rSet!=null) {
				rSet.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (con != null) {
				con.close();
			}
		}
		return list;
	}
	

	

}
