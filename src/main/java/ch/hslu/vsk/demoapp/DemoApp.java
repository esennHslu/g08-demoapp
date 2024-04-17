/*
 * Copyright 2024 Roland Gisler, HSLU Informatik, Switzerland
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ch.hslu.vsk.demoapp;

import ch.hslu.vsk.logger.api.*;
import ch.hslu.vsk.logger.component.LoggerClient;

import java.net.URI;
import java.nio.file.Path;

/**
 * Demo application for the {@link ch.hslu.vsk.demoapp.Point}-Class.
 */
public final class DemoApp {

    private static final int COR_X = 2;

    private static final int COR_Y = -1;

    private DemoApp() {
    }

    /**
     * Main method.
     *
     * @param args start arguments.
     */
    public static void main(final String[] args) {
        final Point point = new Point(COR_X, COR_Y);
        final int quadrant = point.getQuadrant();
        String message = point + " is in quadrant: " + quadrant;

        LoggerSetupBuilder builder = LoggerSetupBuilderFactory.create();
        LoggerSetup loggerClient = builder
                .requires(LogLevel.Info)
                .from("demo-app")
                .usesAsFallback(Path.of("/dev", "null"))
                .targetsServer(URI.create("http://localhost:9999"))
                .build();

        Logger log = loggerClient.createLogger();

        try {
            log.debug(message);
            log.debug("debug");
            log.info("info");
            log.warn("warn");
            log.error("err");
            log.error("err: ", new IllegalArgumentException("argument exc"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
