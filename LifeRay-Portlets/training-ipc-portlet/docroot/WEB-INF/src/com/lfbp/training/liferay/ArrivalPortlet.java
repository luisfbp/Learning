package com.lfbp.training.liferay;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.io.IOException;

import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import javax.portlet.Event;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.ProcessEvent;

/**
 * Portlet implementation class ArrivalPortlet
 */
public class ArrivalPortlet extends GenericPortlet {

	
    @ProcessEvent(qname = "{http://grupodot.com/events}ipc-text")
    public void myEvent(EventRequest request, EventResponse response) {
        Event event = request.getEvent();
        //Get data from the event
        String sampleText = (String) event.getValue();
        //Set the text in response to display in UI
        response.setRenderParameter("sampleText", sampleText);
    }
	
	
    public void init() {
        viewTemplate = getInitParameter("view-template");
    }

    public void doView(
            RenderRequest renderRequest, RenderResponse renderResponse)
        throws IOException, PortletException {

        include(viewTemplate, renderRequest, renderResponse);
    }

    protected void include(
            String path, RenderRequest renderRequest,
            RenderResponse renderResponse)
        throws IOException, PortletException {

        PortletRequestDispatcher portletRequestDispatcher =
            getPortletContext().getRequestDispatcher(path);

        if (portletRequestDispatcher == null) {
            _log.error(path + " is not a valid include");
        }
        else {
            portletRequestDispatcher.include(renderRequest, renderResponse);
        }
    }
 
    protected String viewTemplate;

    private static Log _log = LogFactoryUtil.getLog(ArrivalPortlet.class);

}
