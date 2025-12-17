package com.konopliastyi;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class Application {

    private final OrderService orderService;

    @Inject
    public Application(OrderService orderService) {
        this.orderService = orderService;
    }

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new KonopliastyiModule());
        Application app = injector.getInstance(Application.class);

        // keep your old demo if you want:
        // demonstrateSystem();

        app.run();
    }

    public void run() {
        // Trigger DB creation + write
        orderService.saveOrder("ORD-DB-1", "READY", 1.0);
        System.out.println("[INFO] SQLite write done");
    }

    // If you need your previous demo, paste it here later (optional)
}
