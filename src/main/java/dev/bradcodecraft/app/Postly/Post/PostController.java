package dev.bradcodecraft.app.Postly.Post;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/posts")
class PostController {
  private PostRepository postRepository;

  public PostController(PostRepository postRepository) {
    this.postRepository = postRepository;
  }

  // CREATE

  // READ
  @GetMapping("")
  public List<Post> readAll() {
    return this.postRepository.readAll();
  }

  // UPDATE

  // DELETE
}
