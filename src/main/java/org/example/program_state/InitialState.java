package org.example.program_state;

import org.example.model.Role;
import org.example.model.User;
import org.example.service.UserService;

import java.util.Scanner;

public class InitialState implements PState {
    private static final String MSG = "Please login with username/password:";
    private static final String SEPARATOR = "/";
    private ServiceDiscovery sd;

    public InitialState() {}

    public InitialState(ServiceDiscovery sd) {
        this.sd = sd;
    }

    @Override
    public PState move() {
        return login();
    }

    private PState login() {
        Scanner myObj = new Scanner(System.in);
        System.out.println(MSG);
        String credential = myObj.nextLine();
        String[] tmp = credential.split(SEPARATOR);
        boolean move = false;
        PState nextState = null;
        if (tmp.length == 2) {
            User user = this.sd.getUserService().check(tmp[0], tmp[1]);
            if (user != null) {
                // log in success
                move = true;
                switch (user.getRole()) {
                    case R001: {
                        move = true;
                        nextState = new R001State(sd);
                        break;
                    }
                    case R002: {
                        move = true;
                        nextState = new R002State(sd);
                        break;
                    }
                    case ADMIN: {
                        move = true;
                        nextState = new AdminState(sd);
                        break;
                    }
                }
            }
        }
        if (!move) return this;
        else return nextState;
    }

    public ServiceDiscovery getSd() {
        return sd;
    }

    public void setSd(ServiceDiscovery sd) {
        this.sd = sd;
    }
}
