package mmcs.okleg.todo

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class CustomAdapter(
    //private val mContext: Context,
    private val itemClickListener: OnItemClickListener,
    private val dataSet: ArrayList<TaskModel> = ArrayList()) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        // Define click listener for the ViewHolder's View
        var checkTask: CheckBox = view.findViewById(R.id.checkTask)
        var titleTask: TextView = view.findViewById(R.id.titleTask)
        var taskDelete: Button = view.findViewById(R.id.taskDelete)
        //var textTask: Button = view.findViewById(R.id.taskDelete)

    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val inflater = LayoutInflater.from(viewGroup.context)
        val view =  inflater.inflate(R.layout.text_row_item, viewGroup, false)
        val holder = ViewHolder(view)
        // item view is the root view for each row
        holder.itemView.setOnClickListener {
            // adapterPosition give the actual position of the item in the RecyclerView
            val position = holder.bindingAdapterPosition
            val model = dataSet[position]
            itemClickListener.onUpdate(position, model)
        }
        // to delete the item in recycler view
        holder.taskDelete.setOnClickListener {
            val position = holder.bindingAdapterPosition
            val model = dataSet[position]
            itemClickListener.onDelete(model)
        }
        return holder
    }

    // Replace the contents of a view (invoked by the layout manager)
    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.checkTask = dataSet[position].check
        viewHolder.titleTask.text = dataSet[position].title
        //viewHolder.
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size
    fun addItem(model: TaskModel) {
        dataSet.add(model)
        notifyItemInserted(dataSet.size)
    }
    fun updateItem(model: TaskModel?) {

        if (model == null) return // we cannot update the value because it is null

        for (item in dataSet) {
            // search by id
            if (item.id == model.id) {
                val position = dataSet.indexOf(model)
                dataSet[position] = model
                notifyItemChanged(position)
                break // we don't need to continue any more iterations
            }
        }
    }
    fun removeItem(model: TaskModel) {
        val position = dataSet.indexOf(model)
        dataSet.remove(model)
        notifyItemRemoved(position)
    }
    fun getNextItemId(): Int {
        var id = 1
        if (dataSet.isNotEmpty()) {
            // .last is equivalent to .size() - 1
            // we want to add 1 to that id and return it
            id = dataSet.last().id + 1
        }
        return id
    }
}
