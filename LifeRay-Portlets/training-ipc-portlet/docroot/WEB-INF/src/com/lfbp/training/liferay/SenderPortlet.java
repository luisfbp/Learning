package com.lfbp.training.liferay;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import javax.xml.namespace.QName;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
 
/**
 * Portlet implementation class SenderPortlet
 */
public class SenderPortlet extends GenericPortlet {

	
    @ProcessAction(name="processEvent")
    public void process(ActionRequest request, ActionResponse response) {
         
        /**
         * Get sample text from UI
         */
         
        String sampleText = ParamUtil.getString(request, "sampleText","");
         
        /**
         * Refer portlet.xml
         */
        QName qName = new QName("http://grupodot.com/events", "ipc-text");
        response.setEvent(qName, sampleText);
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

    private static Log _log = LogFactoryUtil.getLog(SenderPortlet.class);

}
