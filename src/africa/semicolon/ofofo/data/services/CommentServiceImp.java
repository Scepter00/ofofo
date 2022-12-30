package africa.semicolon.ofofo.data.services;

import africa.semicolon.ofofo.data.repositories.CommentRepository;
import africa.semicolon.ofofo.data.repositories.CommentRepositoryImp;
import africa.semicolon.ofofo.dtos.requests.CreateCommentRequest;
import africa.semicolon.ofofo.models.Comment;

import java.util.List;

public class CommentServiceImp implements CommentService{
    private CommentRepository commentRepository = new CommentRepositoryImp();
    private PostService postService = new PostServiceImp();
    @Override
    public void creteComment(CreateCommentRequest createCommentRequest) {
        Comment comment = new Comment();
        comment.setComment(createCommentRequest.getCommet());
        comment.setCommenterName(createCommentRequest.getCommenterName());
        comment savedComment = commentRepository.save(comment);
        postService.addComment(createCommentRequest.getPostId(), savedComment);
    }

    @Override
    public List<Comment> viewAll() {
        return commentRepository.findAll();
    }
}
