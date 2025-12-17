package com.konopliastyi;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class Application {

    @Inject
    private OrderServiceField orderService;

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new KonopliastyiModule());
        Application app = injector.getInstance(Application.class);
        app.run();
    }

    public void run() {
        orderService.saveOrder("ORD-FIELD-1", "READY", 3.0);
        System.out.println("[INFO] Field DI write done");
    }
}
