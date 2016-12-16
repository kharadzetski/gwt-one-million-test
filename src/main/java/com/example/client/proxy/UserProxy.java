package com.example.client.proxy;

import com.example.server.entity.User;
import com.google.web.bindery.requestfactory.shared.ProxyFor;
import com.google.web.bindery.requestfactory.shared.ValueProxy;

@ProxyFor(User.class)
public interface UserProxy extends ValueProxy {
	String getName();
	String getSurname();
	Long getId();
}
