package com.bomb.base.page;

import java.io.Serializable;

public class Page implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -955171217827495449L;

	/**
	 * 
	 */

	public static final int DEFAULT_PAGE_SZIE = 4;

	private Integer pageNo;

	private Integer pageSize = DEFAULT_PAGE_SZIE;

	private Integer total;

	private Integer totalPage;

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public void cal(Integer total) {
		this.total = total;
		this.totalPage = total / pageSize + (total % pageSize == 0 ? 0 : 1);
	}

	@Override
	public String toString() {
		return "Page [pageNo=" + pageNo + ", pageSize=" + pageSize + ", total=" + total + ", totalPage=" + totalPage
				+ "]";
	}

	/*public static void main(String[] args) {
		Page page = new Page();
		System.out.println(page.hashCode());
		page.cal(21);
		System.out.println("Input total : 21 ;then page = " + page);
		page.cal(20);
		System.out.println("Input total : 20 ;then page = " + page);
		page.cal(35);
		System.out.println("Input total : 35 ;then page = " + page);
	}*/

}
