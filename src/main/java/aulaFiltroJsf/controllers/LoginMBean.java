package aulaFiltroJsf.controllers;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class LoginMBean {
	
	private String usuario = "";
	private String senha = "";
	
	public String login(){
		if(usuario.equals("adm")){
			return "admin/index.xhtml?faces-redirect=true";
		}else if(usuario.equals("aluno")){
			return "aluno/index.xhtml?faces-redirect=true";
		}else{
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage("Usuario e/ou senha incorretos"));
			return null;
		}
	}
	
	public void isLogged() {
		String mensagem = (String) FacesContext.getCurrentInstance().
				getExternalContext().getSessionMap().remove("mensagem");
		//se houver mensagem, mostra
		if(mensagem != null) {
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(mensagem));
		}
	}
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
}
