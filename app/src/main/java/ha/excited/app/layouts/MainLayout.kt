package ha.excited.app.layouts

import android.app.Activity
import android.view.View
import ha.excited.app.R
import ha.excited.app.databinding.MainBinding
import ha.excited.baselayout.BaseLayoutFactory
import kotlinx.android.synthetic.main.layout_title_bar.view.*

class MainLayout(val activity: Activity) : BaseLayoutFactory.DataBinding<MainBinding>(R.layout.main) {
    override fun onViewCreated(view: View, dataBinding: MainBinding) {
        TitleBarLayout(activity, "Welcome").inflate(view.layoutTitleBar)
    }
}