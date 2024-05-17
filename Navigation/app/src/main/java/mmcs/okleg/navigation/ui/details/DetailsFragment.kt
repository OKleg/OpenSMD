package mmcs.okleg.navigation.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import mmcs.okleg.navigation.R
import mmcs.okleg.navigation.databinding.FragmentDetailsBinding
import mmcs.okleg.navigation.ui.home.HomeViewModel
import mmcs.okleg.navigation.ui.home.list.Task

class DetailsFragment : Fragment() {

    private var _binding: FragmentDetailsBinding? = null
    private val viewModel: HomeViewModel by activityViewModels()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val detailsViewModel =
            ViewModelProvider(this).get(DetailsViewModel::class.java)

        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        val root: View = binding.root
        
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val position = arguments?.getInt("id",1)!!
        val task = viewModel.dataSet.value!![position]
        binding.taskTitleDetails.setText(task.title)
        binding.taskTextDetails.setText(task.text)
        binding.detailsSaveButton.setOnClickListener {
            val todoTitle = binding.taskTitleDetails.text.toString()
            val todoText = binding.taskTextDetails.text.toString()
            if(todoTitle.isNotEmpty()) {
                val todo = Task(id= viewModel.getNextItemId(), title = todoTitle, text = todoText)
                viewModel.addTask(this.requireView(),todo)
            }
            findNavController().navigate(R.id.navigation_home)
        }
        binding.detailsDeleteButton.setOnClickListener {
            viewModel.removeTask(task)
            findNavController().navigate(R.id.navigation_home)

        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}