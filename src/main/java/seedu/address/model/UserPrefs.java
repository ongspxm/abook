package seedu.address.model;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

import seedu.address.commons.core.GuiSettings;

/**
 * Represents User's preferences.
 */
public class UserPrefs {

    private GuiSettings guiSettings;
    private UserParticulars userParticulars;
    private Path entryBookFilePath = Paths.get("data" , "resume-data.xml");

    public UserPrefs() {
        setGuiSettings(500, 500, 0, 0);
        userParticulars = new UserParticulars();
    }

    public GuiSettings getGuiSettings() {
        return guiSettings == null ? new GuiSettings() : guiSettings;
    }

    public void updateLastUsedGuiSetting(GuiSettings guiSettings) {
        this.guiSettings = guiSettings;
    }

    public void setGuiSettings(double width, double height, int x, int y) {
        guiSettings = new GuiSettings(width, height, x, y);
    }

    public UserParticulars getUserParticulars() {
        return userParticulars;
    }

    public void setUserParticulars(UserParticulars userParticulars) {
        this.userParticulars = userParticulars;
    }

    public Path getEntryBookFilePath() {
        return entryBookFilePath;
    }

    public void setEntryBookFilePath(Path entryBookFilePath) {
        this.entryBookFilePath = entryBookFilePath;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof UserPrefs)) { //this handles null as well.
            return false;
        }

        UserPrefs o = (UserPrefs) other;

        return Objects.equals(guiSettings, o.guiSettings)
                && Objects.equals(userParticulars, o.userParticulars)
                && Objects.equals(entryBookFilePath, o.entryBookFilePath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(guiSettings, userParticulars, entryBookFilePath);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Gui Settings : " + guiSettings.toString());
        sb.append("\nUser particulars : " + userParticulars.toString());
        sb.append("\nLocal data file location : " + entryBookFilePath);
        return sb.toString();
    }

}
