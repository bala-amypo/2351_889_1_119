import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.Stockentity;

@Repository
public interface StockRepository extends JpaRepository<>{
    
}