package africa.semicolon.ofofo.data.services;

import africa.semicolon.ofofo.data.repositories.PostRepository;
import africa.semicolon.ofofo.data.repositories.PostRepositoryImp;
import africa.semicolon.ofofo.dtos.requests.CreatePostRequest;
import africa.semicolon.ofofo.models.Comment;
import africa.semicolon.ofofo.models.Post;

import java.util.List;

public class PostServiceImp implements PostService {
    private PostRepository postRepository = new PostRepositoryImp();
    @Override
    public void createPost(String title, String body) {
        Post post = new Post();
        post.setBody(body);
        post.setTitle(title);
        postRepository.save(post);
    }

    @Override
    public void updatePost(int id, String title, String body) {

    }

    @Override
    public void deletePost(int id) {

    }

    @Override
    public Post viewPost(int id) {
        return postRepository.findById(id);
    }

    @Override
    public List<Post> viewAllPost() {
        return postRepository.findAll();
    }

    @Override
    public void createPost(CreatePostRequest createPostRequest) {
        Post post = new Post();
        post.setBody(createPostRequest.getBody());
        post.setTitle(createPostRequest.getTitle());
        postRepository.save(post);
    }

    @Override
    public void addComment(int postId, Comment comment) {
        Post savedPost = postRepository.findById(postId);
        savedPost.getComments().add(comment);
        postRepository.save(savedPost);
    }
}