package mmcs.okleg.todo.ui.newItem

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.core.view.size
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import mmcs.okleg.todo.R
import mmcs.okleg.todo.TaskModel
import mmcs.okleg.todo.databinding.NewListItemBinding
import mmcs.okleg.todo.ui.home.ListFragment
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
class NewItemFragment : Fragment(R.layout.new_list_item){
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var binding: NewListItemBinding
    private lateinit var recyclerView : RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = NewListItemBinding.inflate(layoutInflater)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.todo_list, container, false)
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
        binding.saveButton.setOnClickListener{
            //binding.saveButton.setText("onViewCreated")
            addNewItemToList(view,recyclerView)
            replaceFragment(ListFragment())
        }

    }
    private fun replaceFragment(fragment: Fragment){
        val fragmentManager = parentFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.nav_host_fragment_activity_main,fragment)
        fragmentTransaction.commit()
    }
    private fun addNewItemToList (view: View, recyclerView: RecyclerView) {
        val check: CheckBox = view.findViewById(R.id.new_item_check)
        val text: TextView = view.findViewById(R.id.new_item_text)
        val newItem = TaskModel(recyclerView.size + 1, check, text.text.toString())
        //recyclerView.adapter
    }
}