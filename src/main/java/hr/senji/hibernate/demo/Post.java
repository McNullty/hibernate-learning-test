package hr.senji.hibernate.demo;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "Post")
@Table(name = "post")
@NamedQuery(name = "Post.fetchWithDetails", query = "select p from Post p left join fetch p.details")
public class Post {

  @Id
  @GeneratedValue
  private Long id;

  private String title;

  @OneToMany(mappedBy = "post", fetch = FetchType.LAZY)
  private Set<PostDetails> details;

  public Long getId() {
    return id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(final String title) {
    this.title = title;
  }

  public Set<PostDetails> getDetails() {
    return details;
  }

  public void setDetails(Set<PostDetails> details) {
    this.details = details;
  }

  @Override
  public String toString() {
    return "Post{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", details=" + details +
            '}';
  }
}