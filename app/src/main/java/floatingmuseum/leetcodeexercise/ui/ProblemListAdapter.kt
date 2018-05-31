package floatingmuseum.leetcodeexercise.ui

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import floatingmuseum.leetcodeexercise.R
import floatingmuseum.leetcodeexercise.entity.ProblemItm

/**
 * Created by Floatingmuseum on 2018/5/30.
 */
class ProblemListAdapter(data: List<ProblemItm>) : BaseQuickAdapter<ProblemItm, BaseViewHolder>(R.layout.item_problem_list, data) {

    override fun convert(helper: BaseViewHolder, item: ProblemItm) {
        helper.setText(R.id.tv_problem_title, item.id.toString() + ":" + item.title)
                .setText(R.id.tv_status, if (item.status) "PASSED" else "TRYING")
                .setTextColor(R.id.tv_status, if (item.status) mContext.resources.getColor(android.R.color.holo_green_light) else mContext.resources.getColor(android.R.color.holo_red_light))
                .setText(R.id.tv_desc, item.desc)
                .addOnClickListener(R.id.tv_problem_url)
    }
}