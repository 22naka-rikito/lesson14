package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Product;
import service.ProductService;
import util.Utility;

/**
 * Servlet implementation class topServlet
 */
@WebServlet("/search")
public class TopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public TopServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String str = "";
		String path = "top.jsp";
		
		if(!Utility.isNullOrEmpty(id)) {
			ProductService productService = new ProductService();
			Product product = productService.authentication(Integer.parseInt(id));
			if(product != null) {
				path = "searchResult.jsp";
				str = "データを取得しました";
				request.setAttribute("product", product);
			}else {
				str = "対象のデータはありません";
			}
		}else {
			str = "product_idがありません";
		}
		request.setAttribute("str", str);
		request.getRequestDispatcher(path).forward(request, response);
	}

}
