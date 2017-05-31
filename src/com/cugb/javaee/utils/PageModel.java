package com.cugb.javaee.utils;

import java.util.List;

public class PageModel <T>{
	//记录所有记录
	private int totalRecords;
	//每页记录数
	private int pageSize;
	//当前页号
	private int currentPage;
	//结果集
	private List<T> list;
	public PageModel(int totalRecords, int pageSize, int currentPage, List<T> list) {
		super();
		this.totalRecords = totalRecords;
		this.pageSize = pageSize;
		this.currentPage = currentPage;
		this.list = list;
	}
	
	public int getTotalPages() {
		return totalRecords%pageSize==0?totalRecords/pageSize:totalRecords/pageSize+1;
	}

	public int getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
	

	/**
	 * 第一页
	 * @return
	 */
	public int getTopPageNO(){
		return 1;
	}
	
	/**
	 * 上一页
	 * @return
	 */
	public int getPrevPageNO(){
		if(currentPage <= 1){
			return 1;
		}
		return currentPage-1;
	}
	
	/**
	 * 下一页
	 * @return
	 */
	public int getNextPageNO(){
		if(currentPage >= getTotalPages()){
			return getTotalPages();
		}
		return currentPage+1;
	}
	
	/**
	 * 最后一页
	 * @return
	 */
	public int getBottomPageNO(){
		return getTotalPages();
	}
	
	
}
