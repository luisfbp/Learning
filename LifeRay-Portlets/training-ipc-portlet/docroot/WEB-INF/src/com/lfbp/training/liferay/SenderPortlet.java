package com.lfbp.training.liferay;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import javax.xml.namespace.QName;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.ProcessAction;
 
/**
 * Portlet implementation class SenderPortlet
 */
public class SenderPortlet extends MVCPortlet {

	
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

}
