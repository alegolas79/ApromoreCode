package org.apromore.toolbox.service_manager;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 2.2.9
 * Thu Aug 05 08:36:06 EST 2010
 * Generated source version: 2.2.9
 * 
 */
 
@WebService(targetNamespace = "http://www.apromore.org/toolbox/service_manager", name = "ToolboxManagerPortType")
@XmlSeeAlso({org.apromore.toolbox.model_manager.ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface ToolboxManagerPortType {

    @WebResult(name = "SearchForSimilarProcessesOutputMsg", targetNamespace = "http://www.apromore.org/toolbox/model_manager", partName = "payload")
    @WebMethod(operationName = "SearchForSimilarProcesses")
    public org.apromore.toolbox.model_manager.SearchForSimilarProcessesOutputMsgType searchForSimilarProcesses(
        @WebParam(partName = "payload", name = "SearchForSimilarProcessesInputMsg", targetNamespace = "http://www.apromore.org/toolbox/model_manager")
        org.apromore.toolbox.model_manager.SearchForSimilarProcessesInputMsgType payload
    );

    @WebResult(name = "MergeProcessesOutputMsg", targetNamespace = "http://www.apromore.org/toolbox/model_manager", partName = "payload")
    @WebMethod(operationName = "MergeProcesses")
    public org.apromore.toolbox.model_manager.MergeProcessesOutputMsgType mergeProcesses(
        @WebParam(partName = "payload", name = "MergeProcessesInputMsg", targetNamespace = "http://www.apromore.org/toolbox/model_manager")
        org.apromore.toolbox.model_manager.MergeProcessesInputMsgType payload
    );
}
