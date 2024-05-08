package mmcs.okleg.todo.ui.home
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import mmcs.okleg.todo.CustomAdapter
import mmcs.okleg.todo.R
import mmcs.okleg.todo.TaskModel
import mmcs.okleg.todo.databinding.TodoListBinding



// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
/**
 * A simple [Fragment] subclass.
 * Use the [ListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListFragment() : Fragment(R.layout.todo_list) {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var binding: TodoListBinding
    private lateinit var recyclerView : RecyclerView

    lateinit var addBut: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = TodoListBinding.inflate(layoutInflater)

        binding.root.findViewById<Button>(R.id.add_button).setText("0")
        binding.addButton.setOnClickListener{
            binding.addButton.setText("-")
        }
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }


    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ListFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ListFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recycler_view)
        val layoutManager = LinearLayoutManager(this.context)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        //
        //addBtn = view.findViewById(R.id.add_button)
        view.findNavController()
        //val navController = findNavController(this, R.id.nav_host_fragment_activity_main)


    }
/*
    private fun replaceFragment(fragment: Fragment){
        val fragmentManager = parentFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.nav_host_fragment_activity_main,fragment)
        fragmentTransaction.commit()
    }
    private fun fillList(): ArrayList<TaskModel> {
        val data = ArrayList<TaskModel>()
        (0..10).forEach { i -> data.add(TaskModel(i, CheckBox(this.context), "Some Text Task")) }
        return data
    }*/
}