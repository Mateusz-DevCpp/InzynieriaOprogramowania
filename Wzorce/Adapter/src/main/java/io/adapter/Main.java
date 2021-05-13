package io.adapter;
import java.util.Scanner;

interface USSocket {
    void charge();
    void useUS();
}

interface EUSocket {
    void charge();
    void useEU();
}

// ------------------------------------------------------------------

class USPlug implements USSocket {
    private boolean connector;

    @Override
    public void useUS() {
        connector = true;
        System.out.println("US plug connected");
    }

    @Override
    public void charge() {
        if (connector) {
            System.out.println("charging started");
            System.out.println("charging finished");
        }
    }
}

// ------------------------------------------------------------------

class EUPlug implements EUSocket {
    private boolean connector;

    @Override
    public void useEU() {
        connector = true;
        System.out.println("EU plug connected");
    }

    @Override
    public void charge() {
        if (connector) {
            System.out.println("charging started");
            System.out.println("charging finished");
        }
    }
}

// ----------------------Adapter--------------------------------------------

class USToEUAdapter implements EUSocket {
    private final USSocket USSocket;

    public USToEUAdapter(USSocket USSocket) {
        this.USSocket = USSocket;
    }

    @Override
    public void useEU() {
        System.out.println("EU socket awaiting connection");
        USSocket.useUS();
    }

    @Override
    public void charge() {
        USSocket.charge();
    }
}


// ----------------------Adapter--------------------------------------------

class EUToUSAdapter implements USSocket {
    private final EUSocket EUSocket;

    public EUToUSAdapter(EUSocket EUSocket) {
        this.EUSocket = EUSocket;
    }

    @Override
    public void useUS() {
        System.out.println("US socket awaiting connection");
        EUSocket.useEU();
    }

    @Override
    public void charge() {
        EUSocket.charge();
    }
}

// ------------------------------------------------------------------

public class Main {
    static void chargeWithEUPlug(EUSocket plug) {
        plug.useEU();
        plug.charge();
    }

    static void chargeWithUSPlug (USSocket plug) {
        plug.useUS();
        plug.charge();
    }

    public static void main(String[] args) {
        EUPlug plug1 = new EUPlug();
        USPlug plug2 = new USPlug();
        Scanner s = new Scanner(System.in);
        System.out.println("Choose the area: (1) US (2) EU");
        int area = s.nextInt();
        System.out.println("Choose the plug you have: (1) US (2) EU");
        int plug = s.nextInt();

        if(plug == 1 && area == 1) {
            System.out.println("charging with US Socket");
            chargeWithUSPlug(plug2);
        }
        if(plug == 2 && area == 2) {
            System.out.println("charging with EU Socket");
            chargeWithEUPlug(plug1);
        }
        if(plug == 1 && area == 2) {
            System.out.println("charging with Adapter EU");
            chargeWithEUPlug(new USToEUAdapter(plug2));
        }
        if(plug == 2 && area == 1) {
            System.out.println("charging with Adapter US");
            chargeWithUSPlug(new EUToUSAdapter(plug1));
        }

    }
}