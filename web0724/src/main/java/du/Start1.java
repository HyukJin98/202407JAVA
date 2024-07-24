package du;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/main.do")
public class Start1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Start1() {
        System.out.println("Start 서블릿 생성스바리");
    }

    
//	@Override
//	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println("service() 호출");
//	}


	@Override
	public void destroy() {
		System.out.println("destroy() 호출");
	}


	@Override
	public void init() throws ServletException {
		System.out.println("init() 호출");
	
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf8");
		PrintWriter out = response.getWriter();
		out.println("<h1>앙기모찌</h1>");
		System.out.println("doGet() 호출");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		System.out.println("doPost() 호출");
	}

}
