package taiwan.no1.app.mvp.models

/**
 * @author Jieyi
 * *
 * @version 0.0.1
 * *
 * @since 12/29/16
 */

data class CastDetalModel(
        val isAdult: Boolean = false,
        val biography: String? = null,
        val birthday: String? = null,
        val deathday: String? = null,
        val gender: Int = 0,
        val homepage: String? = null,
        val id: Int = 0,
        val imdb_id: String? = null,
        val name: String? = null,
        val place_of_birth: String? = null,
        val popularity: Double = 0.toDouble(),
        val profile_path: String? = null,
        val also_known_as: List<String>? = null)