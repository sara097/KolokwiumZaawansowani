package edu.ib.kolokwiumzaawansowani

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import edu.ib.kolokwiumzaawansowani.data.Employee
import kotlinx.android.synthetic.main.activity_show_employees.*

class ShowEmployeesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_employees)
        val db = DatabaseHandler(this)
        val adapter: ArrayAdapter<Employee> =
            ArrayAdapter<Employee>(
                this,
                android.R.layout.simple_list_item_1,
                db.allEmployee
            )

        employees.adapter = adapter
    }

}