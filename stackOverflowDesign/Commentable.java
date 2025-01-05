package lldQuestions.stackOverflowDesign;

import java.util.List;

public interface Commentable {
    void addComment(Comment Comment);
    List<Comment> getComments();
}
