package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Numeros
        oneBTN.setOnClickListener{appendOnClick(true,"1")}
        twoBTN.setOnClickListener{appendOnClick(true,"2")}
        threeBTN.setOnClickListener{appendOnClick(true,"3")}
        fourBTN.setOnClickListener{appendOnClick(true,"4")}
        fiveBTN.setOnClickListener{appendOnClick(true,"5")}
        sixBTN.setOnClickListener{appendOnClick(true,"6")}
        sevenBTN.setOnClickListener{appendOnClick(true,"7")}
        eightBTN.setOnClickListener{appendOnClick(true,"8")}
        nineBTN.setOnClickListener{appendOnClick(true,"9")}
        zeroBTN.setOnClickListener{appendOnClick(true,"0")}
        pointBTN.setOnClickListener{appendOnClick(true,".")}

        //Operadores
        divideBTN.setOnClickListener{appendOnClick(false,"/")}
        multiplyBTN.setOnClickListener{appendOnClick(false,"*")}
        subtractBTN.setOnClickListener{appendOnClick(false,"-")}
        addBTN.setOnClickListener{appendOnClick(false,"+")}
        openParenthesisBTN.setOnClickListener{appendOnClick(false,"(")}
        closedParenthesisBTN.setOnClickListener{appendOnClick(false,")")}



        clearBTN.setOnClickListener{
            clear()
        }
        equalsBTN.setOnClickListener{
            calculate()
        }


    }

    fun appendOnClick(clear:Boolean,string:String){
        if(clear){
            resultTV.text= ""
            expressionTV.append(string)
        }else{
            expressionTV.append(resultTV.text)
            expressionTV.append(string)
            resultTV.text=""
        }
    }

    fun clear(){
        expressionTV.text=""
        resultTV.text=""

    }
    private fun calculate(){

        try{

            val input= ExpressionBuilder(expressionTV.text.toString()).build()
            val output = input.evaluate()
            val longOutput = output.toLong()
            if(output== longOutput.toDouble()){
                resultTV.text=longOutput.toString()
            }else{
                resultTV.text=output.toString()
            }

        }catch (e:Exception){
            Toast.makeText(this@MainActivity,e.message,Toast.LENGTH_LONG).show()
        }

    }



}