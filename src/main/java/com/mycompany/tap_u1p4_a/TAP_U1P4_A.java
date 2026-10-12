package com.mycompany.tap_u1p4_a;

import com.formdev.flatlaf.FlatDarkLaf;
import com.mycompany.tap_u1p4_a.views.LoginFrame;

/**
 *
 * @author iscal
 */
public class TAP_U1P4_A {

    public static void main(String[] args) {
        FlatDarkLaf.setup();
        new LoginFrame().setVisible(true);
    }
}