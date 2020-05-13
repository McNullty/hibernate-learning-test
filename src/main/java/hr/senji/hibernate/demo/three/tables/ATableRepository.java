package hr.senji.hibernate.demo.three.tables;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ATableRepository extends JpaRepository<ATable, Long> {

  @Query("SELECT a FROM ATable a LEFT JOIN FETCH a.beovi b")
  List<ATable> findAll();

  // Javlja grešku: org.hibernate.loader.MultipleBagFetchException: cannot simultaneously fetch multiple bags: [hr.senji.hibernate.demo.three.tables.ATable.beovi, hr.senji.hibernate.demo.three.tables.BTable.ceovi]
//  @Query("SELECT a FROM ATable a LEFT JOIN FETCH a.beovi b LEFT JOIN FETCH b.ceovi c")
//  List<ATable> findAllNotWorking();
}
