package lldQuestions.stackOverflowDesign;

public interface Votable {
    void vote(User user, int value);
    int getVoteCnt();
}
