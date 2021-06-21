package com.example.calcy

//import net.objecthunter.exp4j.Expression
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.System.exit


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       btn1.setOnClickListener {
            evaluateExpression("1", clear = true)
        }

        btn2.setOnClickListener {
            evaluateExpression("2", clear = true)
        }

        btn3.setOnClickListener {
            evaluateExpression("3", clear = true)
        }
        btn4.setOnClickListener {
            evaluateExpression("4", clear = true)
        }

        btn5.setOnClickListener {
            evaluateExpression("5", clear = true)
        }

        btn6.setOnClickListener {
            evaluateExpression("6", clear = true)
        }

        btn7.setOnClickListener {
            evaluateExpression("7", clear = true)
        }

        btn8.setOnClickListener {
            evaluateExpression("8", clear = true)
        }

        btn9.setOnClickListener {
            evaluateExpression("9", clear = true)
        }

        btn0.setOnClickListener {
            evaluateExpression("0", clear = true)
        }


        btnplus.setOnClickListener {
            evaluateExpression("+", clear = true)
        }

        btnminus.setOnClickListener {
            evaluateExpression("-", clear = true)
        }

        btnmultiply.setOnClickListener {
            evaluateExpression("*", clear = true)
        }

        btndivide.setOnClickListener {
            evaluateExpression("/", clear = true)
        }

        btndot.setOnClickListener {
            evaluateExpression(".", clear = true)
        }

        tvClear.setOnClickListener {
            tvExpression.text = ""
            tvResult.text = ""
        }

        btnequal.setOnClickListener {

            if(tvExpression.text.toString().isEmpty())
            {
                Toast.makeText(this,"put some numbers buddy",Toast.LENGTH_LONG).show()
            }
            else {
            val text = tvExpression.text.toString()
            val expression = ExpressionBuilder(text).build()
                 val result = expression.evaluate()
                 val longResult = result.toLong()
                 if (result == longResult.toDouble()) {
                     tvResult.text = longResult.toString()
                 } else {
                     tvResult.text = result.toString()
                 }
             }
        }

        btndelete.setOnClickListener {
            val text = tvExpression.text.toString()
            if(text.isNotEmpty()) {
                tvExpression.text = text.dropLast(1)
            }
//            tvResult.text = ""
        }
    }

    /*Function to calculate the expressions using expression builder library*/
    fun evaluateExpression(string: String, clear: Boolean) {
      if(clear and string.isEmpty()) {
//            tvResult.text = ""
            tvExpression.append(string)
        }
        else  {
            tvExpression.append(tvResult.text)
            tvExpression.append(string)
            tvResult.text = ""
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.dele -> {
                startActivity(Intent(this,MainActivity2::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.newmenu, menu)
        return true
    }
}
