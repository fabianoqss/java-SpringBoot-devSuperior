package crud.com.example.REST.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import crud.com.example.REST.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
