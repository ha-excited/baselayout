package ha.excited.app

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import ha.excited.app.layouts.MainLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(MainLayout(this).inflate(this))
    }
}
