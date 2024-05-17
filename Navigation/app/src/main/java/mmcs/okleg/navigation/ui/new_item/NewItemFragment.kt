package mmcs.okleg.navigation.ui.new_item

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import mmcs.okleg.navigation.R
import mmcs.okleg.navigation.databinding.FragmentNewItemBinding
import mmcs.okleg.navigation.ui.home.HomeViewModel
import mmcs.okleg.navigation.ui.home.list.CustomAdapter
import mmcs.okleg.navigation.ui.home.list.Task

class NewItemFragment : Fragment() {

    private var _binding: FragmentNewItemBinding? = null
    private val viewModel: HomeViewModel by activityViewModels()
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val newItemViewModel =
            ViewModelProvider(this).get(NewItemViewModel::class.java)


        _binding = FragmentNewItemBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.newSaveButton.setOnClickListener{
            val todoTitle = binding.newTaskTitle.text.toString()
            val todoText = binding.newTaskText.text.toString()
            if(todoTitle.isNotEmpty()) {
                val todo = Task(id= viewModel.getNextItemId(), title = todoTitle, text = todoText)
                viewModel.addTask(this.requireView(),todo)
            }
            findNavController().navigate(R.id.navigation_home)
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}