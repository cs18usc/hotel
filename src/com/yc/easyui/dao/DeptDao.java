package com.yc.easyui.dao;

import java.util.List;

import com.yc.easyui.bean.Dept;

public class DeptDao {
	public List<Dept> findByPage(int pageNo, int pageSize) {
		DBHelper db = new DBHelper();
		String sql = "select * from (select a.*, rownum rn from ("
				+ "select * from dept order by deptno) a where rownum<=?) where rn > ?";
		return db.finds(Dept.class, sql, pageNo*pageSize,(pageNo-1)*pageSize);
	}
	public int getTotal() {
		DBHelper db = new DBHelper();
		String sql = "select count(deptno) from dept";
		return db.getTotal(sql);
	}
}
