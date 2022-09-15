package org.example.program_state;

import org.example.service.ServiceDiscovery;

public class R002State implements PState {
    private static final String MSG = "Delivery module not available";
    private static final String OPTION_1 = "0-Logout";
    private ServiceDiscovery sd;
    public R002State() {}

    public R002State(ServiceDiscovery sd) {
        this.sd = sd;
    }
    @Override
    public PState run() {
        // TODO: implement this
        return null;
    }
}
