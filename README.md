# Base-Layout

Layout-based view componentization

Replacement of Android's Fragment

#### Import
```
repositories {
    maven { url 'https://jitpack.io' }
}

...
dependencies {
    implementation 'com.github.ha-excited:baselayout:0.1'
...
}
```

#### Example

MainActivity

```
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(MainLayout(this).inflate(this))
    }
}
```

MainLayout
```
class MainLayout(val activity: Activity) : BaseLayoutFactory.DataBinding<MainBinding>(R.layout.main) {
    override fun onViewCreated(view: View, dataBinding: MainBinding) {
        TitleBarLayout(activity, "Welcome").inflate(view.layoutTitleBar)
    }
}
```

TitleBarLayout
```
class TitleBarLayout(val activity: Activity, var title: String) : BaseLayoutFactory.View(R.layout.title_bar, true) {

    override fun onViewCreated(view: View) {
        view.textViewTitle.text = title
        view.viewLeft.setOnClickListener { activity.finish() }
    }
}
```