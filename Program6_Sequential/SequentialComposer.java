import java.util.ArrayList;
import java.util.List;

public class SequentialComposer {
    private final List<OrderStep> pipeline = new ArrayList<>();
    public void addStep(OrderStep step) {
        pipeline.add(step);
    }
    public void execute(OrderContext context) {
        System.out.println("======================================");
        System.out.println("    Sequential Pipeline - START       ");
        System.out.println("======================================\n");
        for (OrderStep step : pipeline) {
            step.execute(context);
        }
        System.out.println("======================================");
        System.out.println("    Sequential Pipeline - COMPLETE    ");
        System.out.println("======================================");
    }
}
