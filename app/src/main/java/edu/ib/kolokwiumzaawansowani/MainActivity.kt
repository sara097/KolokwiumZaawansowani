package edu.ib.kolokwiumzaawansowani

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        addEmployeeBtn.setOnClickListener {
            this.startActivity(Intent(this, AddEmployeeActivity::class.java))
        }
        deleteEmployeeBtn.setOnClickListener {
            this.startActivity(Intent(this, DeleteEmployeeActivity::class.java))
        }
        showEmployeeBtn.setOnClickListener {
            this.startActivity(Intent(this, ShowEmployeesActivity::class.java))
        }

    }
}