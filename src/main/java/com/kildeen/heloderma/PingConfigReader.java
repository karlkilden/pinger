package com.kildeen.heloderma;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hjson.JsonValue;
import org.hjson.Stringify;
import org.slf4j.Logger;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.Files.readAllBytes;

/**
 * @author: Kalle
 */
public class PingConfigReader {

 //   System.getProperty(PingConfig.CONFIG_PATH_PROPERTY_KEY)
    private static final com.fasterxml.jackson.databind.ObjectMapper MAPPER = new ObjectMapper();
    Logger LOG = LogManager.getLogger();
    private String path;

    public PingConfigReader(final String path) {
        this.path = path;
    }

    private String getjson(Path path) throws IOException {
        final String confString = new String(readAllBytes(path));
        final String jsonString = JsonValue.readHjson(confString).toString(Stringify.PLAIN);
        return jsonString;
    }

    public <E> E getObject(Path path, Class<? extends E> clazz) {
        LOG.info("Getting object of type {} from path {}", clazz.getSimpleName(), path);
        try {
            return MAPPER.readValue(getjson(path), clazz);
        } catch (Exception e) {
            LOG.error("",e);
        }
        return null;
    }

    public <E> E getObject(String path, Class<? extends E> clazz) {
        return getObject(Paths.get(path), clazz);
    }

    public PingConfig getConfig() {

        Path currentRelativePath = Paths.get(path);
        return getObject(currentRelativePath, PingConfig.class);

    }

}
