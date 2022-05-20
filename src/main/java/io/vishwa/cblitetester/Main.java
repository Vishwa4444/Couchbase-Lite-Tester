/*
 * Copyright (c) 2020.  amrishraje@gmail.com
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.amrishraje.cblitetester;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class Main extends Application {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    @Override
    public void start(Stage primaryStage) throws Exception {
        logger.debug("Starting CBLite Application...");
        System.out.println("=============================================================================");
        System.out.println("Couchbase CBLite Tester");
        System.out.println("Author: Amrish Raje");
        System.out.println("Repo: https://github.com/Infosys/CouchbaseLiteTester");
        System.out.println("License: https://github.com/Infosys/CouchbaseLiteTester/blob/master/LICENSE");
        System.out.println("=============================================================================");
        Parent root = loadFXML("CBLiteScreen");
        primaryStage.setTitle("Couchbase Lite Sync Tester");
        primaryStage.setScene(new Scene(root, 900, 600));
        primaryStage.show();
        primaryStage.setOnCloseRequest(t -> {
            SyncController.stopReplication();
            Platform.exit();
            System.exit(0);
        });
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
