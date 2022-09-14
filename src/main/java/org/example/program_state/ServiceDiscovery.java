package org.example.program_state;

import org.example.service.DealerService;
import org.example.service.UserService;

public class ServiceDiscovery {
    private UserService userService;
    private DealerService dealerService;

    public ServiceDiscovery() {}

    public ServiceDiscovery(UserService userService, DealerService dealerService) {
        this.userService = userService;
        this.dealerService = dealerService;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public DealerService getDealerService() {
        return dealerService;
    }

    public void setDealerService(DealerService dealerService) {
        this.dealerService = dealerService;
    }
}
