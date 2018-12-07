package com.br.stefanini.pedidos.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.br.stefanini.pedidos.model.Usuario;
import com.br.stefanini.pedidos.repository.UsuarioRepository;

@FacesConverter(forClass = Usuario.class)
public class UsuarioConverter implements Converter {
	
	private UsuarioRepository repository;
	
	public UsuarioConverter() {
		try {
			this.repository = new UsuarioRepository();
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
		Usuario usuario = null;		
		try {			
			if (value != null && !"".equals(value)) {
				try {
					usuario = this.repository.findById(new Long(value));					
				} catch (Exception e) {					
					throw new RuntimeException("error ao convertir" + value.toString());
				}

			}
		} catch (Exception e) {
			throw new RuntimeException("error ao convertir Usuario");
		}
		return usuario;
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
		try {
			if (value != null) {
				Usuario usuario = (Usuario) value;
				if (usuario.getId() == null) {
					return null;
				} else {
					return ((Usuario) value).getId().toString();
				}
			}
			return null;
		} catch (Exception e) {
			throw new RuntimeException("error ao convertir Usuario");
		}
			
	}

}
