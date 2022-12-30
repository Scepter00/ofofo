package africa.semicolon.ofofo.dtos.requests;

import lombok.*;

public class CreateCommentRequest {
    private int postId;
    private String commentName;
    private String comment;
}
