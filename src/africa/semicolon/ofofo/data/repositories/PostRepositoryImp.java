package africa.semicolon.ofofo.data.repositories;

import africa.semicolon.ofofo.models.Post;

import java.util.ArrayList;
import java.util.List;

public class PostRepositoryImp implements PostRepository {
    private final List<Post> postDb = new ArrayList<>();
    @Override
    public Post save(Post post) {
        if (post.getId()!=0) update(post);
        else {
            post.setId(postDb.size() + 1);
            postDb.add(post);
        }
        return post;
    }

    private  void update(Post post) {
        //Fine the Original
        Post savedPost = findById(post.getId());
        savedPost.setTitle(post.getTitle());
        savedPost.setBody(post.getBody());
    }
    @Override
    public long count() {
        return postDb.size();
    }

    @Override
    public Post findById(int id) {
        for (Post post: postDb) if (post.getId()==id)  {return  post ; }
        return null;
    }

    @Override
    public List<Post> findAll() {
        return postDb;
    }

    @Override
    public void delete(Post post) {

    }

    @Override
    public void delete(int id) {
        postDb.remove(id-1);
    }
}
