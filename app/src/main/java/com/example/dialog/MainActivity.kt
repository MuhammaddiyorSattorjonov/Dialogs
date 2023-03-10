package com.example.dialog

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.DatePicker
import android.widget.TimePicker
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.dialog.databinding.ActivityMainBinding
import com.example.dialog.databinding.ItemDialogBinding
import com.google.android.material.snackbar.Snackbar
import java.util.Date

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.alertDialog.setOnClickListener{
            val dialog = AlertDialog.Builder(this)
            dialog.setTitle("So'rovnoma")
            dialog.setMessage("O'qishga rozimisiz")

            dialog.setNeutralButton("Qaytish"
            ) { p0, p1 ->
                Toast.makeText(this, "Qaytildi", Toast.LENGTH_SHORT).show()
            }
            dialog.setPositiveButton("Roziman"){p0,p1->
                Toast.makeText(this, "Yaxshi o'qing", Toast.LENGTH_SHORT).show()
            }
            dialog.setNegativeButton("Rozi emasman"){p0,p1->
                Toast.makeText(this, "Boring umuman oqimang", Toast.LENGTH_SHORT).show()
            }
            dialog.show()
        }


        binding.customDialog.setOnClickListener{
                val dialogc = AlertDialog.Builder(this).create()
                val itemDialog = ItemDialogBinding.inflate(layoutInflater)
                dialogc.setCancelable(false)
                itemDialog.yes.setOnClickListener{
                    Toast.makeText(this, "Bilaman", Toast.LENGTH_SHORT).show()
                    dialogc.cancel()
                }
                itemDialog.no.setOnClickListener{
                    Toast.makeText(this, "Aldama yoqdiyu", Toast.LENGTH_SHORT).show()
                    dialogc.cancel()
                }
                dialogc.setView(itemDialog.root)
                dialogc.show()
        }


        binding.fragmentDialog.setOnClickListener{
            val myFragment = BlankFragment()
            myFragment.show(supportFragmentManager,myFragment.toString())
        }

        binding.dataDialog.setOnClickListener{
            val date = Date()
            val dateDialog = DatePickerDialog(this,object :DatePickerDialog.OnDateSetListener{
                override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {
                    Toast.makeText(this@MainActivity, "$p3/$p2/$p1", Toast.LENGTH_SHORT).show()
                }
            },date.year,date.month,date.day)
            dateDialog.show()
        }

        binding.timeDialog.setOnClickListener{
            val date = Date()
            val dialogt = TimePickerDialog(this,object : TimePickerDialog.OnTimeSetListener{
                override fun onTimeSet(p0: TimePicker?, p1: Int, p2: Int) {
                    Toast.makeText(this@MainActivity, "$p1:$p2", Toast.LENGTH_SHORT).show()
                }
            },date.hours,date.minutes,true)
            dialogt.show()
        }

        binding.snackbar.setOnClickListener{
            val snackbar = Snackbar.make(binding.root,"Snackbarman",Snackbar.LENGTH_LONG)
            snackbar
                .setAction("Bosing",object :View.OnClickListener{
                    override fun onClick(p0: View?) {
                        Toast.makeText(this@MainActivity, "Bosdingizmi", Toast.LENGTH_SHORT).show()
                    }
                })
                .show()
        }

        binding.bottomDialog.setOnClickListener{
            val myBlank = BlankFragment2()
            myBlank.show(supportFragmentManager,myBlank.toString())
        }
    }
}