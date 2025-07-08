package Services;

public class ShippingService {

    public static void send(String address, String title) {
        System.out.println("book store sent \"" + title + "\" to shipping address: " + address);
    }
}
