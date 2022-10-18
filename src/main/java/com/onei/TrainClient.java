package com.onei;

import com.onei.irishrail.wsdl.ArrayOfObjStationData;
import com.onei.irishrail.wsdl.GetAllStationsXML;
import com.onei.irishrail.wsdl.GetAllStationsXMLResponse;
import com.onei.irishrail.wsdl.ObjStation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;



public class TrainClient extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(TrainClient.class);

    public ArrayOfObjStationData getStationByCode(String stationCode) {

        GetAllStationsXMLResponse getAllStationsXMLResponse = new GetAllStationsXMLResponse();
        ObjStation request = new ObjStation();
        request.setStationCode(stationCode);
        ArrayOfObjStationData arrayOfObjStationData = new ArrayOfObjStationData();

        log.info("Requesting location for " + stationCode);

        ArrayOfObjStationData response = (ArrayOfObjStationData) getWebServiceTemplate()
                .marshalSendAndReceive("http://api.irishrail.ie/realtime/realtime.asmx/getStationDataByCodeXML", request);

        return response;
    }

}