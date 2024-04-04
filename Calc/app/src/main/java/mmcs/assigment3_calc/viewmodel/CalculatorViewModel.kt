package mmcs.assigment3_calc.viewmodel

import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.text.trimmedLength
import mmcs.assigment3_calc.viewmodel.Calculator
import mmcs.assigment3_calc.viewmodel.Operation

import androidx.databinding.BaseObservable
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import net.objecthunter.exp4j.ExpressionBuilder
import java.util.Stack
class CalculatorViewModel: BaseObservable(), Calculator {
    override var display = ObservableField<String>("")
    private var num :Stack<Int> = Stack<Int>()
    private var operations :Stack<Operation> = Stack<Operation>()
    private var isOpBedore: Boolean = false
    override fun addDigit(view: View) {
        if (view is TextView) {
            //if (display.get() != null)
                display.set(display.get() + view.text.toString())
            //else
            //    display.set(view.text.toString())
            isOpBedore=false
        }
        formatDisplay()
    }
    private fun formatDisplay(){
        display.set(display.get().toString().substring(0,8))

    }
    override fun addPoint() {
        display.set(display.get()+".")
        isOpBedore=false
        formatDisplay()
    }

    override fun addOperation(op: Operation) {
        if (!isOpBedore){
            when (op) {
                Operation.ADD -> {
                    display.set(display.get()+"+")
                }
                Operation.DIV -> {
                    display.set(display.get()+"÷")
                }
                Operation.MUL -> {
                    display.set(display.get()+"×")
                }
                Operation.SUB -> {
                    display.set(display.get()+"-")
                }
            }
            isOpBedore=true
            operations.push(op)
            formatDisplay()
        }
    }

    override fun compute(view: View) {
        try {
            isOpBedore=false
            val expression = display.get()?.replace("×","*")?. replace("÷","/") ?: ""
            val ex = ExpressionBuilder(expression).build()
            val result = ex.evaluate()

            val longRes = result.toLong()
            if(result == longRes.toDouble())
                display.set(longRes.toString())
            else
                display.set(result.toString())

            formatDisplay()
        } catch(e: Exception){
            Log.d("Ошибка","сообщение: ${e.message}")
            Toast.makeText(view.context,e.message,Toast.LENGTH_LONG).show()
        }
    }

    override fun clear() {
        display.set("")
        isOpBedore=false
    }

    override fun reset() {
        isOpBedore=false
    }
}