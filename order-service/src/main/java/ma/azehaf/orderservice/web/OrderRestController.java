package ma.azehaf.orderservice.web;

import lombok.AllArgsConstructor;
import ma.azehaf.orderservice.Services.CustomerRestClientService;
import ma.azehaf.orderservice.Services.InventoryRestClientService;
import ma.azehaf.orderservice.entities.Order;
import ma.azehaf.orderservice.entities.ProductItem;
import ma.azehaf.orderservice.model.Customer;
import ma.azehaf.orderservice.model.Product;
import ma.azehaf.orderservice.repositories.OrderRepository;
import ma.azehaf.orderservice.repositories.ProductItemRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class OrderRestController {
    private OrderRepository orderRepository;
    private ProductItemRepository productItemRepository;
    private CustomerRestClientService customerRestClientService;
    private InventoryRestClientService inventoryRestClientService;

    @GetMapping("/fullOrder/{id}")
    public Order getOrder(@PathVariable long id){
        Order order = orderRepository.findById(id).get();
        Customer customer = customerRestClientService.customerById(order.getCustomerId());
        order.setCustomer(customer);
        order.getProductItems().forEach(pi ->{
            Product product = inventoryRestClientService.productById(pi.getProductId());
            pi.setProduct(product);
        });
        return order;
    }
}
