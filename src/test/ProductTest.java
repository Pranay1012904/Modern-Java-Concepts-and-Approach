package test;

import com.records.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class ProductTest {

    @Test
    void createProduct(){
        var product=new Product("Jackson",new BigDecimal(89.99),"guitar");
        Assertions.assertEquals("guitar",product.type());
        Assertions.assertEquals("Jackson",product.name());
    }
}
