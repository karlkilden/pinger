package com.kildeen.pinger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kildeen.heloderma.PingConfig;
import com.kildeen.heloderma.PingConfigReader;
import org.hjson.JsonValue;
import org.hjson.Stringify;
import org.junit.Test;

/**
 * @author: Kalle
 */
public class PingerTest {

        private static final ObjectMapper MAPPER = new ObjectMapper();
    @Test
    public void testName() throws Exception {
        String json = MAPPER.writeValueAsString(new PingConfig());
        String hjson = JsonValue.readHjson(json).toString(Stringify.HJSON);
                System.out.print(hjson);
    }

    @Test
    public void testRead() throws Exception {
        //System.setProperty(PingConfig.CONFIG_PATH_PROPERTY_KEY, "src/test/resources/PingConfig.hjson");
        PingConfigReader reader = new PingConfigReader("C:\\kalle\\pinger\\src\\test\\resources\\PingConfig.hjson");

                              PingConfig pingConfig = reader.getConfig();

    }
}