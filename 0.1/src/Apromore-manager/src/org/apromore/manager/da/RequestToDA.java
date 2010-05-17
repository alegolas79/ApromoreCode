package org.apromore.manager.da;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

import javax.activation.DataHandler;
import javax.xml.namespace.QName;

import org.apromore.manager.commons.Constants;
import org.apromore.manager.exception.ExceptionDomains;
import org.apromore.manager.exception.ExceptionFormats;
import org.apromore.manager.exception.ExceptionReadProcessSummaries;
import org.apromore.manager.exception.ExceptionReadUser;
import org.apromore.manager.exception.ExceptionWriteUser;
import org.apromore.manager.model_da.ReadCanonicalInputMsgType;
import org.apromore.manager.model_da.ReadDomainsInputMsgType;
import org.apromore.manager.model_da.ReadDomainsOutputMsgType;
import org.apromore.manager.model_da.ReadFormatsInputMsgType;
import org.apromore.manager.model_da.ReadFormatsOutputMsgType;
import org.apromore.manager.model_da.ReadNativeInputMsgType;
import org.apromore.manager.model_da.ReadProcessSummariesInputMsgType;
import org.apromore.manager.model_da.ReadUserInputMsgType;
import org.apromore.manager.model_da.ResultType;
import org.apromore.manager.model_da.SearchHistoriesType;
import org.apromore.manager.model_da.UserType;
import org.apromore.manager.model_da.WriteUserInputMsgType;
import org.apromore.manager.model_da.WriteUserOutputMsgType;
import org.apromore.manager.model_portal.ProcessSummariesType;
import org.apromore.manager.model_portal.ProcessSummaryType;
import org.apromore.manager.model_portal.VersionSummaryType;

public class RequestToDA {


	private static final QName SERVICE_NAME = new QName(Constants.DA_MANAGER_URI, Constants.DA_MANAGER_SERVICE);
	private DAManagerPortType port;

	public RequestToDA() {
		URL wsdlURL = DAManagerService.WSDL_LOCATION;
		DAManagerService ss = new DAManagerService(wsdlURL, SERVICE_NAME);
		this.port = ss.getDAManager();
	}

	public org.apromore.manager.model_portal.FormatsType ReadFormats() throws ExceptionFormats {

		// payload empty
		ReadFormatsInputMsgType payload = new ReadFormatsInputMsgType();
		ReadFormatsOutputMsgType res = this.port.readFormats(payload);

		ResultType result = res.getResult();
		if (result.getCode() == -1) {
			throw new ExceptionFormats (result.getMessage()); 
		} else {
			List<String> formats = res.getFormats().getFormat();
			org.apromore.manager.model_portal.FormatsType resFormats = new org.apromore.manager.model_portal.FormatsType();
			resFormats.getFormat().addAll(formats);
			return resFormats;
		}
	}

	public org.apromore.manager.model_portal.DomainsType ReadDomains() throws ExceptionDomains{

		// payload empty
		ReadDomainsInputMsgType payload = new ReadDomainsInputMsgType();
		ReadDomainsOutputMsgType res = this.port.readDomains(payload);

		ResultType result = res.getResult();
		if (result.getCode() == -1) {
			throw new ExceptionDomains (result.getMessage()); 
		} else {
			List<String> domains = res.getDomains().getDomain();
			org.apromore.manager.model_portal.DomainsType resDomains = new org.apromore.manager.model_portal.DomainsType();
			resDomains.getDomain().addAll(domains);
			return resDomains;
		}

	}

	public void WriteUser(org.apromore.manager.model_portal.UserType userP) throws ExceptionWriteUser {

		WriteUserInputMsgType payload = new WriteUserInputMsgType();
		UserType userM = new UserType();
		userM.setEmail(userP.getEmail());
		userM.setFirstname(userP.getFirstname());
		userM.setLastname(userP.getLastname());
		userM.setPasswd(userP.getPasswd());
		userM.setUsername(userP.getUsername());
		for (int i=0;i<userP.getSearchHistories().size();i++) {
			SearchHistoriesType sht = new SearchHistoriesType();
			sht.setNum(userP.getSearchHistories().get(i).getNum());
			sht.setSearch(userP.getSearchHistories().get(i).getSearch());
			userM.getSearchHistories().add(sht);
		}
		payload.setUser(userM);

		WriteUserOutputMsgType res = this.port.writeUser(payload);
		ResultType result = res.getResult();
		if (result.getCode() == -1) {
			throw new ExceptionWriteUser (result.getMessage()); 
		}
	}

