package com.cugb.javaee.action;

import java.io.IOException;

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
import com.cugb.javaee.utils.PageModel;
/**
 * Servlet implementation class PageListControl
 */
@WebServlet("/PageListControl")
public class PageListControl extends HttpServlet {
	//private Logger logger = Logger.getLogger(getClass());
	private int pageSize = 6;// 放到配置文件
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
		case "login":
			// 登录
			//loginCheck(request, response);
			break;
		case "pagelist":
			// 分页显示
			pageListView(request, response);
			break;
		case "detail":
			// 显示某一个菜品的详细信息
		case "cart":
			// 添加到购物车
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
		// 获取当前页号
		System.out.println(request.getParameter("currentPageNum"));
	
		int currentPageNum = Integer.parseInt(request.getParameter("currentPageNum"));
		// 生成pageModel对象
		ProductService serv = new ProductService();
		PageModel<Product> pagemodel = serv.showPagelist(currentPageNum, pageSize);
		// 跳转到show页面
		
		request.setAttribute("ProductList", pagemodel.getList());
		request.setAttribute("pageModel", pagemodel);
		RequestDispatcher rd = request
				.getRequestDispatcher("Menu.jsp?currentPageNum=" + currentPageNum + "&totalPages=" + pagemodel.getTotalPages());
		rd.forward(request, response);

	}

}
