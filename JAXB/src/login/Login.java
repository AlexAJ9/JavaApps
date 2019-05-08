package login;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;

import storage.StorageAccess;
import storage.User;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User u = null;
		if( username != null && password != null && !username.equals("") && !password.equals("")) {
			try {
				u = StorageAccess.FindUser(username, password);
			} catch (JAXBException e) {
				e.printStackTrace();
			}
		} 
		if(u != null) {
			ArrayList<String> als = new ArrayList<>();
			for (int i=0; i<50; i++) {
				als.add("string" + i);
			}

			request.setAttribute("als", als);
			request.setAttribute("user", u);
			request.getRequestDispatcher("/page1.jsp").forward(request, response);
		} else {
			response.getWriter().append("<html><body> Wrong username or password!" +
				"<br><button onclick='location.href=\"Login.html\"'> Go back </button> </body></html>");
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User u = null;
		if( username != null && password != null && !username.equals("") && !password.equals("")) {
			try {
				u = StorageAccess.FindUser(username, password);
			} catch (JAXBException e) {
				e.printStackTrace();
			}
		} 
		if(u != null) {
			ArrayList<String> als = new ArrayList<>();
			for (int i=0; i<50; i++) {
				als.add("string" + i);
			}

			request.setAttribute("als", als);
			request.setAttribute("user", u);
			request.getRequestDispatcher("/page1.jsp").forward(request, response);
		} else {
			response.getWriter().append("<html><body> Wrong username or password!" +
				"<br><button onclick='location.href=\"Login.html\"'> Go back </button> </body></html>");
		}
	}

}
