package dev.bradcodecraft.app.Postly.Post;

import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

@Repository
class PostRepository {
  private JdbcClient jdbcClient;

  public PostRepository(JdbcClient jdbcClient) {
    this.jdbcClient = jdbcClient;
  }

  // CREATE

  // READ
  public List<Post> readAll() {
    return this.jdbcClient.sql("SELECT * FROM post")
        .query(Post.class)
        .list();
  }

  public Optional<Post> readById(Integer postId) {
    return this.jdbcClient.sql("SELECT * FROM post WHERE post_id = :post_id")
        .param("post_id", postId)
        .query(Post.class)
        .optional();
  }
  // UPDATE

  // DELETE
}
