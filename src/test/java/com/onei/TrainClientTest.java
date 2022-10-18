package com.onei;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrainClientTest {

    @Test
    void getStationByCode() {
        TrainClient trainClient = new TrainClient();

        trainClient.getStationByCode("SKILL");
    }
}