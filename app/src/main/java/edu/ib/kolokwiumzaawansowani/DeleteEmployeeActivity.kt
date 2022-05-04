package edu.ib.kolokwiumzaawansowani

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import edu.ib.kolokwiumzaawansowani.data.Department
import edu.ib.kolokwiumzaawansowani.data.Employee
import kotlinx.android.synthetic.main.activity_add_employee.*
import kotlinx.android.synthetic.main.activity_delete_employee.*

class DeleteEmployeeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delete_employee)
        val db = DatabaseHandler(this)

        val adapter: ArrayAdapter<Employee> =
            ArrayAdapter<Employee>(
                this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                db.allEmployee
            )

        empSpinner.setSelection(0)
        empSpinner.adapter = adapter

        deleteEmpBtn.setOnClickListener {
            val empIdx = empSpinner.selectedItemPosition
            val employee = db.allEmployee[empIdx]
            db.deleteEmployee(employee)
            Toast.makeText(this, "Employee removed", Toast.LENGTH_SHORT).show()
        }
    }
}