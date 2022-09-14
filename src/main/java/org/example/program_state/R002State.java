package org.example.program_state;

import java.util.Scanner;

public class R002State implements PState {
    private static final String MSG = "Delivery module not available";
    private static final String OPTION_1 = "0-Logout";
    private ServiceDiscovery sd;
    public R002State() {}

    public R002State(ServiceDiscovery sd) {
        this.sd = sd;
    }
    @Override
    public PState move() {
        System.out.println(MSG);
        System.out.println(SEPARATING_LINE);
        System.out.println(OPTION_1);
        System.out.println(SELECT_ONE);
        Scanner myObj = new Scanner(System.in);
        String selection = myObj.nextLine();
        PState nextState = this;
        if (selection.equals("0")) {
            nextState = new InitialState(sd);
        }
        return nextState;
    }
}
