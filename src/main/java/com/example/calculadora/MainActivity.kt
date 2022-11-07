package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var ope: Int = 0
    var num: Long= 0
    var nOpe: Int = 0
    lateinit var txt1: TextView
    lateinit var txt2: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txt1 =findViewById(R.id.txt1)
        txt2 =findViewById(R.id.txt2)
        val clear: Button = findViewById(R.id.btn_clear)
        val equal: Button = findViewById(R.id.btn_result)
        val delete: Button = findViewById(R.id.btn_delete)


        equal.setOnClickListener {
            if( txt1.text.toString().isNotEmpty())
            {
                var num2: Long = txt2.text.toString().toLong(16)
                var resp: Long = 0

                when (ope) {
                    1 -> resp = num + num2
                    2 -> resp = num - num2
                    3 -> resp = num * num2
                    4 -> resp = num / num2
                }
                val hex = java.lang.Long.toHexString(resp)
                txt1.setText(hex)
                txt2.setText("")
                nOpe = 1
            }else{
                txt1.setText(txt2.text.toString())
                txt2.setText("")
                nOpe = 1
            }
        }

        clear.setOnClickListener{
            txt1.setText("")
            txt2.setText("")
            num=0
            ope=0
        }
        delete.setOnClickListener{
            txt1.setText("")
            txt2.setText(removeLastNchars(txt2.text.toString(),1))
        }
    }

    fun ingresar(view: View) {
        var num2: String = txt2.text.toString()
        if(nOpe == 1)
        {
            txt1.setText("")
            nOpe=0
        }
        when (view.id) {
            R.id.btn_0 -> txt2.setText(num2 + "0")
            R.id.btn_1 -> txt2.setText(num2 + "1")
            R.id.btn_2 -> txt2.setText(num2 + "2")
            R.id.btn_3 -> txt2.setText(num2 + "3")
            R.id.btn_4 -> txt2.setText(num2 + "4")
            R.id.btn_5 -> txt2.setText(num2 + "5")
            R.id.btn_6 -> txt2.setText(num2 + "6")
            R.id.btn_7 -> txt2.setText(num2 + "7")
            R.id.btn_8 -> txt2.setText(num2 + "8")
            R.id.btn_9 -> txt2.setText(num2 + "9")
            R.id.btn_A -> txt2.setText(num2 + "A")
            R.id.btn_B -> txt2.setText(num2 + "B")
            R.id.btn_C -> txt2.setText(num2 + "C")
            R.id.btn_D -> txt2.setText(num2 + "D")
            R.id.btn_E -> txt2.setText(num2 + "E")
            R.id.btn_F -> txt2.setText(num2 + "F")
        }
    }

    fun operacion(view: View) {
        num = txt2.text.toString().toLong(16)
        var num2: String = txt2.text.toString()
        txt2.setText("")
        when(view.id)
        {
            R.id.btn_suma ->{
                txt1.setText(num2 + "+")
                ope = 1
            }
            R.id.btn_resta ->{
                txt1.setText(num2 + "-")
                ope = 2
            }
            R.id.btn_mult ->{
                txt1.setText(num2 + "*")
                ope = 3
            }
            R.id.btn_divi ->{
                txt1.setText(num2 + "/")
                ope = 4
            }
        }
    }
    fun removeLastNchars(str: String, n: Int): String {
        return str.substring(0, str.length - n)
    }
}