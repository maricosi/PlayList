package pt.uc.dei.aor.paj;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/index.xhtml")
public class FiltroWeb  implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("filter is working");
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest) request;
		if(req.getSession().getAttribute("loggedin")==null){
			req.getRequestDispatcher("login.xhtml").forward(request, response);
			return;
		}
		
		if (req.getSession().getAttribute("loggedin")!=null){
			boolean a=(boolean) req.getSession().getAttribute("loggedin");
			if(!a){
				req.getRequestDispatcher("index.xhtml").forward(request,response);
				return;
			}
		}
		chain.doFilter(request, response);
		}
	

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}