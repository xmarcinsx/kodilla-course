package pl.mps.kodilla.hibernate.invoice.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.mps.kodilla.hibernate.invoice.Invoice;
import pl.mps.kodilla.hibernate.invoice.Item;
import pl.mps.kodilla.hibernate.invoice.Product;
import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceDaoTestSuite {

    @Autowired
    private InvoiceDao invoiceDao;

    @Test
    public void testInvoiceDaoSave() {
        //Given
        Product product = new Product("Tv");
        Product product1 = new Product("Hi-FI");
        Product product2 = new Product("Notebook");
        Product product3 = new Product("Camera");
        Item item = new Item(new BigDecimal("5000"), 20);
        Item item1 = new Item(new BigDecimal("2200"), 10);
        Item item2 = new Item(new BigDecimal("9000"), 15);
        Item item3 = new Item(new BigDecimal("1250"), 50);
        Item item4 = new Item(new BigDecimal("1000"), 5);
        Invoice invoice = new Invoice("12345678");
        product.getItems().add(item);
        product.getItems().add(item1);
        product.getItems().add(item2);
        product.getItems().add(item3);
        product.getItems().add(item4);
        item.setProduct(product);
        item1.setProduct(product1);
        item2.setProduct(product2);
        item3.setProduct(product3);
        item4.setProduct(product);
        item.setInvoice(invoice);
        item1.setInvoice(invoice);
        item2.setInvoice(invoice);
        item3.setInvoice(invoice);
        item4.setInvoice(invoice);
        invoice.getItems().add(item);
        invoice.getItems().add(item1);
        invoice.getItems().add(item2);
        invoice.getItems().add(item3);
        invoice.getItems().add(item4);
        invoice.getItems().add(item3);
        int unexpected = 0;

        //When
        invoiceDao.save(invoice);
        int actual = invoice.getId();

        //Then
        Assert.assertNotEquals(unexpected, actual);

        //CleanUp
        try {
            invoiceDao.delete(invoice);
        } catch (Exception ex) {

        }
    }
}