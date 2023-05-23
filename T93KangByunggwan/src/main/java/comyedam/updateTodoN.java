package comyedam;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/updateTodoN")
public class updateTodoN extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public updateTodoN() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/json;charset=UTF-8");
		
		int todoN = Integer.parseInt(request.getParameter("todoN"));
		TodoService service = new TodoServiceImpl();
		service.updateTodoN(todoN);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
