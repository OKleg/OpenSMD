package mmcs.okleg.todo

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.Stack


class MainActivity : AppCompatActivity() {
//    private lateinit var addTask: Button
//    private lateinit var deleteTask: Button
//    private lateinit var checkTask: CheckBox

    private lateinit var listAdapter: CustomAdapter

    private var modelToBeUpdated: Stack<TaskModel> = Stack()

//    private val mOnProductClickListener = object : OnItemClickListener {
//        override fun onUpdate(position: Int, model: TaskModel
//) {
//
//            // store this model that we want to update
//            // we will .pop() it when we want to update
//            // the item in the adapter
//            modelToBeUpdated.add(model)
//
//            // set the value of the clicked item in the edit text
//            //checkTask.SetText(model.title)
//        }
//
//        override fun onDelete(model: TaskModel) {
//            // just remove the item from list
//            listAdapter.removeItem(model)
//        }
//    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //addTask = findViewById(R.id.add_button)
        //deleteTask = findViewById(R.id.recycler_view.taskDelete)
       // checkTask = findViewById(R.id.recycler_view.checkTask)

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        //recyclerView.adapter = CustomAdapter(fillList())

//        val button = findViewById<Button>(R.id.add_button)
//        button.setOnClickListener {
//            // Code here executes on main thread after user presses button
//        }

    }

    private fun fillList(): ArrayList<TaskModel> {
        val data = ArrayList<TaskModel>()
        (0..5).forEach { i -> data.add(TaskModel(i,"$i task", "Some Text Task")) }
        return data
    }
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//    }
}