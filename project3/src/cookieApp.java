

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import jakarta.servlet.http.Cookie;

/**
 * Servlet implementation class cookieApp
 */
public class cookieApp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cookieApp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = null;
        String email = null;

        // Get cookies
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("username")) {
                    username = cookie.getValue();
                } else if (cookie.getName().equals("email")) {
                    email = cookie.getValue();
                }
            }
        }

        // Prepare response
        response.setContentType("text/html");
        response.getWriter().write("<html><body>");
        if (username != null && email != null) {
            response.getWriter().write("<h1>Saved Information</h1>");
            response.getWriter().write("Username: " + username + "<br>");
            response.getWriter().write("Email: " + email + "<br>");
        } else {
            response.getWriter().write("No information found in cookies.");
        }
        response.getWriter().write("</body></html>");
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("got called");
		String username = request.getParameter("username");
        String email = request.getParameter("email");

        // Validate username and email (optional)

        // Create cookies
        Cookie usernameCookie = new Cookie("username", username);
        usernameCookie.setMaxAge(60 * 60 * 24 * 7); // Set cookie to expire in a week
        Cookie emailCookie = new Cookie("email", email);
        emailCookie.setMaxAge(60 * 60 * 24 * 7); // Set cookie to expire in a week

        // Add cookies to response
        response.addCookie(usernameCookie);
        response.addCookie(emailCookie);

        // Get cookies (optional)
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("username")) {
                    username = cookie.getValue();
                } else if (cookie.getName().equals("email")) {
                    email = cookie.getValue();
                }
            }
        }

        // Prepare response
        response.setContentType("text/html");
        response.getWriter().write("<html><body>");
        response.getWriter().write("<h1>Saved Information</h1>");
        response.getWriter().write("Username: " + username + "<br>");
        response.getWriter().write("Email: " + email + "<br>");
        response.getWriter().write("</body></html>");
    }

}
