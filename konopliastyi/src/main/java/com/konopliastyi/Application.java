package com.konopliastyi;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class Application {

    private OrderServiceSetter orderService;

    public Application() {}

    @Inject
    public void setOrderService(OrderServiceSetter orderService) {
        this.orderService = orderService;
    }

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new KonopliastyiModule());
        Application app = injector.getInstance(Application.class);
        app.run();
    }

    public void run() {
        orderService.saveOrder("ORD-SET-1", "READY", 2.0);
        System.out.println("[INFO] Setter DI write done");
    }
}
