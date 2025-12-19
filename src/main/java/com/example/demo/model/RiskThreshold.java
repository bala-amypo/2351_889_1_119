@Entity
public class RiskThreshold {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double minValue;
    private Double maxValue;

    private boolean active;   // ✅ ADD THIS LINE

    // getters & setters
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
