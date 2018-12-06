//package com.br.stefanini.pedidos.controllers;
/*
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.event.ItemSelectEvent;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.BarChartSeries;
import org.primefaces.model.chart.BubbleChartModel;
import org.primefaces.model.chart.BubbleChartSeries;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.DateAxis;
import org.primefaces.model.chart.DonutChartModel;
import org.primefaces.model.chart.HorizontalBarChartModel;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
import org.primefaces.model.chart.LinearAxis;
import org.primefaces.model.chart.MeterGaugeChartModel;
import org.primefaces.model.chart.OhlcChartModel;
import org.primefaces.model.chart.OhlcChartSeries;
import org.primefaces.model.chart.PieChartModel;

import com.br.aernnova.services.TarefaService;
/*
@ManagedBean
public class LineCharTarefasCreadasFechadas implements Serializable {

	private static final long serialVersionUID = 1L;

	private TarefaService tarefaService;

	private LineChartModel lineModel2;

	public LineCharTarefasCreadasFechadas() {
		this.tarefaService = new TarefaService();
	}

	@PostConstruct
	public void init() {
		createLineModels();
	}

	public LineChartModel getLineModel2() {
		return lineModel2;
	}

	private void createLineModels() {

		Integer min = 0;

		lineModel2 = initCategoryModel();
		lineModel2.setTitle("Tarefas Creadas/Fechdas Ultimos 6 Meses");
		lineModel2.setLegendPosition("e");
		lineModel2.setShowPointLabels(true);
		lineModel2.getAxes().put(AxisType.X, new CategoryAxis("Meses"));
		Axis yAxis = lineModel2.getAxis(AxisType.Y);
		yAxis.setLabel("Quantidade");
		yAxis.setMin(0);

		yAxis.setMin(min);
		yAxis.setTickFormat("%.0f");

	}

	private LineChartModel initCategoryModel() {

		LineChartModel model = new LineChartModel();

		ChartSeries creadas = new ChartSeries();
		creadas.setLabel("Creadas");
		Map<Object, Object> listaCreadas = this.tarefaService
				.getTarefasCreadasUltimosMeses();

		listaCreadas.forEach((k, v) -> {
			String key = ((String) k).substring(2);
			Integer valor = (Integer) v;
			creadas.set(key, valor);
		});

		ChartSeries fechadas = new ChartSeries();
		fechadas.setLabel("Fechadas");
		Map<Object, Object> listaFechadas = this.tarefaService
				.getTarefasFechadasUltimosMeses();

		listaFechadas.forEach((k, v) -> {
			String key = ((String) k).substring(2);
			Integer valor = (Integer) v;
			fechadas.set(key, valor);
		});

		model.addSeries(creadas);
		model.addSeries(fechadas);

		return model;
	}

}*/