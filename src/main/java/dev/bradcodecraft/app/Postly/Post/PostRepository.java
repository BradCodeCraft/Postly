package dev.bradcodecraft.app.Postly.Post;

import java.util.List;

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

  // UPDATE

  // DELETE
}
