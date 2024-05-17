package mmcs.okleg.navigation.ui.home.list

import android.annotation.SuppressLint
import android.graphics.Paint.STRIKE_THRU_TEXT_FLAG
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import mmcs.okleg.navigation.R


class CustomAdapter(
    //private val mContext: Context,
    private val dataSet: MutableList<Task>) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    fun getDataSet() = dataSet

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
       val taskDelete = view.findViewById<Button>(R.id.delete_button_item)
        val taskTitle = view.findViewById<TextView>(R.id.taskTitleItem)
        val taskText = view.findViewById<TextView>(R.id.taskTextDetails)
        val checkTask = view.findViewById<CheckBox>(R.id.checkTaskItem)
    }

    // Create new views (invoked by the layout manager)
    @SuppressLint("NotifyDataSetChanged")
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val inflater = LayoutInflater.from(viewGroup.context)
        val view =  inflater.inflate(R.layout.todo_list_item, viewGroup, false)
        val holder = ViewHolder(view)
        // item view is the root view for each row
        holder.itemView.setOnClickListener {
            val position = holder.adapterPosition
            val args = Bundle()
            args.putInt("id",position)
            it.findNavController().navigate(R.id.navigation_details,args)
        }
        // to delete the item in recycler view
        holder.taskDelete.setOnClickListener {
            val position = holder.adapterPosition
            dataSet.removeAt(position)
            notifyItemRemoved(position)
        }
        return holder
    }
    private fun toggleStrikeThrough(tvTodoTitle: TextView, isChecked: Boolean) {
        if(isChecked) {
            tvTodoTitle.paintFlags = tvTodoTitle.paintFlags or STRIKE_THRU_TEXT_FLAG
        } else {
            tvTodoTitle.paintFlags = tvTodoTitle.paintFlags and STRIKE_THRU_TEXT_FLAG.inv()
        }
    }
    // Replace the contents of a view (invoked by the layout manager)
    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val curTodo = dataSet[position]
        viewHolder.itemView.apply {
            viewHolder.taskTitle.text = curTodo.title
            viewHolder.checkTask.isChecked = curTodo.isChecked
            toggleStrikeThrough(viewHolder.taskTitle, curTodo.isChecked)
            viewHolder.checkTask.setOnCheckedChangeListener { _, isChecked ->
                toggleStrikeThrough(viewHolder.taskTitle, isChecked)
                curTodo.isChecked = !curTodo.isChecked
            }
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}
