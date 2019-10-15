package hr.senji.hibernate.demo;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class OneToOneTest {

  private static final Logger log = LoggerFactory.getLogger(OneToOneTest.class);

  @Autowired
  private TestEntityManager entityManager;

  @Autowired
  private PostRepository postRepository;

  @Autowired
  private PostDetailsRepository postDetailsRepository;

  @Test
  public void testOneToOneMapping() {

    log.info("Fetching all posts");
    List<Post> allPosts = postRepository.findAll();
    log.info("Fetching all posts... done");

    for (Post p : allPosts) {
      log.info("Logging post details");
      log.info("Post detail: " + p.getDetails());
      if (p.getId().equals(1L)) {
        Assert.assertNotNull(p.getDetails());
      } else if (p.getId().equals(2L)) {
        Assert.assertNotNull(p.getDetails());
      } else if (p.getId().equals(3L)) {
        Assert.assertNull(p.getDetails());
      }
    }
  }

}
