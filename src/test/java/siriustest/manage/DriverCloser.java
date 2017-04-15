package siriustest.manage;

import java.io.IOException;

class DriverCloser {
    DriverCloser() {
        Runtime runtime = Runtime.getRuntime();

        runtime.addShutdownHook( new Thread() {
            @Override
            public void run() {
                String[] commands = {"cmd /c taskkill /f /im chromedriver*",
                                     "cmd /c taskkill /f /im IEDriverServer*"};
                try {
                    for ( String command : commands )
                        runtime.exec(command);
                } catch (IOException e) {
                    System.out.println("Errors with killing drivers");
                    e.printStackTrace();
                }
            }
        } );
    }
}
