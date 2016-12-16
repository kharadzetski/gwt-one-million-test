package com.example.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.Widget;

public class Main extends Composite implements EntryPoint {

	private static MainUiBinder uiBinder = GWT.create(MainUiBinder.class);
	@UiField
	Button btnGenerate;
	@UiField
	TabPanel tabPanel;
	@UiField
	LayoutPanel dataPanel;

	private MainServiceAsync mainService = GWT.create(MainService.class);

	interface MainUiBinder extends UiBinder<Widget, Main> {
	}

	private long startTime;

	public Main() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void onModuleLoad() {
		btnGenerate.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				btnGenerate.setText("Generating...");
				startTime = System.currentTimeMillis();
				generate1M();
			}
		});
		dataPanel.add(new Label("Table view here"));
		RootPanel.get("container").add(tabPanel);
	}

	private void generate1M() {
		mainService.generateRandomPersons(1000000, new AsyncCallback<Void>() {

			@Override
			public void onSuccess(Void result) {
				btnGenerate.setText("Success! " + (System.currentTimeMillis() - startTime) + "ms");
			}

			@Override
			public void onFailure(Throwable caught) {
				System.out.println("Fail!");
			}
		});
	}

}
