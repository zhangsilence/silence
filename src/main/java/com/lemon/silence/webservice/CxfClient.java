package com.lemon.silence.webservice;

import com.lemon.silence.webservice.bo.HttpResponseEntity;
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

	public static HttpResponseEntity invoke(Client cxfClient, String wdsl, String methodName, String sendData) {
		HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
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
			httpResponseEntity.setContent(recieveData);
			httpResponseEntity.setLength(recieveData.length());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return httpResponseEntity;
	}
}
