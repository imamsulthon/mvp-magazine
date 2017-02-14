package taiwan.no1.app.mvp.presenters

import com.hwangjr.rxbus.RxBus
import com.touchin.constant.RxbusTag
import rx.lang.kotlin.subscriber
import taiwan.no1.app.api.config.MovieDBConfig
import taiwan.no1.app.constant.Constant
import taiwan.no1.app.domain.usecase.CastDetail
import taiwan.no1.app.mvp.contracts.CastDetailContract
import taiwan.no1.app.mvp.models.cast.CastDetailModel
import taiwan.no1.app.ui.fragments.MovieGalleryFragment
import taiwan.no1.app.ui.fragments.ViewPagerMainCtrlFragment.Factory.NAVIGATOR_ARG_FRAGMENT
import taiwan.no1.app.ui.fragments.ViewPagerMainCtrlFragment.Factory.NAVIGATOR_ARG_TAG
import taiwan.no1.app.utilies.AppLog
import kotlin.comparisons.compareBy

/**
 *
 * @author  Jieyi
 * @since   1/1/17
 */
class CastDetailPresenter constructor(val castDetailCase: CastDetail):
        BasePresenter<CastDetailContract.View>(), CastDetailContract.Presenter {
    private var castDetailModel: CastDetailModel? = null
    //region Subscribers
    private val castDetailSub = subscriber<CastDetailModel>().onError {
        AppLog.e(it.message)
        AppLog.e(it)
    }.onNext {
        this.castDetailModel = it

        this.castDetailModel?.let {
            val posterUrl: String = it.images?.let { it.profiles?.let { if (it.size > 1) it[1].file_path else it[0].file_path } } ?: ""

            this.view.showCastPoster(MovieDBConfig.BASE_IMAGE_URL + posterUrl)
            this.view.showCastProPic(MovieDBConfig.BASE_IMAGE_URL + it.profile_path)
            this.view.showCastBase(Constant.Gender.values()[it.gender].jobName, it.name ?: "")
            this.view.showCastDetail(it.biography ?: "",
                    it.birthday ?: "",
                    it.place_of_birth ?: "",
                    it.homepage ?: "",
                    it.deathday ?: "")
            this.view.showRelatedMovie(it.combined_credits?.cast?.filter { it.media_type == "movie" }?.
                    sortedWith(compareBy({ it.release_date }))?.reversed() ?: emptyList())
        }
    }
    //endregion

    //region Presenter implementation
    override fun init(view: CastDetailContract.View) {
        super.init(view)
    }

    override fun requestCastDetail(castId: Int) {
        val request = CastDetail.Requests(castId)
        request.fragmentLifecycle = this.view.getLifecycle()
        this.castDetailCase.execute(request, this.castDetailSub)
    }

    override fun enterToGallery(fromFragment: Int) {
        RxBus.get().post(RxbusTag.FRAGMENT_CHILD_NAVIGATOR, hashMapOf(
                Pair(NAVIGATOR_ARG_FRAGMENT,
                        MovieGalleryFragment.newInstance(this.castDetailModel?.images?.profiles ?: emptyList())),
                Pair(NAVIGATOR_ARG_TAG, fromFragment)))
    }
    //endregion
}
