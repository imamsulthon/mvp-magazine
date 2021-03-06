package taiwan.no1.app.data.mapper.movie;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collections;

import javax.inject.Inject;
import javax.inject.Singleton;

import taiwan.no1.app.data.entities.movie.MovieBriefEntity;
import taiwan.no1.app.domain.mapper.IBeanMapper;
import taiwan.no1.app.mvp.models.movie.MovieBriefModel;

/**
 * Base mapper class used to transform between {@link MovieBriefModel} (in the kotlin layer) and
 * {@link MovieBriefEntity} (in the data layer).
 *
 * @author Jieyi
 * @since 12/28/16
 */

@Singleton
public class MovieBriefMapper implements IBeanMapper<MovieBriefModel, MovieBriefEntity> {
    @Inject
    public MovieBriefMapper() {
    }

    /**
     * Implement {@inheritDoc}
     */
    @NonNull
    @Override
    @Deprecated
    public MovieBriefEntity transformFrom(@NonNull MovieBriefModel model) {
        throw new Error("No-op");
    }

    /**
     * Implement {@inheritDoc}
     */
    @NonNull
    @Override
    public MovieBriefModel transformTo(@NonNull MovieBriefEntity entity) {
        // We may not use all of information, then we will remove some redundant information.
        return new MovieBriefModel(entity.getPoster_path(),
                                   entity.isAdult(),
                                   entity.getOverview(),
                                   entity.getRelease_date(),
                                   entity.getId(),
                                   entity.getOriginal_title(),
                                   entity.getOriginal_language(),
                                   entity.getTitle(),
                                   entity.getBackdrop_path(),
                                   entity.getPopularity(),
                                   entity.getVote_count(),
                                   entity.isVideo(),
                                   entity.getVote_average(),
                                   true,
                                   null != entity.getGenre_ids() ?
                                           new ArrayList<>(entity.getGenre_ids()) :
                                           Collections.emptyList());
    }
}
