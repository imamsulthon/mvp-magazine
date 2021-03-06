package taiwan.no1.app.mvp.presenters

import taiwan.no1.app.mvp.views.IView

/**
 * Interface representing a Presenter in a model view presenter (MVP) pattern.
 *
 * @author  Jieyi
 * @since   12/6/16
 */

interface IPresenter<in V: IView> {
    /**
     * Initial method.
     *
     * @param view [IView]
     */
    fun init(view: V)

    /**
     * Method that control the lifecycle of the view. It should be called in the view's (Activity or Fragment)
     * onResume() method.
     */
    fun resume()

    /**
     * Method that control the lifecycle of the view. It should be called in the view's (Activity or Fragment)
     * onPause() method.
     */
    fun pause()

    /**
     * Method that control the lifecycle of the view. It should be called in the view's (Activity or Fragment)
     * onDestroy() method.
     */
    fun destroy()
}