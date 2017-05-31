package com.cugb.javaee.utils;

import java.util.List;

public class PageModel <T>{
	//��¼���м�¼
	private int totalRecords;
	//ÿҳ��¼��
	private int pageSize;
	//��ǰҳ��
	private int currentPage;
	//�����
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
	 * ��һҳ
	 * @return
	 */
	public int getTopPageNO(){
		return 1;
	}
	
	/**
	 * ��һҳ
	 * @return
	 */
	public int getPrevPageNO(){
		if(currentPage <= 1){
			return 1;
		}
		return currentPage-1;
	}
	
	/**
	 * ��һҳ
	 * @return
	 */
	public int getNextPageNO(){
		if(currentPage >= getTotalPages()){
			return getTotalPages();
		}
		return currentPage+1;
	}
	
	/**
	 * ���һҳ
	 * @return
	 */
	public int getBottomPageNO(){
		return getTotalPages();
	}
	
	
}
