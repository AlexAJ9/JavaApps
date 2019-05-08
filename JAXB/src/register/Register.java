package register;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;

import storage.StorageAccess;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
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
		String confirm = request.getParameter("confirm");
		if( username != null && password != null && 
				!username.equals("") && !password.equals("") && confirm.equals(password)) {
			try {
				StorageAccess.AddNewUser(username, password);
			} catch (JAXBException e) {
				e.printStackTrace();
			}
			
			//redirect to login
			response.sendRedirect("Login.html");
		} else {
			response.getWriter().append("<html><body>"
					+ "Invalid input "
					+ "Username: "
					+ username +
					"<br><button onclick='location.href="
					+ "\"Register.html\"'> Go back "
					+ "</button> </body></html>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String confirm = request.getParameter("confirm");
		if( username != null && password != null && 
				!username.equals("") && !password.equals("") && confirm.equals(password)) {
			try {
				StorageAccess.AddNewUser(username, password);
			} catch (JAXBException e) {
				e.printStackTrace();
			}
			
			//redirect to login
			response.sendRedirect("Login.html");
		} else {
			response.getWriter().append("<html><body>"
					+ "Invalid input "
					+ "Username: "
					+ username +
					"<br><button onclick='location.href="
					+ "\"Register.html\"'> Go back "
					+ "</button> </body></html>");
		}
	}

}
