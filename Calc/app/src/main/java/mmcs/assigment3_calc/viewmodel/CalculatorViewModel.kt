package mmcs.assigment3_calc.viewmodel

import android.util.Log
import android.view.View
import android.widget.TextView
import mmcs.assigment3_calc.viewmodel.Calculator
import mmcs.assigment3_calc.viewmodel.Operation

import androidx.databinding.BaseObservable
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import net.objecthunter.exp4j.ExpressionBuilder
import java.util.Stack
class CalculatorViewModel: BaseObservable(), Calculator {
    override var display = ObservableField<String>("")
    var num :Stack<Int> = Stack<Int>()
    var operations :Stack<Operation> = Stack<Operation>()
    var res: Int = 0
    override fun addDigit(view: View) {
        if (view is TextView) {
            //if (display.get() != null)
                display.set(display.get() + view.text.toString())
            //else
            //    display.set(view.text.toString())
        }

    }

    override fun addPoint() {
        display.set(display.get()+".")
    }

    override fun addOperation(op: Operation) {
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

        operations.push(op)
    }

    override fun compute(view: View) {
    try {
        val ex = ExpressionBuilder(display.get()?.replace("×","*")?.replace("÷","/") ?: "").build()
        val result = ex.evaluate()

        val longRes = result.toLong()
        if(result == longRes.toDouble())
            display.set(longRes.toString())
        else
            display.set(result.toString())


    } catch(e: Exception){
        Log.d("Ошибка","сообщение: ${e.message}")
    }
    }

    override fun clear() {
        display.set("")
    }

    override fun reset() {

    }
}