
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package org.apromore.manager.service_portal;

import java.io.InputStream;
import java.util.logging.Logger;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.util.ByteArrayDataSource;

import org.apromore.manager.canoniser.RequestToCanoniser;
import org.apromore.manager.da.ExceptionReadNative;
import org.apromore.manager.da.RequestToDA;
import org.apromore.manager.model_portal.DeleteEditSessionInputMsgType;
import org.apromore.manager.model_portal.DeleteEditSessionOutputMsgType;
import org.apromore.manager.model_portal.DomainsType;
import org.apromore.manager.model_portal.ExportNativeInputMsgType;
import org.apromore.manager.model_portal.ExportNativeOutputMsgType;
import org.apromore.manager.model_portal.FormatsType;
import org.apromore.manager.model_portal.ImportProcessInputMsgType;
import org.apromore.manager.model_portal.ImportProcessOutputMsgType;
import org.apromore.manager.model_portal.ProcessSummariesType;
import org.apromore.manager.model_portal.ReadDomainsInputMsgType;
import org.apromore.manager.model_portal.ReadDomainsOutputMsgType;
import org.apromore.manager.model_portal.ReadEditSessionInputMsgType;
import org.apromore.manager.model_portal.ReadEditSessionOutputMsgType;
import org.apromore.manager.model_portal.ReadFormatsInputMsgType;
import org.apromore.manager.model_portal.ReadFormatsOutputMsgType;
import org.apromore.manager.model_portal.ReadProcessSummariesInputMsgType;
import org.apromore.manager.model_portal.ReadProcessSummariesOutputMsgType;
import org.apromore.manager.model_portal.ReadUserInputMsgType;
import org.apromore.manager.model_portal.ReadUserOutputMsgType;
import org.apromore.manager.model_portal.ResultType;
import org.apromore.manager.model_portal.UserType;
import org.apromore.manager.model_portal.WriteEditSessionInputMsgType;
import org.apromore.manager.model_portal.WriteEditSessionOutputMsgType;
import org.apromore.manager.model_portal.WriteUserInputMsgType;
import org.apromore.manager.model_portal.WriteUserOutputMsgType;

/**
 * This class was generated by Apache CXF 2.2.7
 * Mon May 17 17:31:53 EST 2010
 * Generated source version: 2.2.7
 * 
 */

