import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/query")
@RequiredArgsConstructor
public class QueryController {

    private final QueryService queryService;

    @GetMapping("/holdings/{userId}")
    public ResponseEntity<List<StockHoldingResponse>> getHoldings(@PathVariable String userId) {
        return ResponseEntity.ok(queryService.getUserHoldings(userId));
    }

    @GetMapping("/history/{userId}")
    public ResponseEntity<List<StockOrderResponse>> getOrderHistory(@PathVariable String userId) {
        return ResponseEntity.ok(queryService.getOrderHistory(userId));
    }
}
