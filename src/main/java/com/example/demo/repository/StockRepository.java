import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.Stock;

@Repository
public interface StockRepository extends JpaRepository<>{
    
}