package hr.senji.hibernate.demo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

  List<Post> fetchWithDetails();
}
