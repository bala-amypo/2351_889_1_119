import org.springframework.data.jpa.repository.JpaRepository;
package com.example.demo.repository;
import com.example.demo.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
    
}