package mmcs.okleg.navigation.ui.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import mmcs.okleg.navigation.R
import mmcs.okleg.navigation.databinding.FragmentHomeBinding
import mmcs.okleg.navigation.databinding.TodoListItemBinding
import mmcs.okleg.navigation.ui.home.list.CustomAdapter

class HomeFragment : Fragment(R.layout.fragment_home) {
    private var _binding: FragmentHomeBinding? = null
    private var _bindingItem: TodoListItemBinding? = null

    private lateinit var recyclerView : RecyclerView
    private lateinit var customAdapter: CustomAdapter
    private val viewModel: HomeViewModel by activityViewModels()


    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val bindingItem get() = _bindingItem!!

    private fun changeInfo(){
        val total = viewModel.getItemCount()
        val checked = viewModel.getItemCheckedCount()
        activity?.findViewById<TextView>(R.id.tvTotal)?.text = total.toString()
        activity?.findViewById<TextView>(R.id.tvChecked)?.text = checked.toString()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        _bindingItem = TodoListItemBinding.inflate(inflater, container, false)

        val root: View = binding.root

        customAdapter = viewModel.getCustomAdapter() // CustomAdapter(viewModel. .value!!)// ????????? !!
        recyclerView = root.findViewById(R.id.recycler_view)

        val layoutManager = LinearLayoutManager(this.context)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = customAdapter

        binding.addButton.setOnClickListener{
            findNavController().navigate(R.id.navigation_new_item)
        }

        return root
    }

    /*override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.dataSet.observe(viewLifecycleOwner, Observer { list ->
            // Update the list UI.
            customAdapter = CustomAdapter(list)
            recyclerView.adapter=customAdapter
        })
    }*/

    @SuppressLint("NotifyDataSetChanged")
    override fun onResume() {
        super.onResume()
        changeInfo()
        customAdapter.notifyDataSetChanged()
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null

    }
}