package slf4jLoging.file;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShoppingCartFile {
    private static final Logger logger = LoggerFactory.getLogger(ShoppingCartFile.class);

    public void addToCart(String item) {
        // Логирование добавления товара в корзину
        logger.info("Item '{}' добавлен", item);
        logger.debug("Item added to cart: {}", item);
    }

    public void makePayment(double amount) {
        // Логирование оплаты товара
        logger.info("Прошла оплата в размере : {}", amount);
    }
}

class Main {
    public static void main(String[] args) {
        // Создание экземпляра класса корзины
        ShoppingCartFile cart = new ShoppingCartFile();

        // Добавление товара в корзину
        cart.addToCart("Item 1");
        cart.addToCart("Item 2");

        // Оплата товара
        cart.makePayment(100.50);

    }
}