	public org.apromore.manager.model_portal.UserType ReadUser(String username) throws ExceptionReadUser {

		org.apromore.manager.model_da.ReadUserInputMsgType payload = new ReadUserInputMsgType();
		payload.setUsername(username);
		org.apromore.manager.model_da.ReadUserOutputMsgType res = this.port.readUser(payload);
		org.apromore.manager.model_da.ResultType result = res.getResult();

		if (result.getCode() == -1) {
			throw new ExceptionReadUser (result.getMessage()); 
		} else {
			org.apromore.manager.model_portal.UserType user = new org.apromore.manager.model_portal.UserType();
			user.setEmail(res.getUser().getEmail());
			user.setFirstname(res.getUser().getFirstname());
			user.setLastname(res.getUser().getLastname());
			user.setPasswd(res.getUser().getPasswd());
			user.setUsername(res.getUser().getUsername());
			for (int i=0; i<res.getUser().getSearchHistories().size(); i++) {
				org.apromore.manager.model_portal.SearchHistoriesType sht = new org.apromore.manager.model_portal.SearchHistoriesType();
				sht.setNum(res.getUser().getSearchHistories().get(i).getNum());
				sht.setSearch(res.getUser().getSearchHistories().get(i).getSearch());
				user.getSearchHistories().add(sht);
			}
			return user;
		}

	}


	public org.apromore.manager.model_portal.ProcessSummariesType ReadProcessSummaries(String searchExpression) 
	throws ExceptionReadProcessSummaries {
		org.apromore.manager.model_da.ReadProcessSummariesInputMsgType payload = new ReadProcessSummariesInputMsgType();
		payload.setSearchExpression(searchExpression);
		org.apromore.manager.model_da.ReadProcessSummariesOutputMsgType res = this.port.readProcessSummaries(payload);
		org.apromore.manager.model_da.ResultType result = res.getResult();
		if (result.getCode() == -1) {
			throw new ExceptionReadProcessSummaries(result.getMessage()); 
		} else {
			org.apromore.manager.model_portal.ProcessSummariesType processesP = new ProcessSummariesType();
			org.apromore.manager.model_da.ProcessSummariesType processesM = res.getProcessSummaries(); 
			for (int i=0; i<processesM.getProcessSummary().size();i++){
				org.apromore.manager.model_da.ProcessSummaryType processM = processesM.getProcessSummary().get(i);
				org.apromore.manager.model_portal.ProcessSummaryType processP = new ProcessSummaryType();
				processesP.getProcessSummary().add(processP);

				processP.setDomain(processM.getDomain());
				processP.setId(processM.getId());
				processP.setLastVersion(processM.getLastVersion());
				processP.setName(processM.getName());
				processP.setOriginalNativeType(processM.getOriginalNativeType());
				processP.setRanking(processM.getRanking());

				for (int j=0;j<processM.getVersionSummaries().size();j++){
					org.apromore.manager.model_da.VersionSummaryType versionM = processM.getVersionSummaries().get(j);
					org.apromore.manager.model_portal.VersionSummaryType versionP = new VersionSummaryType();
					processP.getVersionSummaries().add(versionP);
					versionP.setCreationDate(versionM.getCreationDate());
					versionP.setLastUpdate(versionM.getLastUpdate());
					versionP.setName(versionM.getName());
					versionP.setRanking(versionM.getRanking());					
				}
			}
			return processesP;
		}
	}

	public DAManagerPortType getPort() {
		return port;
	}

	public InputStream ReadNative(int processId, String version,
			String nativeType) throws ExceptionReadProcessSummaries, IOException, ExceptionReadNative {	
		org.apromore.manager.model_da.ReadNativeInputMsgType payload0 = new ReadNativeInputMsgType();
		payload0.setProcessId(processId);
		payload0.setVersion(version);
		payload0.setNativeType(nativeType);

		org.apromore.manager.model_da.ReadNativeOutputMsgType res = this.port.readNative(payload0);
		org.apromore.manager.model_da.ResultType result = res.getResult();
		if (result.getCode() == 0) {
			// if native found returned it
			DataHandler handler = res.getNative();
			InputStream is = handler.getInputStream();
			return is;
		} else {
			throw new ExceptionReadNative(result.getMessage());
		}
	}

	public InputStream ReadCanonical(int processId, String version) throws ExceptionReadCanonical, IOException {
		org.apromore.manager.model_da.ReadCanonicalInputMsgType payload = new ReadCanonicalInputMsgType();
		payload.setProcessId(processId);
		payload.setVersion(version);
		
		org.apromore.manager.model_da.ReadCanonicalOutputMsgType res = this.port.readCanonical(payload);
		org.apromore.manager.model_da.ResultType result = res.getResult();
		if (result.getCode() == 0) {
			DataHandler handler = res.getCpf();
			InputStream is = handler.getInputStream();
			return is;
		} else {
			throw new ExceptionReadCanonical(result.getMessage());
		}
		
	}

}







