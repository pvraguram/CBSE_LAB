import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ComponentRepository {
    private final List<Component> registry = new ArrayList<>();

    public void register(Component component) {
        registry.add(component);
        System.out.println("  [Repository] Registered: " + component.getComponentName() + "  v" + component.getComponentVersion());
    }
    public Component findByName(String name) {
        Optional<Component> result = registry.stream()
                .filter(c -> c.getComponentName().equalsIgnoreCase(name))
                .findFirst();
        return result.orElse(null);
    }
    public void listAll() {
        System.out.println();
        System.out.println("  +--------------------------+----------+--------------------------------------------------+");
        System.out.printf("  | %-24s | %-8s | %-48s |%n", "Component Name", "Version", "Description");
        System.out.println("  +--------------------------+----------+--------------------------------------------------+");
        for (Component c : registry) {
            System.out.printf("  | %-24s | %-8s | %-48s |%n",
                    c.getComponentName(),
                    c.getComponentVersion(),
                    c.getComponentDescription());
        }
        System.out.println("  +--------------------------+----------+--------------------------------------------------+");
    }
    public int getCount() {
        return registry.size();
    }
}
