

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
       
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String password1=request.getParameter("password1");
		
		 
	
       
        
		if(username.equals("")||password.equals("")||password1.equals(""))
		{
			response.getWriter().append("<html><body><h3>Empty fields!</h3> <br> <button onClick='location.href=\"index.html\"'>Back</button></body></html>  ");
		}
	
		
		else if(password.equals(password1))
			{
			response.getWriter().append("<html><body><h3>Logged in!</h3></body></html>  ");
			}
		else {
			response.getWriter().append("<html><body><h3>Passwords do not match!</h3> <br> <button onClick='location.href=\"index.html\"'>Back</button></body></html>  ");
		}
		
	
	}
}


