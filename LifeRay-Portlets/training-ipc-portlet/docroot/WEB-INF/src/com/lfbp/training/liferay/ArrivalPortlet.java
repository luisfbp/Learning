package com.lfbp.training.liferay;

import com.liferay.util.bridges.mvc.MVCPortlet;

import javax.portlet.Event;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.ProcessEvent;

/**
 * Portlet implementation class ArrivalPortlet
 */
public class ArrivalPortlet extends MVCPortlet {

	
    @ProcessEvent(qname = "{http://grupodot.com/events}ipc-text")
    public void myEvent(EventRequest request, EventResponse response) {
        Event event = request.getEvent();
        //Get data from the event
        String sampleText = (String) event.getValue();
        //Set the text in response to display in UI
        response.setRenderParameter("sampleText", sampleText);
    }
	
}
