package com.cugb.javaee.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.apache.commons.logging.LogFactory;
//import org.apache.log4j.Logger;

import com.cugb.javaee.bean.Product;
import com.cugb.javaee.biz.ProductService;
import com.cugb.javaee.utils.DaoFactory;
import com.cugb.javaee.utils.PageModel;
/**
 * Servlet implementation class PageListControl
 */
@WebServlet("/PageListControl")
public class PageListControl extends HttpServlet {
	//private Logger logger = Logger.getLogger(getClass());
	private static int pageSize = 6;// 默认值，提供函数读取配置文件进行修改
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PageListControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String actiontype = request.getParameter("actiontype");
		switch (actiontype) {
		case "pagelist":
			// 分页ʾ
			pageListView(request, response);
			break;

					}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private void pageListView(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//当前页
		int currentPageNum = Integer.parseInt(request.getParameter("currentPageNum"));
		String target =request.getParameter("target");
		String property=request.getParameter("property");
		pageSize=loadPageSize(property);
		// 调用业务逻辑层的接口得到控制model
		ProductService serv = new ProductService();
		PageModel<Product> pagemodel = serv.showPagelist(currentPageNum, pageSize);
		// 将ProductList、pageModel、currentPageNum传给掉用分页界面
		
		request.setAttribute("ProductList", pagemodel.getList());
		request.setAttribute("pageModel", pagemodel);
		RequestDispatcher rd = request
				.getRequestDispatcher(target+"?currentPageNum=" + currentPageNum + "&totalPages=" + pagemodel.getTotalPages());
		rd.forward(request, response);

	}
	public static int loadPageSize(String name) {
		Properties pro=new Properties();
		InputStream in = DaoFactory.class.getClassLoader().getResourceAsStream("daoconfig.properties");
		try {
			pro.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pageSize=Integer.parseInt(pro.getProperty(name));
		return pageSize;
	}

}
