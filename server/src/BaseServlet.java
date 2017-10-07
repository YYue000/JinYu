
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 */
public class BaseServlet extends HttpServlet {
	private String[] List= {"http://mp.weixin.qq.com/s/HmolWHdnu1D7SINv7Lza3Q",
        "http://mp.weixin.qq.com/s/tSRY7d3f7X4t7k3YVWMXTw",
            "http://mp.weixin.qq.com/s/4FsSUx46LDDael95udoZTQ"};
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet");
		handleRequest(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("dopost");
		handleRequest(req,resp);
		
	}

	private void handleRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException {
				
		req.setCharacterEncoding("UTF-8");  // 设置字符集
		resp.setCharacterEncoding("UTF-8");
		resp.setHeader("Cache-Control", "no-store");
		PrintWriter out = resp.getWriter(); // 准备输出
		out.println("<html>");
		out.println("<head><title>DayShow</title></head>");
		out.println("<body>");
		out.println("<h1>Date</h1>");
		out.println("<p>");
		Calendar calendar = Calendar.getInstance();
		out.println(calendar.get(Calendar.YEAR));
		out.println(calendar.get(Calendar.MONTH));
		out.println(calendar.get(Calendar.DATE));
		out.println("</p>");
		out.println("<h1>List</h1>");
		out.println("<p>");
		for(int i = 0;i < List.length;i ++){
			out.println(List[i]);
		}
		out.println("</p>");
		out.println("</body>");
		out.println("</html>");
		out.close();// 关闭输出
		
	}
}
