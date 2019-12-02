package com.example.exercise1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val calc: Button = findViewById(R.id.buttonCalculate)
        calc.setOnClickListener{calculate()}
        val reset:Button = findViewById(R.id.buttonReset)
        reset.setOnClickListener{resetText()}
    }

    private fun resetText() {
        val loanText: TextView =findViewById(R.id.textView)
        val interestText: TextView =findViewById(R.id.textView2)
        val monthlyPaymentText: TextView =findViewById(R.id.textView3)

        val price:EditText=findViewById(R.id.editTextCarPrice)
        val downPayment:EditText=findViewById(R.id.editTextDownPayment)
        val period:EditText=findViewById(R.id.editTextLoanPeriod)
        val rate:EditText=findViewById(R.id.editTextInterestRate)

        loanText.text=""
        interestText.text=""
        monthlyPaymentText.text=""
        price.setText("")
        downPayment.setText("")
        period.setText("")
        rate.setText("")
        price.requestFocus()
    }

    private fun calculate() {
        val loanText: TextView =findViewById(R.id.textView)
        val interestText: TextView =findViewById(R.id.textView2)
        val monthlyPaymentText: TextView =findViewById(R.id.textView3)

        val price:EditText=findViewById(R.id.editTextCarPrice)
        val downPayment:EditText=findViewById(R.id.editTextDownPayment)
        val period:EditText=findViewById(R.id.editTextLoanPeriod)
        val rate:EditText=findViewById(R.id.editTextInterestRate)

        val temp = price.text.toString().toDouble() - downPayment.text.toString().toDouble()
        loanText.text=String.format("$%.2f",temp)
        val temp1 = (price.text.toString().toDouble() - downPayment.text.toString().toDouble()) * rate.text.toString().toDouble() * period.text.toString().toDouble()
        interestText.text=String.format("$%.2f",temp1)
        val temp2 = ((price.text.toString().toDouble() - downPayment.text.toString().toDouble()) + ((price.text.toString().toDouble() - downPayment.text.toString().toDouble()) * rate.text.toString().toDouble() * period.text.toString().toDouble()))/period.text.toString().toDouble()/12
        monthlyPaymentText.text=String.format("$%.2f",temp2)
    }
}
