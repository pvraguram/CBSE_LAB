import java.util.ArrayList;
import java.util.List;

public class ComponentRegistry {
    private final List<AppComponent> store = new ArrayList<>();
    public void register(AppComponent component) {
        store.add(component);
    }
    public AppComponent find(String name) {
        return store.stream()
                .filter(c -> c.getComponentName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }
    public void printAll() {
        System.out.println("  +--------------------+---------+");
        System.out.printf("  | %-18s | %-7s |%n", "Component", "Version");
        System.out.println("  +--------------------+---------+");
        for (AppComponent c : store) {
            System.out.printf("  | %-18s | %-7s |%n", c.getComponentName(), c.getComponentVersion());
        }
        System.out.println("  +--------------------+---------+");
    }
}
