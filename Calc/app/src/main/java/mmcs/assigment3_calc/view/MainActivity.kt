package mmcs.assigment3_calc.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import mmcs.assigment3_calc.R
import mmcs.assigment3_calc.databinding.ActivityMainBinding
import mmcs.assigment3_calc.viewmodel.CalculatorViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var binding: ActivityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.viewModel= CalculatorViewModel()
        //btn_0.setOnClickListener{setTextFields("0")}
    }
//    fun setTextFields(str: String){
//        math_operation.append(str)
//    }
}