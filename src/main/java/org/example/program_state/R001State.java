package org.example.program_state;

import java.util.Scanner;

public class R001State implements PState {
    private static final String MSG = "Dealer module";
    private static final String OPTION_0 = "0-Logout";
    private static final String OPTION_1 = "1-Print all dealers";
    private static final String OPTION_2 = "2-Add a new dealer";
    private ServiceDiscovery sd;
    public R001State() {}

    public R001State(ServiceDiscovery sd) {
        this.sd = sd;
    }
    @Override
    public PState move() {
        System.out.println(MSG);
        System.out.println(SEPARATING_LINE);
        System.out.println(OPTION_0);
        System.out.println(OPTION_1);
        System.out.println(OPTION_2);
        System.out.println(SELECT_ONE);
        Scanner myObj = new Scanner(System.in);
        String selection = myObj.nextLine();
        PState nextState = this;
        if (selection.equals("0")) {
            nextState = new InitialState(sd);
        } else {
            nextState = this;
        }
        return nextState;
    }
}
