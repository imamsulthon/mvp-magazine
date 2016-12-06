package taiwan.no1.accounting.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import butterknife.bindView
import com.playone.mobile.internal.components.UseCaseComponent
import taiwan.no1.accounting.R
import taiwan.no1.accounting.internal.di.annotations.PerActivity
import taiwan.no1.accounting.mvp.views.MainViewable
import taiwan.no1.accounting.ui.presenters.MainPresenter
import javax.inject.Inject

/**
 * @author Jieyi Wu
 * @version 0.0.1
 * @since 12/6/16
 */

@PerActivity
class MainFragment: BaseFragment(), MainViewable {
    companion object {
        @JvmStatic fun newInstance() = MainFragment()
    }

    @Inject
    lateinit var presenter: MainPresenter

    private val tvShow: TextView by bindView<TextView>(R.id.tv_show)

    private var rootView: View? = null

    //region Fragment lifecycle
    override fun onAttach(context: Context?) {
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        this.getComponent(UseCaseComponent::class.java, null).inject(MainFragment@ this)
    }

    //    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        val rootView = inflate(R.layout.fragment_playone_create_team, inflater, container)
//    }
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // FIXED: https://www.zybuluo.com/kimo/note/255244
        if (null == rootView)
            rootView = inflater?.inflate(R.layout.fragment_main, null)
        val parent: ViewGroup? = rootView?.parent as ViewGroup?
        parent?.removeView(rootView)

        this.presenter.setView(MainFragment@ this)
        this.presenter.init()
        return rootView
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        this.tvShow.text = "WTF!!!!"
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
    //endregion

    //region Presenter implements
    override fun showLoading() {
    }

    override fun hideLoading() {
    }

    override fun showRetry() {
    }

    override fun hideRetry() {
    }

    override fun showError(message: String) {
    }

    override fun context(): Context {
        return this.activity.applicationContext
    }
    //endregion
}
