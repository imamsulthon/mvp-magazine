package taiwan.no1.app.ui.adapter.viewholder

import android.support.v7.widget.CardView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import butterknife.bindView
import com.hwangjr.rxbus.RxBus
import com.touchin.constant.RxbusTag
import taiwan.no1.app.R
import taiwan.no1.app.api.config.TMDBConfig
import taiwan.no1.app.mvp.models.CreditsInFilmModel
import taiwan.no1.app.ui.adapter.CommonRecyclerAdapter
import taiwan.no1.app.ui.fragments.MovieDetailFragment
import taiwan.no1.app.ui.fragments.ViewPagerMainCtrlFragment.Factory.NAVIGATOR_ARG_FRAGMENT
import taiwan.no1.app.ui.fragments.ViewPagerMainCtrlFragment.Factory.NAVIGATOR_ARG_TAG
import taiwan.no1.app.ui.listeners.GlideResizeTargetListener
import taiwan.no1.app.utilies.ImageLoader.IImageLoader
import taiwan.no1.app.utilies.ViewUtils
import javax.inject.Inject

/**
 * @author  Jieyi
 * @since   1/7/17
 */

class MovieCastRelatedViewHolder(view: View): BaseViewHolder(view) {
    // FIXME: 1/19/17 not be injected.
    @Inject
    lateinit var imageLoader: IImageLoader

    val item by bindView<CardView>(R.id.item_cast)
    val ivPoster by bindView<ImageView>(R.id.iv_cast)
    val tvReleaseDate by bindView<TextView>(R.id.tv_character)
    val tvMovieTitle by bindView<TextView>(R.id.tv_name)

    override fun initView(model: Any, position: Int, adapter: CommonRecyclerAdapter) {
        (model as CreditsInFilmModel.CastInFilmBean).let {
            ViewUtils.loadBitmapToView(this.mContext.applicationContext,
                    TMDBConfig.BASE_IMAGE_URL + it.poster_path,
                    listener = GlideResizeTargetListener(this.ivPoster, this.item))
            this.tvReleaseDate.text = it.release_date
            this.tvMovieTitle.text = it.title
            this.item.setOnClickListener {
                RxBus.get().post(RxbusTag.FRAGMENT_CHILD_NAVIGATOR, hashMapOf(
                        Pair(NAVIGATOR_ARG_FRAGMENT,
                                MovieDetailFragment.newInstance(model.id.toString(), adapter.fragmentTag)),
                        Pair(NAVIGATOR_ARG_TAG, adapter.fragmentTag)))
            }
        }
    }
}