package floatingmuseum.leetcodeexercise

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import floatingmuseum.leetcodeexercise.ui.ProblemListActivity
import org.jetbrains.anko.find
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.startActivity

/**
 * Created by Floatingmuseum on 2018/5/22.
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        find<Button>(R.id.bt_easy).onClick { startActivity<ProblemListActivity>(DataSource.DATA_TYPE_KEY to DataSource.DATA_TYPE_EASY) }
        find<Button>(R.id.bt_medium).onClick { startActivity<ProblemListActivity>(DataSource.DATA_TYPE_KEY to DataSource.DATA_TYPE_MEDIUM) }
        find<Button>(R.id.bt_hard).onClick { startActivity<ProblemListActivity>(DataSource.DATA_TYPE_KEY to DataSource.DATA_TYPE_HARD) }
    }
}