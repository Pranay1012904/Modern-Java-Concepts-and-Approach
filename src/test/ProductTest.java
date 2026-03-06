package test;

import com.records.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProductTest {

    @Test
    void createProduct() {
        var product = new Product("Jackson", new BigDecimal(89.99), "guitar");
        assertEquals("guitar", product.type());
        assertEquals("Jackson", product.name());
    }

    @Test
    void testInvalidName() {
        //var product=new Product(null,new BigDecimal(89.99),"guitar");
        var ex1 = assertThrows(IllegalArgumentException.class, () -> new Product(" ", new BigDecimal(89.99), "guitar"));
        var ex2 = assertThrows(IllegalArgumentException.class, () -> new Product(null, new BigDecimal(89.99), "guitar"));
        assertEquals("Invalid name!", ex1.getMessage());
        assertEquals("Invalid name!", ex2.getMessage());
    }

    @Test
    void testInvalidCost() {
        var ex = assertThrows(IllegalArgumentException.class, () -> new Product("B.C. Rich", new BigDecimal(0.0), "Guitar"));
        assertEquals("Invalid Cost Moron!", ex.getMessage());
    }

    @Test
    void testDefaultParamValue() {
        var product = new Product("Ibenez", new BigDecimal(4.5));//call goes to custom constructor we created
        assertEquals("DEFAULT", product.type());
    }
}
