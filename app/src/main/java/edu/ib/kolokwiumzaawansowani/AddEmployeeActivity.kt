package edu.ib.kolokwiumzaawansowani


import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import edu.ib.kolokwiumzaawansowani.data.Department
import edu.ib.kolokwiumzaawansowani.data.Employee
import edu.ib.kolokwiumzaawansowani.data.isPeselCorrect
import kotlinx.android.synthetic.main.activity_add_employee.*


class AddEmployeeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_employee)

        val adapter: ArrayAdapter<Department> =
            ArrayAdapter<Department>(
                this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                Department.values().toList()
            )

        departmentSpinner.setSelection(0)
        departmentSpinner.adapter = adapter

        addEmpBtn.setOnClickListener {

            val pesel = peselEdeitText.text.toString()
            val name = nameEditText.text.toString()
            val lastName = lastNameEditText.text.toString()
            val dep = departmentSpinner.selectedItemPosition

            if (isPeselCorrect(pesel) && name.isNotBlank() && lastName.isNotBlank()) {
                val db = DatabaseHandler(this)
                val emp = Employee(pesel, name, lastName, dep)
                db.addEmployee(emp)
                Toast.makeText(this, "Employee added", Toast.LENGTH_SHORT).show()
                errMessage.text = ""

                val dbFirestore = Firebase.firestore

                dbFirestore.collection("employees")
                    .add(emp.asMap())
                    .addOnSuccessListener { documentReference ->
                        Log.d("add", "DocumentSnapshot added with ID: ${documentReference.id}")
                        Toast.makeText(this, "Employee added to firestore", Toast.LENGTH_SHORT)
                            .show()
                    }
                    .addOnFailureListener { e ->
                        Log.w("add", "Error adding document", e)
                        Toast.makeText(this, "Employee error", Toast.LENGTH_SHORT).show()
                    }
                errMessage.text = ""

                //  this.startActivity(Intent(this, MainActivity::class.java))
                // finishAffinity()
            } else errMessage.text = "Error"

        }
    }
}