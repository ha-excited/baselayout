package ha.excited.baselayout

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

abstract class BaseLayout {
    companion object {
        val defaultInflaterInterceptor = { layoutInflater: LayoutInflater -> layoutInflater }
        var inflaterInterceptor = defaultInflaterInterceptor

        fun inflaterInterceptor(layoutInflater: LayoutInflater) = inflaterInterceptor.invoke(layoutInflater)

        val defaultInflaterFactory = fun(context: Context) = LayoutInflater.from(context)!!
        var inflaterFactory = defaultInflaterFactory

        fun inflaterFactory(context: Context) = inflaterFactory.invoke(context)
    }

    private var _view: View? = null
    protected val view: View get () = _view!!

    protected fun isInit() = _view != null

    private fun initView(targetView: View) {
        _view = targetView
        onViewCreated(targetView)
    }

    fun inflate(inflater: LayoutInflater, container: ViewGroup? = null): View {
        if (!isInit()) initView(onCreateView(inflaterInterceptor(inflater), container))
        return view
    }

    fun inflate(context: Context, container: ViewGroup? = null) = inflate(inflaterFactory(context), container)
    fun inflate(container: ViewGroup) = inflate(container.context, container)

    protected abstract fun onCreateView(inflater: LayoutInflater, container: ViewGroup?): View
    protected abstract fun onViewCreated(view: View)
}