package com.onei;

import com.onei.irishrail.wsdl.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class TrainClient extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(TrainClient.class);

    public GetCurrentTrainsXMLResponse getStationByCode(String stationCode) {

        GetAllStationsXMLResponse getAllStationsXMLResponse = new GetAllStationsXMLResponse();
        ObjStation request = new ObjStation();
        request.setStationCode(stationCode);
        ArrayOfObjStation arrayOfObjStation = new ArrayOfObjStation();
        GetAllStationsXML getStationDataByCodeXML = new GetAllStationsXML();
        getAllStationsXMLResponse.setGetAllStationsXMLResult(arrayOfObjStation);
        GetCurrentTrainsXML getCurrentTrainsXML = new GetCurrentTrainsXML();

        log.info("Requesting location for " + stationCode);

        GetCurrentTrainsXMLResponse response = (GetCurrentTrainsXMLResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://api.irishrail.ie/realtime/realtime.asmx", getCurrentTrainsXML,
                        new SoapActionCallback(
                                "http://api.irishrail.ie/realtime/getCurrentTrainsXML"));
        var trains = response.getGetCurrentTrainsXMLResult().getObjTrainPositions();
        trains.stream().forEach(s -> System.out.println(s.getTrainCode()));
        return response;
    }

}