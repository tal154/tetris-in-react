package learn.tetris.models;
import java.util.Objects;
public class About {
    private int aboutId;
    private String firstName;
    private String lastName;
    private String aboutDescription;
    private String git;
    public About() {}

    public About(int aboutId, String firstName, String lastName, String aboutDescription, String git) {
        this.aboutId = aboutId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.aboutDescription = aboutDescription;
        this.git = git;
    }

    public int getAboutId() {
        return aboutId;
    }

    public void setAboutId(int aboutId) {
        this.aboutId = aboutId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAboutDescription() {
        return aboutDescription;
    }

    public void setAboutDescription(String aboutDescription) {
        this.aboutDescription = aboutDescription;
    }

    public String getGit() {
        return git;
    }

    public void setGit(String git) {
        this.git = git;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        About about = (About) o;
        return aboutId == about.aboutId && Objects.equals(firstName, about.firstName) && Objects.equals(lastName, about.lastName) && Objects.equals(aboutDescription, about.aboutDescription) && Objects.equals(git, about.git);
    }

    @Override
    public int hashCode() {
        return Objects.hash(aboutId, firstName, lastName, aboutDescription, git);
    }
}
