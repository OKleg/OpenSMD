package mmcs.assignment3_calculator.viewmodel

import androidx.databinding.BaseObservable
import androidx.databinding.ObservableField

class CalculatorViewModel: BaseObservable(), Calculator {
    override var display = ObservableField<String>()

    override fun addDigit(dig: Int) {
        TODO("Not yet implemented")
    }

    override fun addPoint() {
        TODO("Not yet implemented")
    }

    override fun addOperation(op: Operation) {
        TODO("Not yet implemented")
    }

    override fun compute() {
        TODO("Not yet implemented")
    }

    override fun clear() {
        TODO("Not yet implemented")
    }

    override fun reset() {
        TODO("Not yet implemented")
    }
}