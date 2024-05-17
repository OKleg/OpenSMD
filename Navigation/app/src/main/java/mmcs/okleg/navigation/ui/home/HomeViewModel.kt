package mmcs.okleg.navigation.ui.home

import android.view.View
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import mmcs.okleg.navigation.ui.home.list.CustomAdapter
import mmcs.okleg.navigation.ui.home.list.Task

class HomeViewModel : ViewModel() {
     var dataSet: MutableLiveData<MutableList<Task>> = MutableLiveData<MutableList<Task>>(mutableListOf())

     private var customAdapter: CustomAdapter = CustomAdapter(dataSet.value!!)
          fun getCustomAdapter() = customAdapter



     fun addTask(view: View, model: Task) {
          dataSet.value!!.add(model)
          Toast.makeText(view.context,"add ${model.title}",Toast.LENGTH_LONG).show()
          customAdapter.notifyItemInserted(dataSet.value!!.size-1)
     }
     fun updateTask(model: Task?) {

          if (model == null) return // we cannot update the value because it is null

          for (item in dataSet.value!!) {
               // search by id
               if (item.id == model.id) {
                    val position = dataSet.value!!.indexOf(model)
                    dataSet.value!![position] = model
                    customAdapter.notifyItemChanged(position)
                    break // we don't need to continue any more iterations
               }
          }
     }
     fun removeTask(model: Task) {
          val position = dataSet.value!!.indexOf(model)
          dataSet.value!!.remove(model)
          customAdapter.notifyItemRemoved(position)
     }
     fun getNextItemId(): Int {
          var id = 1
          val listTasks = dataSet.value!!
          if (listTasks.isNotEmpty()) {
               // .last is equivalent to .size() - 1
               // we want to add 1 to that id and return it
               id = listTasks.last().id + 1
          }
          return id
     }
     fun getItemCount(): Int{
          return customAdapter.itemCount
     }
     fun getItemCheckedCount(): Int{
          return dataSet.value!!.count { todo -> todo.isChecked }
     }

}