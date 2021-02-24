package com.lemon.silence.utils.webservice;

import com.lemon.silence.utils.bo.RemoteCallResponseEntity;
import lombok.extern.slf4j.Slf4j;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;
import org.springframework.stereotype.Component;

/**
 * webservice cxf动态客户端调用
 *
 * @author zhangxueqi
 * @version 1.0
 * @date 2020/8/28 14:22
 */
@Slf4j
@Component
public class CxfClient {

	public static Client initCxfClient(String url) {

		Client client = null;
		HTTPConduit httpConduit = null;
		try {
			JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
			client = dcf.createClient(url);
			httpConduit = (HTTPConduit) client.getConduit();
		} catch (Exception e) {
			e.printStackTrace();
			log.info("webservice初始化客户端失败");
		}

		HTTPClientPolicy httpClientPolicy = new HTTPClientPolicy();
		httpClientPolicy.setConnectionTimeout(6000);
		httpClientPolicy.setReceiveTimeout(6000);
		httpConduit.setClient(httpClientPolicy);

		return client;
	}

	public static RemoteCallResponseEntity invoke(Client cxfClient, String wdsl, String methodName, String sendData) {
		RemoteCallResponseEntity remoteCallResponseEntity = new RemoteCallResponseEntity();
		//double  check
		if (cxfClient == null) {
			synchronized (CxfClient.class) {
				if (cxfClient == null) {
					cxfClient = initCxfClient(wdsl);
				}
			}
		}
		try {
			String recieveData = cxfClient.invoke(methodName, sendData)[0].toString();
			remoteCallResponseEntity.setContent(recieveData);
			remoteCallResponseEntity.setLength(recieveData.length());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return remoteCallResponseEntity;
	}
}
