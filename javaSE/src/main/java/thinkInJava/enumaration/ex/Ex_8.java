package thinkInJava.enumaration.ex;

import thinkInJava.enumaration.Enums;

import java.util.Iterator;

/**
 * Created by ALEX on 05.07.2016.
 */
public class Ex_8 {
    enum MailHandler {
        GENERAL_DELIVERY {
            boolean handle(FMail m) {
                switch (m.generalDelivery) {
                    case YES:
                        return true;
                    default:
                        return false;
                }
            }
        },
        MACHINE_SCAN {
            boolean handle(FMail m) {
                switch (m.scannability) {
                    case UNSCANNABLE:
                        return false;
                    default:
                        switch (m.address) {
                            case INCORRECT: return false;
                            default:
                                return true;
                        }
                }
            }
        },
        VISUAL_INSPECTION {
            boolean handle(FMail m) {
                switch(m.readability) {
                    case ILLEGIBLE: return false;
                    default:
                        switch(m.address) {
                            case INCORRECT: return false;
                            default:
                                System.out.println("Delivering " + m + " normally");
                                return true;
                        }
                }
            }
        },
        FORWARD_MAIL {
            boolean handle(FMail m) {
                switch (m.forwardAddress) {
                    case MISSING: return false;
                    default:
                        return true;
                }
            }
        },
        RETURN_TO_SENDER {
            boolean handle(FMail m) {
                switch (m.returnAddress) {
                    case MISSING: return false;
                    default:
                        return true;
                }
            }
        }

    }
}
class FMail {
    enum GeneralDelivery {YES,NO1,NO2,NO3,NO4,NO5}
    enum Scannability {UNSCANNABLE,YES1,YES2,YES3,YES4}
    enum Readability {ILLEGIBLE,YES1,YES2,YES3,YES4}
    enum Address {INCORRECT,OK1,OK2,OK3,OK4,OK5,OK6}
    enum ReturnAddress {MISSING,OK1,OK2,OK3,OK4,OK5}
    enum ForwardAddress {MISSING,OK1,OK2,OK3,OK4,OK5}

    GeneralDelivery generalDelivery;
    Scannability scannability;
    Readability readability;
    Address address;
    ReturnAddress returnAddress;
    ForwardAddress forwardAddress;

    static long counter = 0;
    long id= counter ++;
    public String toString() { return "Mail " + id; }
    public String details() {
        return toString() +
                ", General Delivery: " + generalDelivery +
                ", Address Scanability: " + scannability +
                ", Address Readability: " + readability +
                ", Address Address: " + address +
                ", Return address: " + returnAddress;
    }

    public static FMail randomMail() {
        FMail m=new FMail();
        m.generalDelivery= Enums.random(GeneralDelivery.class);
        m.scannability = Enums.random(Scannability.class);
        m.readability = Enums.random(Readability.class);
        m.address = Enums.random(Address.class);
        m.returnAddress = Enums.random(ReturnAddress.class);
        m.forwardAddress = Enums.random(ForwardAddress.class);
        return m;

    }

    public static Iterable<FMail> generator(final int count) {
        return new Iterable<FMail>() {
            int n=count;
            @Override
            public Iterator<FMail> iterator() {
                return new Iterator<FMail>() {
                    @Override
                    public boolean hasNext() {
                        return n-- >0;
                    }

                    @Override
                    public FMail next() {
                        return randomMail();
                    }

                    @Override
                    public void remove() {
                        throw new UnsupportedOperationException();
                    }
                };
            }
        };
    }



}