package main.kotlin

import java.math.BigDecimal
import kotlin.math.abs

var accountBalance = BigDecimal.ZERO

enum class TransactionOption {
    WITHDRAWAL,
    DEPOSIT,
    BALANCE,
    EXIT
}

fun main() {
    welcomeClient()
    while (true) {
        if (!transactionProcess()) break
    }
}

private fun transactionProcess(): Boolean {
    println("Please select a transaction:\n1) WITHDRAWAL\n2) BALANCE\n3) DEPOSIT\n4) EXIT")
    val input = readln().uppercase()

    when (input) {
        "1", TransactionOption.WITHDRAWAL.toString() -> {
            println("Select Amount:")
            withDrawCash()
        }
        "2", TransactionOption.BALANCE.toString() -> {
            println("Current Balance: $$accountBalance")
        }
        "3", TransactionOption.DEPOSIT.toString() -> {
            println("Please enter the amount of cash:")
            depositCash()
        }
        "4", TransactionOption.EXIT.toString() -> {
            println("Thank you for using the ATM. Goodbye!")
            return false )
        }
        else -> {
            println("Invalid option. Please try again.")
        }
    }
    return true
}

private fun withDrawCash() {
    println("Select amount to withdraw:\n$10, $20, $30, $40, Other")

    val input = readln()
    val amountWithdrawal = try {
        input.toBigDecimal()
    } catch (e: Exception) {
        println("Invalid amount. Please enter a valid number.")
        return
    }

    if (amountWithdrawal > accountBalance) {
        println("Insufficient balance. Your current balance is $$accountBalance.")
    } else {
        accountBalance -= amountWithdrawal
        println("Take your cash: $${abs(amountWithdrawal.toInt())}")
        println("New Balance: $$accountBalance")
    }
}

private fun depositCash() {
    println("Enter deposit amount:")

    val amountDeposited = try {
        readln().toBigDecimal()
    } catch (e: Exception) {
        println("Invalid amount. Please enter a valid number.")
        return
    }

    accountBalance += amountDeposited
    println("Cash deposited successfully! New Balance: $$accountBalance")
}

private fun welcomeClient() {
    println("Welcome to the ATM!")
}
