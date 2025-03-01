package dev.bradcodecraft.app.Postly.Post;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/posts")
class PostController {
  private PostRepository postRepository;

  public PostController(PostRepository postRepository) {
    this.postRepository = postRepository;
  }

  // CREATE
  @PostMapping("")
  public void create(@RequestBody Post post) {
    this.postRepository.create(post);
  }

  // READ
  @GetMapping("")
  public List<Post> readAll() {
    return this.postRepository.readAll();
  }

  @GetMapping("/{postId}")
  public Post readById(@PathVariable Integer postId) {
    Optional<Post> temporaryPost = this.postRepository.readById(postId);

    if (temporaryPost.isEmpty()) {
      throw new PostNotFoundException();
    }

    return temporaryPost.get();
  }

  // UPDATE

  // DELETE
}
