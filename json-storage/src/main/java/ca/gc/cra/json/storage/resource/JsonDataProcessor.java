package ca.gc.cra.json.storage.resource;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.eclipse.microprofile.reactive.messaging.Incoming;

import ca.gc.cra.json.storage.service.JsonService;

@ApplicationScoped
public class JsonDataProcessor {

	@Inject
	JsonService service;
	
	@Incoming("json-data")
	public void processJson(String data) {
		System.out.println("*** processJson(" + data + ") ***");
        service.saveJsonRecord(data);
	}
}
