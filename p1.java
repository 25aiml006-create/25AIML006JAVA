import java.util.*;

class item

{
    private final String name;
    private final int price;

    item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    String getName() { return name; }
    int getPrice() { return price; }

    static Item findItem(char c)
     {
        return switch (c)
         {
            case 'T' -> new item("Tea", 10);
            case 'C' -> new item("Coffee", 15);
            case 'S' -> new item("Samosa", 12);
            case 'P' -> new item("Puff", 20);
            default -> null;
        }
    }
}


class Order 
{
    private int tokenno, quantity;
    private Item item;
    static int nexttoken = 101, totalorders, totalsales;


    Order(Item item, int quantity) 
    {
        this.item = item;
        this.quantity = quantity;

        tokenno = nexttoken++;
        totalorders++;
        totalsales += getamount();
    }


    int getAmount() { return item.getPrice() * quantity; }

    static int getTotalOrders() { return totalorders; }

    static int getTotalSales() { return totalsales; }

    public String toString() 
    {
        return "Token " + tokenno + ": " + item.getName() + " x "
                + quantity + " = " + getAmount();
    }
}


public class Main
 {
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        while (n-- > 0)
         {
            char c = sc.next().charAt(0);
            int q = sc.nextInt();
            Item item = Item.findItem(c);

            if (item == null || q <= 0)
                System.out.println("Invalid order: " + c + " " + q);
            else
                System.out.println(new Order(item, q));
        }

        System.out.println("Total orders: " + Order.getTotalOrders()
                + ", Total sales: " + Order.getTotalSales());
    }
}