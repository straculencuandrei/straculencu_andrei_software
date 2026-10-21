package com.parking.parkinglot;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertTrue;

class BootstrapIntegrationTest {

    @Test
    void bootstrapAssetsExistInWebapp() {
        Path cssPath = Path.of("src/main/webapp/css/bootstrap.min.css");
        Path jsPath = Path.of("src/main/webapp/js/bootstrap.bundle.min.js");

        assertTrue(Files.exists(cssPath), "bootstrap.min.css should exist in src/main/webapp/css");
        assertTrue(Files.exists(jsPath), "bootstrap.bundle.min.js should exist in src/main/webapp/js");
    }

    @Test
    void pageTemplateReferencesBootstrap() throws IOException {
        Path templatePath = Path.of("src/main/webapp/WEB-INF/tags/pageTemplate.tag");
        assertTrue(Files.exists(templatePath), "pageTemplate.tag should exist");

        String content = Files.readString(templatePath);
        assertTrue(content.contains("bootstrap.min.css"), "pageTemplate.tag should include bootstrap.min.css");
        assertTrue(content.contains("bootstrap.bundle.min.js"), "pageTemplate.tag should include bootstrap.bundle.min.js");
    }
}
