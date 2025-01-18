package lldQuestions.linkedInDesign;

import java.util.List;

public class Profile {
    private String profilePic;
    private String headline;
    private String summary;
    private List<Experience>experiences;
    private List<Education>educations;
    private List<Skill>skills;

    public void setHeadline(String headline){
        this.headline=headline;
    }

    public void setSummary(String summary){
        this.summary=summary;
    }

    public String getHeadline(){
        return headline;
    }
}
