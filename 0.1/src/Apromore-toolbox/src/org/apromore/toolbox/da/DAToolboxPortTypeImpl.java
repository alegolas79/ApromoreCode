
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package org.apromore.toolbox.da;

import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 2.2.9
 * Thu Feb 10 17:27:13 CET 2011
 * Generated source version: 2.2.9
 * 
 */

@javax.jws.WebService(
                      serviceName = "DAToolboxService",
                      portName = "DAToolbox",
                      targetNamespace = "http://www.apromore.org/data_access/service_toolbox",
                      wsdlLocation = "http://localhost:8080/Apromore-dataAccess/services/DAToolbox?wsdl",
                      endpointInterface = "org.apromore.toolbox.da.DAToolboxPortType")
                      
public class DAToolboxPortTypeImpl implements DAToolboxPortType {

    private static final Logger LOG = Logger.getLogger(DAToolboxPortTypeImpl.class.getName());

    /* (non-Javadoc)
     * @see org.apromore.toolbox.da.DAToolboxPortType#readCanonicals(org.apromore.toolbox.model_da.ReadCanonicalsInputMsgType  payload )*
     */
    public org.apromore.toolbox.model_da.ReadCanonicalsOutputMsgType readCanonicals(org.apromore.toolbox.model_da.ReadCanonicalsInputMsgType payload) { 
        LOG.info("Executing operation readCanonicals");
        System.out.println(payload);
        try {
            org.apromore.toolbox.model_da.ReadCanonicalsOutputMsgType _return = new org.apromore.toolbox.model_da.ReadCanonicalsOutputMsgType();
            org.apromore.toolbox.model_da.ResultType _returnResult = new org.apromore.toolbox.model_da.ResultType();
            _returnResult.setMessage("Message1512149807");
            _returnResult.setCode(Integer.valueOf(-318868978));
            _return.setResult(_returnResult);
            org.apromore.toolbox.model_da.CanonicalsType _returnCanonicals = new org.apromore.toolbox.model_da.CanonicalsType();
            java.util.List<org.apromore.toolbox.model_da.CanonicalType> _returnCanonicalsCanonical = new java.util.ArrayList<org.apromore.toolbox.model_da.CanonicalType>();
            org.apromore.toolbox.model_da.CanonicalType _returnCanonicalsCanonicalVal1 = new org.apromore.toolbox.model_da.CanonicalType();
            _returnCanonicalsCanonicalVal1.setProcessId(-769921832);
            _returnCanonicalsCanonicalVal1.setVersionName("VersionName-1435159532");
            javax.activation.DataHandler _returnCanonicalsCanonicalVal1Cpf = null;
            _returnCanonicalsCanonicalVal1.setCpf(_returnCanonicalsCanonicalVal1Cpf);
            _returnCanonicalsCanonical.add(_returnCanonicalsCanonicalVal1);
            _returnCanonicals.getCanonical().addAll(_returnCanonicalsCanonical);
            _return.setCanonicals(_returnCanonicals);
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see org.apromore.toolbox.da.DAToolboxPortType#readProcessSummaries(org.apromore.toolbox.model_da.ReadProcessSummariesInputMsgType  payload )*
     */
    public org.apromore.toolbox.model_da.ReadProcessSummariesOutputMsgType readProcessSummaries(org.apromore.toolbox.model_da.ReadProcessSummariesInputMsgType payload) { 
        LOG.info("Executing operation readProcessSummaries");
        System.out.println(payload);
        try {
            org.apromore.toolbox.model_da.ReadProcessSummariesOutputMsgType _return = new org.apromore.toolbox.model_da.ReadProcessSummariesOutputMsgType();
            org.apromore.toolbox.model_da.ResultType _returnResult = new org.apromore.toolbox.model_da.ResultType();
            _returnResult.setMessage("Message-938734146");
            _returnResult.setCode(Integer.valueOf(-647748295));
            _return.setResult(_returnResult);
            org.apromore.toolbox.model_da.ProcessSummariesType _returnProcessSummaries = new org.apromore.toolbox.model_da.ProcessSummariesType();
            java.util.List<org.apromore.toolbox.model_da.ProcessSummaryType> _returnProcessSummariesProcessSummary = new java.util.ArrayList<org.apromore.toolbox.model_da.ProcessSummaryType>();
            org.apromore.toolbox.model_da.ProcessSummaryType _returnProcessSummariesProcessSummaryVal1 = new org.apromore.toolbox.model_da.ProcessSummaryType();
            java.util.List<org.apromore.toolbox.model_da.VersionSummaryType> _returnProcessSummariesProcessSummaryVal1VersionSummaries = new java.util.ArrayList<org.apromore.toolbox.model_da.VersionSummaryType>();
            _returnProcessSummariesProcessSummaryVal1.getVersionSummaries().addAll(_returnProcessSummariesProcessSummaryVal1VersionSummaries);
            _returnProcessSummariesProcessSummaryVal1.setOriginalNativeType("OriginalNativeType531074235");
            _returnProcessSummariesProcessSummaryVal1.setName("Name1791492185");
            _returnProcessSummariesProcessSummaryVal1.setId(Integer.valueOf(-1728906504));
            _returnProcessSummariesProcessSummaryVal1.setDomain("Domain520847346");
            _returnProcessSummariesProcessSummaryVal1.setRanking("Ranking-317053870");
            _returnProcessSummariesProcessSummaryVal1.setLastVersion("LastVersion-2067205943");
            _returnProcessSummariesProcessSummaryVal1.setOwner("Owner-1093500694");
            _returnProcessSummariesProcessSummary.add(_returnProcessSummariesProcessSummaryVal1);
            _returnProcessSummaries.getProcessSummary().addAll(_returnProcessSummariesProcessSummary);
            _return.setProcessSummaries(_returnProcessSummaries);
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see org.apromore.toolbox.da.DAToolboxPortType#storeCpf(org.apromore.toolbox.model_da.StoreCpfInputMsgType  payload )*
     */
    public org.apromore.toolbox.model_da.StoreCpfOutputMsgType storeCpf(org.apromore.toolbox.model_da.StoreCpfInputMsgType payload) { 
        LOG.info("Executing operation storeCpf");
        System.out.println(payload);
        try {
            org.apromore.toolbox.model_da.StoreCpfOutputMsgType _return = new org.apromore.toolbox.model_da.StoreCpfOutputMsgType();
            org.apromore.toolbox.model_da.ResultType _returnResult = new org.apromore.toolbox.model_da.ResultType();
            _returnResult.setMessage("Message-1784287405");
            _returnResult.setCode(Integer.valueOf(641155288));
            _return.setResult(_returnResult);
            org.apromore.toolbox.model_da.ProcessSummaryType _returnProcessSummary = new org.apromore.toolbox.model_da.ProcessSummaryType();
            java.util.List<org.apromore.toolbox.model_da.VersionSummaryType> _returnProcessSummaryVersionSummaries = new java.util.ArrayList<org.apromore.toolbox.model_da.VersionSummaryType>();
            org.apromore.toolbox.model_da.VersionSummaryType _returnProcessSummaryVersionSummariesVal1 = new org.apromore.toolbox.model_da.VersionSummaryType();
            java.util.List<org.apromore.toolbox.model_da.AnnotationsType> _returnProcessSummaryVersionSummariesVal1Annotations = new java.util.ArrayList<org.apromore.toolbox.model_da.AnnotationsType>();
            _returnProcessSummaryVersionSummariesVal1.getAnnotations().addAll(_returnProcessSummaryVersionSummariesVal1Annotations);
            _returnProcessSummaryVersionSummariesVal1.setRanking("Ranking-302630837");
            _returnProcessSummaryVersionSummariesVal1.setName("Name913004130");
            _returnProcessSummaryVersionSummariesVal1.setLastUpdate("LastUpdate1243934485");
            _returnProcessSummaryVersionSummariesVal1.setCreationDate("CreationDate1631678493");
            _returnProcessSummaryVersionSummaries.add(_returnProcessSummaryVersionSummariesVal1);
            _returnProcessSummary.getVersionSummaries().addAll(_returnProcessSummaryVersionSummaries);
            _returnProcessSummary.setOriginalNativeType("OriginalNativeType-2055315242");
            _returnProcessSummary.setName("Name160646117");
            _returnProcessSummary.setId(Integer.valueOf(1204562297));
            _returnProcessSummary.setDomain("Domain-494359400");
            _returnProcessSummary.setRanking("Ranking-2022815760");
            _returnProcessSummary.setLastVersion("LastVersion-329760794");
            _returnProcessSummary.setOwner("Owner594227564");
            _return.setProcessSummary(_returnProcessSummary);
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

}
