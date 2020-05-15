package hr.senji.hibernate.demo.three.tables;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BTableRepository extends JpaRepository<BTable, Long> {

  @Query("SELECT b FROM BTable b LEFT JOIN FETCH b.ceovi c WHERE b IN (:b)")
  List<BTable> findAllByBs(List<BTable> b);
}
