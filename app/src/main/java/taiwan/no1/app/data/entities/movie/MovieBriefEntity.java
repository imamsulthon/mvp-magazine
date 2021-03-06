package taiwan.no1.app.data.entities.movie;

import taiwan.no1.app.data.entities.CommonEntity;

/**
 * A brief movie information from the searching list data class. 
 *
 * @author Jieyi
 * @since 12/31/16
 */

public class MovieBriefEntity extends CommonEntity.FilmBriefEntity {
    private boolean adult;
    private String release_date;
    private String original_title;
    private String title;
    private boolean video;

    //region Getter and Setter
    public boolean isAdult() { return adult;}

    public void setAdult(boolean adult) { this.adult = adult;}

    public String getRelease_date() { return release_date;}

    public void setRelease_date(String release_date) { this.release_date = release_date;}

    public String getOriginal_title() { return original_title;}

    public void setOriginal_title(String original_title) { this.original_title = original_title;}

    public String getTitle() { return title;}

    public void setTitle(String title) { this.title = title;}

    public boolean isVideo() { return video;}

    public void setVideo(boolean video) { this.video = video;}
    //endregion

    @Override
    public String toString() {
        return "MovieBriefEntity{" +
                super.toString() +
                "adult=" + adult +
                ", release_date='" + release_date + '\'' +
                ", original_title='" + original_title + '\'' +
                ", title='" + title + '\'' +
                ", video=" + video +
                '}';
    }
}