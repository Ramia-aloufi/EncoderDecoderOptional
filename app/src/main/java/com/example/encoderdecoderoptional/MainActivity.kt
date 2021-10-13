package com.example.encoderdecoderoptional

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
data class codencod(var txt1:String,var txt2:String)
class MainActivity : AppCompatActivity() {
    lateinit var rv:RecyclerView
    lateinit var al:ArrayList<codencod>
    lateinit var btndecode:Button
    lateinit var btnencode:Button
    lateinit var ete:EditText
    lateinit var etd:EditText
    var Key = 13

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        adapt()
        btnencode.setOnClickListener {
            var input = ete.text.toString()
            if (input.isNotEmpty()){
                var encodeinput = encode(ete.text.toString(),Key)
                al.add(codencod(input,encodeinput))
                rv.adapter?.notifyDataSetChanged()
                ete.text.clear()
            }else{
                Toast.makeText(this,"Type a Phrase!",Toast.LENGTH_SHORT).show()
            }
        }
        btndecode.setOnClickListener {
            var input = etd.text.toString()
            if(input.isNotEmpty()){
                var decodinput = decode(etd.text.toString(),Key)
                al.add(codencod(input,decodinput))
                rv.adapter?.notifyDataSetChanged()
                etd.text.clear()
            }else{
                Toast.makeText(this,"Type a Phrase!",Toast.LENGTH_SHORT).show()
            }



        }
    }

    fun init(){
        rv = findViewById(R.id.rv)
        btndecode = findViewById(R.id.btndecod)
        btnencode = findViewById(R.id.btnencode)
        al = ArrayList()
        ete = findViewById(R.id.editTextTextPersonName)
        etd = findViewById(R.id.editTextTextPersonName2)
    }
    fun adapt(){
        rv.adapter = MyAdapter(al)
        rv.layoutManager = LinearLayoutManager(this)
    }
    fun encode(s: String, key: Int): String{

            val offset = key % 26
            if (offset == 0) return s
            var d: Char
            val chars = CharArray(s.length)
            for ((index, c) in s.withIndex()) {
                if (c in 'A'..'Z') {
                    d = c + offset
                    if (d > 'Z') d -= 26
                }
                else if (c in 'a'..'z') {
                    d = c + offset
                    if (d > 'z') d -= 26
                }
                else
                    d = c
                chars[index] = d
            }
            return chars.joinToString("")
        }
    fun decode(s: String, key: Int): String {
        return encode(s, 26 - key)
    }



    }
