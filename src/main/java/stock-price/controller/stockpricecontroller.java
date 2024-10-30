import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import java.time.Duration;

@SpringBootApplication
public class SpringBootStarterWebfluxApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootStarterWebfluxApplication.class, args);
    }
}

@RestController
public class StockPriceController {

    @GetMapping("/stocks/{symbol}")
    public Flux<StockPrice> getStockPrices(@PathVariable String symbol) {
        return Flux.interval(Duration.ofSeconds(1))
                .map(i -> new StockPrice(symbol, (int) (Math.random() * 100)));
    }

    record StockPrice(String symbol, int price) {}
}