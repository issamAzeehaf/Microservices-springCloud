package ma.azehaf.orderservice.repository;

import ma.azehaf.orderservice.entities.Order;
import ma.azehaf.orderservice.entities.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
