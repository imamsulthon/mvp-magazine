package taiwan.no1.accounting.utilies

import rx.Scheduler
import rx.android.schedulers.AndroidSchedulers
import taiwan.no1.accounting.domain.executor.PostExecutionThread
import javax.inject.Inject
import javax.inject.Singleton

/**
 *
 * @author  jieyi
 * @version 0.0.1
 * @since   2016/12/06
 */

@Singleton
class UIThread @Inject constructor(): PostExecutionThread {
    override fun getScheduler(): Scheduler {
        return AndroidSchedulers.mainThread()
    }
}