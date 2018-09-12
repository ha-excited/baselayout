package ha.excited.app.layouts

import android.app.Activity
import android.view.View
import ha.excited.app.R
import ha.excited.baselayout.BaseLayoutFactory
import kotlinx.android.synthetic.main.title_bar.view.*

class TitleBarLayout(val activity: Activity, var title: String) : BaseLayoutFactory.View(R.layout.title_bar, true) {

    override fun onViewCreated(view: View) {
        view.textViewTitle.text = title
        view.viewLeft.setOnClickListener { activity.finish() }
    }
}