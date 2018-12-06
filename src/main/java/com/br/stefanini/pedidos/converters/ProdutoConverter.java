package com.br.stefanini.pedidos.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.br.stefanini.pedidos.model.Produto;
import com.br.stefanini.pedidos.repository.ProdutoRepository;

@FacesConverter(forClass = Produto.class)
public class ProdutoConverter implements Converter {
	
	private ProdutoRepository repository;
	
	public ProdutoConverter() {
		try {
			this.repository = new ProdutoRepository();
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
		Produto produto = null;		
		try {			
			if (value != null && !"".equals(value)) {
				try {
					produto = this.repository.findById(new Integer(value));					
				} catch (Exception e) {					
					throw new RuntimeException("error ao convertir" + value.toString());
				}

			}
		} catch (Exception e) {
			throw new RuntimeException("error ao convertir Produto");
		}
		return produto;
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
		try {
			if (value != null) {
				Produto produto = (Produto) value;
				if (produto.getId() == null) {
					return null;
				} else {
					return ((Produto) value).getId().toString();
				}
			}
			return null;
		} catch (Exception e) {
			throw new RuntimeException("error ao convertir Produto");
		}
			
	}

}
