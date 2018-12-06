//package com.br.stefanini.pedidos.autorizador;
/*
package com.br.aernnova.filter;

import java.io.IOException;

import javax.faces.context.FacesContext;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.br.aernnova.controller.LoginBean;
import com.br.aernnova.model.Pessoa;
import com.br.aernnova.model.enums.Rol;

@WebFilter("*.xhtml")
public class AutorizacaoFilter implements Filter {
	
	private Rol rol;
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletResponse response = (HttpServletResponse) res;
		HttpServletRequest request = (HttpServletRequest) req;	
		boolean auth = request.getSession().getAttribute("user") != null;	
		this.rol = (auth)?(Rol) request.getSession().getAttribute("rol"):null;			
		if (!auth
				&& !request.getRequestURI().endsWith("/Login.xhtml")
				&& !request.getRequestURI().contains("/javax.faces.resource/")) {	
			request.getSession().invalidate();
			response.sendRedirect(request.getContextPath() + "/Login.xhtml?faces-redirect=true");	
			//response.sendRedirect(request.getContextPath() + "/Login.xhtml");
		}
		else if(request.getRequestURI().endsWith("/pessoas.xhtml")){
			if(this.rol.equals(Rol.ADMIN)){				
				chain.doFilter(req, res);
			}
			else{
				response.sendRedirect(request.getContextPath() + "/index.xhtml");
			}
			
		}
		else if(request.getRequestURI().contains("relatorios")){
			if(this.rol.equals(Rol.RESPONSAVEL)){				
				chain.doFilter(req, res);
			}
			else{
				response.sendRedirect(request.getContextPath() + "/index.xhtml");
			}
			
		}
		else if(request.getRequestURI().contains("gestion")){
			if(this.rol.equals(Rol.ADMIN)){				
				chain.doFilter(req, res);
			}
			else{
				response.sendRedirect(request.getContextPath() + "/index.xhtml");
			}
			
		}		
		else if(request.getRequestURI().contains("minhasTarefas")){
			if(this.rol.equals(Rol.RESPONSAVEL) || this.rol.equals(Rol.EJECUTOR)){				
				chain.doFilter(req, res);
			}
			else if(this.rol.equals(Rol.CREADOR) &&  request.getRequestURI().contains("minhastCreadas")){
				chain.doFilter(req, res);
				}			
			
			else{
				response.sendRedirect(request.getContextPath() + "/index.xhtml");
			}
			
		}
		else{			
			chain.doFilter(req, res);
		}

	}

	
	@Override
	public void init(FilterConfig config) throws ServletException {		
		
	}

	@Override
	public void destroy() {
		
	}

}
*/