@javax.jws.WebService(
                      serviceName = "ManagerPortalService",
                      portName = "ManagerPortal",
                      targetNamespace = "http://www.apromore.org/manager/service_portal",
                      wsdlLocation = "http://localhost:8080/Apromore-manager/services/ManagerPortal?wsdl",
                      endpointInterface = "org.apromore.manager.service_portal.ManagerPortalPortType")

		public class ManagerPortalPortTypeImpl implements ManagerPortalPortType {

	private static final Logger LOG = Logger.getLogger(ManagerPortalPortTypeImpl.class.getName());


	public WriteEditSessionOutputMsgType writeEditSession(WriteEditSessionInputMsgType payload) { 
        LOG.info("Executing operation writeEditSession");
        System.out.println(payload);
        WriteEditSessionOutputMsgType res = new WriteEditSessionOutputMsgType();
        ResultType result = new ResultType();
        res.setResult(result);
        
        try {
        	
        	
        } catch (Exception ex) {
            ex.printStackTrace();
            result.setCode(-1);
            result.setMessage(ex.getMessage());
        }
        return res;
    }

	public DeleteEditSessionOutputMsgType deleteEditSession(DeleteEditSessionInputMsgType payload) { 
        LOG.info("Executing operation deleteEditSession");
        System.out.println(payload);
        try {
            org.apromore.manager.model_portal.DeleteEditSessionOutputMsgType _return = new org.apromore.manager.model_portal.DeleteEditSessionOutputMsgType();
            org.apromore.manager.model_portal.ResultType _returnResult = new org.apromore.manager.model_portal.ResultType();
            _returnResult.setMessage("Message-1317706248");
            _returnResult.setCode(Integer.valueOf(-289050559));
            _return.setResult(_returnResult);
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

	
	public ReadEditSessionOutputMsgType readEditSession(ReadEditSessionInputMsgType payload) { 
        LOG.info("Executing operation readEditSession");
        System.out.println(payload);
        try {
            org.apromore.manager.model_portal.ReadEditSessionOutputMsgType _return = new org.apromore.manager.model_portal.ReadEditSessionOutputMsgType();
            org.apromore.manager.model_portal.ResultType _returnResult = new org.apromore.manager.model_portal.ResultType();
            _returnResult.setMessage("Message-1930075894");
            _returnResult.setCode(Integer.valueOf(1195216106));
            _return.setResult(_returnResult);
            javax.activation.DataHandler _returnNative = null;
            _return.setNative(_returnNative);
            _return.setUsername("Username669745323");
            _return.setNativeType("NativeType-1814720970");
            _return.setProcessId(Integer.valueOf(169757094));
            _return.setVersionName("VersionName731431451");
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

	public ExportNativeOutputMsgType exportNative(ExportNativeInputMsgType payload) { 
		LOG.info("Executing operation exportNative");
		System.out.println(payload);
		ExportNativeOutputMsgType res = new ExportNativeOutputMsgType();
		ResultType result = new ResultType();
		res.setResult(result);
		int processId = payload.getProcessId();
		String version = payload.getVersionName();
		String nativeType = payload.getNativeType();
		
		try {
			RequestToDA request = new RequestToDA();
			InputStream native_xml = request.ReadNative (processId, version, nativeType);
			
			DataSource source = new ByteArrayDataSource(native_xml, "text/xml"); 
			res.setNative(new DataHandler(source));	
			
			result.setCode(0);
			result.setMessage("");
		} catch (ExceptionReadNative ex) {
			try {
				// native not found, request canonical
				RequestToDA request1 = new RequestToDA();
				InputStream canonical_xml = request1.ReadCanonical (processId, version);

				// request canonical_xml de-canonisation
				RequestToCanoniser requestCa = new RequestToCanoniser();
				InputStream native_xml = requestCa.DeCanonise (processId, version, nativeType, canonical_xml);
				
				DataSource source = new ByteArrayDataSource(native_xml, "text/xml"); 
				res.setNative(new DataHandler(source));	
				
				result.setCode(0);
				result.setMessage("");
			} catch (Exception e) {
				ex.printStackTrace();
				result.setCode(-1);
				result.setMessage("ManagerPortalPortTypeImpl(exportNative): " + ex.getMessage());
			} 
		} catch (Exception e) {	
			e.printStackTrace();
			result.setCode(-1);
			result.setMessage("ManagerPortalPortTypeImpl(exportNative): " + e.getMessage());
		}
		return res;
	}

	public ImportProcessOutputMsgType importProcess(ImportProcessInputMsgType payload) { 
		LOG.info("Executing operation importProcess");
		System.out.println(payload);
		ImportProcessOutputMsgType res = new ImportProcessOutputMsgType();
		ResultType result = new ResultType();
		res.setResult(result);

		try {
			DataHandler handler = payload.getProcessDescription();
			InputStream is = handler.getInputStream();
			RequestToCanoniser request = new RequestToCanoniser();
			request.ImportProcess(payload.getUsername(), payload.getProcessName(), payload.getNativeType(), 
					is,payload.getDomain());

			result.setCode(0);
			result.setMessage("");

		} catch (Exception ex) {
			ex.printStackTrace();
			result.setCode(-1);
			result.setMessage("ManagerPortalPortTypeImpl(importProcess): " + ex.getMessage());
		}
		return res;
	}


	/* (non-Javadoc)
	 * @see org.apromore.manager.service_portal.ManagerPortalPortType#writeUser(org.apromore.manager.model_portal.WriteUserInputMsgType  payload )*
	 */
	public WriteUserOutputMsgType writeUser(WriteUserInputMsgType payload) { 
		LOG.info("Executing operation writeUser");
		System.out.println(payload);

		WriteUserOutputMsgType res = new WriteUserOutputMsgType();
		ResultType result = new ResultType();
		res.setResult(result);
		UserType user = payload.getUser();
		try {
			RequestToDA request = new RequestToDA();
			request.WriteUser(user);
			result.setCode(0);
			result.setMessage("");
		} catch (Exception ex) {
			ex.printStackTrace();
			result.setCode(0);
			result.setMessage("ManagerPortalPortTypeImpl(writeUser): " + ex.getMessage());
		}
		return res;
	}

	/* (non-Javadoc)
	 * @see org.apromore.manager.service_portal.ManagerPortalPortType#readFormats(org.apromore.manager.model_portal.ReadFormatsInputMsgType  payload )*
	 */
	public ReadFormatsOutputMsgType readFormats(ReadFormatsInputMsgType payload) { 
		LOG.info("Executing operation readFormats");
		System.out.println(payload);
		ReadFormatsOutputMsgType res = new ReadFormatsOutputMsgType();
		ResultType result = new ResultType();
		res.setResult(result);
		try {
			RequestToDA request = new RequestToDA();
			FormatsType formats = request.ReadFormats();
			result.setCode(0);
			result.setMessage("");
			res.setFormats(formats);
		} catch (Exception ex) {
			ex.printStackTrace();
			result.setCode(-1);
			result.setMessage("ManagerPortalPortTypeImpl(ReadFormats) " + ex.getMessage());
		}
		return res;
	}

	/* (non-Javadoc)
	 * @see org.apromore.manager.service_portal.ManagerPortalPortType#readDomains(org.apromore.manager.model_portal.ReadDomainsInputMsgType  payload )*
	 */
	public ReadDomainsOutputMsgType readDomains(ReadDomainsInputMsgType payload) { 
		LOG.info("Executing operation readDomains");
		System.out.println(payload);

		ReadDomainsOutputMsgType res = new ReadDomainsOutputMsgType();
		ResultType result = new ResultType();
		res.setResult(result);
		try {
			RequestToDA request = new RequestToDA();
			DomainsType domains = request.ReadDomains();
			result.setCode(0);
			result.setMessage("");
			res.setDomains(domains);
		} catch (Exception ex) {
			ex.printStackTrace();
			result.setCode(-1);
			result.setMessage("ManagerPortalPortTypeImpl(ReadDomains) " + ex.getMessage());   
		}
		return res;
	}

	/* (non-Javadoc)
	 * @see org.apromore.manager.service_portal.ManagerPortalPortType#readUser(org.apromore.manager.model_portal.ReadUserInputMsgType  payload )*
	 */
	public ReadUserOutputMsgType readUser(ReadUserInputMsgType payload) { 
		LOG.info("Executing operation readUser");
		System.out.println(payload);

		ReadUserOutputMsgType res = new ReadUserOutputMsgType();
		ResultType result = new ResultType();
		res.setResult(result);

		try {
			RequestToDA request = new RequestToDA();
			UserType user = request.ReadUser(payload.getUsername());
			result.setCode(0);
			result.setMessage("");
			res.setUser(user);
		} catch (Exception ex) {
			ex.printStackTrace();
			result.setCode(-1);
			result.setMessage("ManagerPortalPortTypeImpl(ReadUser) " + ex.getMessage());
		}
		return res;
	}

	/* (non-Javadoc)
	 * @see org.apromore.manager.service_portal.ManagerPortalPortType#readProcessSummaries(org.apromore.manager.model_portal.ReadProcessSummariesInputMsgType  payload )*
	 */
	public ReadProcessSummariesOutputMsgType readProcessSummaries(ReadProcessSummariesInputMsgType payload) { 
		LOG.info("Executing operation readProcessSummaries");
		System.out.println(payload);

		ReadProcessSummariesOutputMsgType res = new ReadProcessSummariesOutputMsgType();
		ResultType result = new ResultType();
		res.setResult(result);

		try {
			RequestToDA request = new RequestToDA();
			ProcessSummariesType processes = request.ReadProcessSummaries (payload.getSearchExpression());
			result.setCode(0);
			result.setMessage("");
			res.setProcessSummaries(processes);
		} catch (Exception ex) {
			ex.printStackTrace();
			result.setCode(-1);
			result.setMessage("ManagerPortalPortTypeImpl(ReadProcessSummaries) " + ex.getMessage());
		}
		return res;
	}

}
