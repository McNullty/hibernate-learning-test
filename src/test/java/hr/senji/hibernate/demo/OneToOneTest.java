package hr.senji.hibernate.demo;

import java.util.List;

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
  public void testOneToOneMappingFetchWithoutDetails() {

    log.info("Fetching all posts");
    // ovo fetcha samo postove
    List<Post> allPosts = postRepository.findAll();
    Assert.assertEquals(3, allPosts.size());
    log.info("Fetching all posts... done");

    for (Post p : allPosts) {
      log.info("Logging post details");
      // p.getDetails trigerira fetch details
      log.info("Post detail: " + p.getDetails());
      if (p.getId().equals(1L)) {
        Assert.assertFalse(p.getDetails().isEmpty());
        Assert.assertEquals("Author 1", p.getDetails().stream().findFirst().get().getCreatedBy());
      } else if (p.getId().equals(2L)) {
        Assert.assertFalse(p.getDetails().isEmpty());
      } else if (p.getId().equals(3L)) {
        Assert.assertTrue(p.getDetails().isEmpty());
      }
    }
  }

  @Test
  public void testOneToOneMappingFetchWithDetails() {

    log.info("Fetching all posts");
    // ovo fetcha sve podatke od jednom (i post i post_detail)
    List<Post> allPosts = postRepository.fetchWithDetails();
    Assert.assertEquals(3, allPosts.size());
    log.info("Fetching all posts... done");

    for (Post p : allPosts) {
      log.info("Logging post details");
      log.info("Post detail: " + p.getDetails());
      if (p.getId().equals(1L)) {
        Assert.assertFalse(p.getDetails().isEmpty());
        Assert.assertEquals("Author 1", p.getDetails().stream().findFirst().get().getCreatedBy());
      } else if (p.getId().equals(2L)) {
        Assert.assertFalse(p.getDetails().isEmpty());
      } else if (p.getId().equals(3L)) {
        Assert.assertTrue(p.getDetails().isEmpty());
      }
    }
  }

}
