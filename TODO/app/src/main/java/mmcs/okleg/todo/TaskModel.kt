package mmcs.okleg.todo

import android.widget.CheckBox

data class TaskModel (
    var id: Int = 0,
    var check: CheckBox,
    var title: String="",
    var text: String = ""
)