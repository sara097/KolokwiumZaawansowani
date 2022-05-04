package edu.ib.kolokwiumzaawansowani.data

class IncorrectNumberInputException(msg: String) : Exception(msg)

class LengthException(msg: String) : Exception(msg)

fun isPeselCorrect(pesel: String): Boolean {
    try {
        if (pesel.length != 11) throw LengthException("Niepoprawna długosc")
        pesel.toLongOrNull() ?: throw IncorrectNumberInputException("Nie tylko cyfry")
    } catch (e: LengthException) {
        e.printStackTrace()
        return false
    } catch (e: IncorrectNumberInputException) {
        e.printStackTrace()
        return false
    }
    return true
}