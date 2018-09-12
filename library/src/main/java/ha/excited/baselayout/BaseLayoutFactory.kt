package ha.excited.baselayout

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.ViewGroup

object BaseLayoutFactory {
    abstract class View(private val viewGenerator: (inflater: LayoutInflater, container: ViewGroup?) -> android.view.View) : BaseLayout() {

        constructor(@LayoutRes layoutResId: Int, attachToRoot: Boolean = false) :
                this({ layoutInflater, container -> layoutInflater.inflate(layoutResId, container, attachToRoot) })

        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?) = viewGenerator.invoke(inflater, container)
    }

    abstract class DataBinding<T : ViewDataBinding>(private val dataBindingGenerator: (inflater: LayoutInflater, container: ViewGroup?) -> T) : BaseLayout() {

        constructor(@LayoutRes layoutResId: Int, attachToRoot: Boolean = false) :
                this({ layoutInflater, container -> DataBindingUtil.inflate(layoutInflater, layoutResId, container, attachToRoot) })

        protected lateinit var dataBinding: T private set

        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?) =
                dataBindingGenerator.invoke(inflater, container).let {
                    dataBinding = it
                    it.root
                }

        override fun onViewCreated(view: android.view.View) = onViewCreated(view, dataBinding)

        abstract fun onViewCreated(view: android.view.View, dataBinding: T)
    }
}