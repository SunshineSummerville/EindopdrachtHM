package novi.basics.springbootDemo.service;


import novi.basics.springbootDemo.model.Handyman;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HandymanRepository extends JpaRepository<Handyman, Long> {

    optional<handyman>findb
}
