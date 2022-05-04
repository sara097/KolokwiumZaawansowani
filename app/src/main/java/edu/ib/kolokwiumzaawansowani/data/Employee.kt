package edu.ib.kolokwiumzaawansowani.data

class Employee(
    val pesel: String,
    val name: String,
    val lastName: String,
    val department: Department
) {

    constructor(
        pesel: String,
        name: String,
        lastName: String,
        department: Int
    ) : this(
        pesel, name, lastName,
        when (department) {
            0 -> Department.HR
            1 -> Department.MARKETING
            else -> Department.IT
        }
    )

    constructor(
        map: Map<String, String>
    ) : this(
        map["pesel"]!!,
        map["name"]!!,
        map["lastName"]!!,
        map["department"]!!.toInt()
    )

    fun asMap() = mapOf(
        "pesel" to pesel,
        "name" to name,
        "lastName" to lastName,
        "department" to department.ordinal
    )

    override fun toString(): String {
        return "$name, $lastName, $department"
    }
}