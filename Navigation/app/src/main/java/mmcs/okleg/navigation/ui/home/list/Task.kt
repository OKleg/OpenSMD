package mmcs.okleg.navigation.ui.home.list

data class Task (
    var id: Int = 0,
    var isChecked: Boolean = false,
    var title: String="",
    var text: String = ""
)