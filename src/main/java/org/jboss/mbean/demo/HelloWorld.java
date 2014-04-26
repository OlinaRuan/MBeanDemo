package org.jboss.mbean.demo;

import java.util.logging.Logger;

public class HelloWorld implements HelloWorldMBean, Runnable {
    Logger logger = Logger.getLogger(HelloWorld.class.getSimpleName());

    boolean running = false;

    @Override
    public void start() throws Exception {
        logger.info("Start");
        running = true;
        execute();
    }

    @Override
    public void stop() {
        logger.info("Stop");
        running = false;
    }

    @Override
    public void execute() throws Exception {
        new Thread(this).start();
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used to create a thread, starting the thread
     * causes the object's <code>run</code> method to be called in that separately executing thread. <p> The general
     * contract of the method <code>run</code> is that it may take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        while (running) {
            logger.info("execute...");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
