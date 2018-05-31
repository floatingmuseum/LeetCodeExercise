package floatingmuseum.leetcodeexercise.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.chad.library.adapter.base.BaseQuickAdapter
import floatingmuseum.leetcodeexercise.DataSource
import floatingmuseum.leetcodeexercise.R
import floatingmuseum.leetcodeexercise.entity.ProblemItm
import org.jetbrains.anko.browse
import org.jetbrains.anko.find

/**
 * Created by Floatingmuseum on 2018/5/30.
 */
class ProblemListActivity : AppCompatActivity() {

    private lateinit var rvProblems: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_problem_list)

        val dataType = intent.getIntExtra(DataSource.DATA_TYPE_KEY,DataSource.DATA_TYPE_EASY)
        initView(DataSource.getData(dataType))
    }

    private fun initView(data:MutableList<ProblemItm>) {
        rvProblems = find(R.id.rv_problems)
        rvProblems.layoutManager = LinearLayoutManager(this)
        val adapter = ProblemListAdapter(data)
        rvProblems.adapter = adapter

        adapter.onItemClickListener = BaseQuickAdapter.OnItemClickListener { _, _, position ->
            data[position]
        }

        adapter.onItemChildClickListener = BaseQuickAdapter.OnItemChildClickListener { _, v, position ->
            if (v.id == R.id.tv_problem_url) {
                browse(data[position].url)
            }
        }
    }
}