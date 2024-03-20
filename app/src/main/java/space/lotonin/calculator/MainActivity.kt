package space.lotonin.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val result: TextView = findViewById(R.id.result) as TextView
        val operation: TextView = findViewById(R.id.operation) as TextView
        val sqrt: TextView = findViewById(R.id.b_sqrt) as TextView
        val log2: TextView = findViewById(R.id.b_log2) as TextView
        val ln: TextView = findViewById(R.id.b_ln) as TextView
        val leftb: TextView = findViewById(R.id.b_leftb) as TextView
        val rightb: TextView = findViewById(R.id.b_rightb) as TextView
        val xy: TextView = findViewById(R.id.b_xy) as TextView
        val ac: TextView = findViewById(R.id.b_AC) as TextView
        val back: TextView = findViewById(R.id.b_back) as TextView
        val percent: TextView = findViewById(R.id.b_percent) as TextView
        val div: TextView = findViewById(R.id.b_div) as TextView
        val sin: TextView = findViewById(R.id.b_sin) as TextView
        val seven: TextView = findViewById(R.id.b_seven) as TextView
        val eight: TextView = findViewById(R.id.b_eight) as TextView
        val nine: TextView = findViewById(R.id.b_nine) as TextView
        val mul: TextView = findViewById(R.id.b_mul) as TextView
        val cos: TextView = findViewById(R.id.b_cos) as TextView
        val four: TextView = findViewById(R.id.b_four) as TextView
        val five: TextView = findViewById(R.id.b_five) as TextView
        val six: TextView = findViewById(R.id.b_six) as TextView
        val sub: TextView = findViewById(R.id.b_sub) as TextView
        val pi: TextView = findViewById(R.id.b_pi) as TextView
        val one: TextView = findViewById(R.id.b_one) as TextView
        val two: TextView = findViewById(R.id.b_two) as TextView
        val three: TextView = findViewById(R.id.b_three) as TextView
        val add: TextView = findViewById(R.id.b_add) as TextView
        val e: TextView = findViewById(R.id.b_e) as TextView
        val zerot: TextView = findViewById(R.id.b_zerotr) as TextView
        val dote: TextView = findViewById(R.id.b_dote) as TextView
        val zero: TextView = findViewById(R.id.b_zero) as TextView
        val res: TextView = findViewById(R.id.b_res) as TextView

        cos.setOnClickListener { operation.append("cos(") }
        pi.setOnClickListener { operation.append("pi") }
        e.setOnClickListener { operation.append("e") }
        zero.setOnClickListener {operation.append("0")}
        one.setOnClickListener { operation.append("1") }
        two.setOnClickListener { operation.append("2") }
        three.setOnClickListener { operation.append("3") }
        four.setOnClickListener {operation.append("4")}
        five.setOnClickListener { operation.append("5") }
        six.setOnClickListener { operation.append("6") }
        seven.setOnClickListener { operation.append("7") }
        eight.setOnClickListener {operation.append("8")}
        nine.setOnClickListener { operation.append("9") }
        zerot.setOnClickListener { operation.append("000") }
        dote.setOnClickListener { operation.append(".") }
        div.setOnClickListener {operation.append("/")}
        mul.setOnClickListener { operation.append("*") }
        add.setOnClickListener { operation.append("+") }
        sub.setOnClickListener { operation.append("-") }
        leftb.setOnClickListener {operation.append("(")}
        rightb.setOnClickListener {operation.append(")")}
        back.setOnClickListener {
            val s = operation.text.toString()
            if (s != "") {
                operation.text = s.substring(0, s.length - 1)
            }
        }
        ac.setOnClickListener {
            operation.text = ""
            result.text = ""
        }
        result.setOnClickListener {
            val restext = result.text.toString()
            if (restext != "Error" && restext != ""){
                operation.text = restext
                result.text = ""
            }
        }
        res.setOnClickListener{
            val optext = operation.text.toString() //Выражение в формате строки
            if (optext != "") {
                try {
                    val expr = ExpressionBuilder(operation.text.toString()).build() //строим выражение
                    val res = expr.evaluate() //Находим ответ (число, может быть нецелое)
                    val longres = res.toLong() //longres - число в формате long (целочисленное)
                    if (longres.toDouble() == res) { //Если число целое,
                        result.text = longres.toString() //То: Отбрасываем ноль после запятой
                    } else {
                        result.text = res.toString() //Иначе: Сохраняем числа после запятой
                    }
                } catch (e: Exception) { //Если выражение записано некорректно
                    result.text = "Error" //В поле ответа пишем 'Error'
                }
            }
        }

    }
}