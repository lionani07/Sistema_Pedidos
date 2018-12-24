package com.br.stefanini.pedidos.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.br.stefanini.pedidos.model.Solicitacao;
import com.br.stefanini.pedidos.repository.SolicitacaoRepository;

@FacesConverter(forClass = Solicitacao.class)
public class SolicitacaoConverter implements Converter {
	
	private SolicitacaoRepository repository;
	
	public SolicitacaoConverter() {
		try {
			this.repository = new SolicitacaoRepository();
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
		Solicitacao solicitacao = null;		
		try {			
			if (value != null && !"".equals(value)) {
				try {
					solicitacao = this.repository.findById(new Integer(value));					
				} catch (Exception e) {					
					throw new RuntimeException("error ao convertir" + value.toString());
				}

			}
		} catch (Exception e) {
			throw new RuntimeException("error ao convertir Solicitacao");
		}
		return solicitacao;
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
		try {
			if (value != null) {
				Solicitacao solicitacao = (Solicitacao) value;
				if (solicitacao.getId() == null) {
					return null;
				} else {
					return ((Solicitacao) value).getId().toString();
				}
			}
			return null;
		} catch (Exception e) {
			throw new RuntimeException("error ao convertir Solicitacao");
		}
			
	}

}
