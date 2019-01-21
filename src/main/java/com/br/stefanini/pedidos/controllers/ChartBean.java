package com.br.stefanini.pedidos.controllers;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.primefaces.model.chart.PieChartModel;

import com.br.stefanini.pedidos.services.SolicitacaoService;

@ManagedBean
public class ChartBean implements Serializable {

	private static final long serialVersionUID = 1L;	
	
	
	private int totalSinIniciar;
	private int totalEmAndamento;
	private int totalAprovadas;
	private int totalCanceladas;
	private int sumaTotal;
	
	public int getSumaTotal() {
		return sumaTotal;
	}
	
	

	private PieChartModel pieModel;
	
	private SolicitacaoService solicitacaoService;

	@PostConstruct
	public void init() {
		createPieModel();
	};

	public PieChartModel getPieModel() {
		return pieModel;
	}
	
	public ChartBean() {
		//this.pessoaDao = new PessoaDao();
		try {
			this.solicitacaoService = new SolicitacaoService();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void createPieModel() {
		try {
			
			this.totalSinIniciar = Integer.parseInt(this.solicitacaoService.totalSinIniciar());
			this.totalEmAndamento = Integer.parseInt(this.solicitacaoService.totalEmAndamento());
			this.totalAprovadas = Integer.parseInt(this.solicitacaoService.totalAprovadas());
			this.totalCanceladas = Integer.parseInt(this.solicitacaoService.totalCanceladas());
			
			this.sumaTotal = totalSinIniciar + totalEmAndamento + totalAprovadas + totalCanceladas;

			pieModel = new PieChartModel();
			
			pieModel.set("Sem Iniciar", this.totalSinIniciar);
			pieModel.set("Em andamento", this.totalEmAndamento);
			pieModel.set("Aprovadas", this.totalAprovadas);
			pieModel.set("Canceladas", this.totalCanceladas);

			//pieModel.setTitle("Total Solicitaçoes: " + this.sumaTotal);
			pieModel.setLegendPosition("w");
			pieModel.setShadow(true);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}

	}

}
