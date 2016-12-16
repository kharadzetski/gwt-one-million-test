package com.example.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface MainServiceAsync {

	void generateRandomPersons(long quantity, AsyncCallback<Void> callback);

}
