package com.example.calculator

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() , View.OnClickListener{
    private lateinit var textResult: TextView
    private var state =1
    private var math=""
    private var op1:Int =0
    private var op2:Int =0
    private var result = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textResult = findViewById(R.id.text_result)
        findViewById<View>(R.id.btnmul).setOnClickListener(this)
        findViewById<View>(R.id.btnSub).setOnClickListener(this)
        findViewById<View>(R.id.btnat).setOnClickListener(this)
        findViewById<View>(R.id.btnDot).setOnClickListener(this)
        findViewById<View>(R.id.btnEqual).setOnClickListener(this)
        findViewById<View>(R.id.btnDiv).setOnClickListener(this)
        findViewById<View>(R.id.btnAdd).setOnClickListener(this)
        findViewById<View>(R.id.btnBS).setOnClickListener(this)
        findViewById<View>(R.id.btnC).setOnClickListener(this)
        findViewById<View>(R.id.btnCE).setOnClickListener(this)
        findViewById<View>(R.id.btn0).setOnClickListener(this)
        findViewById<View>(R.id.btn1).setOnClickListener(this)
        findViewById<View>(R.id.btn2).setOnClickListener(this)
        findViewById<View>(R.id.btn3).setOnClickListener(this)
        findViewById<View>(R.id.btn4).setOnClickListener(this)
        findViewById<View>(R.id.btn5).setOnClickListener(this)
        findViewById<View>(R.id.btn6).setOnClickListener(this)
        findViewById<View>(R.id.btn7).setOnClickListener(this)
        findViewById<View>(R.id.btn8).setOnClickListener(this)
        findViewById<View>(R.id.btn9).setOnClickListener(this)
    }
        override fun onClick(p0: View?){
            val id=p0?.id
            when (id) {
                R.id.btn0 -> {
                    addDigit(0)
                }
                R.id.btn1 -> {
                    addDigit(1)
                }
                R.id.btn2 -> {
                    addDigit(2)
                }
                R.id.btn3 -> {
                    addDigit(3)
                }
                R.id.btn4 -> {
                    addDigit(4)
                }
                R.id.btn5 -> {
                    addDigit(5)
                }
                R.id.btn6 -> {
                    addDigit(6)
                }
                R.id.btn7 -> {
                    addDigit(7)
                }
                R.id.btn8 -> {
                    addDigit(8)
                }
                R.id.btn9 -> {
                    addDigit(9)
                }
                R.id.btnAdd -> {
                    state=2
                    math="+"
                }
                R.id.btnSub -> {
                    state=2
                    math="-"
                }
                R.id.btnmul -> {
                    state=2
                    math="*"
                }
                R.id.btnDiv -> {
                    state=2
                    math="/"
                }
                R.id.btnEqual -> {

                    when (math) {
                        "+" -> {
                            result = op1 + op2
                            op1=result
                            op2=0
                        }
                        "-" -> {
                            result=op1-op2
                            op1=result
                            op2=0
                        }
                        "*" -> {
                            result=op1*op2
                            op1=result
                            op2=0
                        }
                        "/" -> {
                            result=op1/op2
                            op1=result
                            op2=0
                        }
                    }
                    textResult.text= "$result"
                    state=1
                }
                R.id.btnCE -> {
                    if(state==1){
                        op1=op1 / 10
                        textResult.text="$op1"
                        state=1
                    }
                    else {
                        op2 = op2 / 10
                        textResult.text="$op2"
                        state=2
                    }
                }
                R.id.btnC -> {
                    op1=0
                    op2=0
                    result=0
                    textResult.text="$result"
                    state=1
                }
            }
        }
    private fun addDigit(digit:Int){
        if(state==1){
            op1=op1*10+digit
            textResult.text="$op1"
        }else{
            op2=op2*10+digit
            textResult.text="$op2"
        }
    }
}