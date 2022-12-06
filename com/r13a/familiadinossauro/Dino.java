package com.r13a.familiadinossauro;

import org.graalvm.polyglot.HostAccess;

@HostAccess.Implementable
public class Dino {

    @HostAccess.Export
    public void say() {
        System.out.println("\nDino: Bom dia minha família que me ama...");
    }
}
