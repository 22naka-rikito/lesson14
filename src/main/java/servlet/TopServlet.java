package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.axiz.entity.Product;
import jp.co.axiz.service.ProductService;
import jp.co.axiz.util.ParamUtil;

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
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		String path = "searchResult.jsp";
		
		ProductService productService = new ProductService();
		Product searchProduct = new Product(name,ParamUtil.checkAndParseInt(price));
		List<Product> list = productService.authentication(searchProduct);
		
		if(list.isEmpty()) {
			path = "top.jsp";
			request.setAttribute("str", "対象のデータはありません");
		}else {
			request.setAttribute("list", list);
		}
		
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}
