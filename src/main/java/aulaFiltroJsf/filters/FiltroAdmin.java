package aulaFiltroJsf.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aulaFiltroJsf.controllers.LoginMBean;

@WebFilter("/admin/*")
public class FiltroAdmin implements Filter{
	
	private LoginMBean login;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("Filtro iniciado! ");
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		login = (LoginMBean) ((HttpServletRequest)request)
				.getSession().getAttribute("loginMBean");
		
		if(login == null || login.getUsuario().equals("")) {
			String contextPath = ((HttpServletRequest)request).getContextPath();
			
			((HttpServletRequest)request).getSession().setAttribute("mensagem", "Acesso negado");
			
			((HttpServletResponse)response).sendRedirect(contextPath + "/index.xhtml");
		}else {
			chain.doFilter(request, response);
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	
}
