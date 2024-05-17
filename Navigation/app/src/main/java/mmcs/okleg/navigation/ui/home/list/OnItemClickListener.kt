package mmcs.okleg.navigation.ui.home.list

interface OnItemClickListener {
    /**
     * When the user clicks on each row this method will be invoked.
     */
    fun onUpdate(position: Int, model: Task){}

    /**
     * when the user clicks on delete icon this method will be invoked to remove item at position.
     */
    fun onDelete(model: Task){}
}