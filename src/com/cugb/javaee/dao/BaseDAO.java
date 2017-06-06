package com.cugb.javaee.dao;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cugb.javaee.utils.JDBCUtils;



public class BaseDAO {
	//XXX 可以删除
	public ArrayList findObjs(String sql,Class clazz){
		Connection conn = null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		ArrayList objs = new ArrayList();
		try {
			conn = JDBCUtils.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				Object obj = mappingObj(rs,clazz);
				objs.add(obj);
			}
			JDBCUtils.free(rs, ps, conn);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}		
		return objs;
	}
	public ArrayList findObjs(String sql,Object[] params,Class clazz){
		//XXX 通用的参数加入方法，值得进一步学习
		Connection conn = null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		ArrayList objs = new ArrayList();
		try {
			conn = JDBCUtils.getConnection();
			ps = conn.prepareStatement(sql);
			if(params != null){
				ParameterMetaData pm = ps.getParameterMetaData();
				for(int i=1;i<=pm.getParameterCount();i++){
					ps.setObject(i, params[i-1]);
				}	
			}
			rs = ps.executeQuery();
			while(rs.next()){
				Object obj = mappingObj(rs,clazz);
				objs.add(obj);
			}
			JDBCUtils.free(rs, ps, conn);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}		
		return objs;
	}
	
	private Object mappingObj(ResultSet rs,Class clazz) throws SQLException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		//实例化映射对象
		Object obj = clazz.newInstance();
		//获取映射对象的方法
		Method[] methods = clazz.getMethods();
		//获取结果集中元数据信息
		ResultSetMetaData meta = rs.getMetaData();
		// 按字段数目循环结果集中记录，进行对象映射
		for(int i=1;i<=meta.getColumnCount();i++){
			// 构造当前列的set方法名称
			String colname = meta.getColumnLabel(i);
			String methodname = "set" + colname;
			// 循环查找同名方法，并通过反射调用该方法，设置属性
			for(Method method:methods){
				if(method.getName().equals(methodname)){
					method.invoke(obj, rs.getObject(i));
					break;
				}
			}
			
		}
		return obj;
	}
	
	public Object findObj(String sql,Object[] params,Class clazz){
		Connection conn = null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		Object obj = null;
		try {
			conn = JDBCUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ParameterMetaData pm = ps.getParameterMetaData();
			for(int i=1;i<=pm.getParameterCount();i++){
				ps.setObject(i, params[i-1]);
			}			
			rs = ps.executeQuery();
			while(rs.next()){
				obj = mappingObj(rs,clazz);
			}
			JDBCUtils.free(rs, ps, conn);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}		
		return obj;
	}
	
	public int modifyObj(String strsql,Object[] params){
		Connection conn = null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConnection();
			ps = conn.prepareStatement(strsql);
			ParameterMetaData pm = ps.getParameterMetaData();
			if(params.length > 0){
				for(int i=1;i<=pm.getParameterCount();i++){
					ps.setObject(i, params[i-1]);
				}	
			}
			int i = ps.executeUpdate();
			JDBCUtils.free(rs, ps, conn);
			return i;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
		
	}
	
	public int getTotalRecords(String sqlTable){
		int count = 0;
		try {
			String sql="select count(*) from "+sqlTable;
			Connection conn = JDBCUtils.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				count = rs.getInt(1);
			}
			JDBCUtils.free(rs, ps, conn);
		}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		return count;
	}
}
